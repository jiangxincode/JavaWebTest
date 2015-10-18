package com.archie.mongodb;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

/**
 * 获得DBCollection集合的工具类
 * @author archie2010
 *
 * since 2012-9-29 下午10:54:42
 */
public class DBUtil {

	public static Mongo mg=null;    
	public static DB db=null;    
	public static DBCollection collection;
	
	/**
	 * 获得DBCollection对象
	 * @param dbName
	 * @param colName
	 * @return
	 */
	public static DBCollection getDBCollection(String dbName,String colName) {
		if(mg==null){
			mg=new Mongo();
		}
		if(db==null){
			db=mg.getDB(dbName);
		}
		return db.getCollection(colName);
	}
}
