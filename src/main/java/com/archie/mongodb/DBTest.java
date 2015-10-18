package com.archie.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * 查询指定数据库指定DBCollection集合中的所有数据
 * @author archie2010
 *
 * since 2012-9-29 下午10:40:21
 */
public class DBTest {
	public static void main(String[] args) throws UnknownHostException,
			MongoException {
		/**
		   Mongo实例代表了一个数据库连接池
		 * Mongo mg = new Mongo("localhost");
           Mongo mg = new Mongo("localhost", 27017);
		 */
		Mongo mg = new Mongo();
		// 查询所有的数据库
		for (String name : mg.getDatabaseNames()) {
			System.out.println("DB Name: " + name);
		}

		// 获取名为“dbtest”的数据库对象
		DB db = mg.getDB("dbtest");
		// 查询该库中所有的集合 (相当于表)
		for (String name : db.getCollectionNames()) {
			System.out.println("Collection Name: " + name);
		}
		DBCollection users = db.getCollection("emp");
		// 查询集合中所有的数据
		DBCursor cur = users.find();
		System.out.println("Record Count:" + cur.count());
		while (cur.hasNext()) {
			DBObject object = cur.next();
			System.out.println(object);
			// 取出对象中列表为字段名为'uname'和'upwd'的数据
			System.out.println("uname:" + object.get("uname") + "\tupwd:"
					+ object.get("upwd"));
		}
	}
}