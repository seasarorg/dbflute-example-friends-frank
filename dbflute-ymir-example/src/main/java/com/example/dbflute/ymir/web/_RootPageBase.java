package com.example.dbflute.ymir.web;

public class _RootPageBase extends com.example.dbflute.ymir.web.PageBase {
    @org.seasar.ymir.annotation.Meta(name = "source", value = "return \"redirect:/member/search/list.html\";")
    public String _get() {
        return "redirect:/member/search/list.html";
    }
}
