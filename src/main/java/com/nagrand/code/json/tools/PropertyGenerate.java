package com.nagrand.code.json.tools;

import com.google.common.collect.Sets;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

/**
 * @author Yeshufeng
 * @title 随机生成object的属性
 * @date 2019/5/28
 */
public class PropertyGenerate {


    private  final Set<String> basicProperty = Sets.newHashSet();

    private final int UPPER_STRING = 2;

    private final int LOWER_STRING = 1;

    {
        basicProperty.add("int");
        basicProperty.add("byte");
        basicProperty.add("short");
        basicProperty.add("char");
        basicProperty.add("double");
        basicProperty.add("float");
        basicProperty.add("boolean");
        basicProperty.add("java.lang.String");
        basicProperty.add("java.lang.Double");
        basicProperty.add("java.lang.Float");
        basicProperty.add("java.lang.Integer");
        basicProperty.add("java.lang.Short");
        basicProperty.add("java.lang.Byte");
        basicProperty.add("java.lang.Boolean");
        basicProperty.add("java.lang.Character");
    }


    public Object setRandomProperty(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields) {
            boolean flag = field.isAccessible();
            try {
                field.setAccessible(true);

                if (basicProperty.contains(field.getType().getTypeName())) {
                    setPropertyByType(o, field);
                } else {
                    Class clazz = field.getType();
                    Object propertySet = clazz.newInstance();
                    setRandomProperty(propertySet);
                    field.set(o, propertySet);
                }

            } catch (Exception e) {

            }
            field.setAccessible(flag);
        }
        return o;
    }


    private boolean setPropertyByType(Object o, Field property) {

        boolean result = false;

        Class clazz = property.getType();

        String type = clazz.getTypeName();

        try {
            if (clazz.isPrimitive()) {
                switch (type) {
                    case "int":
                        property.set(o, getRandom(0, 100));
                        break;
                    case "float":
                        property.set(o, (float) getRandom(0, 100));
                        break;
                    case "byte":
                        property.set(o, (byte) getRandom(0, 100));
                        break;
                    case "short":
                        property.set(o, (short) getRandom(0, 100));
                        break;
                    case "char":
                        property.set(o, (char) getRandom(97, 122));
                        break;
                    case "double":
                        property.set(o, (double) getRandom(97, 122));
                        break;
                    case "boolean":
                        property.set(o, 1 == getRandom(0, 2));
                        break;
                }
            } else {
                switch (type) {
                    case "java.lang.String":
                        property.set(o, getRandomStringByType(LOWER_STRING));
                        break;
                    case "java.lang.Integer":
                        property.set(o, getRandom(0, 100));
                        break;
                    case "java.lang.Double":
                        property.set(o, new Double(getRandom(0, 100)));
                        break;
                    case "java.lang.Float":
                        property.set(o, new Float(getRandom(0, 100)));
                        break;
                    case "java.lang.Byte":
                        property.set(o, new Byte((byte) getRandom(0, 100)));
                        break;
                    case "java.lang.Short":
                        property.set(o, new Short((short) getRandom(0, 100)));
                        break;
                    case "java.lang.Character":
                        property.set(o, new Character((char) getRandom(97, 122)));
                        break;
                    case "java.lang.Boolean":
                        property.set(o, getRandom(0, 2) == 1);
                        break;
                }
            }
            result = true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取随机字符串
     *
     * @param type 1:小写字符串，2：大写字符串
     * @return
     */
    private  String getRandomStringByType(int type) {
        Integer size = getRandom(4, 12);//随机生成4~12位字符串

        String result;
        switch (type) {
            default:

            case LOWER_STRING:
                result = getLowerString(size);
                break;

            case UPPER_STRING:
                result = getUpperString(size);
                break;
        }

        return result;
    }

    private  String getUpperString(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char stringItem = (char) getRandom(65, 90);
            sb.append(stringItem);
        }
        return sb.toString();
    }

    private  String getLowerString(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char stringItem = (char) getRandom(97, 122);
            sb.append(stringItem);
        }
        return sb.toString();
    }


    /**
     * 大写：65-90 小写：97-122 之间取随机值
     *
     * @param min
     * @param max
     * @return
     */
    private int getRandom(int min, int max) {
        Random random = new Random();
        int s;
        while (true) {
            s = random.nextInt(max) % (max - min + 1) + min;
            if (s < 91 || s > 96) {
                break;
            }
        }
        return s;

    }


}
