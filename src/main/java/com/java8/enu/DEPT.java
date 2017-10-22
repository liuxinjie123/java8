package com.java8.enu;

public enum DEPT {
    IT("001", "IT"),
    CUSTOMER("002", "CUSTOMER"),
    FINANCE("003", "FINANCE"),

    ;
    public String code;
    public String name;

    DEPT(){};

    DEPT(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
