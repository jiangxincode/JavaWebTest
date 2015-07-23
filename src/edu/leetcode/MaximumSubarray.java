package edu.leetcode;

//find the contiguous连续�?  subarray within an array (containing at least one number) which has the largest sum.
//
//For example, given the array [�?2,1,�?3,4,�?1,2,1,�?5,4],
//the contiguous subarray [4,�?1,2,1] has the largest sum = 6. 
//cc 原题 19.7
//因为题目要求找连续子序列 就是说这些要连续的�?? 
//因为这点，本题目可以�?次遍历O（n）就做出�? 
//当加到a[i]时�?? 如果当前sum小于0 就把0-i都扔�? 重新加起
//然后每次当currentSum大于maxSum的时候更新maxSum,这样 在过程当中最大的maxSub就会被保�?
// 注意要�?�虑 只有负数的情�? �?�? 要先和maxsum判断 在和大于小于0判断
public class MaximumSubarray {

	public int maxSubArray(int[] A) {
		int max = Integer.MIN_VALUE;
		int currentSum = 0;
		for (int i = 0; i < A.length; i++) {
			currentSum = currentSum + A[i];
			if (currentSum > max) {
				max = currentSum;
			}
			if (currentSum < 0) {
				currentSum = 0;
			}
		
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
