package edu.leetcode;

import java.util.ArrayList;
//��ͨ��preorder traverse �����arraylist����
//�þ����㷨��ģ������ 

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		preorder(root, result);
		return result;
	}

	private void preorder(TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val); // ��root�ķ��ʷ����� ǰ��
		preorder(root.left, result);
		// ��root�ķ��ʷ����� ����
		preorder(root.right, result);
		// ��root�ķ��ʷ����� ����

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}