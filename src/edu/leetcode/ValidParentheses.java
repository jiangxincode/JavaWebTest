package edu.leetcode;
import java.util.Stack;

                  //����
public class ValidParentheses {
//	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
//��CC�ϵĲ�̫һ��
	
//������֤Parentheses  ����Ĺؼ���ʲô ��������ź��ұ����ŵĺϷ�ƥ��
//�ȷ�˵ {[()[{(())}]]}����ǿ��Ե� ��Ϊ��������ƥ�����ˣ��������һ��stack��ʵ��validation ��Ϊstack�Ƚ��ȳ�,�Ƿ���valid
	//�������ǵ��߼��ġ�

	 public boolean isValid(String s) {
		 char first=s.charAt(0);
	     if(s==null||s.equals("")||(s.length()%2)!=0||first=='}'||first==')'||first==']'){
	    	 return false;
	     }	
	     		 Stack<Character> stack=new Stack<Character>();
	     for(int i=0;i<s.length();i++){
	    	 Character current=s.charAt(i);
	    	 if(current=='{'||current=='['||current=='('){
	    		 stack.add(current);
	    	 }
	    	 if(current=='}'||current==']'||current==')'){
	    		 if(stack.size()==0){return false;}
	    		 Character lastLeft=stack.pop();
	    		                  //��ô��equals�� �ѵ��������ܵ���������ô 
	    		 //���Ǵ��if(!lastLeft.equals(current)){return false;}
	    		 if(current=='}'){
	    			 if(lastLeft!='{'){return false;}
	    		 }
	    		 if(current==']'){
	    			 if(lastLeft!='['){return false;}
	    		 }
	    		 if(current==')'){
	    			 if(lastLeft!='('){return false;}
	    		 }
	    	 }
	    	 
	     }
	     //��ʱ��forѭ������ ���trueӦ�ö�22ƥ�� stack�ù�
	     if(stack.size()!=0){return false;}
		return true;
	     

	 }	
	
	public static void main(String[] args) {
		String strin="((";
		System.out.print((new ValidParentheses()).isValid(strin));
				
	}

}
