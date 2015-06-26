package edu.leetcode.frequency_5;
import java.util.HashSet;
import java.util.LinkedList;

//    Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//
//    Only one letter can be changed at a time
//    Each intermediate word must exist in the dictionary
//    For example,
//
//    Given:
//    start = ��hit��
//    end = ��cog��
//    dict = ["hot","dot","dog","lot","log","cog"]
//    As one shortest transformation is ��hit�� -> ��hot�� -> ��dot�� -> ��dog�� -> ��cog��,
//    return its length 5.
//
//    Note:
//    Return 0 if there is no such transformation sequence.
//    All words have the same length.
//    All words contain only lowercase alphabetic characters.
//��ΪҪ����̳��ȣ�������ͬ�Ĵ�������һ�� ��������̳�����


public class WordLadder {

	 public int ladderLength(String start, String end, HashSet<String> dict) {
	  if(dict.size()==0){
		  return 0;
	  }
		 int result=0;
		 //wordQ���� ��start��ʼ ���еı��� Ȼ�� ���end
		 LinkedList<String> wordQueue=new LinkedList<String>();
		 //
		 LinkedList<Integer> distanceQueue=new LinkedList<Integer>();
		
		 wordQueue.add(start);
		
		 distanceQueue.add(1);
		 
		 while(!wordQueue.isEmpty()){
			 String currWord=wordQueue.poll();
			 Integer currDistance=distanceQueue.poll();
			 if(currWord.equals(end)){
	                return currDistance;
	            }
			 
			 for(int i=0;i<currWord.length();i++){
				 char[] currCharArr=currWord.toCharArray();
			//��ǰ��ÿ���ַ� ������λһ�� ��a������z ����ҵ��дʿ�һ����
			//	 �Ͱ�����ʿ���Ĵʷŵ�Queue��
			//����queue������е�ǰ�ʱ�λһ����ĸ���������ֵ���Ĵ�
		  //Ȼ��ÿ������ȥ�ұ�λһ����ĸ�к��������ֵ���Ĵ�
				 //����ҵ�endʱ�򷵻� currDistace  �Ҳ�������0
				 for(char temp='a';temp<='z';temp++){
					 currCharArr[i]=temp;
					 String newWord=new String(currCharArr);
					 if(dict.contains(newWord)){
						 wordQueue.add(newWord);
						 //�����currDistance+1 ����forѭ���ﱣ֤��
						 //�Ķ�һ����ĸֻ���� ����start������ĸ��õ�3���ʵ�����´�
						 //��ô����3��0+1 ������ʵ�ķ�Ӧ���롣
						 distanceQueue.add(currDistance+1);
						 dict.remove(newWord);
					 }
				 }
			 }
		 	 
		 }
		return 0;
		 
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
