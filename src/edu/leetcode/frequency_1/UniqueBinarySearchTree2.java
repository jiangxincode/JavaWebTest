package edu.leetcode.frequency_1;

import java.util.ArrayList;
//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n
//
//For example,
//Given n = 3, there are a total of 5 unique BST's.
//
// 1         3     3      2      1
//  \       /     /      / \      \
//   3     2     1      1   3      2
//  /     /       \                 \
// 2     1         2                 3

import javax.management.loading.PrivateClassLoader;

//1~n  Ҫȫ��������bst�� �м��ֿ��ܵ�����
//��dfs��˼��  ��rootΪ1ʱ�� rootΪ2ʱ�� rootΪ3ʱ��ѭ�� һֱ��n �����for
//Ȼ��rootΪ1ʱ�� ��߲��ܷ� �ұ߷�2~n   rootΪ2ʱ��  ��߷�1 �ұ߷�3��n
//��֮ �� rootΪ iʱ�� ��߷�1��i-1  �ұ߷�1+1��n�������������dfs
//ѭ������1��n

public class UniqueBinarySearchTree2 {
	public ArrayList<TreeNode> generateTrees(int n) {

		return numTrees(0, n-1);
	}

	// dfs
	private ArrayList<TreeNode> numTrees(int start, int end) {
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			// ��root=iʱ�� all possible left subtree��󶼻᷵�ص�leftChild
			ArrayList<TreeNode> leftChild = numTrees(start, i - 1);
			// ��root=iʱ�� all possible right subtree��󶼻᷵�ص�rightChild
			ArrayList<TreeNode> rightChild = numTrees(i + 1, end);
			// ��Ϊ��ʱ���ڴ��iѭ���� ����root����i
			// ��ô��root ��i��ʱ�� ���еĿ�������
			// i���������������п��� �� i���������������п���
			for (int j = 0; j < leftChild.size(); j++) {
				for (int k = 0; k < rightChild.size(); k++) {
					TreeNode root = new TreeNode(i + 1);// that store values
														// 1...n. û��0
					root.left = leftChild.get(j);
					root.right = rightChild.get(k);
					result.add(root);
				}
			}
		}
		return result;
	}
}
