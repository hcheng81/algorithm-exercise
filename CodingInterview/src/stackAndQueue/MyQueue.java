package stackAndQueue;

import java.util.Stack;

public class MyQueue {
	Stack a = new Stack();
	Stack b = new Stack();
	
	public void enqueue(int i){
		a.push(new Node(i));
	}
	public void dequeue(){
		if(b.size() != 0){
			//b.pop();
			System.out.println(((Node)b.pop()).data);
		}else if(a.size() != 0){
			while(a.size() != 0){
				b.push(a.pop());
			}
			System.out.println(((Node)b.pop()).data);
		}
	}
	public static void main(String[] args){
		MyQueue mq = new MyQueue();
		mq.enqueue(3);
		mq.enqueue(4);
		mq.enqueue(5);mq.enqueue(6);mq.enqueue(7);mq.enqueue(8);
		mq.dequeue();mq.dequeue();mq.dequeue();mq.dequeue();mq.dequeue();mq.dequeue();mq.dequeue();mq.dequeue();mq.dequeue();
		mq.enqueue(3);
		mq.enqueue(4);
		mq.enqueue(4);
		mq.dequeue();
		mq.enqueue(4);
		mq.enqueue(5);mq.enqueue(6);mq.enqueue(7);mq.enqueue(8);
	}
}

class Node{
	int data;
	Node next;
	
	Node(int i){
		data = i;
	}
}