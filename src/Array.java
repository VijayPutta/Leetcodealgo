
public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getMaximumnofromcards();
		//mergeSortedarray();
		//replacewithgreaterelementonrightside();
		//integerBreak();
		searchinrotatedarray();
	}

	private static void getMaximumnofromcards() {
		// TODO Auto-generated method stub
		int[] arr = Arrayutil.createArray();
		int n = arr.length;
		int k = Arrayutil.getNumber();
		int leftsum = 0,max=0,rightsum=0;
		for(int i=0;i<k;i++){
			leftsum += arr[i];
		}
		max = leftsum;
		for(int i=0;i<k;i++){
			leftsum -= arr[k-1-i];
			rightsum += arr[n-i-1];
			max = Math.max(max, leftsum+rightsum);
		}
		System.out.println(max);
	}
	
	private static boolean binarySearch(int[] arr,int l,int h,int target){
		int m = (l+h)/2;
		if(l<h){
			if(arr[m] == target){
				return true;
			}
			else{
				if(arr[m] < target){
					return binarySearch(arr,l,m,target);
				}else{
					return binarySearch(arr,m,h,target);
				}
			}
		}
		return false;
	}
	private static void mergeSortedarray() {
		int m = Arrayutil.getNumber();
		int n = Arrayutil.getNumber();
		int[] nums1 = Arrayutil.createArray();
		int [] nums2 = Arrayutil.createArray();
        int i = m - 1, j = n - 1, k = m + n - 1 ;
        while (k >= 0 && j >= 0) {
            if (i >= 0 && nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                nums1[i] = 0;
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        Arrayutil.printArray(nums1);
    }
	private static void replacewithgreaterelementonrightside(){
		int[] arr = Arrayutil.createArray();
		int length = arr.length;
		int max = -1,temp=0;
		for(int i=length-1;i>=0;i--){
			temp = max;
			if(max < arr[i]){
				max = arr[i];
			}
			arr[i] = temp;
		}
		Arrayutil.printArray(arr);
	}
	private static void integerBreak(){
		int number = Arrayutil.getNumber();
		int rem = number % 3;
		int result = 0;
		if(number == 1){
			System.out.println("0");
			return;
		}
		if(number == 2){
			System.out.println("1");
			return;
		}
		if(number == 3){
			System.out.println("2");
			return;
		}
		switch (rem){
			case 0:
				result = (int) Math.pow(3, number/3);
				break;
			case 1:
				result = 2 * 2 * (int) Math.pow(3,  (number/3)-1);
				break;
			case 2:
				result = 2 * (int) Math.pow(3, (number/3));
				break;
		}
		System.out.println(result);
	}
	/*Example 1:
		Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
		Input: nums = [2,5,6,0,0,1,2], target = 0
		Output: true
		*/
	private static void searchinrotatedarray(){
		int[] nums = Arrayutil.createArray();
		int length = nums.length;
		int start = 0, end= nums.length-1,mid;
		System.out.println("enter the number to be searched");
		int target = Arrayutil.getNumber();
		while(start <= end){
	        mid = start + (end - start)/2;
	        if(nums[mid] == target){
	        	System.out.println("true");
	        } 
	        
	        //if left part is sorted
	        if(nums[start] < nums[mid]){
	            if(target < nums[start] || target > nums[mid]){
	                //target is in rotated part
	                start = mid + 1;
	            }else{
	                end = mid - 1;
	            }
	        }else if(nums[start] > nums[mid]){
	            //right part is rotated
	            
	            //target is in rotated part
	            if(target < nums[mid] || target > nums[end]){
	                end = mid -1;
	            }else{
	                start = mid + 1;
	            }
	        }else{
	            //duplicates, we know nums[mid] != target, so nums[start] != target
	            //based on current information, we can only move left pointer to skip one cell
	            //thus in the worest case, we would have target: 2, and array like 11111111, then
	            //the running time would be O(n)
	            start ++;
	        }
	    }
	    
    	System.out.println("false");
	}
	/*
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

		(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
		
		Find the minimum element.
		
		You may assume no duplicate exists in the array.
		
		Example 1:
		
		Input: [3,4,5,1,2] 
		Output: 1
		Example 2:
		
		Input: [4,5,6,7,0,1,2]
		Output: 0
	 */
	public static int findMin(int[] num) {
	    int low = 0;
	    int high = num.length - 1;
	    while(low < high){
	        int mid = (low + high) / 2;
	        if(num[high] < num[mid]){
	            low = mid + 1;
	        } else {
	            high = mid;
	        }
	    }
	    return num[high];
	    }
	/*
	 * With duplicates the above problem
	 */
	public int findMinwithduplicatesinsortedarray(int[] num) {
        int lo = 0;
        int hi = num.length - 1;
        int mid = 0;
        
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            
            if (num[mid] > num[hi]) {
                lo = mid + 1;
            }
            else if (num[mid] < num[hi]) {
                hi = mid;
            }	
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return num[lo];
    }
	
	// Microsoft prep
	/* Print the matrix in spiral form 
	 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
	 
	 * Input:  1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
		Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		Explanation: The output is matrix in spiral format. 
		
		Input:  1   2   3   4  5   6
		        7   8   9  10  11  12
		        13  14  15 16  17  18
		Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
		Explanation :The output is matrix in spiral format.
	 */
}
