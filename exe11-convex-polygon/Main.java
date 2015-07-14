// This program determines if a polygon is convex or not.

import java.util.*;

class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of vertices: ");
		int n = sc.nextInt();
		int[][] matrix = new int[n + 2][2];

		System.out.println("Enter vertices: ");
		
		for(int i = 0; i< n; i++){
			matrix[i][0]=sc.nextInt();
			matrix[i][1]=sc.nextInt();
		}
		
		matrix[n][0] = matrix[0][0];
		matrix[n][1] = matrix[0][1];
		matrix[n+1][0] = matrix[1][0];
		matrix[n+1][1] = matrix[1][1];

		if (isConvex(matrix))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	// Returns true if polygon is convex, else returns false.
	// A polygon is convex if walking along its boundary,
	// we always encounter right turns (or left turns).
	public static boolean isConvex(int[][] matrix) {
		boolean isConvex = false;
		
		int[] results = new int[matrix.length];
		
		try{
			//take first det as sample
			Integer sampleDet = null;
			
			for(int i = 0; i< matrix.length;i++){
				int determinant = 	matrix[i][0]*matrix[i+1][1] - 
									matrix[i][0]*matrix[i+2][1] -
									matrix[i][1]*matrix[i+1][0] +
									matrix[i][1]*matrix[i+2][0] +
									matrix[i+1][0]*matrix[i+2][1] -
									matrix[i+1][1]*matrix[i+2][0];
				
				//System.out.println(determinant);
				
				if( i==0){
					sampleDet = determinant;
				}
				
				if(sampleDet != null){
					if( sampleDet < 0 && determinant< 0){
						isConvex = true;
					}else if(sampleDet >0 && determinant > 0){
						isConvex = true;
					}else{
						isConvex = false;
						break;
					}
				}
			}
		}catch (ArrayIndexOutOfBoundsException ex){
			//do nothing
		}		

		return isConvex;
	}

	public static void printTriangularArray(int[][] arr) {

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				System.out.print(arr[r][c] + "\t");
			}
			System.out.println();
		}
	}

}
