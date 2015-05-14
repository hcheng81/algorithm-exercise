package factor;

public class CountFactorIteration {
	public int cfi (int n){
		int sum = 1;
		int result = 1;
		while (sum < n){
			result = result * (++sum);
		}
		return result;
	}
	public static void main(String[] args){
		CountFactorIteration cfi = new CountFactorIteration(); 
		System.out.println(cfi.cfi(6));
	}
}
