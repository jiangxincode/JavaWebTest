package edu.jiangxin.statistics.dao;

import java.sql.Timestamp;

import edu.jiangxin.statistics.bean.LogBean;

public interface LogDao {
	
	/**
	 * 保存访问日志
	 * @param logBean
	 * @throws Exception
	 */
	public void saveLog(LogBean logBean) throws Exception;
	
	/**
	 * 查出最近的那条访问日志记录
	 * @param sessionId
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public LogBean getLatestLog(String sessionId, String ip) throws Exception;
	
	/**
	 * 修改访问日志中页面的停留时间
	 * @param id
	 * @param stayTime
	 * @throws Exception
	 */
	public void updateLog(String id, long stayTime) throws Exception;
	
	/**
	 * 统计某段时间内的PV数（页面访问数），每刷新一次页面就算一次访问
	 * @param startTime
	 * @param endTime
	 * @throws Exception
	 */
	public int getPV(Timestamp startTime, Timestamp endTime) throws Exception;
	
	/**
	 * 统计某段时间内的UV数（独立访客数），同一段时间内，一个IP多次访问只算一个。
	 * @param startTime
	 * @param endTime
	 * @throws Exception
	 */
	public int getUV(Timestamp startTime, Timestamp endTime) throws Exception;


}
