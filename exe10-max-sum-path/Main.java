// This program computes the maximum-value path
// in a triangular matrix.

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of rows: ");
		int rows = sc.nextInt();

		int[][] table = new int[rows][];

		for (int i=0; i<rows; i++) {
			table[i] = new int[i+1];
		}

		System.out.println("Enter values for array: ");
		for (int r=0; r<table.length; r++) {
			for (int c=0; c<table[r].length; c++) {
				table[r][c] = sc.nextInt();
			}
		}

		// printTriangularArray(table);   // for checking

		System.out.println("Maximum path value = " + maxPathValue(table));
	}

	// Compute the path that gives the maximum value
	public static int maxPathValue(int[][] arr) {
		int[] result = new int[arr.length];
		int maxRow = arr.length;
		int maxCol = arr[maxRow - 1].length;
		for(int r=0; r<maxRow;r++){
			// check which sum is better result
			
			for(int c=0; c<r;c++){				
				try{
					result[r] = Math.max(arr[r+1][c] + result[r] , arr[r+1][c+1] + result[r] );
				}catch (Exception ex){
					break;
				}				
			}
		}
		int max = -1;
		for(int res: result){
			System.out.print(res+" ");
			
			if(res> max){
				max = res;
			}
		}
		return max;
		
	}

    // Print elements in the 2-dimensional triangular array arr.
	// For checking purpose.
    public static void printTriangularArray(int[][] arr) {

        for (int r=0; r<arr.length; r++) {
            for (int c=0; c<arr[r].length; c++) {
                System.out.print(arr[r][c] + "\t");
            }
            System.out.println();
        }
    }

}
