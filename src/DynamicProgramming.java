
public class DynamicProgramming {
	public static void main(String[] args){
		LongestPallindromeSubsequence();
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
}
