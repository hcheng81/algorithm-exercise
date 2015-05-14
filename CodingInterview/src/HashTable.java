import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Insert
//Look Up
//Delete
//my data: 3 - cat, 6 - dog, 9 - bird, 12 - lion, 15 - human

//array
public class HashTable {
	String[] myArray = new String[10];
	
	public void insertData(int myKey, String myString){
		int afterKey = myHashFunction(myKey);
		myArray[afterKey] = myString;
	}
	
	public String lookUpData(int myKey){
		String myResult;
		int afterKey = myHashFunction(myKey);
		if(myArray[afterKey] == null){
			myResult = null;
		}else{
			myResult = myArray[afterKey];
		}
		return myResult;
	}
	
	public void deleteData(int myKey){
		int afterKey = myHashFunction(myKey);
		if(myArray[afterKey] != null){
			myArray[afterKey] = null;
		}
	}

	private int myHashFunction(int myKey) {
		int afterKey = myKey / 3; 
		return afterKey;
	}
	
	public void printData(){
		System.out.println(Arrays.asList(myArray));
	}
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashTable ht = new HashTable();
		Boolean flag = true;
		try {
			while(flag){
				System.out.println("Please select: \n 1)Insert\n 2)Look Up\n 3)Delete\n 4)Print\n 5)Exit");
			    try {
			    	String s = br.readLine();
					switch(s){
					case "1": 
						System.out.println("Please enter your key and value. \n Key:");
						int key_1 = Integer.parseInt(br.readLine());
						System.out.println("Value:");
						String value = br.readLine();
						ht.insertData(key_1, value);
						break;
					case "2":
						System.out.println("Please enter your key: \n Key:");
						int key_2 = Integer.parseInt(br.readLine());
						System.out.println(ht.lookUpData(key_2));
						break;
					case "3":
						System.out.println("Please enter your key: \n Key:");
						int key_3 = Integer.parseInt(br.readLine());
						ht.deleteData(key_3);
						break;
					case "4":
						ht.printData();
						break;
					case "5":
						flag = false;
						break;
			    	}
			    }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
