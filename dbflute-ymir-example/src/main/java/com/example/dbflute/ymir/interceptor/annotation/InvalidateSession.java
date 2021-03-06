package com.example.dbflute.ymir.interceptor.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.seasar.framework.aop.annotation.Interceptor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Interceptor("invalidateSessionInterceptor")
public @interface InvalidateSession {
}
