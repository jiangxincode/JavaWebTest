package cn.chinahadoop.spark

import org.apache.spark.{ SparkContext, SparkConf }
import scala.collection.mutable.ListBuffer
import org.apache.spark.SparkContext._

class Analysis {

}

/**
 * 下载搜狗实验室用户查询日志精简版（63M）：http://download.labs.sogou.com/dl/sogoulabdown/SogouQ/SogouQ.reduced.zip
 * 做以下查询：
 * 1、用户在00:00:00到12:00:00之间的查询数？
 * 2、搜索结果排名第一，但是点击次序排在第二的数据有多少？
 *
 */
object Analysis {

  def main(args: Array[String]) {

    val conf = new SparkConf()
    conf.setMaster("spark://Ubuntu-01:7077")
      .setSparkHome("/usr/local/spark/spark-2.1.0-bin-hadoop2.7")
      .setAppName("analysis")
      .set("spark.executor.memory", "25g")

    val sc = new SparkContext(conf)
    val data = sc.textFile("hdfs://Ubuntu-01:9000/spark/test/SogouQ.reduced")
    
    

    println(data.count)
    data.cache
    println(data.count)
    println(data.map(_.split('\t')(0)).filter(_ > "00:00:00").filter(_ < "12:00:00").count)
    //println(data.map(_.replace(' ', '\t')).filter(_.split('\t')(3).toInt == 1).filter(_.split('\t')(4).toInt == 2).count)
    println(data.map(_.replace(' ', '\t')).filter(_.split('\t')(3).toInt == 1).count)
    println(data.map(_.replace(' ', '\t')).filter(_.split('\t')(4).toInt == 2).count)
  }

}
