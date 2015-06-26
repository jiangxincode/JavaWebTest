package edu.leetcode.frequency_3;
//Given a binary tree, return the zigzag level order traversal of its
		// nodes' values. (ie, from left to right, then right to left for the next
		// level and alternate between).
		//
		// For example:
		// Given binary tree {3,9,20,#,#,15,7},
		//
		// 3
		// / \
		// 9 20
		// / \
		// 15 7
		//
		// return its zigzag level order traversal as:
		//
		// [
		// [3],
		// [20,9],
		// [15,7]
		// ]
		// level order ����Ҫһ��������� һ�㷴�����
import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
// //2��stack ����ô����� ��סstack ���� FILO
//          1
//        2   3
//       4 5 6 7
//	��normal order��true 1pop ʱ��,2 3��nextlevel  
//Ȼ����һ��normal order ��false Ȼ��pop������˳���� 3��2 Ȼ����Ϊ�Ƿ���,������push right ��push left
//��ʱpush��˳�����7 6 5 4 Ȼ��pop��˳������� 4 5 6 7 �ӵ����������� ������������ 	
//
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> currLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		Stack<TreeNode> tep;
		currLevel.push(root);
		boolean normalOrder = true;
		while (!currLevel.isEmpty()) {
			ArrayList<Integer> currLevelResut = new ArrayList<Integer>();
			while (!currLevel.isEmpty()) {
				TreeNode node = currLevel.pop();
				currLevelResut.add(node.val);

				if (normalOrder) {
					 
					if (node.left != null) {
						nextLevel.push(node.left);
					}
					if (node.right != null) {
						nextLevel.push(node.right);
					}

				} else {
					if (node.right != null) {
						nextLevel.push(node.right);
					}
					if (node.left != null) {
						nextLevel.push(node.left);
					}
				}
			}
			result.add(currLevelResut);
			//��ʱ currLevel �Ѿ�pop���� �ǿյ� 
			tep = currLevel;
			currLevel = nextLevel;
			nextLevel = tep;//���Ը�ֵ���µ�nextLevel
			normalOrder = !normalOrder;
		}

		return result;

	}

}
