package edu.leetcode.frequency_3;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree. 
//֪���������������
/*
 *             5
 *            /  \          
 *           2    7 
 *          / \  / \
 *         1  3 6   8     
 *����     1235678
 *����     1326875  ����root�Ǻ������һ�� val��5
 *Ȼ�� ȥ������������ 5��position 5��ߵ� ������������5�ұߵĶ���������
 �ں������� 132	(poststart, poststart + position - instart - 1)�������� 687position-inend+postend, postend-1)�������� 
 *�ٵݹ�����ұ�����  myBuildTree������������root,���� ��root��5��left��right  
 *���return root
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length != postorder.length) {
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1);
	}

	private TreeNode myBuildTree(int[] inorder, int instart, int inend,
			int[] postorder, int poststart, int postend) {
		if (instart > inend) {
			return null;
		}
		// post ������ ���� ��root��post order���һ��
		TreeNode root = new TreeNode(postorder[postend]);
		// �������������ҵ���root��val ����Ҫ�����������ҵ�root����������ڼ�λ
		// ��Ϊ�����������ң����� �����������ҵ�root��
		// root����߶������������ұ߶�����������
		int position = findPosition(inorder, instart, inend, postorder[postend]);
		root.left = myBuildTree(inorder, instart, position - 1, postorder,
				poststart, poststart + position - instart - 1);
		root.right = myBuildTree(inorder, position + 1, inend, postorder,
				position - inend + postend, postend - 1);
		return root;
	}

	private int findPosition(int[] arr, int start, int end, int key) {

		for (int i = start; i <= end; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

}
