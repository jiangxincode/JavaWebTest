package edu.leetcode;

import java.util.Arrays;
//There are N children standing in a line. Each child is assigned a rating value.
//
//You are giving candies to these children subjected to the following requirements:
//
//   Each child must have at least one candy.
//   Children with a higher rating get more candies than their neighbors.
//
//What is the minimum candies you must give? 
//��ô�ȷ�˵  345 5��С����3���� 4��С����2����  1��С����1���� 
//��һ��Ҫע�⣬ͬ��rating���ŵ�����С�����ǿ��Բ�һ����
//����˵rating��35553 ����12121  rating ��34555 ���� 12311

public class Candy {
	//
//�ȰѴ�������ȫ������1.Ȼ�������ͷɨ�飬��һ�δ����ң��ڶ��δ��ҵ���
//���������͵ݼ��Ĺ�ϵ�͸պ��෴��ÿһ����������һ���ݼ��Ͳ��䡣 
// �ȷ�˵ rating�� 3455542 ���ҵ�һ��ɨ��� 1231111
//�ڶ���ɨ��ʱ�� ��Ϊ ratings[i-1]>ratings[i]&&count[i-1]<=count[i]
//����         1231221
	 public int candy(int[] ratings) {
	   if(ratings==null||ratings.length==0){
		   return 0;
	   }    
	   int[] count =new int[ratings.length];
	   Arrays.fill(count, 1);
	   int sum =0;
	   for(int i=1;i<ratings.length;i++){
		   //����ɨһ�� ֻҪ��i-1�� count[i]-count[i-1]+1; 
		   if(ratings[i]>ratings[i-1]){
			   count[i]=count[i-1]+1;
		   }
	   }
	   //�ٷ���ɨһ�� ͬʱ����sum
	   for(int i = ratings.length-1;i>=1;i--){
		   sum=sum+count[i];
		    //i-1 ��  iС  ����     count����i=1С�ڵ���count [i] count�ǽ��
		   if(ratings[i-1]>ratings[i]&&count[i-1]<=count[i]){
			   count[i-1]=count[i]+1;
		   }
	   }
	    sum=sum+count[0];
	   return sum;
	     }
}
