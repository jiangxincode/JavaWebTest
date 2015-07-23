package edu.leetcode;

import java.util.zip.Inflater;

import edu.leetcode.FlattenBinaryTreetoLinkedList.TreeNode;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//���� ���粻�Ǳ�� ����ĿӦ����ô����
//һ��ƽ���BST ������� �ұ�һ���ߡ���Ԫ��һ����
//��ô ����binary searchһ�� mid �� root Ȼ��ǰ���mid ��root.left ����mid��root.right
//	root.left = helper(num, low, mid - 1);
//root.right = helper(num, mid + 1,high);

public class ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		return helper(num, 0, num.length - 1);
	}

	private TreeNode helper(int[] num, int low, int high) {

		if (low > high) {
			return null;
		}
		int mid = low + (high - low) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = helper(num, low, mid - 1);
		root.right = helper(num, mid + 1, high);
		return root;
	}
}