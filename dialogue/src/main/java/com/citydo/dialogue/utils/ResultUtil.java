package com.citydo.dialogue.utils;


import com.google.gson.Gson;

/**
 * @ClassName ResultUtil
 */
public class ResultUtil<T> {

    public static String success() {
        Result result = new Result(ResultEnum.SUCCESS);
        return new Gson().toJson(result);
    }

    public static String success(Object obj) {
        Result result = new Result(ResultEnum.SUCCESS, obj);
        return new Gson().toJson(result);
    }

    public static String fail() {
        Result result = new Result(ResultEnum.FAIL);
        return new Gson().toJson(result);
    }

    public static String success(Integer code,String message) {
        Result result = new Result(code,message);
        return new Gson().toJson(result);
    }

}
