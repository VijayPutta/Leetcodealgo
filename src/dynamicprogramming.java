import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



public class dynamicprogramming {
	public static void main(String[] args){
		//LongestPallindromeSubsequence("agbdba");
		//LongestPallindromeSubstring("forgeeksskeegfor");
		//maxHistogram();
		//bestTimetosellstock();
		//bestTimetosellstock1();
		dynamicprogramming dp = new dynamicprogramming();
		//String str = "agbdba";
        //int r1 = calculateRecursive(str.toCharArray(), 0, str.length());
        //System.out.println(r1);
		//dp.noofclimbingsteps();
		//dp.minCostClimbingStairs();
		//dp.maxrodcutting();
		//dp.Longestpallindromicsubsequence();
		//dp.minDistance();
		//dp.minDistanceRecursive();
		//dp.LCS();
		//dp.LCSubstring();
		//dp.LongestIncreasingsubsequence();
		//dp.greedyKnapsack();
		//dp.knapsackproblem01();
		dp.recursiveknapsackproblem01();
		//dp.maxsubarray();
		//dp.maxslidingwindow();
		//houserobber();
		//noofbinarystringswithoutconsones();
		//noofpathsinmazebfs();
		//noofpaths();
		//dp.subsetequaltozero();
		//dp.maxproductsubarray();
		//dp.minNoofJUMPS();
	}

	
	


	




	public static class pair{
		int first;
		int second;
		public pair(int f,int s) {
			first=f;
			second=s;
		}
	}


	private static void LongestPallindromeSubsequence(String str1) {
		// TODO Auto-generated method stub
		
		char[] str = str1.toCharArray();
		System.out.println(str);
	        int T[][] = new int[str1.length()][str1.length()];
	        for(int i=0; i < str1.length(); i++){
	            T[i][i] = 1;
	        }
	        for(int i=2;i<=str1.length();i++) {
	        	for(int j=0;j<str1.length()-i+1;j++) {
	        		int k = j+i-1;
	        			if(i == 0 && j == 4) {
	        				System.out.println(str1.charAt(i));
	        	        	System.out.println(str1.charAt(j));
	        			}
        	        	

	        			if(str1.charAt(j) == str1.charAt(k) ) {

	        				T[j][k] = 2 + T[j+1][k-1];
	        			}
	        			else {
	        	        //	System.out.println(i+"sahdjh"+j);
	        				
	        				T[j][k] = Math.max(T[j+1][k],T[j][k-1]);
	        			}
	        		
	        	}
	        }
	        for(int i=0;i<T.length;i++) {
	        	for(int j=0;j<T.length;j++) {
		        	System.out.print(T[i][j]+" ");
		        }
	        	System.out.println();
	        }
	        //Arrayutil.printtwodimesionalArray(T);
	        System.out.println(T[0][str.length-1]);
	}
	
	private static void LongestPallindromeSubstring(String str1) {
		// TODO Auto-generated method stub
		
		char[] str = str1.toCharArray();
		System.out.println(str);
	        int T[][] = new int[str1.length()][str1.length()];
	        for(int i=0; i < str1.length(); i++){
	            T[i][i] = 1;
	        }
	        for(int i=2;i<=str1.length();i++) {
	        	for(int j=0;j<str1.length()-i+1;j++) {
	        		int k = j+i-1;
	        			
	        			if(str1.charAt(j) == str1.charAt(k) ) {

	        				T[j][k] = 2 + T[j+1][k-1];
	        			}
	        			else {
	        	        //	System.out.println(i+"sahdjh"+j);
	        				
	        				T[j][k] = 0;
	        			}
	        		
	        	}
	        }
	        for(int i=0;i<T.length;i++) {
	        	for(int j=0;j<T.length;j++) {
		        	System.out.print(T[i][j]+" ");
		        }
	        	System.out.println();
	        }
	        //Arrayutil.printtwodimesionalArray(T);
	        System.out.println(T[0][str.length-1]);
	}
	
	public static int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
	int steps = 0;
	private void noofclimbingsteps(){
		int n = Arrayutil.getNumber();
		int bool = climbStairs(n);
		System.out.println(bool);
	}
	
	int result;
	HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

	public int climbStairs(int n) {
	    if(n < 2) {
	        return 1;
	    }
	    if(memo.containsKey(n)) {
	        return memo.get(n);
	    }
	    result = climbStairs(n-1) + climbStairs(n-2);
	    memo.put(n,result);
	    return result;
	}
	public int minCostClimbingStairs() {
		int[] cost = Arrayutil.createArray();
        int f0,f1=0,f2=0;
        for(int i=cost.length-1;i>=0;i--){
            f0=cost[i]+Math.min(f1,f2);
            f2=f1;
            f1=f0;
        }
        System.out.println(Math.min(f1, f2));
        return Math.min(f1,f2);
    }
	public void maxrodcutting(){
		int[] price = Arrayutil.createArray();
		
		int t[] = new int[price.length+1];
		for(int i=1;i<=price.length;i++){
			for(int j=i;j<=price.length;j++){
				t[j] = Math.max(t[j], t[j-i]+price[i-1]);
			}
		}
		System.out.println(t[price.length]);
	}

	
	public void minDistance() {
		String word1 = Stringutil.createString();
		String word2 = Stringutil.createString();
		
		int m = word1.length();
		int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i <= m;i++){
        	dp[i][0] = i;
        }
        for(int i=0;i <= n;i++){
        	dp[0][i] = i;
        }
        for(int i = 1;i<=m;i++){
        	for(int j=1;j<=n;j++){
        		if(word1.charAt(i-1) == word2.charAt(j-1)){
        				dp[i][j] = dp[i-1][j-1];
        		}else{
        			dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
        		}
        	}
        }
        System.out.println(dp[m][n]);
    }
	public void minDistanceRecursive() {
		String word1 = Stringutil.createString();
		String word2 = Stringutil.createString();
		
		int m = word1.length();
		int n = word2.length();
		System.out.println(recursiveMinDistance(word1,word2,m-1,n-1));
	}
	public int recursiveMinDistance(String str, String str2, int m,int n) {
		if(m == 0) {
			return n;
		}
		if(n==0) {
			return m;
		}
		if(str.charAt(m) == str2.charAt(n)) {
			return recursiveMinDistance(str,str2,m-1,n-1);
		}
		else {
			return 1 + Math.min(Math.min(recursiveMinDistance(str, str2,m-1,n),recursiveMinDistance(str,str2,m,n-1)),recursiveMinDistance(str,str2,m-1,n-1));
		}
	}
	
	/*https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/	 */
	public void LCS(){
		String fString = Stringutil.createString();
		String secString = Stringutil.createString();
		int l1 = fString.length();
		int l2 = secString.length();
		int dp[][] = new int[l1+1][l2+1];
		for(int i=0;i<=l1;i++){
			for(int j=0;j<=l2;j++){
				if(i==0||j==0){
					dp[i][j] = 0;
				}
				else{
					if(fString.charAt(i-1) == secString.charAt(j-1) ){
						dp[i][j] = 1+dp[i-1][j-1];
					}else{
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
		System.out.println(dp[l1][l2]);
	}
	public void LCSubstring(){
		String fString = Stringutil.createString();
		String secString = Stringutil.createString();
		int l1 = fString.length();
		int l2 = secString.length();
		int dp[][] = new int[l1+1][l2+1];
		int result = 0;
		for(int i=0;i<=l1;i++){
			for(int j=0;j<=l2;j++){
				if(i==0||j==0){
					dp[i][j] = 0;
				}
				else{
					if(fString.charAt(i-1) == secString.charAt(j-1) ){
						dp[i][j] = 1+dp[i-1][j-1];
					}else{
						dp[i][j] =0;
					}
					result = Math.max(result,dp[i][j]);
				}
			}
		}
		System.out.println(result);
	}
	public void LongestIncreasingsubsequence(){
		int[] arr = Arrayutil.createArray();
		int l = arr.length;
		int I[] = new int[l];
		int R[] = new int[l];
		I[0] = 0;
		int len = 0;
		for(int i=1;i<l;i++){
			if(arr[i] <= arr[I[0]]){
				I[0] = i;
			}
			else if(arr[i] > arr[len]){
				len++;
				I[len] = i;
			}
			else{
				int index = ceilIndex(arr, I, len,arr[i]);
				I[index] = i;
			}
		}
		Arrayutil.printArray(I);
	}
	private int ceilIndex(int[] input, int[] T, int end, int s) {
		// TODO Auto-generated method stub
		 int start = 0;
	        int middle;
	        int len = end;
	        while(start <= end){
	        	System.out.println("loop");
	            middle = (start + end)/2;
	            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
	                return middle+1;
	            }else if(input[T[middle]] < s){
	                start = middle+1;
	            }else{
	                end = middle-1;
	            }
	        }
	        return -1;
	}
	class ItemValue  
    { 
        Double cost; 
        double wt, val, ind; 
          
        // item value function 
        public ItemValue(int wt, int val, int ind) 
        { 
            this.wt = wt; 
            this.val = val; 
            this.ind = ind; 
            cost = new Double(val/wt ); 
        } 
    } 
	public void greedyKnapsack(){
		int wt[] = Arrayutil.createArray();
		int val[] = Arrayutil.createArray();
		int capacity = Arrayutil.getNumber();
		
		ItemValue[] item = new ItemValue[wt.length];
		for(int i=0;i<wt.length;i++){
			item[i] = new ItemValue(wt[i],val[i],i);
		}
		Arrays.sort(item, new Comparator<ItemValue>() {
			@Override
			public int compare(ItemValue o1, ItemValue o2) {
				// TODO Auto-generated method stub
				return o2.cost.compareTo(o1.cost);
			}
		});
		double totalval = 0;
		for(int i=0;i<item.length;i++){
			int curw = (int)item[i].wt;
			int curval = (int)item[i].val;
			
			if(capacity-curw >= 0 ){
				totalval += curval;
				System.out.println(totalval);
				capacity -= curw;
			}else{
				totalval += ((double)capacity/(double)curw)*(double)curval;
				System.out.println(((double)capacity/(double)curw)*(double)curval);
				capacity = 0;
				break;
			}
		}
		System.out.println(totalval);
	}
	public void knapsackproblem01(){
		int wt[] = Arrayutil.createArray();
		int val[] = Arrayutil.createArray();
		int n = wt.length;
		int W = Arrayutil.getNumber();
		int K[][] = new int[n + 1][W + 1]; 
		  
        // Build table K[][] in bottom up manner 
        for (int i = 0; i <= n; i++) { 
            for (int w = 0; w <= W; w++) { 
                if (i == 0 || w == 0) 
                    K[i][w] = 0; 
                else if (wt[i - 1] <= w) 
                    K[i][w] = Math.max( 
                        val[i - 1] + K[i - 1][w - wt[i - 1]], 
                        K[i - 1][w]); 
                else
                    K[i][w] = K[i - 1][w]; 
            } 
        } 
  
        System.out.println(K[n][W]); 
	}
	public void recursiveknapsackproblem01() {
		int wt[] = Arrayutil.createArray();
		int val[] = Arrayutil.createArray();
		int n = wt.length;
		int W = Arrayutil.getNumber();
		
		int maxweight = recursiveKNP(wt,val,n,W);
		System.out.println(maxweight);
	}
	private int recursiveKNP(int[] wt, int[] val, int n, int w) {
		// TODO Auto-generated method stub
		if(n == 0 || w == 0) {
			return 0;
		}
		if(wt[n-1] > w) {
			return recursiveKNP(wt,val,n-1,w);
		}else {
			return Math.max(val[n-1]+recursiveKNP(wt,val,n-1,w-wt[n-1]), recursiveKNP(wt,val,n-1,w));
		}
	}

	public void maxsubarray(){
		int arr[] = Arrayutil.createArray();
		int length = arr.length;
		int maxsofar = 0,
				maxending = 0;
		for(int i=0;i<length;i++){
			maxending += arr[i];
			if(maxending<0){
				maxending = 0;
			}
			if(maxsofar<maxending){
				maxsofar = maxending;
			}
		}
		System.out.println(maxsofar);
	}
	/* https://algorithms.tutorialhorizon.com/sliding-window-algorithm-track-the-maximum-of-each-subarray-of-size-k */
	public void maxslidingwindow(){
		int arr[] = Arrayutil.createArray();
		int length = arr.length;
		int k =  Arrayutil.getNumber();
		Deque<Integer> dq = new LinkedList<Integer>();
		for(int i=0;i<k;i++){
			while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]){
				dq.removeLast();
			}
			dq.addLast(i);
		}
		for(int i=k;i<length;i++){
			System.out.println(arr[dq.peekFirst()]);
			while(!dq.isEmpty() && dq.peekFirst() <= i-k){
				dq.removeFirst();
			}
			while(!dq.isEmpty() && arr[dq.peekLast()]  <= arr[i]){
				dq.removeLast();
			}
			dq.addLast(i);
		}
	}
	public static void houserobber(){
		int arr[] = Arrayutil.createArray();
		int length = arr.length;
		int in = arr[0], ex = 0;
		for(int i=1;i<length;i++){
			int curIn = ex + arr[i];
			ex = Math.max(in, ex);
			in = curIn;
		}
		System.out.println(Math.max(in, ex));
	}
	/* https://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
	 */
	private static void noofbinarystringswithoutconsones() {
		// TODO Auto-generated method stub
		int n = Arrayutil.getNumber();
		int a[] = new int[n];
		int  b[] = new int[n];
		a[0] = b[0] = 1;
		for(int i=1;i<n;i++){
			a[i]= a[i-1]+b[i-1];
			b[i] = a[i-1];
		}
		System.out.println(a[n-1]+b[n-1]);
	}
	// https://www.geeksforgeeks.org/count-number-of-ways-to-reach-destination-in-a-maze-using-bfs/
	 
	private static void noofpathsinmazebfs(){
		int matrix[][] = {{ 1, 0, 0, 1 }, 
			                { 1, 1, 1, 1 }, 
			                { 1, 0, 1, 1 }}; 
		int n=3,m=4;
		Queue<pair> q = new LinkedList();
		pair p=new pair(0,0);
		int count =0;
		q.add(p);
		while(!q.isEmpty()){
			 p = q.peek();
			 q.remove();
			 if(p.first == n-1 && p.second == m-1){
				 count ++;
			 }
			 if(p.first +1 < n && matrix[p.first+1][p.second] == 1){
				 q.add(new pair(p.first+1,p.second));
			 }
			 if(p.second +1 < m && matrix[p.first][p.second+1] == 1){
				 q.add(new pair(p.first,p.second+1));
			 }
		}
		System.out.println(count+"nof of ways in maze");
	}
	private static void noofpaths() {
		// TODO Auto-generated method stub
		int m = Arrayutil.getNumber();
		int n = Arrayutil.getNumber();
		int count[][] = new int[m][n];
		 // first column is 1 
        for (int i = 0; i < m; i++) 
            count[i][0] = 1; 
        	
        // Count of paths to reach any cell in 
        // first column is 1 
        for (int j = 0; j < n; j++) 
            count[0][j] = 1; 
        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
        		count[i][j] = count[i-1][j]+count[i][j-1];
        	}
        }
        System.out.println(count[m-1][n-1]);
	}
	public void subsetequaltozero(){
		int arr[] = Arrayutil.createArray();
		int length = arr.length;
		int target =  Arrayutil.getNumber();
		recursivesubsetequaltozero(arr,0,length,target);
	}
	private boolean recursivesubsetequaltozero(int[] arr, int i, int length, int target) {
		// TODO Auto-generated method stub
		if(i>=length){
			return false;
		}
		System.out.println("heello");
		if(target-arr[i] == 0){
			System.out.println(true);
			return true;
		}else{
			boolean r = recursivesubsetequaltozero(arr,i+1,length,target-arr[i]) ;
			if(r == false)
			r = recursivesubsetequaltozero(arr,i+1,length,target) ;
			return r;
		}
	}
	public void subarrayequaltozero(){
		int arr[] = Arrayutil.createArray();
		int length = arr.length;
	}
	public void maxproductsubarray(){
		int A[] = Arrayutil.createArray();
		int length = A.length;
		if (A.length == 0)  {
			System.out.println(0);
		}
		   int max = A[0], min = A[0], totalMax = A[0];
		   for (int i = 1; i < A.length; i++) {
		       int tempMax = A[i] * max;
		       int tempMin = A[i] * min;
		       max = Math.max(Math.max(tempMax,tempMin), A[i]);
		       min = Math.min(Math.min(tempMax,tempMin), A[i]);
		       totalMax = Math.max(totalMax, max);
		   }
		 System.out.println(totalMax);
		
	}
	public void minNoofJUMPS(){
		int A[] = Arrayutil.createArray();
		int length = A.length;
		if (A.length == 0)  {
			System.out.println(0);
		}
		int dp[] =new int[length];
		int acJump[] =new int[length];
		dp[0] = 0;
		for(int i=1;i<length;i++){
			for(int j=0;j<i;j++ ){
				if(A[j]+j >= i){
					if(dp[i] == 0){
						dp[i] = dp[j]+1;
						acJump[i] = j;
					}else{
						if(dp[i]>dp[j]+1){
							acJump[i] = j;
						}
						dp[i] = Math.min(dp[i],dp[j]+1);
					}
				}
			}
		}
		Arrayutil.printArray(dp);
		Arrayutil.printArray(acJump);
		System.out.println(dp[length-1]);
	}
	public static int maxHistogram(){
		int input[] = Arrayutil.createArray();
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        System.out.println(maxArea);
        return maxArea;
    }
	public static void bestTimetosellstock() {
		int arr[] = Arrayutil.createArray();
		int minprice = Integer.MAX_VALUE,maxprofit=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<minprice) {
				minprice = arr[i];
			}
			if(arr[i]-minprice > maxprofit) {
				maxprofit = arr[i]-minprice;
			}
		}
		System.out.print(maxprofit);
		
	}
	private static void bestTimetosellstock1() {
		// TODO Auto-generated method stub
		int arr[] = Arrayutil.createArray();
		int profit=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[i-1]) {
				profit+= arr[i]-arr[i-1];
			}
		}
		System.out.println(profit);
	}

}
