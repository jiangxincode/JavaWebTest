package edu.jiangxin.db.mongodb;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class CRUDTest {

	public static void main(String[] args) throws UnknownHostException, MongoException {

		Mongo mongo = new Mongo(); // Mongo实例代表了一个数据库连接池
		// Mongo mg = new Mongo("localhost");
		// Mongo mg = new Mongo("localhost", 27017);
		for (String name : mongo.getDatabaseNames()) { // 查询所有的数据库
			System.out.println("DB Name: " + name);
		}

		DB db = mongo.getDB("dbtest"); // 获取名为“dbtest”的数据库对象
		for (String name : db.getCollectionNames()) { // 查询该库中所有的集合
			System.out.println("Collection Name: " + name);
		}


		DBCollection dbCollection = db.getCollection("user");
		DBCursor dbCuror = dbCollection.find(); // 查询集合中所有的数据
		DBObject dbObject = null;

		System.out.println("-----------------------增加前-------------------");
		System.out.println("Record Count:" + dbCuror.count());
		while (dbCuror.hasNext()) {
			dbObject = dbCuror.next();
			System.out.println(dbObject);
			System.out
					.println("username:" + dbObject.get("username") + "\tuserpassword:" + dbObject.get("userpassword"));
		}

		/*
		 * 添加
		 */
		dbObject = new BasicDBObject();
		dbObject.put("username", "teddy");
		dbObject.put("userpassword", "123456");

		dbCollection.insert(dbObject);
		dbCuror = dbCollection.find();
		System.out.println("-----------------------增加后-------------------");
		System.out.println("Record Count:" + dbCuror.count());
		while (dbCuror.hasNext()) {
			DBObject object = dbCuror.next();
			System.out.println(object);
			System.out.println("username:" + object.get("username") + "\tuserpassword:" + object.get("userpassword")
					+ "\t_id:" + object.get("_id"));
		}

		/*
		 * 更新
		 */
		dbObject = new BasicDBObject();
		dbObject.put("username", "teddy");
		dbObject.put("userpassword", "3333");

		dbCollection.update(new BasicDBObject("username", "teddy"), dbObject);
		dbCuror = dbCollection.find();
		System.out.println("-----------------------修改后-------------------");
		System.out.println("Record Count:" + dbCuror.count());
		while (dbCuror.hasNext()) {
			DBObject object = dbCuror.next();
			System.out.println(object);
			System.out.println("username:" + object.get("username") + "\tuserpassword:" + object.get("userpassword")
					+ "\t_id:" + object.get("_id"));
		}

		/*
		 * 删除
		 */
		dbCollection.remove(new BasicDBObject("username", "teddy"));
		System.out.println("-----------------------删除后-------------------");
		dbCuror = dbCollection.find();
		System.out.println("Record Count:" + dbCuror.count());
		while (dbCuror.hasNext()) {
			DBObject object = dbCuror.next();
			System.out.println(object);
			System.out.println("username:" + object.get("username") + "\tuserpassword:" + object.get("userpassword")
					+ "\t_id:" + object.get("_id"));
		}
	}
}
