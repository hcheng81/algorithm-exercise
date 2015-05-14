//put
//get
//print

public class HashTableWithLinkedList {
	CatNode[] myArray = new CatNode[10];
	
	public void put(int catKey, String catName){
		int catKeyAfterHash = hashMe(catKey);
		CatNode cn = new CatNode(catKey, catName);
		if(myArray[catKeyAfterHash] == null){
			myArray[catKeyAfterHash] = cn;
		}else{
			CatNode thisNode = myArray[catKeyAfterHash];
			while(thisNode.next != null){
				thisNode = thisNode.next;
			}
			thisNode.next = cn;
		}
	}
	
	public String get(int catKey){
		int catKeyAfterHash = hashMe(catKey);
		if(myArray[catKeyAfterHash] == null){
			return null;
		}else{
			CatNode thisNode = myArray[catKeyAfterHash];
			while(thisNode.next != null){
				if(thisNode.catKey == catKey){
					return thisNode.catName;
				}else{
					thisNode = thisNode.next;
				}
			}
		}
		return null;
	}
	
	public int hashMe(int ck){
		return ck%10;
	}
}
