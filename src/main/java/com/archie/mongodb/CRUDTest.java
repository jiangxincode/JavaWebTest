package com.archie.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 对指定DBCollection集合的CRUD操作
 * @author archie2010
 *
 * since 2012-9-29 下午10:51:24
 */
public class CRUDTest {
	/**
	 * 增加
	 * @param obj
	 */
	public static void add(DBObject obj){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		coll.insert(obj);
	}
	/**
	 * 删除
	 * @param obj
	 */
	public static void delete(DBObject obj){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		coll.remove(obj);
	}
	/**
	 * 查询
	 */
	public static void query(){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		// 查询集合中所有的数据
		DBCursor cur = coll.find();
		System.out.println("Record Count:" + cur.count());
		while (cur.hasNext()) {
			DBObject object = cur.next();
			System.out.println(object);
			// 取出对象中列表为'uname'和'upwd'的数据
			System.out.println("uname:" + object.get("uname") + "\tupwd:"
					+ object.get("upwd")+"\t_id:"+object.get("_id"));
		}
	}
	/**
	 * 修改
	 */
	public static void modify(DBObject orig,DBObject update){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		coll.update(orig, update, true, false);
	}
	public static void main(String[] args) {
		DBObject empObj=new BasicDBObject();
		empObj.put("uname", "teddy");
		empObj.put("upwd", "123456");
		//添加
		add(empObj);
		query();
		
		
		DBObject updateObj=new BasicDBObject();
		updateObj.put("uname", "teddy");
		updateObj.put("upwd", "3333");
		//更新
		modify(new BasicDBObject("uname","teddy"),updateObj);
		System.out.println("-----------------------修改后-------------------");
		query();
		
		//删除
		delete(new BasicDBObject("uname","teddy"));
		System.out.println("-----------------------删除后-------------------");
		query();
	}
}
