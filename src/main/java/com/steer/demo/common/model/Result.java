package com.steer.demo.common.model;

import com.steer.demo.constant.ResultEnum;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:10
 */
public class Result<T> {

    public int code;

    public String desc;

    public T data;

    public static <T> Result<T> errorResult(int code){
        return new Result<T>(code,"",null);
    }

    public static <T> Result<T> errorResult(int code,String desc){
        return new Result<T>(code,desc,null);
    }

    public static <T> Result<T> successReult(){
        return new Result<T>(ResultEnum.ok.getCode(),"",null);
    }

    public static <T> Result<T> successReult(T data){
        return new Result<T>(ResultEnum.ok.getCode(),"",data);
    }

    public static <T> Result<T> successReult(String desc,T data){
        return new Result<T>(ResultEnum.ok.getCode(),desc,data);
    }

    public static <T> Result<T> successResult(int code,String desc,T data){
        return new Result<T>(code,desc,data);
    }

    public Result() {
        super();
    }

    public Result(int code,String desc,T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}