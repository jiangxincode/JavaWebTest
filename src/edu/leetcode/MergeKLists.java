package edu.leetcode;

import java.util.ArrayList;

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
//�ҿ��Գ�������
public class MergeKLists {

	 public ListNode mergeKLists(ArrayList<ListNode> lists) {
		boolean alldone=true;
		 for (ListNode s : lists) {
				
				if(s!=null){
					alldone=false;
				break;}
				}
		 if(alldone){return null;}
     ListNode result=new ListNode(0);
	 int min=Integer.MAX_VALUE;
	 for (ListNode s : lists) {
	if(s!=null)	{
		if(s.val<min){
			min=s.val;
		}
		}}
	 for (int i = 0; i < lists.size(); i++) {
		    if (lists.get(i) != null && lists.get(i).val == min ) {
		        lists.set(i, lists.get(i).next);
		        break;
		   }
		}

//	 for (ListNode s : lists) {  
//		 if(s!=null)	{
//			if(s.val==min){
//			s=s.next; //Ϊʲô������ô��  ��Ϊ��foreachѭ���� sֻ��һ������ʱ���á���s ��û�������list����node����һλ
//			break;
//			}
//			}}
	 result.val=min;
	 result.next=mergeKLists(lists);	 
	    
	 return result; 
	 }
	
	
	public static void main(String[] args) {
     ListNode a1=new ListNode(1);
     ListNode a2=new ListNode(5);
     a1.next=a2;
     ListNode b1=new ListNode(2);
     ListNode b2=new ListNode(4);
     b1.next=b2;
     ArrayList<ListNode> testArrayList=new ArrayList();
     testArrayList.add(a1);
     testArrayList.add(a2);
     
		(new MergeKLists()).mergeKLists(testArrayList);

	}

	static class ListNode {
	    int val;
	   ListNode next;
	  ListNode(int x) {
	       val = x;
	      next = null;
	   }
	  }


}


 
