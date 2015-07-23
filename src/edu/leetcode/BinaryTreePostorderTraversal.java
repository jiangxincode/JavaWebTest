package edu.leetcode;

import java.util.ArrayList;
//��ͨ��postorder traverse �����arraylist����
//�þ����㷨��ģ������ "

public class BinaryTreePostorderTraversal {
	 public ArrayList<Integer> postorderTraversal(TreeNode root) {
	        ArrayList<Integer> result=new ArrayList<Integer>();
	        if(root==null){
	            return result;
	            }
	            postOrder(root,result);
	        return result;
	    }
	    
	    private void postOrder(TreeNode root, ArrayList<Integer> result){
	        if(root ==null){
	            return;
	        }
	        postOrder(root.left,result);
	        postOrder(root.right,result);
	        result.add(root.val);
	    }
}
