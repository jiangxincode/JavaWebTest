# JavaWebTest

[![Build and Release](https://github.com/jiangxincode/JavaWebTest/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/jiangxincode/JavaWebTest/actions/workflows/build.yml)
[![Deploy](https://img.shields.io/badge/JavaWebTest-Deploy-blue)](http://124.222.145.48:8080/java-web-test/index.jsp)
[![Apache License V2.0](https://img.shields.io/badge/license-Apache%202-green)](http://www.apache.org/licenses/LICENSE-2.0)

## Deployment

* Ubuntu 22.04 LTS
* JDK21
* Tomcat 11
* MySQL 5.7.19
* 数据初始化脚本 `InitDbData.sql`

## 常用maven命令备忘

```shell
mvn help:effective-pom -rf java-bigdata #打印生效的pom文件
mvn dependency:tree -rf java-bigdata #打印依赖树
mvn clean package -DskipTests #不执行测试用例，但编译测试用例类生成相应的class文件至target/test-classes下
mvn clean package -D"maven.test.skip=true" #不执行测试用例，也不编译测试用例类
```

## TODO

* 解决编译告警
* 解决运行告警
* 将main方法改为单元测试
* 统一使用UTF-8编码

+ 批量文件重命名，批量文件备份和恢复；
+ 批量源代码文件注释删除；
+ 批量代码文件行数统计等等。

+ 增强系统鲁棒性
+ 随机身份证号码输出
+ 随机姓氏输出
+ 去除不必要的文档信息输出，如果必要，该用xml方式输出，便于扩展
+ Verify log4j related content.
+ Use the properties instead of xml to store password.

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
* forward和include
* service和doGet等的关系
* EL表达式变量的作用范围
* eclipse调试
* 各种乱七八糟的Dispatcher
* html5和CSS3
* 控制层在filter，显示层配置在*.xml，逻辑层还是需要servlet来完成
* eclipse快捷键

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