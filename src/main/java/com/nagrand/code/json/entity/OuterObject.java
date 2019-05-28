package com.nagrand.code.json.entity;

import lombok.Data;

/**
 * @author Yeshufeng
 * @title
 * @date 2018/12/10
 */
@Data
public class OuterObject {

    private int account;

    private float valueFloat;

    private byte valueByte;

    private short valueShort;

    private char customProperty;

    private double valueDouble;

    private boolean booleanValue;

    private Integer accountInteger;

    private Float valueFloatF;

    private Byte valueByteB;

    private Short valueShortS;

    private Character valueCharC;

    private Boolean booleanValueB;

    private Double valueDoubleD;

    private String name;

    private InnerObject innerObject;
}
