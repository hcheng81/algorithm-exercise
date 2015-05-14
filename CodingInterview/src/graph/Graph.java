package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph{
	 private final int V;
	 private int E;
	 //nodes is an array that has lots of Node, Node is a class that has a arraylist of int
	 private Node<Integer>[] nodes;
	 
	 public Graph(int v){
		 this.V = v;
		 nodes = new Node[V];
		 for(int i = 0; i < V; i++){
			 nodes[i] = new Node<Integer>();
		 }
		 addEdge(0, 3);
		 addEdge(4, 0);
	 }
	 public void addEdge(int v, int w) {
	        E++;
	        nodes[v].add(w);
	        nodes[w].add(v);
	    }
	public boolean isDirect(int node1, int node2){
		if(nodes[node1].data.contains(node2)){
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		Graph g = new Graph(5);
		System.out.println(g.isDirect(3,0));
	}

}
class Node<T>{
	List<T> data = new ArrayList<T>();
	public void add(T t){
		data.add(t);
	}
}