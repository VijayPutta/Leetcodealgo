import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Arrayutil {
	public static int[] createArray(){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the length of array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("enter the array");
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("you have entered array");
		return arr;
	}
	public static int getNumber(){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number");
		int n = sc.nextInt();
		return n;
	}
	public static void printArray(int[] nums1) {
		// TODO Auto-generated method stub
		for(int i=0;i<nums1.length;i++){
			System.out.println(nums1[i]+" ");
		}
	}
	public static List convertArraytoList(){
		List list = new LinkedList();
		int[] arr = Arrayutil.createArray();
		list.add(arr);
		return list;
	}
	public static void printArray(int[][] dp, int length, int capacity) {
		// TODO Auto-generated method stub
		for(int i=0;i<=length;i++){
			for(int j=0;j<=capacity;j++){
				System.out.println(dp[i][j]);
			}
			System.out.println("\n");
		}
	}
}
