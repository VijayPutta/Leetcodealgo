import java.util.HashMap;


public class DynamicProgramming {
	public static void main(String[] args){
		//LongestPallindromeSubsequence();
		DynamicProgramming dp = new DynamicProgramming();
		//dp.noofclimbingsteps();
		//dp.minCostClimbingStairs();
		//dp.maxrodcutting();
		//dp.Longestpallindromicsubsequence();
		dp.minDistance();
	}

	private static void LongestPallindromeSubsequence() {
		// TODO Auto-generated method stub
		String str = Stringutil.createString();
		int length = str.length();
		int[][] arr = new int[length][length];
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(i==j){
					arr[i][j] = 1;
				}
				if(i<j){
					arr[i][j] = -1;
				}
			}
		}
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				if(str.charAt(i) == str.charAt(j)){
					//arr[i][j] = 
				}
			}
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
	public void Longestpallindromicsubsequence(){
		String s = Stringutil.createString();
		int t[][] = new int[s.length()+1][s.length()+1];
		for(int i=0;i<=s.length();i++){
			for(int j=0;j<=s.length();j++){
				if(i==j){
					t[i][j] = 1;
				}
			}
		}
		for(int i=2;i<=s.length();i++){
			for(int j=i+1;j<=s.length();j++){
				if(i>j){
					 if(s.charAt(i)==s.charAt(j)){
						 t[i][j] = t[i+1][j-1] + 2;
					 }else{
						 t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
					 }
				}
			}
		}
		System.out.println(t[0][s.length()]);
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
}
