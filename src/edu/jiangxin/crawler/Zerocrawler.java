package edu.jiangxin.crawler;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Zerocrawler {
	private static Logger m_debug = LogManager.getLogger("Debuglogger");

	private static int m_maxThreads = 4;

	public static void main(String[] args) {
		BasicConfigurator.configure();
		String testUrl = "http://www.cnblogs.com/";
		Crawl(testUrl,"temp/");
		System.out.println(HttpUtility.GetContent(HttpUtility.GetEntity(testUrl)));
	}

	public static void Crawl(String url, String savePath) {
		int cnt = 1;
		long startTime = System.currentTimeMillis();
		AtomicInteger numberOfThreads = new AtomicInteger(); // ��¼��ǰʹ�õ�������
		ThreadPoolExecutor executor = new ThreadPoolExecutor(m_maxThreads,
				m_maxThreads, 3, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>()); // �����̳߳�

		Queue.Add(UrlUtility.Encode(UrlUtility.Normalizer(url))); // ���ӳ�ʼURL��Queue��
		try {
			while ((url = Queue.Fetch()) != null) {
				executor.execute(new PageCrawler(url, savePath, numberOfThreads)); // ��URL��������

				while ((Queue.Size() == 0 && numberOfThreads.get() != 0)
						|| (numberOfThreads.get() == m_maxThreads)) { // ��ֹ��ǰ�˳�
					sleep();
				}

				if (cnt++ > 1000)
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