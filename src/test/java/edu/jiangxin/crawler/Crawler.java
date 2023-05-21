package edu.jiangxin.crawler;

import edu.jiangxin.utils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Crawler {
	private static Logger m_debug = LogManager.getLogger(Crawler.class);

	private static int m_maxThreads = 4;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		String testUrl = PropertyUtils.getProperty("http.url");
		Crawl(testUrl, Crawler.class.getResource("/").getPath() + "Crawler/");
		System.out.println(HttpUtility.GetContent(HttpUtility.GetEntity(testUrl)));
	}

	public static void Crawl(String url, String savePath) {
		int cnt = 1;
		long startTime = System.currentTimeMillis();
		AtomicInteger numberOfThreads = new AtomicInteger(); // 记录当前使用的爬虫数
		ThreadPoolExecutor executor = new ThreadPoolExecutor(m_maxThreads,
				m_maxThreads, 3, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>()); // 建立线程池

		Queue.Add(UrlUtility.Encode(UrlUtility.Normalizer(url))); // 添加初始URL到Queue中
		try {
			while ((url = Queue.Fetch()) != null) {
				executor.execute(new PageCrawler(url, savePath, numberOfThreads)); // 将URL交给爬虫

				while ((Queue.Size() == 0 && numberOfThreads.get() != 0)
						|| (numberOfThreads.get() == m_maxThreads)) { // 防止提前退出
					sleep();
				}

				if (cnt++ > 10)
					break;
				// if( Queue.Size() == 0 && numberOfThreads.get() == 0 ) break;
			}
		} finally {
			executor.shutdown();
		}

		long useTime = System.currentTimeMillis() - startTime;
		System.out.println("use "
				+ Utility.ToStandardTime((int) (useTime / 1000))
				+ " to finish " + cnt + " links");
		System.out.println("remain url: " + Queue.Size());
	}

	private static void sleep() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			m_debug.debug("main thread died. ");
		}
	}
}
