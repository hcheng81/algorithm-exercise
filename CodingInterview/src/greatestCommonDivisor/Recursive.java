package greatestCommonDivisor;

public class Recursive {
	public int gcd(int a, int b){
		if (b == 0){
			return a;
		}
		return gcd(b, a%b);
	}
	
	public static void main(String[] args){
		Recursive rrr = new Recursive();
		System.out.println(rrr.gcd(259, 111));
	}
}
