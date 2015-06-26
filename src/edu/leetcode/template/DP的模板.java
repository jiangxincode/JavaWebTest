package edu.leetcode.template;

import java.awt.datatransfer.Transferable;

public class DP��ģ�� {
//DP��������leetcode��һ���м���
//1.����DP matrix��eg ���������ϵ����� triangle��
//2. 1άDP sequence ��eg word break �� jump game��
//3. 2άDP 2sequence ��eg edit distan�Ȱ�A�ʱ��B�ʵģ�
//4. Interval (eg merge interval, insert interval)
//
//���� �⼸���� Ҫ��ô����
//1. status  
// Matrix      : f[i][j] ��1,1�ߵ�i,j ...
// Sequence    : f[i] ǰi�� ***
// 2 Sequences : f[i][j] word1ǰi��ƥ����wordǰj�� *** 
// Interval    : f[i][j] ��ʾ����i-j ***

//2.Transfer  DP �Ƶ�����
//LCS: f[i][j] = max(f[i-1][j], f[i][j-1], f[i-1][j-1] + 1)  longest common sequence
// LIS: f[i] = max(f[j] + 1, a[i] >= a[j])   longest increasing sequence
// �������һ�λ���/���һ���ַ�/���***

//3. initialize  ��ʼ״̬
// f[i][0] f[0][i]
// f[0]
// LIS: f[1..n] = 1;

//4. answer  
// LIS: max{f[i]}
// LCS: f[n][m]


//5. loop   
// Interval: �����С������ö�����䳤��. Palindrome Patitioning II 



}
