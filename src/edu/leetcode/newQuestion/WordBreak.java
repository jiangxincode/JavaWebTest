package edu.leetcode.newQuestion;

import java.util.Set;
//Given a string s and a dictionary of words dict, determine 
//if s can be segmented into a space-separated sequence of 
//one or more dictionary words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code". 
//Ҫ�г��������ж������ڴʵ������true

 

public class WordBreak {
	// Ҳ��Ԥ����һ��һά����
	// dp[i]����˼�����string��0λ��iλ�ǿ���(��ĳ�ָ��valid break��) Ȼ���ٴ�i�ĺ����ж��Ƿ���valid break
	// �ͺ��󹫽������ɣ�ǰ���Ѿ����ɵ�3�������Բ��ù� ����ֻҪ�ܺ�����ܺϷ������յ�վ�Ϳ�����
	//  leetcode
	// 012345678 //dp[0] ��DP����״̬ ��ʾdp[0]֮ǰ����ok���� ֻ�ô�1��ʼ��������Ϳ�����
 // dp[TFFFTFFFT] return dp[8]

	// ���д�ļ򵥷��� ����DP ������� �Ż���������
	public boolean wordBreak(String s, Set<String> dict) {
		int length = s.length();
		boolean[] dp = new boolean[length + 1];
		dp[0] = true; //���0�Ǻ���Ҫ��DP[0]�����DP�ĳ�ʼ���� �൱�� 0λ����֮ǰ��������еĻ� �ǿɷֵģ��������1��ʼ��������ͺ��� ����i=1 ��ʼѭ��
		
		for (int i = 1; i <= length; i++) {
				for (int j = 0; j < i; j++) {
	//���if�жϾ��൱�� ��dp[j]��true ʱ�� ��ʾj��j֮ǰ�Ĵ���valid word ���ȷ�˵��һ����ѭ������ substring(0,1)���ص��� l Ȼ��l�ʿ���û�� 
					//Ȼ��j==i Ȼ�����һ����ѭ����Ȼ��ֱ��j=0,i=4��ʱ�� �ʵ�����leet ���� dp[4]���� ture  �Դ�����
					if (dp[j] && dict.contains(s.substring(j, i))) { // (eg,substring (1,3) 0λchar�ͻᱻ��©  ���Դ�0λ��ʼ
					dp[i] = true;
					break; 
				}
			}
		}
		return dp[length];
	}

}






















//
// public boolean wordBreak(String s, Set<String> dict) {
// if (s == null || s.length() == 0) {
// return false;
// }
// // �ⷽ�������ֵ���������Ǽ�����ĸ
// int maxLength = getMaxLength(dict);
// boolean[] canSegment = new boolean[s.length() + 1];
// //���0�Ǻ���Ҫ��canSegment[0]�����DP�ĳ�ʼ����
// canSegment[0] = true;
// for (int i = 1; i <= s.length(); i++) {
// canSegment[i] = false;
// // ��ѭ����ѭ����1-iλ ����1-i�ĳ��Ȳ�����maxlength()
// // Ȼ�󿴿�jλ��iλ���subsring���Ը�ô ��������Ծ�j����һλ
// for (int j = 1; j <= maxLength && j <= i; j++) {
// //[i-j] 4-1=3 �ڶ��� 4-2=2 ������ 4-3=1
// if (!canSegment[i - j]) {
// continue;
// }
//
// String word = s.substring(i - j, i);
// if (dict.contains(word)) {
// canSegment[i] = true;
// break;
// }
// }
// }
// return canSegment[s.length()];
// }
//
// private int getMaxLength(Set<String> dict) {
// int maxLength = 0;
// for (String word : dict) {
// maxLength = Math.max(maxLength, word.length());
//
// }
// return maxLength;
// }
