package com.yuqiaotech.helloj2ee.java.thread.waitnotify1;

import java.util.List;
import java.util.Random;

//生产者线程:无数据时再存,存入一个就发通知
class ProduceThread extends Thread{
	public static int requirement = 0;
	//构造器参数是生产线程要放入数据的队列
	ProduceThread(List shareList){
		this.shareList=shareList;
	}
	

	public void run(){
		System.out.println("生产线程己启动...."+shareList.size() );
		while(true){
		try{
			Thread.sleep(2000);
			synchronized(shareList){
				System.out.println("老板:现在还剩【"+shareList.size()+"】串。需求是["+ProduceThread.requirement+"]串。");
				while(shareList.size() > requirement){
					shareList.wait();
				}
				int num = new Random().nextInt(5)+1;
				System.out.print("--->生产线程放入对象:");
				for(int i = 0; i < num; i++){
					Kebab st=new Kebab();
					count++;
					st.id=count;
					System.out.print(" "+st.id );
					shareList.add(st);
				}
				System.out.println();
				System.out.println("老板:我这次烤了【"+num+"】串，现在还剩【"+shareList.size()+"】串。需求是["+ProduceThread.requirement+"]串。");
	            //通知消费线程,队列中有对象了
				shareList.notify();
				//
			}
		}catch(Exception ef){
			ef.printStackTrace();
		}
		}
	}
	/**用来标记放入对象的每一个独立ID号*/
	private static int count=0;
	//与消费线程或以共同存取的对象列表
	private List shareList;
}