import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	/**
	 * reference : http://wildaboutmath.com/2008/02/01/math-magic-with-the-number-9/
	 */
	public static void main(String[] args) {
		ArrayList<int[]> numList = new ArrayList<int[]>();
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()){
						
			int[] entry = new int[3];
			
			entry[0] = scanner.nextInt();
			
			if( entry[0] == -1){
				break;
			}
			
			entry[1] = scanner.nextInt();
			entry[2] = scanner.nextInt();
			
			numList.add(entry);
			
		}
		
		for(int[] nums : numList){
			System.out.println(findHiddenNum(nums));
		}
		
		
	}
	
	private static int findHiddenNum(int... numbers){
		int digitalRoot = 0;
		for(int number: numbers){
			digitalRoot = digitalRoot + number;
		}
		
		if(digitalRoot < 10){
			
			if (digitalRoot == 9){
				return 9;
			}
			return 9 - digitalRoot;
		}else{
		
			return findHiddenNum(toIntArray(digitalRoot));
		}
	}
	
	private static int[] toIntArray(int num){
		char[] numChars = String.valueOf(num).toCharArray();
		int[] nums = new int[numChars.length];
		
		for(int i = 0;i<numChars.length;i++){
			nums[i] = Integer.parseInt(Character.toString(numChars[i]));
		}
		return nums;
	}

}


