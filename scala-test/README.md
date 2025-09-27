注意：

2、在1.1中，Spark SQL的HiveContext的hql已经变成了sql,所以视频中凡是出现hql("...")的地      方都需要改成sql("")

3、在1.1中，Spark SQL的SchemaRDD注册为table时的api由registerAsTable改成了registerTempTable，不过目前两者还是可以通用。