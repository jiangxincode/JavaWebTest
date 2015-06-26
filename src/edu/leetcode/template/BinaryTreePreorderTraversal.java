package edu.leetcode.template;

import java.util.ArrayList;

public class BinaryTreePreorderTraversal {

	
	//ģ��
	 public ArrayList<Integer> preorderTraversal(TreeNode root) {
	     ArrayList<Integer> result=new ArrayList<Integer>();
		 traversal(root,result);
		 return result;
		 }
		 
	 
	public void  traversal(TreeNode root, ArrayList<Integer> result){
	if(root==null){
		return;
	}	 
	//do sth with the root(eg:print  visit  result.add(root.val);)  ǰ����һ��
	traversal(root.left,result);
	//do sth with the root(eg:print  visit  result.add(root.val);) ������һ��
	traversal(root.right,result );
	//do sth with the root(eg:print  visit  result.add(root.val);)  ��������һ��
	
	 
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