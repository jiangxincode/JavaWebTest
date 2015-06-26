package edu.leetcode.frequency_3;

import java.util.ArrayList;
import java.util.Stack;

//recursive ��д�� ��ĿҪ�� iteratorд�� 
//����  �� �� ��  ������ ���� ������
public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode curr=root;
		while(curr!=null||!stack.isEmpty()){
			if(curr!=null){
				                       //�����pre order���������������
				stack.push(curr);
				curr=curr.left;
			}else{
				curr=stack.pop();
				result.add(curr.val); 
			curr=curr.right;
			}
		}
		
return result;	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}