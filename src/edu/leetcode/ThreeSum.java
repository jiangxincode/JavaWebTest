package edu.leetcode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.naming.spi.DirStateFactory.Result;

//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//
//    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a �� b �� c)
//    The solution set must not contain duplicate triplets.
//
//    For example, given array S = {-1 0 1 2 -1 -4},
//
//    A solution set is:
//    (-1, 0, 1)
//    (-1, -1, 2)

//���ǵ�2sum��Ҫô��hashmap Ҫô��ͷβ2��ָ��ô��
//������ԸĶ��� �ڶ������� ��3Sum 
//����twoSum��������threeSum���������£�ֻ��������򣬺�һ��ѭ����������AC��
public class ThreeSum {

	 ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	
	  public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	      Arrays.sort(num); 
	      if(num.length<3){return result;
	      }else if(num.length==3){
	    	  if((num[0]+num[1]+num[2])==0){
	    		  Arrays.sort(num);
	    		  ArrayList<Integer> tmpList=new ArrayList<Integer>();
					 
					tmpList.add(num[0]);
					tmpList.add(num[1]);
					tmpList.add(num[2]);
	    		  result.add(tmpList);
	    	  }else{return result;}
	      }else{   
	      for(int i=0;i<num.length-3;i++){
	    	if(i!=0&&num[i]==num[i-1]){
	    		//he solution set must not contain duplicate triplets.
	    		//���Ե�num[i]==num[i-1] ʱ�� Ҫ����
	    		//����ѭ����һ��
	    		continue;
	    	}
	    	judgeAndPut(num,i,i+1,num.length-1);
	    	
	      }
	     
	 }
		return result;
	      
	      }
	        // Ҳ�Ǳƽ��ķ��� ���ʺ�2sumһ�� 
	          // ��Ϊ�������ź����                    //i    //i+1
	       private void judgeAndPut(int[] num,int i,int j ,int end ){
	    	   while (j<end) {
				if(num[i]+num[j]+num[end]<0){
					j++;  //��ʵ���ʺ�˫��ѭ��j=i+1 j++�鲻��
				}else if(num[i]+num[j]+num[end]>0){
					end--;
				}else if(num[i]+num[j]+num[end]==0){
					ArrayList<Integer> tmpList=new ArrayList<Integer>();
					//ע����ĿҪ�� С����ǰ
					tmpList.add(num[i]);
					tmpList.add(num[j]);
					tmpList.add(num[end]);
					result.add(tmpList);
				j++;
				end--;
				//he solution set must not contain duplicate triplets.
				// ����arraylist��������ͬ����ʱ�� ��Ҫ��������
				//ps �����Ҫ����else���� ������else���� ��Ϊ ֻ��else������ʵ����arraylist���������triplets
				//����ֻ���ڴ�ʱ���б�Ҫ��
				while ((j < end) && num[j] == num[j - 1]) {
					j++;
				}
				while ((j < end) && (end<num.length-1)&&num[end] == num[end + 1]) {
					end--;
				}

				}
			
		}
	} 
	        
	        
	     
	
	
	public static void main(String[] args) {
		 int num[] = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};  
	        System.out.println(new ThreeSum().threeSum(num));  

	}

}
