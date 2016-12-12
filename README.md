# Test

[![Build status](https://ci.appveyor.com/api/projects/status/lcxa9ka5mltxighw?svg=true)](https://ci.appveyor.com/project/jiangxincode/javawebtest)
[![Dependency Status](https://www.versioneye.com/user/projects/58286ae9f09d22004f59150d/badge.svg?style=flat)](https://www.versioneye.com/user/projects/58286ae9f09d22004f59150d)

jiangxinnju@163.com

http://github.com/jiangxincode


## 版本改动

### Version 0.01

* 初始化环境

### Version 0.02

* 完成猜数字的jsp实现

### Version 0.03

* 完成猜数字的servlet实现

### Version 0.04

* 初步实现流量统计，但是还有很多问题需要解决

### Version 0.05

* 初步实现CURD的功能
* 去除项目全部警告

### Version 0.06

* 使用独立CSS文件代替内嵌样式表
* 修复了一些小bugs
* 数据库，源代码等全部统一为utf8编码

### Version 0.07

* 解决部分数据库作者无法显示的bug

### Version 0.08

* 修复了有关流量统计的一些bugs

### Version 0.09

* 修复了一些bugs
* 美化了部分页面
* 解决猜数字jsp实现中js问题
* 增加了一些独立CSS文件

## 将要进行的改进

* 重新设计各个页面的格式
* 删除不必要代码
* 数据库乱码
* 修复why标记
* tomcat修改缓存的目的
* 权限，规则 filter /*
* listerner
* $(param.guess)与request.getParameter("guess")区别（null）
* forward和include
* service和doGet等的关系
* EL表达式变量的作用范围
* eclipse调试
* 各种乱七八糟的Dispatcher
* html5和CSS3
* 控制层在filter，显示层配置在*.xml，逻辑层还是需要servlet来完成
* eclipse快捷键


webservice学习顺序:
edu.jiangxin.webservice.socket
edu.jiangxin.webservice.mobilecodeservice
edu.jiangxin.webservice.phoneservice
edu.jiangxin.webservice.jobservice
edu.jiangxin.webservice.weatherservice
edu.jiangxin.webservice.languageservice (cxf)



Some tests and exercises in Java.

## 传智播客Hadoop7天培训_吴超版

* 原工程：hbase-demo
* 所在包：cn.itcast.hbase
* hbase由0.94.7升级为0.94.26

* 原工程：hive-udf
* 所在包：cn.itcast.hive.udf
* hive由0.9.0升级为1.2.1

## storm视频教程

* 原工程：storm
* 所在包：cn.itcast.storm.storm

* 原工程：wordCount
* 所在包：原工程没有src包，反编译bin/下的代码与storm/下的类似，直接删除

* 原工程：reliability
* 所在包：cn.itcast.storm.reliability

* 原工程：lifeCycle
* 所在包：cn.itcast.storm.lifeCycle

* 原工程：component
* 所在包：cn.itcast.storm.component


# 设计模式

## 大话设计模式源代码 JAVA 吴强

* 修改了代码格式

publishSubscribe?
* 第一章 大学毕业了怎么办？——设计模式概述

* 第二章 学校招聘会——接口型模式介绍
* 第三章 我们班来了位新同学——适配器模式 adapter
* 第四章 金融危机股票还挣钱？——外观模式 facade
* 第五章 生日礼物——组合模式 composite
* 第六章 蜡笔与毛笔——桥接模式 bridge

* 第七章 击鼓传花——责任型模式 chainOfResponsibility
* 第八章 购物车——单体模式 singleton
* 第九章 放风者与偷窃者——观察者模式
* 第十章 中介公司——中介者模式 mediator
* 第十一章 高老庄的故事——代理模式 proxy
* 第十二章 包子——享元模式 flyWeight

* 第十三章 可恶的皇帝——构造型模式
* 第十四章 汽车组装——生成器模式 builder
* 第十五章 运动协会——工厂方法模式 factoryMethod simpleFactory
* 第十六章 麦当劳的鸡腿——抽象工厂模式
* 第十七章 兰州拉面馆——原型模式 prototype
* 第十八章 月光宝盒——备忘录模式 memento

* 第十九章 儿子的功课——操作型模式
* 第二十章 订单处理——模板方法模式 templateMethod
* 第二十一章 金融危机何时休——状态模式 state
* 第二十二章 还钱——策略模式 strategy
* 第二十三章 饭店点菜——命令模式 command
* 第二十四章 苹果汁——解释器模式 interpreter

* 第二十五章 多功能的手机——扩展型模式
* 第二十六章 三明治——装饰器模式 decorator
* 第二十七章 老公，有钱不？——迭代器模式
* 第二十八章 只会工人工作——访问者模式 visitor
* 第二十九章 大学生毕业3条出路：学、仕、商——设计模式总结

## 自己添加

* 委托模式


Java加密与解密的艺术。




# TextTools

## Author

+ JiangXin jiangxinnju@163.com

## Description

文本处理工具包，您可以有两种方式使用：

1. 作为一个文本处理小工具，以实现以下功能：

+ 文本文件的编码格式批量转换（可以自行指定编码亦可以由本工具自行探测）；
+ Unix、Mac、Dos等文件格式的批量互转；
+ 批量文件重命名，批量文件备份和恢复；
+ 批量源代码文件注释删除；
+ 批量代码文件行数统计等等。

2. 作为一个文本工具处理的JAVA封装包，由于上述功能都很好的以包的方式进行封装，您可以直接调用相关功能，另外您还可能使用以下功能：

+ 目录的递归复制、移动、删除；
+ 文件过滤（通过该功能您可以将某个目录下符合特定条件的文件进行操作，比如仅针对后缀名为.java的文件进行复制）；
+ 随机数据生成，可看做是Java官方Random类的扩充。目前已经实现：
    + 随机英文输出（自定义大小写，自定义固定长度还是随机长度）；
    + 随机ASCII字符，随机扩展ASCII字符，随机可打印ASCII字符输出；
    + 随机中文输出（自定义固定长度还是随机长度）；
    + 随机Eamil地址输出，随机手机号码输出，随机日期输出等。

## Usage:

说明：由于使用的是Java进行编程，所以具有平台通用性，您可以同时在Mac,Windows,Linux/Unix等平台上以上述两种方式使用。如果您想以第一种方式对文件进行处理，可以参考下面的用法说明；如果您想以第二种方式使用，您所下载的压缩包里应该有该工具的example和详细的API文档，如果没有请您到下面提供的网站中重新下载。

```Batchfile
java -jar TestTools [option] filename1 [filename2...]
-f The encoder of your file.If you don't know the econder,we will try to detect auto.However we can't ensure the validity!
-t The encoder you want to convert
-os pattern Convert your file from one os patter to another.pattern includes:dos2mac dos2unix dos2linux mac2dos mac2unix, etc.
-b Backup your file when Convert.It's recommended!
-r Recovey your file..Can't use with other options!
-suffix 文件的后缀名 过滤特定后缀的文件进行处理，比如-suffix .txt
-sum 统计代码的行数
-h Display this usage.
filename1[,filename2...] The file that you want to convert,at most one file.
```

For example:
```Batchfile
    java -jar TestTools -f GBK -t UTF-8 test.txt
    java -jar TestTools  -dos2unix test.txt
    java -jar TestTools -r test.txt
```

## UpdateInfo

+ Version 0.01 搭建起基本框架，实现基本功能，包括：备份、恢复文件，基本编码转换，显示帮助文档，文本编码检测，DOS/Unix文件格式互转
+ Version 0.02 为每个源文件添加了说明信息，去除了部分冗余代码，提高了程序的可读性。
+ Version 0.03 为FileProcess类添加了删除目录的函数，便于以后扩展。
+ Version 0.04 实现代码统计功能。
+ Version 0.05 为每个源文件添加了说明信息，去除了部分冗余代码，提高了程序的可读性。
+ Version 0.06 实现简单的文件重命名功能。
+ Version 0.07 Apache commons-io包的依赖，使用java自带的类库代替，同时统一了函数接口。提高了系统效率。优化了程序结构。
+ Version 0.08 这是一次较为重大的升级，主要变动为：将不同操作系统之间文件格式进行转变的逻辑判断部分由主类转入OSPatternConvert；OSPatternConvert类实现了更好地封装，提供了更多函数功能，实现批量文件转换，鲁棒性更好，系统结构更加优良；同时修复了fileFilter类中的部分bug。
+ Version 0.09 将备份功能从Mail类中分离，单列为一类，以实现结构优化和之后的程序扩展；进一步优化了Main的结构。
+ Version 0.10 将恢复功能从Mail类中分离，单列为一类，以实现结构优化和之后的程序扩展；进一步优化了Main的结构。
+ Version 0.11 优化了Main类和OSPatternConvert类。
+ Version 0.12 优化了Main类和检码转码部分。至此Main部分优化大体完成，实现了程序的可读性。
+ Version 0.13 实现了消除注释功能。但是此部分编码识别等部分还存在一些bug。此部分代码参考了一些网友的代码。
+ Version 0.14 实现了提示信息的文档化。
+ Version 0.15 添加随机数据生成功能，能够实现基本的随机数据生成，包括随机英文输出（自定义大小写，自定义固定长度还是随机长度），随机ASCII字符，随机扩展ASCII字符，随机可打印ASCII字符输出，随机中文输出（自定义固定长度还是随机长度），随机Eamil地址输出，随机手机号码输出，随机日期输出等，可看做是Java官方Random类的扩充。
+ Version 0.16 更新的文档说明。
+ Version 0.16 将所有代码文件添加简单注释。优化了程序结构。
+ Version 0.17 对文件结构进行了大调整，进一步增加了说明注释，修改了OSPatternConvert类的部分方法。
+ Version 0.18 利用Markdown重写了README.MD
+ Version 0.19 修改了此README.md文件
+ Version 0.20 使用junit替换原手工测试
+ Version 0.21 更新了README.md, 完全引入junit，删除原有测试方法。重命名了某些文件
+ 转换为maven项目[20150804]
+ 更改了帮助信息显示方式[20150806]
+ 更新了大部分单元测试[20150806]
+ 组织了文件结构[20150806]

## TODO

+ 增强系统鲁棒性
+ 随机身份证号码输出
+ 随机姓氏输出
+ 去除不必要的文档信息输出，如果必要，该用xml方式输出，便于扩展

## License:

+ GPLv3 http://www.gnu.org/licenses/gpl-3.0.txt
