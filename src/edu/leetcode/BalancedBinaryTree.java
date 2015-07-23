package edu.leetcode;
//
//Given a binary tree, determine if it is height-balanced.
//
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
//����Ҫ��ÿһ�������ĸ߶ȶ�һ�� ������һ������ �����е㲻ͬ
//����CCԭ�� �����þ��µ�ģ������   (��cc������΢��һ����cc������������node����ǳnode�Ĳ� )
//������ ��ÿ��recursive���������ĸ߶Ⱥ��������ĸ߶ȣ������ǵø߶���ô��ô Ҷ�ӽڵ�����null����0 Ȼ��Ҷ�ӽڵ㷵��0+1 ���Ͼͷ���1+1�����������/�������Ѿ���ƽ���� ���� ���߸߶�������1�� �ͷ���-1
//Ȼ���һ������Ϸ���-1 ���false
//�ݹ�   �Ƚ����������������ĸ߶� �=1����true ��1����false
//�����ֽ�ϻ�����ƽ������������
public class BalancedBinaryTree {
	
	 public boolean isBalanced(TreeNode root) {
	      return maxDepth(root)!=-1;  
	    }
	 
	 private int maxDepth(TreeNode root){
		 if(root==null){
			 return 0;
		 }
	 
	 int left=maxDepth(root.left);
	 int right=maxDepth(root.right);
	 if(left==-1||right==-1||Math.abs(left-right)>1){
		 return -1;  //�ҵ�����������ƽ���� �� ����-1
	 }
	 
	 return Math.max(left,right)+1;
}
}