package edu.leetcode.frequency_4;

//һ�������� ��root��һ��Ҷ����һ��path ��������
//         1
//        / \
//       2   3
//��ôһ��path���� 12 һ��path����13 ����Ҫ���صĴ𰸾��� 12+13=15
//��Ȼ �������dfs�� ������� ����  ѭ��+�ݹ�
//ps ���������� 1-2-4 =124 ��ô �͵�������һ�������һ��x10+����
//eg ��һ��1  �ڶ���1x10+2=12 ������12x10+4=124

public class SumRoottoLeafNumbers {
  int res;  //д�����ǳ�Ա���� ���з��������Բ����� ������Ҫͨ�����������������
            // ���res�����������ܺ���
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		res=0;
		sumNumbers(root,0); //�൱��root�ġ��ϲ㡱��0 
		return res;
		
	}
                                                //pathsum��һ��·����ֵ
	public void sumNumbers(TreeNode root, int pathsum){
		if(root.left==null&&root.right==null){ //�Ѿ��ӵ�path�ײ� pathsum������ �ӵ�res����
		res=res+pathsum*10+root.val;
		}
	if(root.left!=null){
		sumNumbers(root.left,pathsum*10+root.val);
	}
     if(root.right!=null){
    	 sumNumbers(root.right,pathsum*10+root.val);
     }		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
