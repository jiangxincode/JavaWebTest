package edu.leetcode;

import java.util.Stack;

//Given a singly linked list L: L0��L1������Ln-1��Ln,
//reorder it to: L0��Ln��L1��Ln-1��L2��Ln-2����
//
//You must do this in-place without altering the nodes' values.
public class ReorderList {
	  public void reorderList(ListNode head) {
	      if(head==null||head.next==null){
	    	  return;
	      }  
	      
	      ListNode dummy=new ListNode(-1);
	      dummy.next=head;
	      ListNode fast=dummy;
	      ListNode slow=dummy;
	      while(fast!=null&&fast.next!=null){
	    	  fast=fast.next.next;
	    	  slow=slow.next;
	      }
	      // �������ѭ���� slow������ һ��
	      ListNode curr=slow.next;
	      slow.next=null;
	  Stack<ListNode> stack=new Stack<ListNode>();
	  // �Ѻ��ζ�����stack
	  while(curr!=null){
		  stack.push(curr);
		  curr=curr.next;
	  }
	  //������֮�� ��curr��ָ��head��
	  curr=head;                            //��ֹ��е��е�ڵ㱻�ظ��á�
	  //curr ��ǰ�����󡣡�stack�Ǵ������pop��ǰ
	  while(!stack.isEmpty()&&stack.peek()!=curr.next){
		  ListNode temp=stack.pop(); //n
		  temp.next=curr.next;//n->2
		  curr.next=temp;//1->n
		  curr=curr.next.next; //  1->n->2 ( ��ʱcurrΪ2)
	  }
	  
	  }
}
