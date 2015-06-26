package edu.leetcode.frequency_1;

import java.util.ArrayList;

//Given an index k, return the kth row of the Pascal's triangle.
//
//For example, given k = 3,
//Return [1,3,3,1].
//
//Note:
//Could you optimize your algorithm to use only O(k) extra space?

//���������II Ҫ����������������ε�N��,�������ÿռ� 
//��I�Ľⷨһ�� ��ʵÿ�������ֻ��������һ��������
//��ôʵ����ֻҪ������һ��ľͿ��� ��������㣬������������һ��Ϳ��Զ���
//Ȼ�󱾲��������Ϊ�µġ���һ�㡱�����㱾��������ǲ�
//K��������Ѿ�����ֻ��һ��Ŀռ� ����
public class PascalsTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		
		ArrayList<Integer> lastLevel = new ArrayList<Integer>();
		lastLevel.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			ArrayList<Integer> currentLevel = new ArrayList<Integer>();
			currentLevel.add(1);
			for (int j = 0; j < lastLevel.size() - 1; j++) {
					currentLevel.add(lastLevel.get(j) + lastLevel.get(j + 1));
				}
				currentLevel.add(1);
				lastLevel = currentLevel;
		
		}
		return lastLevel;

	}
}
