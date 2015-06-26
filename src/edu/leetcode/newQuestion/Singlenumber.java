package edu.leetcode.newQuestion;

//Given an array of integers, every element appears twice except for one. Find that single one.
//λ���� �����  ^

// 0000^1010= 1010    0^����ֵ=����ֵ
// 1010^1010=0000     ֵ^ֵ=0

public class Singlenumber {
	public int singleNumber(int[] A) {
//result=��0^��������������� ��˫�ɶԵĶ���0�� 
//�����result=0^�Ǹ�Ψһ����=Ψһ����
		int result = 0 ^ A[0];
		for (int i = 1; i < A.length; i++) {
			result = result ^ A[i];
		}
		return result;
	}
}
