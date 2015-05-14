package PermutationString;

public class Way1 {
	private String firstString = "abcabcdddecf";
	private String secondString = "abcabcddfcdc";
	
	public boolean ifPermutate(){
		int[] myArray = new int[128];		
		for(int i=0; i < firstString.length(); i++){
			int myIndex = firstString.charAt(i);
			myArray[myIndex]++;
		}
		for(int i=0; i < secondString.length(); i++){
			int myIndex = secondString.charAt(i);
			if(--myArray[myIndex] < 0){
				return false;
			};
		}
		
		return true;
	}
	public static void main(String[] args){
		Way1 myWay = new Way1();
		System.out.println(myWay.ifPermutate());
	}
}
