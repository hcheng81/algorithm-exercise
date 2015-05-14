//input: aabbdddef
//output: a2b2d3ef
public class UseString {
	public String makeItShort(String myStr){
		int count = 1;
		char temp = myStr.charAt(0);
		String newStr = "";
		String myStr1 = myStr + '\0';
		for(int i=1; i<myStr1.length(); i++){
			System.out.println(i + "----" + myStr1.charAt(i));
			if(temp != myStr1.charAt(i)){
				//if(count > 1){
					newStr = newStr + temp + count;
				//}else{
					//newStr = newStr + temp;
				//}
				temp = myStr1.charAt(i);
				count=1;
			}else{
				count++;
			}
		}
		return newStr;
	}
	
	public String compressBad(String str){
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i=1; i< str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			}else{
				mystr += last + "" + count;
				last = str.charAt(i);
				count=1;
			}
		}
		return mystr+last+count;
	}
	
	public String compressBadStringBuffer(String str){
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for (int i=1; i< str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			}else{
				sb.append(last).append(count);
				last = str.charAt(i);
				count=1;
			}
		}
		return sb.append(last).append(count).toString();
	}
	
	public static void main(String[] args){
		UseString uu = new UseString();
		System.out.println(uu.makeItShort("aaabdeeeeeefrtrt"));
		System.out.println(uu.compressBad("aaabdeeeeeefrtrt"));
		System.out.println(uu.compressBadStringBuffer("aaabdeeeeeefrtrt"));
	}
}
