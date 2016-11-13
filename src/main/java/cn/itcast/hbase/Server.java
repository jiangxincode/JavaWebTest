/**
 * 这段代码不是itcast的，为了方便放到了这里
 */
package cn.itcast.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;


public class Server {
	public static void main(String args[]) {
		try
		{
			HBaseConfiguration config =new HBaseConfiguration();//获得Hbase配置参数  
			//config.clear();
			config.set("hbase.master","10.28.0.185:60000");
			config.set("hbase.zookeeper.quorum","10.28.0.186,10.28.0.187,10.28.0.188");
		//	config.set("hbase.rootdir", "hdfs://localhost.localdomain:9000/hbase");
			//config.set("hbase.cluster.distributed","true");
			config.set("hbase.zookeeper.property.clientPort", "2223");
			//config.set("zookeeper.session.timeout","60000");
		//	config.set("hbase.regionserver.port", "61234");
			config.set("hbase.master.port", "62345");
			//config.set("HBASE_MANAGER_ZK", "true");
	        HBaseAdmin admin =new HBaseAdmin(config);//新建一个数据库管理员  
	        if (admin.tableExists("info")) {  
	            System.out.println("drop table");  
	            admin.disableTable("info");//关闭一个表  
	            admin.deleteTable("info");//删除一个表  
	        }  
	        System.out.println("create table");  
	        HTableDescriptor tableDescripter =new HTableDescriptor("info".getBytes());//新建一个scores表的描述  
	        tableDescripter.addFamily(new HColumnDescriptor("details:"));//在描述里添加列族  
	        admin.createTable(tableDescripter);//根据配置好的描述建表  
	        HTable htable =new HTable(config,"info");//返回表scores的实例
	        
	        htable.setAutoFlush(true);
	        htable.setWriteBufferSize(1024 * 1024 * 100);
	        
	        byte[] rowkey = Bytes.toBytes(1);
			Put put = new Put(rowkey);
			put.add(Bytes.toBytes("details"),Bytes.toBytes("name"),Bytes.toBytes("liuyue"));
			put.add(Bytes.toBytes("details"),Bytes.toBytes("num"),Bytes.toBytes("24"));
			put.add(Bytes.toBytes("details"),Bytes.toBytes("time"),Bytes.toBytes("2011"));
			htable.put(put);
			
			htable.flushCommits();
			
			Get get=new Get(Bytes.toBytes(1));//新建Get实例，用来根据条件返回一个指定行里的数据  
	        Result r=htable.get(get);//返回一个指定行里的数据
	        byte[] value1 = r.getValue(Bytes.toBytes("details"),Bytes.toBytes("name"));
	        byte[] value2 = r.getValue(Bytes.toBytes("details"),Bytes.toBytes("num"));
	        byte[] value3 = r.getValue(Bytes.toBytes("details"),Bytes.toBytes("time"));//根据列key=course:math，返回value 
			
	        System.out.println(new String(value1));
	        System.out.println(new String(value2));
	        System.out.println(new String(value3));
			htable.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
