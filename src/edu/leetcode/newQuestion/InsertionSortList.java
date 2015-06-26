package edu.leetcode.newQuestion;

import java.util.Iterator;
 
//Sort a linked list using insertion sort.

public class InsertionSortList {
//insertion sort�����ǽ������δ����������С����ǰ��İ�������
	
// ���� �ȷ�˵Ҫ���� 6543�Ļ�������һ��dummynode -1
// Ȼ�� //	-16  -156  -1456  -13456
	// while(head!=null){�������ѭ��֮��node��һֱ���Ǹ���ʼdummy-1
	//Ȼ��ͨ����whileѭ���ȴ�Сѡ��Ҫ��ǰ����Ǹ�node
	//temp=head.next=5 Ȼ�� dummy node ��next����head.next һ��ʼdummy.next ��null ��ô��ʱ��һ��head.nextҲ��null
	//
	
	public ListNode insertionSortList(ListNode head) {
	       ListNode dummy= new ListNode(-1); 
	 
	 while(head!=null){
		 ListNode node=dummy;

		 while(node.next!=null&&node.next.val<head.val){
			 node=node.next;
		 }  //�ұ�headС�� ����

		 ListNode temp=head.next; 
         head.next=node.next; //�ȷ�˵dummyԭ��ָ��6 ������ head 5ָ��6   
		 node.next=head; //��dummy.next=һֱָ��ǰhead 5  ���������� dummy-5-6
		 head=temp;  //head���� ʵ���ϵ�head.next ��linkedlist����һλ������ ��ʱ head=4

		 }
	 
	 return dummy.next;

	 }
//	���� 6 5 4  3
//	-1
//	-16
//	-156
//	-1456
//	-13456


	 public static void main(String[] args) {
		ListNode a=new ListNode(6);
		ListNode b=new ListNode(5);
		ListNode c=new ListNode(4);
		ListNode d=new ListNode(3);
		a.next=b;
		b.next=c;
		c.next=d;
		
	InsertionSortList sort=new InsertionSortList();
	sort.insertionSortList(a);
		
	}
}
