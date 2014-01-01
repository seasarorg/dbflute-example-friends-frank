package com.example.dbflute.ymir.ymir.util;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.ymir.Request;
import org.seasar.ymir.RequestProcessor;
import org.seasar.ymir.Response;
import org.seasar.ymir.message.Note;
import org.seasar.ymir.message.Notes;
import org.seasar.ymir.response.PassthroughResponse;

abstract public class PageBase {
    public static final String SCHEME_FORWARD = PageUtils.SCHEME_FORWARD;

    public static final String SCHEME_REDIRECT = PageUtils.SCHEME_REDIRECT;

    public static final String SCHEME_PROCEED = PageUtils.SCHEME_PROCEED;

    public static final String PASSTHROUGH = PageUtils.SCHEME_PASSTHROUGH;

    private Request ymirRequest;

    @Binding(bindingType = BindingType.MUST)
    final public void setYmirRequest(Request ymirRequest) {
        this.ymirRequest = ymirRequest;
    }

    final public Request getYmirRequest() {
        return ymirRequest;
    }

    final protected void addNote(String key) {
        addNote(new Note(key));
    }

    final protected void addNote(Note note) {
        if (note != null) {
            getNotes().add(note);
        }
    }

    final protected Notes getNotes() {
        Notes notes = (Notes) ymirRequest.getAttribute(RequestProcessor.ATTR_NOTES);
        if (notes == null) {
            notes = new Notes();
            ymirRequest.setAttribute(RequestProcessor.ATTR_NOTES, notes);
        }
        return notes;
    }

    final protected Response passthrough() {
        return new PassthroughResponse();
    }
}
