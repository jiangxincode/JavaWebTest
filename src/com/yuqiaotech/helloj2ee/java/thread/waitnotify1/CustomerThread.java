package com.yuqiaotech.helloj2ee.java.thread.waitnotify1;

import java.util.List;
import java.util.Random;

class CustomerThread extends Thread{
	
	CustomerThread(List shareList){
		this.shareList=shareList;
	}
	
	public void run(){
		System.out.println("消费线程己启动...."+shareList.size() );
		while(true){
		try{
		synchronized(shareList){
			if(ProduceThread.requirement < 5){
				int num = new Random().nextInt(10);
				if(num > 3){
					ProduceThread.requirement+=num;
					System.out.println("顾客:老板再来["+num+"]串。还缺["+ProduceThread.requirement+"]串。现在烤好了【"+shareList.size()+"】串");
				}
			}
			while(shareList.size()==0){
				//如果没有,消费线程则等待
				shareList.wait();
			}
			System.out.println("顾客:开始消费了，缺["+ProduceThread.requirement+"]串。现在烤好了【"+shareList.size()+"】串");
			int x = 0;
			int cnt = shareList.size();
			System.out.print("<---消费线程取出: ");
			for (int i = 0; i < ProduceThread.requirement && i < cnt; i++) {
				System.out.print(" "+((Kebab)shareList.remove(0)).id );
				x++;
			}
			System.out.println();
			ProduceThread.requirement-=x;
			System.out.println("顾客:我拿走了【"+x+"】串,缺["+ProduceThread.requirement+"]串。现在烤盘里还剩【"+shareList.size()+"】串");
			shareList.notify();
		}
		}catch(Exception ef){
			ef.printStackTrace();
		}
		}
	}
	
	private List shareList;
}

