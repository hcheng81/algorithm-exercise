package linkedList;

import java.util.HashSet;

public class niceLinkedList {
	
	public static void main(String[] args){
		niceLinkedList nll = new niceLinkedList();
		nll.head = new Node(5);
		nll.appendToTail(2);
		nll.appendToTail(3);
		nll.appendToTail(3);
		nll.appendToTail(5);
		//nll.deleteDup2();
		//nll.traverse();
		nll.sortingBaseOn(3);
	}
	
	private Node head;
	
	public Node appendToTail(int key){
		Node node = new Node(key);
		Node n = head;
		while(n.next != null){
			n = n.next; 
		}
		n.next = node;
		return head;
	}
	
	public Node delete(int key){
		Node n = head;
		while(n.next.key != key){
			n = n.next;
		}
		n.next = n.next.next;
		return head;
	}
	
	public void traverse(){
		Node n = head;
		while(n.next != null){
			System.out.println(n.key + " ");
			n = n.next;
		}
		System.out.println(n.key + " ");
	}
	public Node deleteDup (){
		Node n = head;
		HashSet<Integer> hs = new HashSet<Integer>();
		Node pre = null;
		while(n != null){
			if(hs.contains(n.key)){
				pre.next = n.next;
				//n = n.next;
			}else{
				hs.add(n.key);
				pre = n;
			}
			n = n.next;
		}
		return n;
	}
	public Node deleteDup2(){
		Node n = head;
		Node m = head;
		while(n != null){
			m = n;
			while(m.next != null){
				if(n.key == m.next.key){
					m.next = m.next.next;
				}else{
					m = m.next;
				}
			}
			n = n.next;
		}
		return head;
	}
	public int findK(int i, int k){
		Node n = head;
		//int i = 0;
		if(n == null){
			return i;
		}else if(i == k){
			return i;
		}
		
		return 1;
	}
	public Node sortingBaseOn(int k){
		niceLinkedList big = new niceLinkedList();
		niceLinkedList small = new niceLinkedList();
		Node n = head;
		while(n != null){
			if(n.key >= k){
				if(big.head == null){
					big.head = new Node(n.key);
				}else if(n.key == k){
					Node temp = big.head;
					big.head = new Node(n.key);
					big.head.next = temp;
				}else{
					big.appendToTail(n.key);
				}
			}else{
				if(small.head == null){
					small.head = new Node(n.key);
				}else{
					small.appendToTail(n.key);
				}
			}
			n = n.next;
		}
		if(small.head != null){
			small.traverse();
		}
		if(big.head != null){
			big.traverse();
		}
		return this.head;
	}
}

class Node{
	int key;
	Node next = null;
	
	Node(int key){
		this.key = key;
	}
	Node(int key, Node next){
		this.key = key;
		this.next = next;
	}
}