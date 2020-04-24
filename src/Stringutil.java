import java.util.Scanner;
import java.lang.*;
import java.util.*;
public class Stringutil {
	public static java.lang.String createString(){
		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);
		java.lang.String str = sc.nextLine();
		return str;
	}
	public static String[] arraySting(int num){
		System.out.println("Enter the array of strings");
		String s[] = new String[num];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<num;i++){
			s[i] = sc.nextLine();
		}
		return s;
		
	}
	public static int getNumber(){
		System.out.println("Enter the size of strings");
		int n = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		return n;
	}
}
