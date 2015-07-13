import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter n and k: ");
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		
		
		System.out.print("Total candles burnt: " + calcRerollCandle(n, k));
		
	}

	private static int calcRerollCandle(int n, int k) {
		int newCandle = n / k;
		int remainingCandle = n % k;
		

		if( (newCandle + remainingCandle) >= k){
			n = n + calcRerollCandle(newCandle+remainingCandle, k);
		}else{
			n = n + remainingCandle;
		}
		
		return n;
	}

}
