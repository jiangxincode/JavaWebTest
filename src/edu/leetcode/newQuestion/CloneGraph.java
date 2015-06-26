package edu.leetcode.newQuestion;

import java.util.ArrayList;
import java.util.HashMap;

//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors. 
//���¡һ������ͼ
//ͼ��ÿ��node��һ��label  label��Ψһ�� . ����һ��ArrayList<UndirectedGraphNode> neighbors
//���arraylist�����neighbors 

//    1
//   / \
//  /   \
// 0 --- 2
//      / \
//      \_/
//{0,1,2#1,2#2,2}. ��leetcode�� ��Ϊ��undirected��ͼ ������neighbour�ﲻ�ظ���¼
//0��neighbour�� 1,2,| 1��2,|2��2 �ظ��ľͲ���¼��
public class CloneGraph {
//	1.��Ϊlabel��Ψһ�� ���Խ�һ��hashmap<label,Node> Ȼ��ݹ���÷��� cloneGraphHelper(node, map).
//	���������node��ֵnewNode�� ֮�� �ٱ�����node���ھ���,�����map���оͼӵ�newNode�� arraylist neighbor�
//	���û�� �͵ݹ���ñ�����  newnode.neighbors.add(cloneGraphHelper(point,map));

//dfs
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		// ���hashmap�Ǵ�<ԭnode.label,new���Ƴ�����node>
		// ��Ϊlabel ��unique�� ���Կ��Ե�key
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		return cloneGraphHelper(node, map);

	}

private UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode node,HashMap<Integer, UndirectedGraphNode> map){
	//���¡��һ���ڵ�
	
	UndirectedGraphNode newnode=new UndirectedGraphNode(node.label);
	map.put(node.label,newnode);
	//������������node���neighbors
	for(UndirectedGraphNode point:node.neighbors){
	//���map�����Ѿ������neighbours��	(��ס map�����node�����½������� �����ϵ�)
		if(map.containsKey(point.label)){
			//��neighbor�ķŵ���node��neighbour��
			newnode.neighbors.add(map.get(point.label));
		}else{
			//û����node�Ļ� �ݹ���ñ�������node������ھ�Ҳ�ŵ�ͼ�ﻹ�� ��󷵻ص�node�ӵ��ھ���
			newnode.neighbors.add(cloneGraphHelper(point,map));
			
		}
	}
return newnode;
}




}

class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}