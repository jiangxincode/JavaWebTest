package edu.leetcode;
//������һ��  ���ڹ�����׷���� 
//���ӻص�head,Ȼ��Ҳ���ڹ�һ��һ��һ����
//�����ٴ�������һ���ص� 
public class LinkedListCycleII {
	 public ListNode detectCycle(ListNode head) {
	        if(head==null){
	        	return null;
	        }
 ListNode fast=head;
 ListNode slow=head;
 //ǰ��κ�cycle linked list 1һ�� 
 do{
	 if(fast.next==null||fast.next.next==null){
		 return null;
	 }
	 fast=fast.next.next;
	 slow=slow.next;
}while(fast!=slow);
 // ��ʱ��β����  �ٴ�ͷͬ������
 while(head!=slow){
	 head=head.next;
	 slow=slow.next;
 }
 return head;
	 }
}
