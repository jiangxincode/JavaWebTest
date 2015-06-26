package edu.leetcode.frequency_4;

import java.util.ArrayList;

import javax.management.relation.Relation;

//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//For example,
////If n = 4 and k = 2, a solution is: 
//[
// [2,4],
// [3,4],
// [2,3],
// [1,2],
// [1,3],
// [1,4],
//]
//����˵ ��1��N ��������� ��Ԫ����ΪK   combinations of k numbers
//�����Ǹ����Ӿ��Ǵ�1��4 ���� ��2�����������С�

//�����premutation/cc��8.4������  �������� ���ǲ���ȫ���С� 
public class Combinations {
	 public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp=new ArrayList<Integer>();
		subsetsRecord(result, temp ,n,k,0);
		return result;		 
	}
	      //������void ���Ǵ���result ��result�������е�����
	 public void subsetsRecord(ArrayList<ArrayList<Integer>> result,ArrayList<Integer> temp,int n, int k ,int level	){
		 //temp.size==k˵�����temp���Ԫ�ض������� ���Լ���
		 if(temp.size()==k){
			  //�½�һ��arraylist ����temp������ ����result
			 //��������� ��ôֻ��һ��temp���� ��ô����ĸĶ�����arraylist��Ҳ���� ��Ϊ�����Ǵ�arraylist���Ǵ�temp����ָ��ͬһ������
			 result.add(new ArrayList<Integer>(temp));
		return;	
		 }
		 
		 //level һ��ʼ��0
		 //���for�Ƿ�������temp �޸�, �����Ƕ�ֻ�ǰѵ���涨���ȵ�arraylist����һ����k��Ȼ�󷽷����� 
		 //ע�����i ��Ϊֻ��һ��i �������i�ڲ����ĵݹ������������·����ﴫ������ֵ�ǲ�ͬ��
		 	 for(int i=level;i<n;i++){
				 temp.add(i+1);
				 subsetsRecord(result, temp, n, k, i+1);
				 System.err.print(temp);
			     temp.remove(temp.size()-1);//��ȥ���һ�� 
			 //������ѭ���׵ݹ�Ҫ��ô��� 
			     // ����Ҫע�����,�ڵݹ�ϵͳ�����������᷵����һ��
			     //�������subsetsResut��������� ��2��������������,1.temp.size=k 2.forѭ��ʱ��i=n forѭ������ �����������.
			     //�ͱȷ�˵ n = 4 and k = 2,�����Ӱɣ���Ϊk����2 ����tempҪ�ݹ�3�� 
			     //һ��ʼ���ѭ����temp����1 Ȼ��ݹ����2 Ȼ���1��2 add��result,����������һ�� ��ʱ�� remove��temp.size()-1 (�������һλ)��2ɾ���ͻ�ʣ��1
			     //������ʱ��i�Ѿ������� i+3����3��Ȼ���ڵݹ�2����add 3�ľ��� 1.3 �ٽ��𰸡���ͬ�� 1,4 Ȼ��1,4��remove��1 ���Ǵ�ʱ i<n�Ѿ��������� �������� 
			     //�ٵݹ鷵����һ�� Ȼ��remove���һλ �Ͱ�1Ҳɾ���� ��ʱ���������ǲ��forѭ��1�Ѿ����� Ȼ��ʼѭ��2 Ȼ����������
			    	 	 
			     //[1, 2][1, 3][1, 4][1][2, 3][2, 4][2][3, 4][3][4]
		 	 }
	 }
	 
	 
	 public static void main(String[] args) {
		new Combinations().combine(4, 2);
	}
	 
}
