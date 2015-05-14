package stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	ArrayList<Stack> al = new ArrayList<Stack>();
	int threshold = 3;
	
	public void push(Element e){
		if(al.size() == 0 || getLastStack().size() == threshold){
			addNewStack();
		}
		getLastStack().push(e);
	}
	
	public Element pop(){
		Element e = (Element) getLastStack().pop();
		if(getLastStack().isEmpty()){
			al.remove(getLastStack());
		}
		return e;
	}
	
	public void addNewStack(){
		al.add(new Stack<Element>());
	}
	public Stack getLastStack(){
		return al.get(al.size()-1);
	}
}