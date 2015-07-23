package edu.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//java  �� queue�ǽӿ� stack���ֳ��� ������linkedlistʵ�� 


public class BinaryTreeLevelOrderTraversal {
	// level order ÿ�����һ��arraylist<Interger>
	// ��bfs ������ queue ÿ�ΰ��ϲ�ڵ���� Ȼ��dequeue��ʱ�� �� ����dequeue�ڵ���ӽڵ�
	//
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		 
		Queue<TreeNode> queue =new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode current;
		while (!queue.isEmpty()) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			int num = queue.size();// ��ǰ���whileѭ���е�current size
									// һ��ʼ��root��һ�� Ȼ��root
									// dequeue��ʱ���ѵڶ���ȫ�Ž�queue
									// Ȼ��ڶ���dequeue�Ĺ����л�ѵ����㶼�Ž�ȥqueue
									// ����ÿ��whileѭ���տ�ʼ��ʱ��queue��ֻ��һ��
									// ������Žв������
			for (int i = 0; i < num; i++) {
				current = queue.remove();
				arrayList.add(current.val);
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
	//һ��������� ����forѭ����ı��� ����result
			result.add(arrayList);
		}
return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}