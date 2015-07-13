import java.util.Scanner;

public class Main {

	/**
	 * Use gradient to detect change of sign
	 * 
	 * UpSlope condition: 1. constant -> inc 2. dec -> inc 3. inc all the way
	 */
	public static void main(String[] args) {


		System.out.println("Number of up-slopes = " + compute_upslopes());

	}

	private static int getGradient(Double curr, Double prev) {
		if (curr - prev > 0) {
			return 1; // increasing
		} else if (curr - prev < 0) {
			return -1; // decreasing
		} else {
			return 0; // constant
		}
	}

	private static boolean isUpSlope(int currGradient, int prevGradient) {

		if (currGradient == 1 && prevGradient == 0) {
			return true;
		} else if (currGradient == 1 && prevGradient == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int compute_upslopes() {
		
		Scanner scanner = new Scanner(System.in);

		int totalUpSlopes = 0;

		Double currHeight = null;
		Double prevHeight = null;
		Integer currGradient = null;
		Integer prevGradient = null;

		boolean isBeginWithUpSlope = false;

		System.out.println("Enter data:");
		while (true) {

			prevHeight = currHeight;
			currHeight = scanner.nextDouble();

			if (currHeight < 0) {

				break;
			}

			if (prevHeight != null) {
				prevGradient = currGradient;
				currGradient = getGradient(currHeight, prevHeight);

				if (prevGradient == null && currGradient == 1) {
					isBeginWithUpSlope = true;
				} else if (prevGradient != null) {
					if (isUpSlope(currGradient, prevGradient)) {
						totalUpSlopes++;
					}
				}

			}

		}
		
		if(isBeginWithUpSlope){
			totalUpSlopes++;
		}
		
		// The return value below is to be replaced by the correct answer
		return totalUpSlopes;
	}

}
