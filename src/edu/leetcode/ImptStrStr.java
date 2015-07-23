package edu.leetcode;
import java.util.Arrays;

//Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack. 
//�ڸɲݶ�haystack����һ����
//ʲô��˼�� ���� ��haystack���string�￴�Ƿ����needle���string
//�ȷ�˵ abcde  ���� bc  ����ҵ��ͷ��� bcde û�о���null
//����ͺ�׺���ǲ�һ���� ��Ϊ��һ���Ǻ�׺ �����ǵ���һ�Ρ�
//�ַ�������ƥ�������
public class ImptStrStr {

	 public String strStr(String haystack, String needle) {
//	        if(needle.equals("")||needle==null||haystack.equals(null)||haystack==null||needle.length()>haystack.length()){
//	        	return null;}  Ϊʲô���ﲻҪ ��Ϊ ""����Ҫ�ҵõ� ""
	        char[] result=new char[haystack.length()];
	        char[] n=needle.toCharArray();
	        int h_len = haystack.length();
			int n_len = needle.length();  
			   //ֻҪ����haystack-needle�ĳ��ȼ���(�ȷ�˵ haystack�ǳ���14 needle ����5,��Ҫ����14-5+1=10�� ��Ϊ������
			 //hay[9]��û���ҵ��Ļ�����ʱ����haystack[13]ֻ��4��Ԫ���� ��needle����Ϊ5 ������ôҲƥ�䲻���� )
			for (int i = 0; i < h_len - n_len + 1; i++) {
				int j;
				for (j = 0; j < n_len; j++) {
					//���if��ע�� ��Ϊ�Ǵ�haystack��iλ��needle��0λ��ʼ��
					//���� j=0..j++ Ȼ�� ��haystack.charAt(i + j)��needle.charAt(j)�� //�������߶�����������
					//ֱ��Ҫô��һ�� �� ����תս��һ��i 
					if (haystack.charAt(i + j)!=needle.charAt(j)) {
						break;
					}
				}//Ҫô��j=n_len˵�������˶��� �ʹ�iλ���haystack
				if (j == n_len) {  //��ע�� ��ÿһ��jѭ����ƥ���ϵ�ʱ�� ����һ��iѭ���﷢����
					return haystack.substring(i);
				}
			}
			return null;

	    }
	
	
	public static void main(String[] args) {
         System.out.print(((new ImptStrStr()).strStr("abcdefg", "abcdefg")));
	}

}
