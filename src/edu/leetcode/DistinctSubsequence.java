package edu.leetcode;

import java.lang.reflect.Array;
//Given a string S and a string T, count the number of distinct subsequences of T in S.
//
//A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
//Here is an example:
//S = "rabbbit", T = "rabbit"    S source

//
//Return 3. 
//�������˼�� rabbit ������rabbbit���������Ԫ��,�ڲ��ı�˳��������ȡ�����Ԫ�� �����rabbit ���ǿ���
//�ȷ�˵ rabbit������rabbbit�� ��һ�ڶ���b �ڶ�������b ��һ������b��� 
//���� ��3����ɷ��� ������ ����3






public class DistinctSubsequence {
//2 sequence dp������ģ�� ��edit distance����
//һ������num ��ΪT.length+1 ��ΪS.length+1    Ȼ�� num[i][j] ��  S��д��T�м��ַ���
//	       ��  r a b b i t 
// �� 	1 0 0 0 0 0 0    ��ô��� ��� matrix ,���� ��rabbit��Ҫ�� rabbbit��char������� ��ô��2sequence����֤˳�򲻻���
// r	1 1 0 0 0 0 0   Ȼ��[0][0]�ǿ���ɿ� ��ô1�ַ�����Ȼ���һ���ϲ����ǿ�+rab.���ǿ�+rabbbit��ɿ� ����ֻ�õ�һ���� ���Ե�һ�ж���1 
// a	1 1 1 0 0 0 0   Ȼ�� rab���rabҲ��ֻ��1�ַ��� [3][3]=1 �������Ҫ ��S rabb ���T rab����2�ְ취�� ra+b1  or ra+b2 ����[4][3]��2
// b	1 1 1 1 0 0 0   nums[4][3]=nums[4][3]+nums[3][2];=1+1=2  ����[4][4]����1�� ��Ϊ rabb��rabbֻ��һ����ɰ취
// b	1 1 1 2 1 0 0   ����������Ӧ�ÿ�����2��forѭ���� 
// b	1 1 1 3 3 0 0 
// i	1 1 1 3 3 3 0 
// t	1 1 1 3 3 3 3 

	public int numDistinct(String S, String T) {
     if(S==null||T==null){
    	 return 0;
    	 }
     //��ʼ״̬ 
     int[][] nums= new int[S.length()+1][T.length()+1];
    //     
     for(int i=0;i<=S.length();i++){
    	 nums[i][0]=1;
     }
		
     
     
     for(int i=1;i<=S.length();i++){
    	 for(int j=1;j<=T.length();j++){  
    		 		 nums[i][j]=nums[i-1][j]; //nums[i][j]����nums[i - 1][j]���ƶ�һλ������
    		 		 //eg [2][1]=[1][1]=1 ����r����ɡ���r����һ�ַ���(��ɾ) ����ra����ɡ� ��ra��Ҳ��һ��(ɾa) ����������
    	  		 if(S.charAt(i-1)==T.charAt(j-1)){  //������Ϊnum�������Ǵ�1��ʼ��,[0][0]�ǿ� ���� ��i=4 j=3ʱ�� S.charAt(i-1)==T.charAt(j-1)
    			 nums[i][j]=nums[i][j]+nums[i-1][j-1];//ʵ������S.charAt(3)==T.charAt(2) ������rabbbit�ĵ�2��b���� rabbit�ĵ�һ��b 
    			 //���Ե�ȷ��rab1���rab�����ֿ��ܣ���б�Ͻ�nums[i-1][j-1]num[3][2] �����num[4][3] ���ֿ��ܣ�
    			 //Ҳ�д�rab2���rab���� �����Ϸ�nums[i-1]num[3][3] �����num[4][3] ���ֿ��ܣ� 
    			 //���Դ�ʱ nums[i][j]=nums[i][j]+nums[i-1][j-1];
    			 
    		 }
    	 }
   
     }
     //
	 for (int i = 0; i <nums.length; i++) {
	 System.out.println("");
	 for (int j = 0; j <nums[0].length; j++) {
	 System.out.print(nums[i][j]+" ");
	 }
	}
		
	return nums[S.length()][T.length()];	
	
		
    }
	
	public static void main(String[] args) {                     //source    target
		System.err.println( new DistinctSubsequence().numDistinct("rabbbit", "rabbit"));
		
	}
}
