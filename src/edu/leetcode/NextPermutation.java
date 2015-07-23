package edu.leetcode;


//implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 �� 1,3,2
//3,2,1 �� 1,2,3
//1,1,5 �� 1,5,1
//��һ����ݔ�����и��������������С�� ��
//��������Ծ� ������С������
public class NextPermutation {
	// ��β��ͷ���� �ҵ���һ��ǰ��Ⱥ���С��index
	// ����һ���ǵݼ���
	// // ���� ��547532��
	// ����1. ��547532���� 4���½��ء�
	// ����2. ��547532���� 5��Ҫ�滻��Ԫ�أ� �滻��õ� �� 557432��
	// 3. "557432",
	// �ٴ�β��ͷ�������ҵ���һ�����Ǹ�index������ݴ��index2
	// eg �Ǹ�index�� 1 ֵ��4 ���Ե�һ���ҵ�����5 ���Ĵ� ����swap 4��5
	// ��index��1 ��ȫ��reverse 7432��ת���õ� ��552347����

	// ���������һ��ʼindex������ͷ���ǵݼ��ģ��Ǿ�ֱ��reverseȫarray������

	public void nextPermutation(int[] num) {
		if (num == null || num.length <= 1) {
			return;
		}
		// 1. �Ӻ���ǰ��falling edge���½��ء�eg ��547532���� 4���½��ء�
		int edge = -1;
		for (int i = num.length - 2; i >= 0; i--) {
			if (num[i] < num[i + 1]) {
				edge = i;
				break;
			}
		}
		// 2. �ٴ�β��ͷ�������ҵ���һ�����Ǹ�index������ݴ��index2
		// eg ��547532���� 2--3--5 ��������
		// Ȼ��swap �½��غ�����ҵ���ֵ   ��4 �� 5 
		if (edge > -1) {
			for (int i = num.length - 1; i > edge; i--) {
				if (num[i] > num[edge]) {
					swap(num, i, edge);
					break;
				}
			}
		}

		// reverse�½��غ��������Ԫ�ء� ���ȫ����Ļ�edge����-1
		// anyway ����ֻҪ��egde+1��ʼ��ת��ͺ�
		int i = edge + 1;
		int j = num.length - 1;
		while (i < j) {
			swap(num, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] num, int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
}
