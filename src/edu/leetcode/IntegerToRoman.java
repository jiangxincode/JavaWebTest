package edu.leetcode;
//
//Given an integer, convert it to a roman numeral.
//(eg:2123=MMCXXIII)
//Input is guaranteed to be within the range from 1 to 3999.

//��integer�����������
//�����֮ǰ��integer���Ӣ��������һ��
//1.��׼���ʿ⣨���ֺ�string���Ӵ�С��
 
public class IntegerToRoman {

	 public String intToRoman(int num) {
		 //����ʿ��� ������� �͵����ַ���Ӧ�ľ���Щ����
		 int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1}; 
		 String[] numerals={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		 StringBuilder resultBuilder=new StringBuilder();
		 //2.��Ϊvalue�Ǵӵ���С�� ���Կ�����ô�� ��num�ȴʿ�������ֵ���ʱ�� ��ȥ������ֵȻ��
		 //stringbuilder����append���string Ȼ��ѭ�� ֱ������0
		 for(int i=0;i<values.length;i++){
				while(num>=values[i]){
					num=num-values[i];
					resultBuilder.append(numerals[i]);
			} 
		 }
		 return resultBuilder.toString();}
		 
		 
	public static void main(String[] args) {
	System.out.print((new IntegerToRoman()).intToRoman(2123));
}
	
	
}
