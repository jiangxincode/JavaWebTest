package edu.leetcode.newQuestion;
//Given an array of integers, every element appears three times except for one. Find that single one. 

//java��intʼ��ռ4���ֽڣ�32λ���������ѭ������32�Σ�Ȼ���ڲ�ѭ����¼0-31λÿһλ���ֵĴ������ڲ�ѭ�������󽫽��ȡ����3��Ϊ��ǰλ��ֵ

//ʱ�临�Ӷ�O(32 * n), �ռ临�Ӷ�O(1)

// �ȷ�˵ 
//1101
//1101
//1101
//0011
//0011
//0011
//1010   ���unique��   
//----
//4340  1�ĳ��ִ���  
//1010  ��3�Ļ� �����Ǹ�Ψһ������
public class Singlenumber2 {
	 public int singleNumber(int[] A) {
	 int bit=0;
	 int result=0;
	 for(int i=0;i<32;i++){ //ÿ����ѭ�� ���32λint��,1��λ���ܺ�
		 bit=0;
		 for(int j=0;j<A.length;j++){
			if(((A[j]>>i)&1)==1){  //�ȷ�˵��ѭ����һ�ε�ʱ��0 ��ô�Ͳ�����ƽ�� Ȼ���1�� �����ǲ���1
				bit++;             //��ѭ���ڶ��ε�ʱ��������1λȻ��ȵڶ�λ��
			}
		} 
		 bit=bit%3;
		 result=result|bit<<i;//ÿ����ѭ��������ʱ��Ͱ�bitȡ�����Ľ���浽result��
	 }
	 return result;
	 }
	 
}
