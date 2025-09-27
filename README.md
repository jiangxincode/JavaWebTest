# MyTestProject

[![Build](https://github.com/jiangxincode/MyTestProject/actions/workflows/build.yml/badge.svg?branch=master)](https://github.com/jiangxincode/MyTestProject/actions/workflows/build.yml)
[![Deploy](https://github.com/jiangxincode/MyTestProject/actions/workflows/deploy.yml/badge.svg?branch=master)](https://github.com/jiangxincode/MyTestProject/actions/workflows/deploy.yml)
[![Apache License V2.0](https://img.shields.io/badge/license-Apache%202-green)](http://www.apache.org/licenses/LICENSE-2.0)

## 常用maven命令备忘

```shell
mvn help:effective-pom -rf java-bigdata #打印生效的pom文件
mvn dependency:tree -rf java-bigdata #打印依赖树
mvn clean package -DskipTests #不执行测试用例，但编译测试用例类生成相应的class文件至target/test-classes下
mvn clean package -D"maven.test.skip=true" #不执行测试用例，也不编译测试用例类
```