package edu.leetcode;

import java.util.ArrayList;

//
//Given a collection of numbers, return all possible permutations.
//
//For example,
//[1,2,3] have the following permutations:
//[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
//����һ������ ���㷵�����в�ͬ�����
//����� ���ַ���ȫ���е�����
// ���ǵ��͵ĵݹ�������⣬�ݹ��㷨���ĸ����ԣ�

//�����пɴﵽ����ֹ�������������������ѭ��
//�������ڹ�ģ�ϱ�ԭ����С
//�������ͨ���ٴεݹ�������
//������Ľ�Ӧ����ϳ���������Ľ�
//�ο�cc150 8����4
public class Permutations {

	public ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if (num == null) {
			return null;
		}
		// numΪ����ֻ��һ��Ԫ�� �������Ԫ��
		if (num.length == 1) {
			temp.add(num[0]);
			result.add(temp);
			return result;
		}
		int[] numless = new int[num.length - 1];
		int currentFirst = num[0];
		System.arraycopy(num, 1, numless, 0, num.length - 1);
		ArrayList<ArrayList<Integer>> retrieving = permute(numless);

		for (ArrayList<Integer> combo : retrieving) {
			// ÿ��arraylist�������ϴα����ͷ
			// //length()+1��ԭ���� �ȷ�˵ 0���� abc a֮ǰҪ���� c֮��ҲҪ���� ����Ҫ+1
		 
			ArrayList<Integer> tep=(ArrayList<Integer>) combo.clone();
			for (int i = 0; i < combo.size() + 1; i++) {
				combo.add(i, currentFirst);
				result.add(combo);
			 //����ÿ��combo���ڶ���forѭ����current��ʱ�򣬱���һ�Σ��ͱ����˼�current�������combo.size�仯 ���µĴ���
				//Ϊʲô ����remove i �� ��Ϊ���ܻ������ڲ����Ż��Ĵ��� ���ܻᱨ��
				//������������ԭʼ��combo
				combo = (ArrayList<Integer>) tep.clone();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] num = { 0,1,3,5};
		System.out.println((new Permutations()).permute(num));

	}

}
