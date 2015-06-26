package edu.leetcode.frequency_3;

import java.util.ArrayList;
import java.util.Arrays;

//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times. 
//
//All numbers (including target) will be positive integers.
//Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
//The solution set must not contain duplicate combinations.
//For example, given candidate set 2,3,6,7 and target 7,
//A solution set is:
//[7]
//[2, 2, 3] 
//���Ǹ���һ������ Ȼ�� ����������� ѡ���֣�һ�����ֿ����ظ��ã� ���ǵĺ��� ָ�����Ǹ�����
//�� 2-Sum 3-sum�������ơ�|||���þ��µ� combination/subset��ģ����|||

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (candidates == null) {
			return result;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		// resultҪ�󷵻صĶ��ǵ�������ϣ���ô�Ҿ�sort��ԭʼ�������
		Arrays.sort(candidates);
		subsetsHelper(candidates, target, path, 0, result);
		return result;
	}

	private void subsetsHelper(int[] candidates, int target,
			ArrayList<Integer> path, int index,
			ArrayList<ArrayList<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(path));
			return;
		}
		int prev = -1;// prevָ���� ��һ�������Ǹ���
		// bfs�� ѭ���ӵݹ� ÿһ��charȥѭ����ȥ
		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) {
				break;
			}
			// ȥ�ظ� ���ȥ������ô�������أ��ȷ�˵������{2,2,4,4} Ȼ��target��6.
			// ������˵�һ��2 ��һ��4 , ��������ڶ���2 ��һ��4   ������ 2��{2,4}�ظ���ô
			// ע�����	prev = candidates[i];���ڵݹ鷽��֮��ľ��� ��һ��dfsȫ���������� ���ǵ�һ��2+����Ԫ�ؿ��ܵĽ� �Ѿ����е�ʱ�� 
			// ����ڶ���forѭ�� i=1��ʱ�� candidates[1]==prev ����2 ��ô ��� 2�ͺ��� Ԫ����ϵĿ��ܵĽ� �͵�һ��Ԫ�س����Ľⶼ���ظ���
			// ���Ծ�ֱ��continue��	
			if (prev != -1 && prev == candidates[i]) {	
				continue;
			}
			path.add(candidates[i]); // ��ע�� ���i��index ����˵�ݹ����һ����������indexλ
										// ��Ϊһ���������ö��
			subsetsHelper(candidates, target - candidates[i], path, i, result);
			path.remove(path.size() - 1);
			prev = candidates[i];
		}

	}
	public static void main(String[] args) {
		int[] candidates={2,3,6,7};
		//combinationSum(candidates, 7);
	}
}
