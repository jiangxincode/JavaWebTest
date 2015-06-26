package edu.leetcode.frequency_5;
//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 

//����� n����135������е����� �����Ƿֱ���������ϣ����������� ���Ⱥ�˳��
//��Ȼ��Ҫ�ݹ�����
//DP dynamic Programming��˼�� ��ȷ��С���� �ڵ��� 
//���ֻ��1��step, ��ֻ��һ�ֽⷨ 1��, �����2���Ļ� , ���ֽⷨ 2��һ�� ��1������
//����3��step��ʱ�� ��� ��һ����1�� ����ȥ����f(2) ��� ��һ����2�� ����ȥ����f(1)
// ����ʣn�����ݵ�ʱ��, �����޷Ǿ�2�ֿ���  ��1�� ��2��  Ȼ����һ������f(n-1) ����������f(n-2)
//f(n)=f(n-1)+f(n-2)  �ͷѲ��������к���
public class ClimbStairs {

	
	//��iterator �������ݹ�������ظ��ӽṹ
	
public int climbStairs(int n) {
 if(n<=0){return 0;}
 if(n==1){return 1;}
 int n1=1;
 int n2=2;
 int n3=n2; //=2 at the initial point
 for(int i=3;i<=n;i++){  //����n1 n2 n3 ���ǲ�����
	 n3=n1+n2;  // ���ʻ���f(n)=f(n-1)+f(n-2)         f(n)=f(n-1)+��һ��  +  f(n-2)+������  ��һ�� ������ ����һ���߷�
	 n1=n2;     //ÿ��i++ʱ��
	 n2=n3;     //n1=��һ�ε�n2 n2������һ�ε�n3
	            //�����������Լ�һ�� ���Ӷ�0��n��
 }
	return n3;
	
}
	
	
	
	
	
	
	
	//  ��ôд���ǶԵ� ���� �ᳬʱ�� Ϊʲô�أ� 
	//����������F(3) = F(2) + F(1)���ڼ���F(4) = F(3) + F(2)��ʱ�������2��F(2)��������ظ��ӽṹ
// ��recursion���� ����ֺܶ��ظ��ӽṹ �ᳬʱ��
//	public int climbStairs(int n) {
//		int ways=0;
//		if (n <= 0) {
//			return 0;
//		} else {
//			if (n == 1) {
//				return 1;
//			}
//			if (n == 2) {
//				return 2;
//			}
//			if (n >= 3) {
//				ways= climbStairs(n - 1) + climbStairs(n - 2);
//			}
//
//		}
//		return ways;
//	}

	public static void main(String[] args) {
		System.out.println((new ClimbStairs()).climbStairs(5));

	}

}
