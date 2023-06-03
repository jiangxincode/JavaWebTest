package edu.jiangxin.bd.hbase.demo;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.BufferedMutator;
import org.apache.hadoop.hbase.client.BufferedMutatorParams;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * hbase -jar big-data-demo-0.0.1-SNAPSHOT.jar
 * @author jiangxin
 *
 */
public class HbaseDemo {
	public static void main(String args[]) throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		Configuration config = HBaseConfiguration.create();
		config.set("hbase.master", "192.169.1.160:16000");
		Connection conn = ConnectionFactory.createConnection(config);

		Admin admin = conn.getAdmin();
		TableName tableName = TableName.valueOf("info");
		if (admin.tableExists(tableName)) {
			System.out.println("The table exists: " + tableName.getNameAsString());
			admin.disableTable(tableName);
			admin.deleteTable(tableName);//删除一个表
			System.out.println("The table is deleted: " + tableName.getNameAsString());
		}

		HTableDescriptor tableDescripter = new HTableDescriptor(tableName);
		HColumnDescriptor hColumnDescriptor = new HColumnDescriptor("details");
		hColumnDescriptor.setVersions(3, 10);
		tableDescripter.addFamily(hColumnDescriptor);
		admin.createTable(tableDescripter);
		System.out.println("The table is created: " + tableName.getNameAsString());

		Table table = conn.getTable(tableName);
		BufferedMutatorParams params = new BufferedMutatorParams(tableName);
		params.writeBufferSize(1024 * 1024 * 100);

		BufferedMutator bufferedMutator = conn.getBufferedMutator(params);

		for (int i = 0; i < 1000; i++) {
			Put put = new Put(Bytes.toBytes("row-key-" + String.format("%04d", i)));
			put.addColumn(Bytes.toBytes("details"), Bytes.toBytes("name"), Bytes.toBytes("jiangxin"));
			put.addColumn(Bytes.toBytes("details"), Bytes.toBytes("num"), Bytes.toBytes("24"));
			put.addColumn(Bytes.toBytes("details"), Bytes.toBytes("time"), Bytes.toBytes("2011"));
			table.put(put);
		}

		bufferedMutator.flush();

		Get get = new Get(Bytes.toBytes("row-key-0001"));//新建Get实例，用来根据条件返回一个指定行里的数据
		get.setMaxVersions(5);
		Result r = table.get(get);//返回一个指定行里的数据

		// 获取数据方式1
		for (Cell cell : r.getColumnCells(Bytes.toBytes("details"), Bytes.toBytes("name"))) {
			System.out.println(cell.getTimestamp());
		}

		// 获取数据方式2
		byte[] value1 = r.getValue(Bytes.toBytes("details"), Bytes.toBytes("name"));
		System.out.println(new String(value1));

		Scan scan = new Scan(Bytes.toBytes("row-key-0001"), Bytes.toBytes("row-key-0100"));
		scan.addFamily(Bytes.toBytes("details"));
		ResultScanner scanner = table.getScanner(scan);
		for (Result result : scanner) {
			byte[] value = result.getValue(Bytes.toBytes("details"), Bytes.toBytes("name"));
			System.out.println(new String(value));
		}

		Delete del = new Delete(Bytes.toBytes("rk0001"));
		del.addColumn(Bytes.toBytes("details"), Bytes.toBytes("name"));
		table.delete(del);
		table.close();
	}
}
