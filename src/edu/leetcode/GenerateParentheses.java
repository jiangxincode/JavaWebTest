package edu.leetcode;

import java.util.ArrayList;

//��CC8-5��ȫһ��  ����ccҪ���ӡ ����Ҫ�����ArrayList
//���� �Ȳ�̸���� �����Ŀ�Ļ����߼���ʲô��
	// ��Ȼ�ǡ����� �� ������ ��������ȣ�����������ֻ࣬�ܴ�ӡ����������֮��Ȼ
//��ֻҪ���л�û��������涨������ �Ϳ��Բ���
	// �ң�����������ң������Ѿ�����n������ô�ҵ��������ܳ���n

public class GenerateParentheses {

	 public ArrayList<String> generateParenthesis(int n) {
		 char[] str = new char[n * 2];
		 ArrayList<String> result=new ArrayList<String>();
		 return printpar(n, n, str, 0,result); 
	    }
	
	                                              //��ʣ���ٸ�l rû��             //count���Ѿ����˶��ٸ�����
		private static ArrayList<String> printpar(int l, int r, char[] str, int count,ArrayList<String> result) {
			
			if(l<0||r<0){return null;}
			
			if(l==0&&r==0){result.add(new String(str));
			}else{//����ʣ�µ�lû�� ������
				if(l>0){
					str[count]='(';
					printpar(l-1, r, str, count+1,result);
				//ʣ�µ�r��l�� ������l
				}if(r>l){
					str[count]=')';
					printpar(l, r-1, str, count+1,result);
				}
			}
		return result;	
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
