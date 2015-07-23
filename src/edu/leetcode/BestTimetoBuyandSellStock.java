package edu.leetcode;

//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//ֻ����1��  ����0�� ���������
//�ҵ�����������ɡ�(��һ��Ҫ������)
//��ǰ�����õ�ǰ�۸��ȥ��ǰ��ͼ۸񣬾����ڵ�ǰ��������Ʊ�ܻ�õ��������
//ɨ��Ĺ����и�������������ͼ۸�����ˡ�
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int minPrice = Integer.MAX_VALUE;
		int maxProfits = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
		int currentProfit=prices[i]-minPrice;
		if(currentProfit>maxProfits){
			maxProfits=currentProfit;
		}
			
		}
	return maxProfits;
	}
}
