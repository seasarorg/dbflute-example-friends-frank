package com.example.dbflute.flex.simpleflute;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;

/**
 * The definition of classification.
 * @author DBFlute(AutoGenerator)
 */
public interface AppCDef {

    /** The empty array for no sisters. */
    String[] EMPTY_SISTERS = new String[]{};

    /** The empty map for no sub-items. */
    @SuppressWarnings("unchecked")
    Map<String, Object> EMPTY_SUB_ITEM_MAP = (Map<String, Object>)Collections.EMPTY_MAP;

    /**
     * @return The code of the classification. (NotNull)
     */
    String code();

    /**
     * @return The name of the classification. (NotNull)
     */
    String name();

    /**
     * @return The code of the classification. (NullAllowed: when an alias is not specified in its setting)
     */
    String alias();

    /**
     * @return The map of sub-items. (NotNull, EmptyAllowed, ReadOnly)
     */
    Map<String, Object> subItemMap();

    /**
     * @return The meta of the classification. (NotNull)
     */
    DefMeta meta();

    /**
     * フラグを示す
     */
    public enum Flg implements AppCDef {
        /** True: 有効を示す */
        True("1", "True", EMPTY_SISTERS)
        ,
        /** False: 無効を示す */
        False("0", "False", EMPTY_SISTERS)
        ;
        private static final Map<String, Flg> _codeValueMap = new HashMap<String, Flg>();
        static {
            for (Flg value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisters()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private String[] _sisters;
        private Flg(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisters = sisters; }
        public String code() { return _code; } public String alias() { return _alias; }
        private String[] sisters() { return _sisters; }
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        public DefMeta meta() { return DefMeta.Flg; }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Flg codeOf(Object code) {
            if (code == null) { return null; } if (code instanceof Flg) { return (Flg)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Flg nameOf(String name) { // null allowed
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<Flg> listAll() {
            return new ArrayList<Flg>(Arrays.asList(values()));
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 会員の状態を示す
     */
    public enum MemberStatus implements AppCDef {
        /** Provisional: 仮会員を示す */
        Provisional("PRV", "Provisional", EMPTY_SISTERS)
        ,
        /** Formalized: 正式会員を示す */
        Formalized("FML", "Formalized", EMPTY_SISTERS)
        ,
        /** Withdrawal: 退会会員を示す */
        Withdrawal("WDL", "Withdrawal", EMPTY_SISTERS)
        ;
        private static final Map<String, MemberStatus> _codeValueMap = new HashMap<String, MemberStatus>();
        static {
            for (MemberStatus value : values()) {
                _codeValueMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisters()) { _codeValueMap.put(sister.toLowerCase(), value); }
            }
        }
        private String _code; private String _alias; private String[] _sisters;
        private MemberStatus(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisters = sisters; }
        public String code() { return _code; } public String alias() { return _alias; }
        private String[] sisters() { return _sisters; }
        public Map<String, Object> subItemMap() { return EMPTY_SUB_ITEM_MAP; }
        public DefMeta meta() { return DefMeta.MemberStatus; }

        /**
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static MemberStatus codeOf(Object code) {
            if (code == null) { return null; } if (code instanceof MemberStatus) { return (MemberStatus)code; }
            return _codeValueMap.get(code.toString().toLowerCase());
        }

        /**
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static MemberStatus nameOf(String name) { // null allowed
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of all classification elements. (NotNull)
         */
        public static List<MemberStatus> listAll() {
            return new ArrayList<MemberStatus>(Arrays.asList(values()));
        }

        @Override public String toString() { return code(); }
    }

    public enum DefMeta {
        /** フラグを示す */
        Flg
        ,
        /** 会員の状態を示す */
        MemberStatus
        ;

        /**
         * Get classification by the code.
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the classification. (NullAllowed: when not found and code is null)
         */
        public AppCDef codeOf(Object code) {
            if ("Flg".equals(name())) { return AppCDef.Flg.codeOf(code); }
            if ("MemberStatus".equals(name())) { return AppCDef.MemberStatus.codeOf(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        /**
         * Get classification by the name.
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the classification. (NullAllowed: when not found and name is null)
         */
        public AppCDef nameOf(String name) {
            if ("Flg".equals(name())) { return AppCDef.Flg.valueOf(name); }
            if ("MemberStatus".equals(name())) { return AppCDef.MemberStatus.valueOf(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The list of classification elements. (NotNull)
         */
        public List<AppCDef> listAll() {
            if ("Flg".equals(name())) { return toClassificationList(AppCDef.Flg.listAll()); }
            if ("MemberStatus".equals(name())) { return toClassificationList(AppCDef.MemberStatus.listAll()); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @SuppressWarnings("unchecked")
        private List<AppCDef> toClassificationList(List<?> clsList) {
            return (List<AppCDef>)clsList;
        }
    }
}
