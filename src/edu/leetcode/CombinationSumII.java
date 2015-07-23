package edu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import org.omg.CORBA.PUBLIC_MEMBER;

//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//Each number in C may only be used once in the combination.
//
//Note:
//
//   All numbers (including target) will be positive integers.
//   Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
//   The solution set must not contain duplicate combinations.
//
//For example, given candidate set 10,1,2,7,6,1,5 and target 8,
//A solution set is:
//[1, 7]
//[1, 2, 5]
//[2, 6]
//[1, 1, 6] 
//��һ������ ����������ظ�Ԫ�أ�����ÿ��Ԫ�������һ�� 
//���㷵������Ԫ����� which ��ϵ�sum==target


public class CombinationSumII {
	  private ArrayList<ArrayList<Integer>> results;
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
	   		  if(num.length<1){
	   			  return results;
	   		  }
		  ArrayList<Integer> path=new ArrayList<Integer>();
		 //sort���С�������� ���� forѭ���ӵ�ʱ�� �����ظ���eg 13123 ��sort����2��123 123
		  Arrays.sort(num);
		  results=new ArrayList<ArrayList<Integer>>();
		  combinationSumHelper(path,num,target,0);
		  return results;
		  }
		                                               //pathֻ��һ�� 
		  private void combinationSumHelper(ArrayList<Integer> path,int[] num,int sum,int pos) {
			  //dfs��������1  �ﵽSUM 
			  if(sum==0){  //path���涫�������µ�һ��arraylist�����ټӵ� result��
				  results.add(new ArrayList<Integer>(path));
				 }
			  //  ��������2 pos����num������ or sum������
			  if(pos>=num.length||sum<0){
				  return;
			  }
			  int prev=-1;
			  for(int i=pos;i<num.length;i++){
				  if(num[i]!=prev){ //��� ���ε����ֵ��֮ǰ��һ��
					  path.add(num[i]);
					  combinationSumHelper(path, num, sum-num[i], i+1);
					  prev=num[i];
					  path.remove(path.size()-1);
				  }
			  }
		}
    }

