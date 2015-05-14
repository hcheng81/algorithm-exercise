package greatestCommonDivisor;

public class Iterative {
	public int gcd(int a, int b){
		while(a%b != 0){
			int temp = a%b;
			a = b;
			b = temp;
		}
		return b;
	}
	
	public static void main(String[] args){
		Iterative iii = new Iterative();
		System.out.println(iii.gcd(15, 10));
	}
}
