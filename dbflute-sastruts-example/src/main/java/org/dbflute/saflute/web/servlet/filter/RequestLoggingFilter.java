/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.dbflute.saflute.web.servlet.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The filter for logging of request. <br />
 * org.seasar.extension.filter.RequestDumpFilter be used as reference.
 * 
 * <p>This filter outputs request info as debug level in development
 * and outputs exception info as error level in development and production.
 * The error message contains request info, so you can see it.</p>
 * 
 * <p>The requests for resource files, e.g. JavaScript(.js) and CSS(.css), is out of target.
 * You can customize it by {@link FilterConfig}.</p>
 * @author jflute
 */
public class RequestLoggingFilter implements Filter {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(RequestLoggingFilter.class);

    public static final String ERROR_ATTRIBUTE_KEY = "javax.servlet.error.exception";
    protected static final String LF = "\n";
    protected static final String IND = "  ";
    protected static final ThreadLocal<String> DUPLICATE_CHECK_LOCAL = new ThreadLocal<String>();
    protected static final ThreadLocal<Request500Handler> REQUEST_500_HANDLER_LOCAL = new ThreadLocal<Request500Handler>();

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected FilterConfig config;
    protected boolean errorLogging;
    protected Set<String> exceptExtSet;
    protected Pattern exceptUrlPattern;
    protected Pattern requestUriTitleUrlPattern;
    protected Pattern subRequestUrlPattern;

    // ===================================================================================
    //                                                                          Initialize
    //                                                                          ==========
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        this.errorLogging = isBooleanParameter(filterConfig, "errorLogging", true);
        setupExceptExtSet(filterConfig);
        setupExceptUrlPattern(filterConfig);
        setupRequestUriTitleUrlPattern(filterConfig);
        setupSubRequestUrlPatternUrlPattern(filterConfig);
    }

    protected boolean isBooleanParameter(FilterConfig filterConfig, String name, boolean defaultValue) {
        final String value = filterConfig.getInitParameter(name);
        return value != null ? value.trim().equalsIgnoreCase("true") : defaultValue;
    }

    protected void setupExceptExtSet(FilterConfig filterConfig) {
        final String value = filterConfig.getInitParameter("exceptExtSet");
        if (value != null) {
            final String[] splitAry = value.split(","); // e.g. js,css,png,gif,jpg,ico,svg,svgz
            exceptExtSet = new LinkedHashSet<String>();
            for (String element : splitAry) {
                exceptExtSet.add("." + element.trim());
            }
        } else { // as default
            final List<String> defaultExtList = getDefaultExceptExtSet();
            exceptExtSet = new LinkedHashSet<String>(defaultExtList);
        }
    }

    protected List<String> getDefaultExceptExtSet() {
        return Arrays.asList(".js", ".css", ".png", ".gif", ".jpg", ".ico", ".svg", ".svgz");
    }

    protected void setupExceptUrlPattern(FilterConfig filterConfig) {
        String pattern = filterConfig.getInitParameter("exceptUrlPattern");
        if (pattern == null || pattern.trim().length() == 0) {
            pattern = filterConfig.getInitParameter("ignoreUrlPattern"); // for compatible
        }
        if (pattern != null && pattern.trim().length() > 0) {
            this.exceptUrlPattern = Pattern.compile(pattern);
        }
    }

    protected void setupRequestUriTitleUrlPattern(FilterConfig filterConfig) {
        String pattern = filterConfig.getInitParameter("requestUriTitleUrlPattern");
        if (pattern != null && pattern.trim().length() > 0) {
            this.requestUriTitleUrlPattern = Pattern.compile(pattern);
        }
    }

    protected void setupSubRequestUrlPatternUrlPattern(FilterConfig filterConfig) {
        String pattern = filterConfig.getInitParameter("subRequestUrlPattern");
        if (pattern != null && pattern.trim().length() > 0) {
            this.subRequestUrlPattern = Pattern.compile(pattern);
        }
    }

    // ===================================================================================
    //                                                                              Filter
    //                                                                              ======
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        if (!isHttpServlet(servletRequest, servletResponse)) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (isNestedProcess() || isOutOfTargetPath(request)) {
            // nested processes are e.g. forwarding to JSP
            // out-of-target paths are e.g. .html
            chain.doFilter(request, response);
            return;
        }

        Long before = null;
        if (LOG.isDebugEnabled()) {
            before(request, response);
            before = System.currentTimeMillis();
        }
        boolean existsServerError = false;
        try {
            markBegin();
            chain.doFilter(request, response);
            if (handleErrorAttribute(request, response)) {
                existsServerError = true;
            }
        } catch (Request404NotFoundException e) {
            handle404NotFound(response, e);
        } catch (RuntimeException e) {
            sendInternalServerError(request, response, e);
            logError(request, response, "*RuntimeException occurred.", e);
            existsServerError = true;
            // no throw the exception to suppress duplicate error message
            // (Jetty's message doesn't have line separator so hard to see it)
        } catch (ServletException e) {
            final Throwable rootCause = e.getRootCause();
            if (rootCause instanceof Request404NotFoundException) {
                handle404NotFound(response, (Request404NotFoundException) rootCause);
            } else {
                final Throwable realCause = rootCause != null ? rootCause : e;
                sendInternalServerError(request, response, realCause);
                logError(request, response, "*ServletException occurred.", realCause);
                existsServerError = true;
            }
        } catch (IOException e) {
            sendInternalServerError(request, response, e);
            logError(request, response, "*IOException occurred.", e);
            existsServerError = true;
        } catch (Error e) {
            sendInternalServerError(request, response, e);
            logError(request, response, "*Error occurred.", e);
            existsServerError = true;
        } finally {
            clearMark();
            clearHandler();
            if (LOG.isDebugEnabled()) {
                if (existsServerError) {
                    attention(request, response);
                } else {
                    // only when success request
                    // because error logging contains request info
                    Long after = System.currentTimeMillis();
                    after(request, response, before, after);
                }
            }
        }
    }

    protected boolean isHttpServlet(ServletRequest servletRequest, ServletResponse servletResponse) {
        return (servletRequest instanceof HttpServletRequest) && (servletResponse instanceof HttpServletResponse);
    }

    protected boolean isOutOfTargetPath(HttpServletRequest request) {
        if (exceptUrlPattern != null) {
            final String uri = getRequestURI(request);
            if (exceptUrlPattern.matcher(uri).find()) {
                return true;
            }
        }
        if (exceptExtSet != null) {
            // not use request URI because it might have noise e.g. jsessionID
            final String path = getServletPath(request);
            if (path != null && path.contains(".")) {
                final int indexOf = path.lastIndexOf(".");
                final String ext = path.substring(indexOf);
                if (exceptExtSet.contains(ext)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isNestedProcess() {
        return DUPLICATE_CHECK_LOCAL.get() != null;
    }

    protected void markBegin() {
        DUPLICATE_CHECK_LOCAL.set("begin");
    }

    protected void clearMark() {
        DUPLICATE_CHECK_LOCAL.set(null);
    }

    protected void clearHandler() {
        REQUEST_500_HANDLER_LOCAL.set(null);
    }

    // -----------------------------------------------------
    //                                                Before
    //                                                ------
    protected void before(HttpServletRequest request, HttpServletResponse response) {
        final StringBuilder sb = new StringBuilder();
        final String beginDecoration;
        if (isSubRequestUrl(request)) {
            beginDecoration = "- - - - - - - - - - {SUB BEGIN}: ";
        } else { // mainly here
            beginDecoration = "* * * * * * * * * * {BEGIN}: ";
        }
        sb.append(beginDecoration);
        sb.append(getTitlePath(request));
        sb.append(LF).append(IND);
        buildRequestInfo(sb, request, response, false);
        LOG.debug(sb.toString().trim());
    }

    protected void buildRequestInfo(StringBuilder sb, HttpServletRequest request, HttpServletResponse response,
            boolean showResponse) {
        sb.append("Request class=" + request.getClass().getName());
        sb.append(", RequestedSessionId=").append(request.getRequestedSessionId());

        sb.append(LF).append(IND);
        sb.append(", REQUEST_URI=").append(request.getRequestURI());
        sb.append(", SERVLET_PATH=").append(request.getServletPath());
        sb.append(", CharacterEncoding=" + request.getCharacterEncoding());
        sb.append(", ContentLength=").append(request.getContentLength());

        sb.append(LF).append(IND);
        sb.append(", ContentType=").append(request.getContentType());
        sb.append(", Locale=").append(request.getLocale());
        sb.append(", Locales=");
        final Enumeration<?> locales = request.getLocales();
        boolean first = true;
        while (locales.hasMoreElements()) {
            final Locale locale = (Locale) locales.nextElement();
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }
            sb.append(locale.toString());
        }
        sb.append(", Scheme=").append(request.getScheme());
        sb.append(", isSecure=").append(request.isSecure());

        sb.append(LF).append(IND);
        sb.append(", SERVER_PROTOCOL=").append(request.getProtocol());
        sb.append(", REMOTE_ADDR=").append(request.getRemoteAddr());
        sb.append(", REMOTE_HOST=").append(request.getRemoteHost());
        sb.append(", SERVER_NAME=").append(request.getServerName());
        sb.append(", SERVER_PORT=").append(request.getServerPort());

        sb.append(LF).append(IND);
        sb.append(", ContextPath=").append(request.getContextPath());
        sb.append(", REQUEST_METHOD=").append(request.getMethod());
        sb.append(", PathInfo=").append(request.getPathInfo());
        sb.append(", RemoteUser=").append(request.getRemoteUser());

        sb.append(LF).append(IND);
        sb.append(", REQUEST_URL=").append(request.getRequestURL());
        sb.append(LF).append(IND);
        sb.append(", QUERY_STRING=").append(request.getQueryString());
        if (showResponse) {
            sb.append(LF).append(IND);
            buildResponseInfo(sb, request, response);
        }

        sb.append(LF);
        buildRequestHeaders(sb, request);
        buildRequestParameters(sb, request);
        buildCookies(sb, request);
        buildRequestAttributes(sb, request);
        buildSessionAttributes(sb, request);
    }

    // -----------------------------------------------------
    //                                                 After
    //                                                 -----
    protected void after(HttpServletRequest request, HttpServletResponse response, Long before, Long after) {
        final StringBuilder sb = new StringBuilder();
        sb.append(LF).append(IND);
        buildResponseInfo(sb, request, response);

        // show only dynamic values in request
        sb.append(LF);
        // hope response cookie (not request cookie)
        //buildCookies(sb, request);
        buildRequestAttributes(sb, request);
        buildSessionAttributes(sb, request);

        final String endDecoration;
        if (isSubRequestUrl(request)) {
            endDecoration = "- - - - - - - - - - {SUB END}: ";
        } else { // mainly here
            endDecoration = "* * * * * * * * * * {END}: ";
        }
        sb.append(endDecoration);
        sb.append(getTitlePath(request));
        sb.append(" [" + convertToPerformanceView(after.longValue() - before.longValue()) + "]");
        sb.append(LF);
        sb.append(LF);

        String logString = sb.toString();
        LOG.debug(logString);
    }

    // -----------------------------------------------------
    //                                          Request Info
    //                                          ------------
    protected boolean isRequestUriTitleUrl(final String servletPath) {
        return requestUriTitleUrlPattern != null && requestUriTitleUrlPattern.matcher(servletPath).find();
    }

    protected boolean isSubRequestUrl(HttpServletRequest request) {
        final String servletPath = ((HttpServletRequest) request).getServletPath();
        return subRequestUrlPattern != null && subRequestUrlPattern.matcher(servletPath).find();
    }

    protected String getTitlePath(HttpServletRequest request) {
        final String servletPath = ((HttpServletRequest) request).getServletPath();
        if (isRequestUriTitleUrl(servletPath)) {
            return getRequestURI(request);
        }
        return servletPath;
    }

    protected String getServletPath(HttpServletRequest request) {
        return ((HttpServletRequest) request).getServletPath();
    }

    protected String getRequestURI(HttpServletRequest request) {
        return ((HttpServletRequest) request).getRequestURI();
    }

    protected void buildRequestHeaders(StringBuilder sb, HttpServletRequest request) {
        for (Iterator<?> it = toSortedSet(request.getHeaderNames()).iterator(); it.hasNext();) {
            String name = (String) it.next();
            String value = request.getHeader(name);
            sb.append(IND);
            sb.append("[header] ").append(name);
            sb.append("=").append(value);
            sb.append(LF);
        }
    }

    protected void buildCookies(StringBuilder sb, HttpServletRequest request) {
        final Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return;
        }
        for (int i = 0; i < cookies.length; i++) {
            sb.append(IND);
            sb.append("[cookie] ").append(cookies[i].getName());
            sb.append("=").append(cookies[i].getValue());
            sb.append(LF);
        }
    }

    protected void buildRequestParameters(StringBuilder sb, HttpServletRequest request) {
        for (final Iterator<?> it = toSortedSet(request.getParameterNames()).iterator(); it.hasNext();) {
            final String name = (String) it.next();
            sb.append(IND);
            sb.append("[param] ").append(name).append("=");
            final String[] values = request.getParameterValues(name);
            for (int i = 0; i < values.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(values[i]);
            }
            sb.append(LF);
        }
    }

    protected void buildRequestAttributes(StringBuilder sb, HttpServletRequest request) {
        for (Iterator<?> it = toSortedSet(request.getAttributeNames()).iterator(); it.hasNext();) {
            final String name = (String) it.next();
            if (ERROR_ATTRIBUTE_KEY.equals(name)) {
                continue; // because the error is handled in this filter
            }
            final Object attr = request.getAttribute(name);
            sb.append(IND);
            sb.append("[request] ").append(name).append("=");
            sb.append(filterAttributeDisp(attr));
            sb.append(LF);
        }
    }

    protected void buildSessionAttributes(StringBuilder sb, HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        for (Iterator<?> it = toSortedSet(session.getAttributeNames()).iterator(); it.hasNext();) {
            final String name = (String) it.next();
            final Object attr = session.getAttribute(name);
            sb.append(IND);
            sb.append("[session] ").append(name).append("=");
            sb.append(filterAttributeDisp(attr));
            sb.append(LF);
        }
    }

    protected Object filterAttributeDisp(final Object attr) {
        final Object filtered;
        if (attr instanceof Throwable) { // exception will be displayed in another way
            final String msg = ((Throwable) attr).getMessage();
            final String ln = "\n";
            if (msg != null && msg.contains(ln)) {
                filtered = msg.substring(0, msg.indexOf(ln));
            } else {
                filtered = msg;
            }
        } else {
            filtered = attr;
        }
        return filtered;
    }

    protected void buildResponseInfo(StringBuilder sb, HttpServletRequest request, HttpServletResponse response) {
        sb.append("Response class=" + response.getClass().getName());
        sb.append(", ContentType=").append(response.getContentType());
        sb.append(", Committed=").append(response.isCommitted());
        String exp = response.toString().trim();
        if (exp != null) {
            exp = replaceString(exp, "\r\n", "\n");
            exp = replaceString(exp, "\n", " ");
            final int limitLength = 120;
            if (exp.length() >= limitLength) {
                // it is possible that Response toString() show all HTML strings
                // so cut it to suppress too big logging here
                exp = exp.substring(0, limitLength) + "...";
            }
            sb.append(LF).append(IND);
            sb.append(", toString()=").append(exp);
            // e.g. Jetty
            // HTTP/1.1 200  Expires: Thu, 01-Jan-1970 00:00:00 GMT Set-Cookie: ...
        }
    }

    // -----------------------------------------------------
    //                                               Failure
    //                                               -------
    protected void logError(HttpServletRequest request, HttpServletResponse response, String comment, Throwable e) {
        final StringBuilder sb = new StringBuilder();
        sb.append(comment);
        sb.append(LF);
        sb.append("/= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =: " + getTitlePath(request));
        sb.append(LF).append(IND);
        try {
            buildRequestInfo(sb, request, response, true);
        } catch (RuntimeException continued) {
            sb.append("*Failed to get request info: " + continued.getMessage());
            sb.append(LF);
        }
        sb.append("= = = = = = = = = =/");
        final String msg = sb.toString().trim();
        if (errorLogging) {
            LOG.error(msg, e);
        } else {
            LOG.debug(msg, e);
        }
    }

    protected void attention(HttpServletRequest request, HttpServletResponse response) {
        final StringBuilder sb = new StringBuilder();
        sb.append("{FAILURE}: ").append(getTitlePath(request));
        sb.append(LF);
        sb.append(" *Read the exception message!");
        sb.append(LF);
        LOG.debug(sb.toString());
    }

    // ===================================================================================
    //                                                                     Error Attribute
    //                                                                     ===============
    protected boolean handleErrorAttribute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String attributeKey = ERROR_ATTRIBUTE_KEY;
        final Object errorObj = request.getAttribute(attributeKey);
        if (errorObj != null && errorObj instanceof Throwable) {
            if (errorObj instanceof RuntimeException) {
                throw (RuntimeException) errorObj;
            } else if (errorObj instanceof Throwable) {
                String msg = "Found the exception in " + attributeKey;
                throw new ServletException(msg, (Throwable) errorObj);
            }
            sendInternalServerError(request, response, null);
            final String msg = "The error attribute exists but unknown type: " + errorObj;
            if (errorLogging) {
                LOG.error(msg);
            } else {
                LOG.debug(msg);
            }
            return true;
        }
        return false;
    }

    // ===================================================================================
    //                                                                       404 Not Found
    //                                                                       =============
    protected void handle404NotFound(HttpServletResponse response, Request404NotFoundException notFoundEx)
            throws IOException {
        if (response.isCommitted()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("*Cannot send error as '404 Not Found' because of already committed");
            }
            return; // cannot help it
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("...Sending error as '404 Not Found' manually: " + notFoundEx.getMessage());
        }
        try {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } catch (IOException sendEx) {
            final String msg = "Failed to send error as '404 Not Found': " + sendEx.getMessage();
            if (errorLogging) {
                LOG.error(msg);
            } else {
                LOG.debug(msg);
            }
            return; // cannot help it
        }
    }

    /**
     * The exception that means 404 Not Found for the current request. <br />
     * You can send 404 by throwing this exception in your program.
     */
    public static class Request404NotFoundException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public Request404NotFoundException(String msg) {
            super(msg);
        }

        public Request404NotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    // ===================================================================================
    //                                                                    500 Server Error
    //                                                                    ================
    protected void sendInternalServerError(HttpServletRequest request, HttpServletResponse response, Throwable cause)
            throws IOException {
        if (cause != null) {
            process500HandlingCallback(request, response, cause);
            request.setAttribute(ERROR_ATTRIBUTE_KEY, cause); // for something outer process
        }
        try {
            if (!response.isCommitted()) { // might be committed in callback
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (IOException sendEx) {
            final String msg = "Failed to send error as '500 Error': " + sendEx.getMessage();
            if (errorLogging) {
                LOG.error(msg);
            } else {
                LOG.debug(msg);
            }
            return; // cannot help it
        }
    }

    protected void process500HandlingCallback(HttpServletRequest request, HttpServletResponse response, Throwable cause) {
        final Request500Handler request500Handler = REQUEST_500_HANDLER_LOCAL.get();
        if (request500Handler == null) {
            return;
        }
        try {
            request500Handler.handle(request, response, cause);
        } catch (Throwable handlingEx) {
            final String msg = "Failed to handle '500 Error' by the handler: " + request500Handler;
            if (errorLogging) {
                LOG.error(msg, handlingEx);
            } else {
                LOG.debug(msg, handlingEx);
            }
        }
    }

    /**
     * The handler of '500 Error' in the request.
     */
    public interface Request500Handler {

        /**
         * Handle the '500 Error' exception. <br />
         * The error logging is executed after your handling so basically you don't need logging.
         * @param request The request provided by caller. (NotNull)
         * @param response The response provided by caller, might be already committed. (NotNull)
         * @param cause The cause of this '500 Error'. (NotNull)
         */
        void handle(HttpServletRequest request, HttpServletResponse response, Throwable cause);
    }

    public static void setRequest500HandlerOnThread(Request500Handler handler) {
        REQUEST_500_HANDLER_LOCAL.set(handler);
    }

    // ===================================================================================
    //                                                                             Destory
    //                                                                             =======
    public void destroy() {
        config = null;
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected SortedSet<?> toSortedSet(final Enumeration<?> enu) {
        final SortedSet<Object> set = new TreeSet<Object>();
        set.addAll(Collections.list(enu));
        return set;
    }

    protected String replaceString(String str, String fromStr, String toStr) {
        StringBuilder sb = null; // lazy load
        int basePos = 0;
        int nextPos = 0;
        do {
            basePos = str.indexOf(fromStr, nextPos);
            if (nextPos == 0 && basePos < 0) { // first loop and not found
                return str; // without creating StringBuilder
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            if (basePos == 0) {
                sb.append(toStr);
                nextPos = fromStr.length();
            } else if (basePos > 0) {
                sb.append(str.substring(nextPos, basePos));
                sb.append(toStr);
                nextPos = basePos + fromStr.length();
            } else { // (basePos < 0) second or after loop only
                sb.append(str.substring(nextPos));
                return sb.toString();
            }
        } while (true);
    }

    /**
     * Convert to performance view.
     * @param afterMinusBefore The difference between before time and after time.
     * @return The view string to show performance. e.g. 01m40s012ms (NotNull)
     */
    protected String convertToPerformanceView(long afterMinusBefore) { // from DfTraceViewUtil.java
        if (afterMinusBefore < 0) {
            return String.valueOf(afterMinusBefore);
        }

        long sec = afterMinusBefore / 1000;
        final long min = sec / 60;
        sec = sec % 60;
        final long mil = afterMinusBefore % 1000;

        final StringBuffer sb = new StringBuffer();
        if (min >= 10) { // Minute
            sb.append(min).append("m");
        } else if (min < 10 && min >= 0) {
            sb.append("0").append(min).append("m");
        }
        if (sec >= 10) { // Second
            sb.append(sec).append("s");
        } else if (sec < 10 && sec >= 0) {
            sb.append("0").append(sec).append("s");
        }
        if (mil >= 100) { // Millisecond
            sb.append(mil).append("ms");
        } else if (mil < 100 && mil >= 10) {
            sb.append("0").append(mil).append("ms");
        } else if (mil < 10 && mil >= 0) {
            sb.append("00").append(mil).append("ms");
        }

        return sb.toString();
    }
}
