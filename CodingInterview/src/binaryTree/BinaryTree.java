package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
	Node root;
	public void makeTree(){
		root = new Node(15);
		root.left = new Node(13);
		root.right = new Node(23);
		root.left.left = new Node(12);
		root.left.right = new Node(14);
		root.right.right = new Node(39);
		root.right.left = new Node(10);
	}
	
	public boolean ifBinarySearchTree(Node root){
		if(root == null || (root.left == null && root.right == null)){
			return true;
		}
		if(root.left != null && (!ifBinarySearchTree(root.left) || root.left.data > root.data)){
			return false;
		}else if(root.right != null && !ifBinarySearchTree(root.right) || root.right.data <= root.data){
			return false;
		}
		return true;
	}
	/*
	public ArrayList<LinkedList<Node>> buildLinkedList(BinaryTree bt){
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		LinkedList<Node> current = new LinkedList<Node>();
		current.add(root);
		LinkedList<Node> nodes = new LinkedList<Node>();
		while(current != null){
s
			nodes.add(new Node(current.getFirst().right.data));
			current.remove();
			result.add(nodes);
			current = nodes;
		}
		return result;
	}
	*/
	
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.makeTree();
		//bt.buildLinkedList(bt);
		System.out.print(bt.ifBinarySearchTree(bt.root));
	}
}

class Node{
	int data;
	Node left;
	Node right;
	Node(int d){
		data = d;
	}
}
