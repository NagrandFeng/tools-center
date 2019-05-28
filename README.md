# tools-center

## 简介
一个满足奇怪需求的仓库

1. 满足创建嵌套类型对象

2. 值都是随机生成，项目只是为了生成object的json结构


## 功能
待生成的entity大概长这样
```
Response.class
    | _ ...//其他基本属性
    | - OuterObject.class
        |
        | - InnerObject.class
            |
            | - ItemObject.class


```
生成效果如下
```json
{
	"status": "jglx",
	"message": "ztaedjarbu",
	"outerObject": {
		"account": 19,
		"valueFloat": 81.0,
		"valueByte": 63,
		"valueShort": 62,
		"customProperty": "z",
		"valueDouble": 112.0,
		"booleanValue": false,
		"accountInteger": 20,
		"valueFloatF": 50.0,
		"valueByteB": 97,
		"valueShortS": 18,
		"valueCharC": "c",
		"booleanValueB": true,
		"valueDoubleD": 98.0,
		"name": "jvbmut",
		"innerObject": {
			"userName": "gbqpe",
			"id": "ykereatm",
			"itemObject": {
				"item": "uzmqta"
			}
		}
	}
}
```

## todo list
1. 在属性上打注解的方式控制值的生成规则

2. 优化下生成属性的方法

3. basicProperty以外的一些类型补充，ep:数组类型，集合类型，Date目前的处理也有问题