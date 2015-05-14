package stackAndQueue;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer>{
	Stack<Integer> s2;
	public StackWithMin2(){
		s2 = new Stack<Integer>();
	}
	
	public void push(int value){
		if(value <= min()){
			s2.push(value);
		}
		super.push(value);
	}
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			s2.pop();
		}
		return value;
	}
	public int min(){
		if(s2.empty()){
			return Integer.MAX_VALUE;
		}else{
			return s2.peek();
		}
	}
	public static void main(String[] args){
		StackWithMin2 s1 = new StackWithMin2();
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
