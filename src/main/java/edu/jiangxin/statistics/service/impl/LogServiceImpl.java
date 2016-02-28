package edu.jiangxin.statistics.service.impl;

import java.sql.Timestamp;

import edu.jiangxin.statistics.bean.LogBean;
import edu.jiangxin.statistics.dao.LogDao;
import edu.jiangxin.statistics.service.LogService;

public class LogServiceImpl implements LogService {
	private LogDao logDao;

	public LogServiceImpl() {
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}


	public LogBean getLatestLog(String sessionId, String ip)
			throws Exception {
		return logDao.getLatestLog(sessionId, ip);
	}


	public void saveLog(LogBean logBean) throws Exception {
		logDao.saveLog(logBean);
	}


	public void updateLog(String id, long stayTime) throws Exception {
		logDao.updateLog(id, stayTime);
	}


	public int getPV(Timestamp startTime, Timestamp endTime) throws Exception {
		return logDao.getPV(startTime, endTime);
	}


	public int getUV(Timestamp startTime, Timestamp endTime) throws Exception {
		return logDao.getUV(startTime, endTime);
	}

}
