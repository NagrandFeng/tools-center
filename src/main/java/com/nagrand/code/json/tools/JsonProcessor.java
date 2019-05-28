package com.nagrand.code.json.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nagrand.code.json.entity.Response;

/**
 * @author Yeshufeng
 * @title 生成json字符串
 * @date 2019/5/28
 */
public class JsonProcessor {

    private Gson gson = new GsonBuilder().serializeNulls().create();

    private PropertyGenerate propertyGenerate = new PropertyGenerate();


    public static void main(String[] args) {
        JsonProcessor jsonProcessor =new JsonProcessor();
        Response response = new Response();

        String s = jsonProcessor.getJsonStr(response);
        System.out.println(s);
    }

    public String getJsonStr(Object o){
        propertyGenerate.setRandomProperty(o);
        return gson.toJson(o);
    }

}
