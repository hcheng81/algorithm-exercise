package BinarySearchTree;

public class MyBST {
	Node head;
	
	public static void main(String[] args){
		MyBST mb = new MyBST();
		mb.insert(13);
		mb.insert(7);
		mb.insert(15);
		mb.insert(5);
		mb.insert(10);
		mb.insert(11);
		mb.insert(12);
		//mb.insert(13);
		mb.insert(18);
		mb.insert(17);
		//mb.insert(6);
		//mb.insert(7);
		//mb.insert(3);
		//mb.insert(4);
		//mb.insert(22);
		mb.traverse(mb.head);
		System.out.println(mb.ifBalance(mb.head));
	}
	public void insert(int item){
		head = insert(head, item);
	}
	private Node insert(Node current, int item){
		//Node current = head;
		if(current == null){
			return new Node(item);
		}
		if(item < current.data){
			current.left = insert(current.left, item);
		}else if(item > current.data){
			current.right = insert(current.right, item);
		}
		return current;
	}
	public void traverse(Node current){
		//(pre-order)
		System.out.println(current.data);
		if(current.left != null){
			traverse(current.left);
		}
		//(in-order)System.out.println(current.data);
		if(current.right != null){
			traverse(current.right);
		}
		//System.out.println(current.data);
	}
	public int count(Node current){
		if(current == null){
			return 0;
		}
		if(Math.abs(count(current.left) + 1) - (count(current.right) + 1) > 1){
			return -1;
		}else{
			return Math.max(count(current.left) + 1, count(current.right) + 1);
		}
	}
	public boolean ifBalance(Node current){
		if(Math.abs(count(current)) > 1){
			return false;
		}
		return true;
	}
}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
}
