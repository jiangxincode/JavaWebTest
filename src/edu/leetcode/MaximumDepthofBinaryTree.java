package edu.leetcode;
//�����ĸ߶�
//�����㷨 ģ����
public class MaximumDepthofBinaryTree {
	 public int maxDepth(TreeNode root) {
	       if(root==null){
	    	   return 0;
	       }
	       
	       int left=maxDepth(root.left);
	       int right=maxDepth(root.right);
	       return Math.max(left, right)+1;
	    }
	
}