// -------------------------------
// This program aims to determine the number of
// christmas presents received for a particular day, called n,
// as well as the total number of presents received for the
// entire n days. The number of christmas presents received
// is determined by the lyric of the Christmas song "The 
// Twelve Days of Christmas". 
import java.util.*;

class Main {

	// The main program is called with an integer argument
	// denoting the "n-th" day on which the number of presents
	// will be determined.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter the number of days: ");
		int n = sc.nextInt();

		System.out.println("You have entered the number of days as: " + n);

		if (n == 1) {
			System.out.println("The number of present received on day 1 is "
				                + present_on_day(1) + ".");
		}
		else { // Here, n > 1 
			System.out.println("The number of presents received on day "
			                    + n + " is  " + present_on_day(n) + ".");

			System.out.println("The number of presents received in "
			                    + n + " days is  " + present_thru_days(n) + ".");
		}
	}

	// This function determines the number of presents to be received 
	// on the n-th day.
	// Pre-condition: n >= 1
	public static int present_on_day(int n) {
		if(n>0){
			return present_on_day(n-1)+n ;
		}else{
			return n;
		}
	}

	// This function determines the number of presents to be received
	// throughout n days.
	// Pre-condition: n >= 1
	public static int present_thru_days(int n) {
		int totalPresent = 0;
		if(n > 0 ){
			totalPresent = present_thru_days(n-1) + present_on_day(n); 
		}

		return totalPresent;
		
		//if(n==1) return 1 else return present_on_day(n) + presents_thru_days(n-1)
	}
}

