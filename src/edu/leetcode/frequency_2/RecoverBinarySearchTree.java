package edu.leetcode.frequency_2;

import org.omg.CORBA.PRIVATE_MEMBER;

//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.����˵ֻ�û�val������

//BST����2��node��swap�� �ƻ��� bst  ��Ҫ��������ָ���BST

//�þ����㷨ģ�� 

//���� ����Ҫ�ǲ�coding�Ļ�,���������˵��߼���ô���أ� ��ô�ҵ�����Ľڵ��أ�

//�ͺñ���һ��sorted�����bst�����������sorted���飩 �����2����λ�û�����
//��ô�϶�Ҫ����sort ��sort״̬�� ��root�϶�������һ��root�� ��ô���ﱾrootС��inorder�ݹ����һ��root �϶����Ǵ��node 
//��2��node �������� ����  �����������+��� ����
public class RecoverBinarySearchTree {

	private TreeNode firstElement=null;
	private TreeNode secondElement=null;
	//��ʼ��lastElement�� ��Сֵ�����ڱ�� 
	private TreeNode lastElement=new TreeNode(Integer.MIN_VALUE);
	
	
	public void recoverTree(TreeNode root) {
	       //traverse and get two elements
		
		traverse(root);
		//swap the wrong ordered element Ȼ���2�����Ƶ�swapһ�¼��� 
		int temp=firstElement.val;
		firstElement.val=secondElement.val;
		secondElement.val=temp;
	    }
	
	//in-order traverse
	private void traverse(TreeNode root){
		if (root==null) {
			return;
		}
		traverse(root.left);
		if(firstElement==null&&root.val<lastElement.val){//����ݹ��root�� ����������ϸ�node�ȿ����򲻴���sort
			firstElement=lastElement;  //��һ�����Ƶ�sort��node
		}
		if(firstElement!=null&&root.val<lastElement.val){//����ݹ��root�� ����������ϸ�node�ȿ����򲻴���sort
			secondElement=root;  //�ڶ��δ�����Ƶ�sort��node
		}
		lastElement=root; // ÿ�������������һ��node  
		traverse(root.right);
	}

     

}
