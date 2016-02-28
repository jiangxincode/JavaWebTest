package com.db.dao;

import com.mongodb.DBCollection;

public abstract class BaseDAO {
	static DataBaseConnection dbc = new DataBaseConnection();

	protected static DBCollection getDBCollection(String collection_name) {
		return dbc.getDBCollection(collection_name);
	}

	protected static boolean release(DBCollection dbColl) {
		return dbc.release(dbColl);
	}
}
