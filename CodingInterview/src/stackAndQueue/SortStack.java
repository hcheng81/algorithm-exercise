package stackAndQueue;

import java.util.Stack;

public class SortStack {
	public void sort(Stack s1){
		Stack s2 = new Stack();
		while(!s1.isEmpty()){
			int temp = (int) s1.pop();
			while((int)s2.peek() > temp){
				s1.push(s2.pop());
			}
			//if(s2.isEmpty() || (int)s2.peek() < temp){
				s2.push(temp);
			//}
		}
	}
}
