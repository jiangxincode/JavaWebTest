package edu.leetcode.frequency_4;

import javax.naming.spi.DirStateFactory.Result;

//Given an array of integers, every element appears twice except for one. Find that single one.
//
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//һ���������� ����һ��һ����ͬ�����֣�����ֻ��һ�������� 
//��������ռ�(��ʵָ���ǿռ临�Ӷ���0(1))

//��0ȥ������������ж���
//�ȷ�˵0^1101=1101    1101^1101=0000  ���ԳɶԵ���������0��
//���������0^��һ���Ǹ� �� 0^����=���� ����ֱ��return
public class SingleNumber {

	public int singleNumber(int[] A) {
	  
	    int result=0^A[0];
		for(int i=1;i<A.length;i++){
	      result=result^A[i];
	     }
	   return result; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
