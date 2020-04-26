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
}
