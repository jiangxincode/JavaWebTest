package edu.leetcode.frequency_4;

//Subsets

//
//Given a set of distinct integers, S, return all possible subsets.
//
//Note:
//
//    Elements in a subset must be in non-descending order.
//    The solution set must not contain duplicate subsets.
//����һ�����ϵ������Ӽ�  ��CC 8-3һ�� 
//// For example S = {1, 2, 3} then P(s) = {{}, {1}, {2}, {3}, {1,2}, {1, 3}, {2, 3}, {1, 2, 3}}.

//����һ�����ϣ������Ӽ�һ����2^n ��(�����ռ���������)��(������ѧ)
//�����ĿΪʲô�����õݹ飿 ��Ϊ�������ҵ���ԭ�����ģСȴͬ�ʵ����⡣(��ע�� ���˼��ǳ���Ҫ)
//�ȷ�˵ ���Ȱ�1 �ó��� ����������2 3���Ӽ�����ô2 3���Ӽ���2��3��  2 3��ͬʱҲ��123���Ӽ�
//Ȼ���Ұ����2 3���Լ���2��3��23�� ����1�ӽ�ȥ�����Ǿ����ˣ�1 2��1 3��123������ 2 3 1 ��23 �Ϳռ�

//���Դ�ʱ {} 1��2��3 123 ��12��13��23������

//��cc΢С��ͬ�ĵط��� ����Ҫ�� ����subset�ڲ���������Ϊ����subset������ֵ�ʱ������index��С����� ���� ������sortһ������
//��Ϊ��recursive�ǵ��������ſ�ʼ���ص� ���غ�ſ�ʼ������
//Ȼ���ٴӺ󵽵��ļ���array list

//
//��CC8_3��һ���� ͨ��recursive������EG: ��ע�� ��������� �������С�
//(���� ����int[]�ǡ�1��2��3��4��) ÿ�ζ��ǰ������[0]���� Ȼ���[1��n]�ݹ���ȥ��
//ֱ�����ֻ��һ�����ˣ�List.size=index��Ȼ���ʱ����һ��result arraylist<ArrayList<Integer>>[4][��] 
//		Ȼ�󷵻ظ��ϲ� �ϲ�3�������淵������2��arraylist<Integer> ����ÿ��������3��
//		�ټӵ�result�� ���Դ�ʱresult�����[3,4][3][4][��]�ٷ��ظ��ϲ�2,Ȼ��2������arraylist[Integer]���涼����2 
//		����Ȼ ԭʼ������������ЩԪ�ض������� ��
//
//��ʱ result�� [2��3,4][2 3][24][2 ][3,4][3][4][��] Ȼ�� 1���Դ�����
import java.util.ArrayList;
import java.util.Arrays;
//�����㷨ģ�� 
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        subsetsHelper(result, list, num, 0);

        return result;
}


private void subsetsHelper(ArrayList<ArrayList<Integer>> result,
                ArrayList<Integer> list, int[] num, int pos) {

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < num.length; i++) {

                list.add(num[i]);
                subsetsHelper(result, list, num, i+1);
                list.remove(list.size()-1);
        }
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
