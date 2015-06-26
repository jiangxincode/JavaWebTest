

package edu.leetcode.newQuestion;

import java.util.Stack;

//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.
//
//Some examples:
//
// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//������������������־�ѹ��stack�� Ȼ��
//�������� �͵���stack�������2������ Ȼ������ Ȼ���ٰѽ��ѹ��ȥ
//һֱ����������Ϊֹ  ����ֻ�ü��㲻��ѹ��ջ

//ps ����Ժ����Թ����� Ҫ��Ҫ���� ���������� ����stack.size()<2 ��ô��
//pps���ⲻ���������test case
public class EvaluateReversePolishNotation {
public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length==0){
        	return 0;
        }
        Stack<Integer> stack =new Stack<Integer>();
      
        for(int i=0;i<tokens.length;i++){
        	if(tokens[i].equals("+")){
        		int a=stack.pop();
        		int b=stack.pop();
        		stack.push(a+b);
        	}else if(tokens[i].equals("-")){
        		//ע����ǰ�����-������� ջ��һ��pop�����ĺ������
        		int a=stack.pop();
        		int b=stack.pop();
        		stack.push(b-a);
        	}else if(tokens[i].equals("*")){
        	  stack.push(stack.pop()*stack.pop());
        	}else if(tokens[i].equals("/")){
        		int a=stack.pop();
        		int b=stack.pop();
        		stack.push(b/a);
        	}else{
        		stack.push(Integer.parseInt(tokens[i]));
        	}
        }
        //�������һ�μ���� stackӦ��ֻ�����ս��һ��int
        return stack.pop();
    }
}
