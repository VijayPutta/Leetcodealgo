import java.util.HashMap;


public class DynamicProgramming {
	public static void main(String[] args){
		//LongestPallindromeSubsequence();
		DynamicProgramming dp = new DynamicProgramming();
		//dp.noofclimbingsteps();
		dp.minCostClimbingStairs();
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
}
