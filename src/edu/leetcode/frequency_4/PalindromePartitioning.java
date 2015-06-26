package edu.leetcode.frequency_4;

import java.util.ArrayList;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return all possible palindrome partitioning of s. 

//���ǰ�string�����а��ջ��ķָ�ж��ֿ��� ��
//�ȷ�˵ aab ���Էֳ� aa b �� a a  b Ҫ��ÿ�����ǻ��� Ҳ�������Ǵ�
public class PalindromePartitioning {

	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

	public ArrayList<ArrayList<String>> partition(String s) {
		result.clear();
		ArrayList<String> al = new ArrayList<String>();
		dfs(s, 0, al);
		return result;
	}

	// string���±�
	void dfs(String s, int start, ArrayList<String> al) {
		if (start == s.length()) { // �Ѿ�ȫ���й��� Stringȫ������
			result.add((new ArrayList<String>(al))); // ��al����al
			return;
		}
		// ���forѭ������Ҫ �������string��string�±굽i�±�֮�������
		// forѭ������start~ start+1-1(i-1)��ʼֱ�ӵ��ֶ����������i<=s.length()��
		// �����start��i-1���� ��copy add��AL�� Ȼ���ٵݹ���ñ����� Ȼ�� �ٰ�I�����µ�start �ڵݹ���ñ�����
		for (int i = start + 1; i <= s.length(); i++) {
			if (isPalin(s, start, i - 1)) { // ����ֶ��� �Ĵ�start��i-1��һС���ǻ��ľ� ����
				al.add(s.substring(start, i));

				dfs(s, i, al);// ע�� ����substing�� al�Ѿ��������ݹ���ַ�����ȥ��
				al.remove(al.size() - 1); // ��������Ҫremove�����¼ӵ���� ��Ϊ al�൱�ڻ���
											// �����remove ���forѭ���ͻ��
				// ���string���start���ֶ��������л��Ļ��ظ��� ��������al�൱��һ������
			}
		}
	}

	// �������ǲ��ǻ��� ����ͷ�����бȶ� �����ⷽ���ķ������i j ���ŵ�stringͷβ
	boolean isPalin(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
