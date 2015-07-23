package edu.leetcode;

//Given a linked list, determine if it has a cycle in it.
//ccԭ�� ����ָ������ ��Ҷ���ͷ��ʼ��  ��ÿ�������� ��ÿ����һ�� Ȼ�� �����ֱ�ߵ�linkedlist
//�������������� ���ò�������  ��������ǻ����û����� 

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
    if(head==null){
    	return false;
    }
	ListNode fast=head;//һ�������� 
	ListNode slow=head;//һ����һ�� 
	do{
		if(fast==null||fast.next.next==null){
			//fast �ߵ����� ����Բ������²������ߵ���
	return false;
		}
		fast=fast.next.next;
	    slow=slow.next;
	}while(fast!=slow);
	//���� ����ܵ���� fast==slow�� ��������ѭ�� �л�
	return true;
	}
}