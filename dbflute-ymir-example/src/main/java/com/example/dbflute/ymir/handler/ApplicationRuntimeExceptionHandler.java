package com.example.dbflute.ymir.handler;

import java.util.Iterator;

import org.seasar.ymir.Response;
import org.seasar.ymir.handler.annotation.ExceptionHandler;
import org.seasar.ymir.message.Note;

import com.example.dbflute.ymir.exception.ApplicationRuntimeException;

public class ApplicationRuntimeExceptionHandler extends HandlerBase {
    
    @ExceptionHandler
    public Response handle(ApplicationRuntimeException t) {
        for (Iterator<Note> itr = t.getNotes().get(); itr.hasNext();) {
            addNote(itr.next());
        }
        return toErrorPage();
    }
}
