package edu.leetcode;


//
//What constitutes a word?
//A sequence of non-space characters constitutes a word.

//Could the input string contain leading or trailing spaces?
//Yes. However, your reversed string should not contain leading or trailing spaces.

//How about multiple spaces between two words?
//Reduce them to a single space in the reversed string.

public class ReverseWordsinaString {
//	��ͳ�����������Լ�ȥ����ҵ�ÿ�����ʣ���ǰ�����ǴӺ���ǰ��ʵ����࣬
//	��Ҫ��ת��Ҫô�Ƿ�ת��ĸ���Ӻ���ǰ����Ҫô��ת���ʣ���ǰ���󣩡�
//
//	�������������java�Դ���split���������������ԡ� �������и���뿴��ȥ��Ƚϼ�����ˡ�
	 public String reverseWords(String s) {
		if(s==null||s.length()==0){
			return "";
		} 
		String[] array=s.split(" +");   //��ʾ1~n���ո� split 2�� 5����splitһ��
		StringBuilder sb=new StringBuilder();
		for(int i=array.length-1;i>=0;i--){  //���������һ������ǰ����
			sb.append(array[i]).append(" "); //��һ���ʺ��һ����
		}
		return sb.length()==0?"":sb.toString().trim();
	  }
}
