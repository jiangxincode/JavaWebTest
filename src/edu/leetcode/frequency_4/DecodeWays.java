package edu.leetcode.frequency_4;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.

//DP���� �ο�135Ӳ�����N�� ��һ����������1������ô�� ��һ����������2������ô��
//or�ο� CC8_2
//ע����һ��ҵ���߼��ϵ����� ���� 26������2��6 B+F ����Z 26 ����27 ��ֻ����2+7��
//���е���һ��0�ǲ����Ա�decode��Ҫ�����ԣ��ȷ�˵9 0 9 
//---------------------�ڶ������� 
public class DecodeWays {

	public int numDecodings(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		//f�Ǵ浱String���ڼ�charλ��ʱ�� ��ʱ�ж�����decoding����
		int[] f = new int[n + 1];// ���һ����ֹ���
		f[0] = 1;
		if (isValidDecoding(s.substring(0, 1))) {
			f[1] = 1;
		} else {
			f[1] = 0;
		}
		
		//��ΪҪi-1,�ֲ��� 
		for (int i = 2; i <= n; i++) {
			if (isValidDecoding(s.substring(i - 1, i))) {
				//����ֻ��1λ��valid�� ��ô�ⷨû�б�� 
				f[i] = f[i - 1];
			}
			if (isValidDecoding(s.substring(i - 2, i))) {
				//����2Ҳ���ԵĵĻ� f[i]=f[i-1]+f[i-2]
				//����2����1Ҳ�϶� ���� �� 1�Ѿ�f[i]=f[i-1]��
				//����			f[i] = f[i] + f[i - 2];
				//�������    Ϊ��˵��f[i-1]+f[i-2]
				//��Ϊ ����˵i-2,i�ǺϷ��Ļ� ��ô ��iλΪֹ--(�Ͼ�F[i]��f�Ǵ浱String���ڼ�charλ��ʱ�� ��ʱ�ж�����decoding����)
				//��ôf��i����������ʱӦ���� ����f[i-2]ʱ��  ��decode��2����λ���� ����f[i-2]ʱ�� ��decode��һ��.������f[i] + f[i - 2]
				f[i] = f[i] + f[i - 2];
			}
		}

		return f[n];

	}

	// �жϵ�ǰiterator������1λ����2λ�Ƿ��ܱ��Ϸ���decoding
	// �ȷ�˵ ����һ����0���ǿ϶������Ա�decode�� Ҫ��|����|
	private boolean isValidDecoding(String s) {
		if (s.charAt(0) == '0') {
			return false;
		}
		int code = Integer.parseInt(s);
		// ������1λ����2λ����int��֮����1��26֮���������decode
		return (code >= 1 && code <= 26);
	}

	public static void main(String[] args) {
		System.out.print((new DecodeWays())
				.numDecodings("12303232434343212121222"));
	}

}
