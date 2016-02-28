package com.db.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.ObjectId;

public class AuthorDAO extends BaseDAO {
	// private static DBCollection coll =
	// getDBCollection(Constants.COLLECTION_AUTHOR);

	/**
	 * 插入作者信息
	 */
	public static boolean insert(Map<String, String> map) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject author = new BasicDBObject(map);
		DBObject dbo = findByURL(map.get(Constants.AUTHOR_URL));

		if (dbo == null) {
			coll.insert(author);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 通过id查找作者信息
	 * @param id
	 * @return
	 */
	public static DBObject findByID(String id) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.ID, new ObjectId(id));
		return coll.findOne(query);
	}

	/**
	 * 通过url查找作者信息
	 * @param author_url
	 * @return
	 */
	public static DBObject findByURL(String author_url) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.AUTHOR_URL, author_url);
		return coll.findOne(query);
	}

	/**
	 * 通过名字查找作者信息
	 * @param author_name
	 * @return List
	 */
	public static List<DBObject> findByName(String author_name) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.AUTHOR_NAME, author_name);
		return coll.find(query).toArray();
	}

	/**
	 * 根据开始位置查询指定个数的数据
	 * @param first
	 * @param max
	 * @return
	 */
	public static List<DBObject> findAllByKeyLimit(Map<String, String> keyMap, int first, int max) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject query = new BasicDBObject();

		Set<String> keySet = keyMap.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = keyMap.get(key);
			if (key.indexOf(Constants.LIKE_QUERY) == 0) {
				key = key.replaceFirst(Constants.LIKE_QUERY, "");
				value = ".*" + value + ".*";
				Pattern keyPattern = Pattern.compile(value);
				query.put(key, keyPattern);
			} else {
				query.put(key, value);
			}
		}
		return coll.find(query).skip(first).limit(max).toArray();
	}

	/**
	 * 通过key查询所有的数据
	 * @param keyMap
	 * @return
	 */
	public static List<DBObject> findAllByKey(Map<String, String> keyMap) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject query = new BasicDBObject();

		Set<String> keySet = keyMap.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = keyMap.get(key);
			if (key.indexOf(Constants.LIKE_QUERY) == 0) {
				key = key.replaceFirst(Constants.LIKE_QUERY, "");
				value = ".*" + value + ".*";
				Pattern keyPattern = Pattern.compile(value);
				query.put(key, keyPattern);
			} else {
				query.put(key, value);
			}
		}
		return coll.find(query).toArray();
	}

	public static long getCount(Map<String, String> keyMap) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject query = new BasicDBObject();

		Set<String> keySet = keyMap.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = keyMap.get(key);
			if (key.indexOf(Constants.LIKE_QUERY) == 0) {
				key = key.replaceFirst(Constants.LIKE_QUERY, "");
				value = ".*" + value + ".*";
				Pattern keyPattern = Pattern.compile(value);
				query.put(key, keyPattern);
			} else {
				query.put(key, value);
			}
		}
		return coll.getCount(query);
	}

	/**
	 * 查询所有数据个数
	 * @return
	 */
	public static long getCount() {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		long count = coll.getCount();
		release(coll);
		return count;
	}

	/**
	 * 查询所有
	 * @return
	 */
	// public static List<DBObject> findAll(){
	// return coll.find().toArray();
	// }

	/**
	 * 通过url删除用户信息
	 * @param author_url
	 * @return
	 */
	public static void deleteByURL(String author_url) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		DBObject dbo = findByURL(author_url);
		if (dbo != null) {
			coll.remove(dbo);
		}
	}

	public static void deleteByDBObject(DBObject dbo) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		coll.remove(dbo);
	}

	/**
	 * 通过id删除用户信息
	 * @param id
	 * @return
	 */
	public static void deleteByID(String id) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		DBObject dbo = findByID(id);
		if (dbo != null) {
			coll.remove(dbo);
		}
	}

	/**
	 * 通过作者名字删除所有作者信息
	 * @param author_name
	 */
	public static void deleteByName(String author_name) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		BasicDBObject query = new BasicDBObject();
		query.put(Constants.AUTHOR_NAME, author_name);
		coll.remove(query);
	}

	/**
	 * 更新用户信息
	 * @param author_name
	 * @param author_url
	 * @return
	 */
	public static boolean update(Map<String, String> map) {
		DBCollection coll = getDBCollection(Constants.COLLECTION_AUTHOR);
		if (!map.containsKey(Constants.ID))
			return false;

		DBObject query = findByID(map.get(Constants.ID));

		if (query != null) {
			BasicDBObject dbo = new BasicDBObject(map);
			dbo.remove(Constants.ID);
			coll.update(query, dbo);
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws InterruptedException {

	}
}
