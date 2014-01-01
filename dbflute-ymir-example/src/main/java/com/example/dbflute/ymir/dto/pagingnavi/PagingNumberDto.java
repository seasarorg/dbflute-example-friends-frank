package com.example.dbflute.ymir.dto.pagingnavi;

import java.io.Serializable;

/**
 * @author jflute
 */
public class PagingNumberDto implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Integer value;

    protected boolean current;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public PagingNumberDto() {
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder().append('(');
        append(sb.append("value="), value).append(", ");
        append(sb.append("current="), current);
        sb.append(')');
        return toString(sb);
    }

    protected StringBuilder append(StringBuilder sb, Object obj) {
        if (obj != null && obj.getClass().isArray()) {
            sb.append('{');
            int len = java.lang.reflect.Array.getLength(obj);
            String delim = "";
            for (int i = 0; i < len; i++) {
                sb.append(delim);
                delim = ", ";
                append(sb, java.lang.reflect.Array.get(obj, i));
            }
            sb.append('}');
        } else {
            sb.append(obj);
        }
        return sb;
    }

    protected String toString(StringBuilder sb) {
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isCurrent() {
        return this.current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
