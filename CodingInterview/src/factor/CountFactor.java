package factor;

public class CountFactor {
	public int factor (int n){
		if(n==0){
			return 1;
		}
			return n * factor(n-1);
	}
	public static void main(String[] args){
		CountFactor cf = new CountFactor();
		System.out.println(cf.factor(4));
	}
}
