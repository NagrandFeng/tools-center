package com.nagrand.code.json.entity;

import lombok.Data;

/**
 * @author Yeshufeng
 * @title
 * @date 2018/12/10
 */
@Data
public class Response {

   private String status;

   private String message;

   private OuterObject outerObject;


}
