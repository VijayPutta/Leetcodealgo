
public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getMaximumnofromcards();
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

}
