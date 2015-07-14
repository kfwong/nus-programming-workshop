
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sortedArr = {4,8,9,10,11,12,15,27};
		int[] rotatedArr = {12,15,27,4,8,9,10,11};
		
		System.out.println(binarySearch2(rotatedArr, 27));
	}
	
	private static int binarySearch(int[] arr, int key){
		int low = 0;
		int high = arr.length - 1;
		
		int mid = arr.length / 2;
		
		while(low <= high && arr[mid] != key){
			if (key < arr[mid]){
				high = mid -1;
			}else{
				low = mid + 1;
			}
			
			mid = (low+high) / 2;
		}
		if( low > high){
			return -1;
		}
		
		return mid;
	}
	
	private static int binarySearch2(int[] arr, int key){
		int low = 0;
		int high = arr.length - 1;		
		int mid = arr.length / 2;
		
		while(low <= high && arr[mid] != key){
			System.out.println("k:"+ key+" h:"+high+" l:"+low);
			if (key > arr[high]){
				high = mid -1;
			}else if( key < arr[low]){
				low = mid + 1;
			}
			
			mid = (low+high) / 2;
		}
		if( low > high){
			return -1;
		}
		
		return mid;
	}

}
