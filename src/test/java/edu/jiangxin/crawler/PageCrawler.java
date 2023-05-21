package edu.jiangxin.crawler;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class PageCrawler implements Runnable  {
	
    private static Logger m_debug = LogManager.getLogger(PageCrawler.class);

    private String url;
    private String savePath;
    private AtomicInteger numberOfThreads;
    
    public PageCrawler(String url, String savePath, AtomicInteger numberOfThreads) {
    	this.url = url;
    	this.savePath = savePath;
    	this.numberOfThreads = numberOfThreads;
    	
    	numberOfThreads.incrementAndGet();
    }
       
	public void run() {
		try {
			HttpEntity entity = HttpUtility.GetEntity(url);
			byte[] bytes = null;
			if( entity != null ) {
				try {
					bytes = EntityUtils.toByteArray(entity);
				} catch (IOException e) {
					m_debug.debug("can't get bytes from entity");
					m_debug.debug("the url is " + url);
				}
			
				String content = HttpUtility.GetContent(bytes);
				if( content == null || content.isEmpty() ) {
					m_debug.debug(url + " :No content");
					return;
				}

				m_debug.trace("get content successfully from " + url );
				if( !Utility.SavePage(bytes, content, savePath) ) {
					m_debug.debug("can't save page whose url is " + url);
				}		
									
				UrlUtility.ExtractURL(url, content);
			}
			else {
				m_debug.trace("could not get entity from " + url);
			}
		}
		finally {
			numberOfThreads.decrementAndGet();
		}
		
	}

}
