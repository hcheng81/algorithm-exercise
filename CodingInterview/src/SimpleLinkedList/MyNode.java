package SimpleLinkedList;

import java.util.Arrays;

public class MyNode {
	public int myKey;
	public MyNode next;
	
	public MyNode(int key){
		this.myKey = key;
	}
	
	static MyNode thisList = new MyNode(0);
	
	public static void put(MyNode mn){
		MyNode thisRef = thisList;
		while(thisRef.next != null){
			thisRef = thisRef.next;
		}
		thisRef.next = mn;	
	}
	public static void main(String[] args){
		put(new MyNode(5));
		put(new MyNode(7));
		put(new MyNode(9));
		MyNode thisRef = thisList;
		while(thisRef.next != null){
			System.out.println(thisRef.myKey);
			thisRef = thisRef.next;
		}
	}
}
