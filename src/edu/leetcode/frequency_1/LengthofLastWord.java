package edu.leetcode.frequency_1;
//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non-space characters only.
//
//For example,
//Given s = "Hello World",
//return 5. 


public class LengthofLastWord {
	  public int lengthOfLastWord(String s) {
	        
		 int length=0;
		 char[] chars=s.toCharArray();
		 //���Ŵ�string�����ǰ���
		 for(int i=s.length()-1;i>=0;i--){
			 if(length==0){
				 if(chars[i]==' '){
					 continue;
				 }else{
					 length++; // �ҵ���һ���ǿյ� ��ĸ ������ʼ
				 }
			 }else{
				 if(chars[i]==' '){
					 break;  //�ڶ����ո��� ˵�����һ���ʽ����� break forѭ��
				 }else{
					 length++;
				 }
			 }
		 }
		  return length;
	    }
}
