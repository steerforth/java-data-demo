package com.steer.demo.common.model;

import com.steer.demo.constant.ResultEnum;

/**
 * @Program: demo
 * @Author: Steerforth
 * @Description:
 * @Date: 2019-09-06 11:10
 */
public class Result<T> {

    public int status;

    public String desc;

    public T data;

    public static <T> Result<T> errorResult(int status){
        return new Result<T>(status,"",null);
    }

    public static <T> Result<T> errorResult(int status,String desc){
        return new Result<T>(status,desc,null);
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

    public static <T> Result<T> successResult(int status,String desc,T data){
        return new Result<T>(status,desc,data);
    }

    public Result() {
        super();
    }

    public Result(int status, String desc, T data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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