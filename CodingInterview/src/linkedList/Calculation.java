package linkedList;

public class Calculation {
	
	public EasyNode add(EasyNode s1, EasyNode s2, int count, EasyNode localHead){
		int result = 0;
		int c1 = 0;
		int c2 = 0;
		EasyNode s1Next = null;
		EasyNode s2Next = null;
		if(s1 == null && s2 == null && count == 0){
			return null;
		}
		if(s1 != null){
			c1 = s1.key;
			s1Next = s1.next;
		}
		if(s2 != null){
			c2 = s2.key;
			s2Next = s2.next;
		}
		result = (c1 + c2 + count) % 10;
		count = (c1 + c2 + count) / 10;

		while(localHead != null){
			localHead = localHead.next;
		}
		localHead = new EasyNode(result);
		localHead.next = add(s1Next, s2Next, count, localHead);
		return localHead;
	}
	
	public WrapperNode add2(EasyNode s1, EasyNode s2, WrapperNode localHead){
		if(s1.next == null && s2.next == null){
			return null;
		}
		if(s1.next != null){
			s1 = s1.next;
		}
		if(s2.next != null){
			s2 = s2.next;
		}
		WrapperNode localHead1 = new WrapperNode();
		localHead1.en = new EasyNode();
		//localHead1.next = add2(s1, s2, localHead1);
		int result = 0;
		int c1 = 0;
		int c2 = 0;
		if(s1 != null){
			c1 = s1.key;
		}
		if(s2 != null){
			c2 = s2.key;
		}
		int myCount = 0;
		if(localHead1.en.next != null){
			myCount = localHead1.count;
		}
		System.out.println("c1:" + c1 + "\nc2:" + c2 + "\n mycount:"+myCount+"\n");
		result = (c1 + c2 + myCount) % 10;
		System.out.println("result: " + result +"\n");
		int count = (c1 + c2 + myCount) / 10;
		localHead1.en.setKey(result);
		localHead1.setCount(count);
		return localHead1;
	}
	
	public static void main(String[] args){
		EasyNode n1 = new EasyNode(5);
		n1.next = new EasyNode(7);
		n1.next.next = new EasyNode(9);
		n1.next.next.next = null;
		
		EasyNode n2 = new EasyNode(8);
		n2.next = new EasyNode(7);
		n2.next.next = new EasyNode(0);
		n2.next.next.next = new EasyNode(6);
		n2.next.next.next.next = new EasyNode(4);
		n2.next.next.next.next.next = new EasyNode(9);
		n2.next.next.next.next.next.next = new EasyNode(3);
		n2.next.next.next.next.next.next.next = null;
		
		Calculation cal = new Calculation();
		WrapperNode result = cal.add2(n1, n2, null);
		while(result != null){
			System.out.println(result.en.key);
			//result = result.en.next;
		}
	}
}

class EasyNode{
	int key;
	EasyNode next = null;
	
	public void setKey(int key){
		this.key = key;
	}
	
	EasyNode(){	
	}
	
	EasyNode(int key){
		this.key = key;
	}
}

class WrapperNode{
	EasyNode en = null;
	int count = 0;
	
	public void setCount(int count){
		this.count = count;
	}
}
