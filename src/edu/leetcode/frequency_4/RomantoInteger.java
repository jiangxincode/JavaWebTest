//Given a roman numeral, convert it to an integer.
//(eg:2123=MMCXXIII)
//Input is guaranteed to be within the range from 1 to 3999.
//���������ֵ�string Ȼ����integer
package edu.leetcode.frequency_4;

//���Ǻ͸ո�����IתR�е㲻һ��
//�����ַ������ǵ�����һ����ĸ��ʾ ����������һ����һ������
// 
//�����ǰ��ǰһ����˵����һ�ε�ֵӦ���ǵ�ǰ���ֵ��ȥ��һ��ֵ������IV = 5 �C 1
//���򣬽���ǰֵ���뵽����У�Ȼ��ʼ��һ�μ�¼������VI = 5 + 1�� II=1+1
//

public class RomantoInteger {
	 public int romanToInt(String s) {
 
	   int result=0;
	 char[] array=s.toCharArray();
	 for(int i=0;i<array.length;i++){
		//�������ֵ�ʮ���߼�
		   //��ֹi-1����Խ��      //�����һλ��ǰһλ����һ�ε�ֵӦ���ǵ�ǰ���ֵ��ȥ��һ��ֵ������IV = 5 �C 1
		 if(i>0&&getChar(array[i])>getChar(array[i-1])){
			 result=result+(getChar(array[i])-2*getChar(array[i-1]));
		 }else{//�������� ����
			 result=result+getChar(array[i]);
		 }
	 }
	 
	 return result;
	 }
	 
	 public int getChar(char c){
		    switch(c){
		        case 'I': return 1;
		        case 'V': return 5;
		        case 'X': return 10;
		        case 'L': return 50;
		        case 'C': return 100;
		        case 'D': return 500;
		        case 'M': return 1000;
		    }
		    return 0;
	 
	 
}}
