package edu.leetcode.newQuestion;

import java.util.Random;

//һ��linkedlist ����next֮�⻹��һ��randomָ�� ����ָ������ڵ� �����Լ�/null
//Return a deep copy of the list. 

//����1 1. ��hashmap���µĵ���ϵĵ��Ӱ���ϵ
//����2.ÿ��node�����Լ�.next����һ���Լ���node��Next=node�� 
//Ȼ�����ǵ�randomָ��ԭ��node�ĺ�һ�㡣 Ȼ���ٰѸ��Ƶĵ��ԭ���ĵ�ֿ���  

//�ȷ�˵  1-1'-2-2'-3-3'
//       3    2    null   ���� 3 2 null�� 123��randomָ��  
//��ô���ƽڵ�� random��ô����أ�
//head.next.random=head.random.next;
//eg    1��.random=1.random.next=3.next=3' �������

public class Copylistwithrandompointer {
	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}
		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}

	private void copyNext(RandomListNode head) {
		while (head != null) {
			// �½ڵ���new������
			RandomListNode newNode = new RandomListNode(head.label);
			// ע�� ����ֻ�Ǽ���һ������ ��ǳ���� �������
			newNode.random = head.random;
			newNode.next = head.next;
			head.next = newNode;
			head = head.next.next;// head ����1�� ���³�2
		}
	}

	private void copyRandom(RandomListNode head) {
		while (head != null) {
			// head.next ���Ǹ��Ƶ���Щ 1�� 2�� node��
			if (head.next.random != null) {
				// �ؼ���1'2���ǵ�random��������¡��
				head.next.random = head.random.next;
			}
			head = head.next.next;// head ����1�� ���³�2

		}
	}

	// �� 1-1'-2-2'-3-3' ����
	// 1'-2'-3'
	private RandomListNode splitList(RandomListNode head) {
		RandomListNode newHead = head.next;
		while (head != null) {
			RandomListNode temp = head.next; //1'
			head.next = temp.next;// temp.next��2
			head = head.next;  //head������һλ
			if (temp.next != null) { // 2.next!=null
				temp.next = temp.next.next;//1'����2' ��һ��while���ټ��head��3.next�ǲ���null 
				
			}
		}
		return newHead;
	}

}

class RandomListNode {
	int label; // �൱��value
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}