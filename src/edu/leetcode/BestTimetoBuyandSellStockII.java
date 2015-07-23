package edu.leetcode;
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit. You may complete as many transactions 
//as you like (ie, buy one and sell one share of the stock multiple times).
//However, you may not engage in multiple 
//transactions at the same time (ie, you must sell the stock before you buy again).

//��������0�������� Ҫ������� ����һ��Ҫ��������
// ̰�ķ���ֻѡȡ��ǰѡ������Ž�-�ֲ����Ž� ,���������� ���� ���������ǰ���Best Time to Buy and Sell Stock ��ͬ���ڣ�������Զ��������Ʊ��  
// �Ӷ��ۻ�׬ȡ���еļ۸������̰�ķ�������˼�����������Ȼ���ڼ۸������ֲ���ߵ�  
// ������һ��ļ�Ǯ���½��ˣ�ʱ���׳���Ʊ��Ȼ�����һ��ϵ͵ļ�Ǯ��Ϊ���룬���ż��㡣  
// Ҫע�����Ҫ�������һ�ε�����  

public class BestTimetoBuyandSellStockII {

	 public int maxProfit(int[] prices) {
	     if(prices==null||prices.length==0){
	    	 return 0;
	     }   
		int totalProfit=0;
		int startIndex=0; //��һ�������λ����0λ
		for(int i=1;i<prices.length;i++){
			if(prices[i]<prices[i-1]){ //����1��ļ۸�С��ǰ��һ��ļ۸� Ҫ���ˡ�
			totalProfit=totalProfit+prices[i-1]-prices[startIndex];	
			startIndex=i;//  Ȼ����i���������
			
			}
		}
		//��forѭ��������(��󻹻�i++һ�� ������Ϊ������forѭ�������Խ�����for��) ��Ϊ �������һ������
		if(prices[prices.length-1]>prices[startIndex]){
			totalProfit=totalProfit+prices[prices.length-1]-prices[startIndex];}
					return totalProfit;			
		
	    }

}
