package edu.leetcode.frequency_5;
 



 

// Assume a BST is defined as follows:
//
//    The left subtree of a node contains only nodes with keys less than the node's key.
//    The right subtree of a node contains only nodes with keys greater than the node's key.
//    Both the left and right subtrees must also be binary search trees.

//�����һ�ö�������BST����ô�������������һ�����������顣���Կ��Զ���������㷨�Լ��޸ģ�
//ÿ�α�������¼��һ��Ԫ�أ�������ǰ�ڵ�Ԫ��ֵ�Ƚϡ�
//������bst,����ltcd������Ϊbst ���������ظ�ֵ
public class ValidateBST {
	
	//���ʾ���������� ֻ�������Լ�����������������boolean
	static int lastVisit=Integer.MIN_VALUE;
	  public boolean isValidBST(TreeNode root) {
		if(root==null){	return true;}
		if(!isValidBST(root.left)){return false;}
		if(root.val<=lastVisit){return false;}
	    lastVisit=root.val;
		if(!isValidBST(root.right)){return false;}
	  return true;
	  
	  }
		 
	
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(0);
		TreeNode left=new TreeNode(-1);
		root.left=left;
		System.out.print((new ValidateBST()).isValidBST(root));
	}

}

 
class TreeNode {
    int val;    
    TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
