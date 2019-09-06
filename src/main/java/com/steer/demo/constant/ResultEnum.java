package com.steer.demo.constant;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:11
 */
public enum ResultEnum {
    ok("SUCCESS", 200),
    error("ERROR", -1),
    error_500("500", 500);

    private String name;
    private int code;

    ResultEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

