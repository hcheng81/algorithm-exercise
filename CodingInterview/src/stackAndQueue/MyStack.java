package stackAndQueue;

import java.util.Stack;

public class MyStack extends Stack<Element>{
	Element top;

	public Element pop(){
		if(top == null){
			return null;
		}
		Element temp = top;
		top = top.next;
		return temp;
	}
	
	public void push(int t){
		Element toPush = new Element(t);
		if(top == null){
			top = toPush;
			toPush.myMin = t;
		}else{
			if(t < top.myMin){
				toPush.myMin = t;
			}else{
				toPush.myMin = top.myMin;
			}
			toPush.next = top;
			top = toPush;
		}
	}
	public int min(){
		Element temp = peek();
		return temp.myMin;
	}
	public Element peek(){
		if(top == null){
			return null;
		}
		return top;
	}
	
	public static void main(String[] args){
		MyStack s1 = new MyStack();
		s1.push(6);
		s1.push(4);
		s1.push(0);
		s1.push(5);
		s1.push(9);
		s1.pop();
		s1.pop();
		s1.pop();
		//System.out.println(s1.pop().data);
		System.out.println(s1.min());
	}
}

class Element {
	int data;
	int myMin;
	Element next = null;
	
	Element(int data){
		this.data = data;
	}
}