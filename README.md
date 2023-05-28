# JavaWebTest

[![Build and Release](https://github.com/jiangxincode/JavaWebTest/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/jiangxincode/JavaWebTest/actions/workflows/build.yml)
[![Deploy](https://img.shields.io/badge/JavaWebTest-Deploy-blue)](http://124.222.145.48:8080/JavaWebTest/index.jsp)

## License

+ GPLv3 http://www.gnu.org/licenses/gpl-3.0.txt

## Deployment

1. Install and config JDK(Test on jdk-8u321-windows-x64)
2. Install and config Maven(Test on apache-maven-3.8.1)
3. Install and config Tomcat(Test on apache-tomcat-8.5.82)
4. Install and config MySQL(Test on mysql-5.7.19-linux-glibc2.12-x86_64 on Ubuntu 16.04)
数据初始化脚本 `InitDbData.sql`

5. Import this project from IDEA by maven format

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
edu.jiangxin.webservice.mobilecodeservice
edu.jiangxin.webservice.phoneservice
edu.jiangxin.webservice.jobservice
edu.jiangxin.webservice.weatherservice
edu.jiangxin.webservice.languageservice (cxf)

## 圣思园

shengsiyuansrc/

目录结构有调整

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

# java-design-patterns

大话设计模式 程杰 原书使用C#作为样例语言，本项目翻译成Java语言

## 自己添加

* 委托模式

# java-encrypt-decrypt

Java加密与解密的艺术

## TODO

+ 批量文件重命名，批量文件备份和恢复；
+ 批量源代码文件注释删除；
+ 批量代码文件行数统计等等。

+ 增强系统鲁棒性
+ 随机身份证号码输出
+ 随机姓氏输出
+ 去除不必要的文档信息输出，如果必要，该用xml方式输出，便于扩展
+ Verify log4j related content.
+ Use the properties instead of xml to store password.

## Maven Command

```shell
mvn help:effective-pom -rf java-bigdata > a.log
mvn dependency:tree -rf java-bigdata > b.log
```
