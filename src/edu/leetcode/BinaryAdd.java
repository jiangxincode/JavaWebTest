package edu.leetcode;

import java.util.ArrayList;

//Given two binary strings, return their sum (also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100". 
//������ϵͳ�Դ��� Integer.parseInt(a, 10);  ��Ϊ���string����32λ�����int�� 
//������string buffer��   (��linkedlist add ����һ���� ��λ�ͽ�λ 0+0=0  1+1=0��1  1+0/0+1 =1
public class BinaryAdd {
	// ��Ϊ Ҫ�ӵ�λ�ӵ���λ ���� Ӧ�ô�string�����λ��ǰ��� �ӵ�һ��stringbuffer��Ϳ�����
	// ���stringbuffer��reverse��ȥ
	
	//�����ж϶����Ƽӷ�����0����1
	// carryλ��/2  valueλ��%2
	// eg:1+1=2  2/2=1  ����carryλ��1    2%2=0 ����valueλ��0
	
	public String addBinary(String a, String b) {
		int firstLen = a.length() - 1;
		int secondLen = b.length() - 1;
		StringBuffer result = new StringBuffer();
	int value=0;
	int carry=0;
		while (firstLen > -1 && secondLen > -1) {
		value=(((a.charAt(firstLen)-'0')+(b.charAt(secondLen)-'0'))+carry)%2;
		carry=((a.charAt(firstLen)-'0')+(b.charAt(secondLen)-'0')+carry)/2;
			result.append(value);
			firstLen--;
			secondLen--;
        }
		
		if(firstLen<0){
			while(secondLen>-1){
				value=(((b.charAt(secondLen)-'0'))+carry)%2;
			 carry=(((b.charAt(secondLen)-'0'))+carry)/2;
					result.append(value);
					secondLen--;
			}
		}else{
			while(firstLen>-1){
				value=(((a.charAt(firstLen)-'0'))+carry)%2;
			 carry=(((a.charAt(firstLen)-'0'))+carry)/2;
					result.append(value);
					firstLen--;
			}
		}
		//Ҫע��߼���� ��� ���߶�û�� ���ǻ���һ������Ľ�λcarry��ǰ�� 
		if(carry!=0){result.append(carry);}
result=result.reverse();
	return result.toString();}

	public static void main(String[] args) {
		System.out.print((new BinaryAdd()).addBinary("11", "1"));
	}

}

// ������ô�� ��Ϊ �����string���ܳ���32λ ���int ����������������Ľ��Ҳ����
// int first=Integer.parseInt(a, 10);
// int second=Integer.parseInt(b, 10);
// int sum=first+second;
// String result=Integer.toBinaryString(sum);
// return result;