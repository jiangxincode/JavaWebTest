package com.db.dao;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class DataBaseConnection {

	public static String USERNAME = "username";
	public static String PASSWORD = "password";
	public static String HOST = "192.168.1.10";
	public static int PORT = 27017;
	public static String DATABASE = "TestDB";

	private static int maxConnectNum = 20;// 最大连接数

	private static DB dbs[] = new DB[maxConnectNum];
	private static ArrayList<DB> dbPool = new ArrayList<DB>();
	private static int flag = 0;

	public DataBaseConnection() {
		if (flag == 0) {
			init();
		}
	}

	private DB getDbFromDatabase() {
		DB db = null;
		try {
			// readDbConfig();
			DBAddress dba = new DBAddress(HOST, PORT, DATABASE);
			db = Mongo.connect(dba);
			boolean auth = db.authenticate(USERNAME, PASSWORD.toCharArray());
			if (auth == true) {
				System.out.println("MongoDB连接成功了！");
				return db;
			} else {
				System.out.println("MongoDB用户名和密码不匹配");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 建立所有连接
	private void init() {
		for (int i = 0; i < maxConnectNum; i++) {
			dbs[i] = getDbFromDatabase();
			dbPool.add(i, dbs[i]);
		}
		flag = 1;
	}

	public synchronized DBCollection getDBCollection(String collection_name) {
		DBCollection dbColl = null;
		System.out.println("poolSize:" + dbPool.size());
		while (dbPool.size() == 0) {
			try {
				System.out.println("sleep------------------------------------");
				java.lang.Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("连接全部用光,这里sleep出错了.");
			}
		}
		dbColl = dbPool.remove(0).getCollection(collection_name);
		return dbColl;
	}

	// 提供给外部程序调用,不用的连接放回连接池当中...
	public boolean release(DBCollection dbColl) {
		System.out.println("===========================" + dbPool.size());
		return dbPool.add(dbColl.getDB());
	}

	@SuppressWarnings("rawtypes")
	protected static void readDbConfig() {
		try {
			Properties props = new Properties();
			InputStream is = new BufferedInputStream(new FileInputStream("database.properties"));
			props.load(is);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String Property = props.getProperty(key);
				if (key.toLowerCase().equals("username")) {
					USERNAME = Property;
				} else if (key.toLowerCase().equals("password")) {
					PASSWORD = Property;
				} else if (key.toLowerCase().equals("host")) {
					HOST = Property;
				} else if (key.toLowerCase().equals("port")) {
					try {
						PORT = Integer.parseInt(Property);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (key.toLowerCase().equals("database")) {
					DATABASE = Property;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	protected static void readDbConfig(String filePath) {
		try {
			Properties props = new Properties();
			InputStream is = new BufferedInputStream(new FileInputStream(filePath));
			props.load(is);
			Enumeration en = props.propertyNames();
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String Property = props.getProperty(key);
				if (key.toLowerCase().equals("username")) {
					USERNAME = Property;
				} else if (key.toLowerCase().equals("password")) {
					PASSWORD = Property;
				} else if (key.toLowerCase().equals("host")) {
					HOST = Property;
				} else if (key.toLowerCase().equals("port")) {
					try {
						PORT = Integer.parseInt(Property);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (key.toLowerCase().equals("database")) {
					DATABASE = Property;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
