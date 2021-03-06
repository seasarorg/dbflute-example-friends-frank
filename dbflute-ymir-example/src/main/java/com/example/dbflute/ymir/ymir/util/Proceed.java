package com.example.dbflute.ymir.ymir.util;

import org.seasar.ymir.Response;
import org.seasar.ymir.response.ProceedResponse;

public class Proceed {
    protected Proceed() {
    }

    public static Response to(String path, Object... params) {
        return new ProceedResponse(PageUtils.constructPath(path, false, params));
    }

    public static Response to(Class<?> pageClass, Object... params) {
        return new ProceedResponse(PageUtils.constructPath(pageClass, false,
                params));
    }
}
