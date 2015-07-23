package edu.leetcode;


//�ҳ�һ��������һ��path������path��node�ĺ�Ϊ���ֵ���������path���Դ��κ�һ��node��ʼ��/\Ҳ���� ����ȥ������Ҳ��һ��path��
//ֻҪ���ž���
//�������ĵ�·������root��Left���� Ȼ������path��һ��··��  �������ĵ�·Ҳ��һ��
//Ȼ��������ٿ�����������root������֮�� �ǲ��� ����� 
//�þ��µ�ģ������-devided and concer ģ��
//           single path ���ߵ�����
//            /    or \
//           /         \
//            maxPath    ˫�ߵ�������һ���
//             /\
//            /  \
//           /    \
public class BinaryTreeMaximumPathSum {
	private class ResultType{
		int singlePath,maxPath;
		public ResultType(int singlePath,int maxPath) {
			this.singlePath=singlePath;
			this.maxPath=maxPath;
		}
	}
	
	public int maxPathSum(TreeNode root){
		ResultType result=helper(root);
		return result.maxPath;
	}
	
	public ResultType helper(TreeNode root) {
	    if(root== null){
	    	return new ResultType(0, Integer.MIN_VALUE);
	    } 
		//devided ���η� �ȷ� ������ȫ���ݹ���������������� ������ڱ��㴦�������������������صĶ���
	    ResultType left=helper(root.left);
	    ResultType right=helper(root.right);
	    
	    //conquer �ڱ��㴦�������������������صĶ���
	    //single Pathָ������/���ӽڵ����µ�path��ȡ������Ǹ�+(����)root ��ֵ
	    int singlePath=Math.max(left.singlePath, right.singlePath)+root.val;
	    //singlePath����Ǹ��ľ��������е���maxium sub array��
	    singlePath=Math.max(singlePath, 0);
	    //maxPath���Ǳ����������ڲ���˫���� �Ǹ����ȡ�Ǹ�
	    int maxPath=Math.max(left.maxPath,right.maxPath);
	    //Ȼ�������ϱ��εݹ��root��Ϊ��˫���� �����Ǹ���
             
	    maxPath=Math.max(maxPath,left.singlePath+right.singlePath+root.val);
	    return new ResultType(singlePath, maxPath);
	    		
	 }
}
