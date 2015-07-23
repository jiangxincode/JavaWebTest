package edu.leetcode;

//�����CC150��1_7���� ����cc 150�Ľⷨ������ rows ��columns2������������0�����꣬����matrix[i][j]=0  columns[i]++ rows[j]++,
//Ȼ���ٴα������matrix,��if(columns[i]!=0||rows[j]!=0)���matrix[i][j]=0�� leetcode��Ҫ���������ռ�  
//��ô���ǾͰ�matrix�ĵ�0�к͵�0�е���columns[] rows[] ����0 (ע�� ���ԭ��x��0����0 ��ôx�л���Ҫ��0 ��֮��Ȼ)
//��ע�⵱matrixֻ��1��1�е����
public class SetMatrixZeroes {
	public void setZeroes(int[][] a) {
		// ���жϵ�0�� ��0����û��0
		boolean row0has0 = false;
		boolean column0has0 = false;
		for (int k = 0; k < a[0].length; k++) {
			// ��0�е�k�� ���Դ���ʼ����ɨ
			if (a[0][k] == 0) {
				row0has0 = true;
				break;
			}

		}

		for (int k = 0; k < a.length; k++) {
			// ��k�е�0�� ���Դ��Ͽ�ʼ����ɨ
			if (a[k][0] == 0) {
				column0has0 = true;
				break;
			}

		}
		// ��matrix����1�� ����һ��ʱ��
		if (a.length > 1 && a[0].length > 1) {
			for (int i = 1; i < a.length; i++) {
				for (int j = 1; j < a[0].length; j++) {
					// most important line
					if (a[i][j] == 0) {
						a[i][0] = 0;
						a[0][j] = 0;
					}
				}
			}
			// ��Ȼ�Ѿ���0��0�к�1��1�зֿ���¼�� ��ô����ʱ��ҲӦ�÷ֿ�
			for (int i = 1; i < a.length; i++) {
				for (int j = 1; j < a[0].length; j++) {

					// �������������
					if (a[i][0] == 0 || a[0][j] == 0) {
						a[i][j] = 0;

					}

				}
			}
		} else
		// ��matirx����1��x�л���x��1�е�ʱ��
		if (a.length == 1 || a[0].length == 1) {
			if (row0has0 || column0has0) {
				for (int i = 0; i < a.length; i++) {
					for (int j = 0; j < a[0].length; j++) {

						a[i][j] = 0;
					}
				}
			}
		}
		if (row0has0) {
			for (int k = 0; k < a[0].length; k++) {

				a[0][k] = 0;
			}
		}
		if (column0has0) {
			for (int k = 0; k < a.length; k++) {
				a[k][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// int[][] b = new int[4][5];
		int[][] b = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
				{ 1, 2, 1, 3 }, { 0, 0, 1, 1 } };

		// for (int i = 0; i < 5; i++) {
		// for (int j = 0; j < 4; j++) {
		// b[i][j] = 2;
		//
		// }
		// }
		// b[2][3] = 0;
		// b[1][1] = 0;

		for (int s = 0; s < 5; s++) {
			System.out.println("");
			for (int j = 0; j < 4; j++) {
				System.out.print(b[s][j] + " ");
			}
		}
		System.out.println("");
		(new SetMatrixZeroes()).setZeroes(b);
		System.out.println("");

		for (int s = 0; s < 5; s++) {
			System.out.println("");
			for (int j = 0; j < 4; j++) {
				System.out.print(b[s][j] + " ");
			}
		}

	}

}
