package edu.leetcode;
//��x��ƽ����
//���ַ���ԭ����ǣ�Ҫ��x��ƽ�������ڼٶ�xΪ������������£���ô���Ľ��һ����0��x֮�䣬�����ֲ��ҷ�һ������©����
public class Sqrt {
	   public int sqrt(int x) {
	     if(x<0){return -1;}
	     if(x==0){return 0;}
		long low=0;
		long high=x;
		long mid;
		while(low<=high){
			mid=(low+high)/2;
			if(mid*mid==x){return (int)mid;
			}else if(mid*mid<x) {low=mid+1;
			}else{ high =mid-1;}
			}
		//��Ϊ low high mid�������� ���Ե����low high ����С��ʱ�򻹳˲��ϵĻ�
		//�ͱƽ��ķ������ǵ�ƽ��ֵ
		  mid=(low+high)/2;
		  return (int)mid;
		   
		   
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
