
public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//getMaximumnofromcards();
		//mergeSortedarray();
		//replacewithgreaterelementonrightside();
		integerBreak();
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
	private static void searchrotatedsortedarray(){
		int k = Arrayutil.getNumber();
		int[] arr = new int[k];
		int target = Arrayutil.getNumber();
		
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
}
