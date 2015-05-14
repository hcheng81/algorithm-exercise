
public class charArrayTest {
	public char[] toTest(char[] str, int length){
		int spaceCount = 0;
		for(int i=0; i<length; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		int finalLength = length + spaceCount * 2;
		str[finalLength] = '\0';
		for(int i=length-1; i >= 0; i--){
			if(str[i] == ' '){
				str[finalLength-1] = '0';
				str[finalLength-2]='2';
				str[finalLength-3]='%';
				finalLength = finalLength - 3;
			}else{
				str[finalLength-1] = str[i];
				finalLength = finalLength - 1;
			}
		}
		return str;
	}
	public static void main(String[] args){
		char[] charArray = new char[19];
		charArray[0]='a';
		charArray[1]=' ';
		charArray[2]=' ';
		charArray[3]=' ';
		charArray[4]='b';
		charArray[5]=' ';
		charArray[6]='c';
		charArray[7]=' ';
		charArray[8]=' ';
		charArray[9]=' ';
		charArray[10]=' ';
		charArray[11]=' ';
		charArray[12]=' ';
		charArray[13]=' ';
		charArray[14]=' ';
		charArray[15]=' ';
		charArray[16]=' ';
		charArray[17]=' ';
		charArray[18]=' ';
		charArrayTest mm = new charArrayTest();
		System.out.println(mm.toTest(charArray, 7));
	}
}
