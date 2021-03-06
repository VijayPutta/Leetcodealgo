import java.awt.Dimension;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;


public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DefrangingIpAddress();
		//decNumbertoAplhabet();
		//stringmatchinginarray();
		//convertRomantoInteger();
//		boolean status = detectCapitalworduse();
//		boolean status = canconstructTheMagazine();
//		boolean status = continousAbsent();
//		Stringutil.printStatus(status);
	//	addTwoString();
		//maximumscore();
		//boolean status = longpressedstring();
	//	Stringutil.printStatus(status);
	//	addBinary();
		//minnoofmovesforanagram();
		//thesmallestString();
		//removeAdjacentDuplicate();
		//removeAdjacentDuplicate2();
		//permutationsofthestring();
		printanagramstogether();
	}
	
	

	private static void permutationsofthestring() {
		// TODO Auto-generated method stub
		String perm = Stringutil.createString();
		int length = perm.length();
		recursivePermutate(perm,0,length-1);
	}



	private static void recursivePermutate(String perm, int l, int r) {
		// TODO Auto-generated method stub
		if(l==r){
			System.out.println(perm);
		}
		else{
			for(int i=l;i<=r;i++){
				perm = Stringutil.swap(perm,l,i);
				recursivePermutate(perm, l+1, r);
				perm = Stringutil.swap(perm,l,i);
			}
		}
	}



	/* brute force solution */
	private static void DefrangingIpAddress() {
		// TODO Auto-generated method stub
		String s = Stringutil.createString();
		int length = s.length();
		String str = "";
		int j=0;
		for(int i=0 ; i < length ; i++){
			if(s.charAt(i) == '.'){
				str += '[';
				str += '.';
				str += ']';
			}else{
				str += s.charAt(i);
			}
		}
		System.out.println(str);
	}
	// optimal solution
	private static void DefrangingIpAddressoptimal() {
		// TODO Auto-generated method stub
		String s = Stringutil.createString();
		String str = "";
		str = s.replace(".", "[.]");
		System.out.println(str);
	}
	private static void decNumbertoAplhabet(){
		String s = Stringutil.createString();
		StringBuffer sb = new StringBuffer();
		int length = s.length();
		for(int i=length-1;i>=0;i--){
			if(s.charAt(i) == '#'){
				sb.append((char)('a' + s.charAt(i-1)-'0' + 10*(s.charAt(i-2)-'0')-1));
				i -= 2;
			}else{
				sb.append((char)('a'+(s.charAt(i)-'0')-1));
			}
		}
		sb.reverse();
		System.out.println(sb.toString());
	}
	private static void stringmatchinginarray(){
		int n = Stringutil.getNumber();
		String s[] = Stringutil.arraySting(n);
		HashSet set = new HashSet();
		
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s.length;j++){
				if(i !=  j && !set.contains(s[i])){
					if(s[i].contains(s[j])){
						set.add(s[j]);
						//list.add(s[j]);
					}
				}
			}
		}
		LinkedList list = new LinkedList(set);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("hello");
	}
	private static void convertRomantoInteger(){
		        // I = 1
		        // V = 5
		        // X = 10
		        // L = 50
		        // C = 100
		        // D = 500
		        // M = 1000
		        
		        int total = 0; //Keep track of the sum
		        
		        String s = Stringutil.createString();
		        for(int i = 0; i <= s.length()-1; i++){
		            char c = s.charAt(i); 
		            
		            
		            
		            if(i <= s.length()-2){ //See if we can check Pairs of symbols 
		                if(c == 'C' && s.charAt(i+1) == 'M'){
		                    total += 900;
		                    i++; //Adding since we have cleared a pair of symbols 
		                } else if(c == 'C' && s.charAt(i+1) == 'D'){
		                    total += 400;
		                     i++;
		                } else if(c == 'X' && s.charAt(i+1) == 'C'){
		                    total += 90;
		                    i++;
		                } else if(c == 'X' && s.charAt(i+1) == 'L'){
		                    total += 40;
		                    i++;
		                } else if(c == 'I' && s.charAt(i+1) == 'X'){
		                    total += 9;
		                    i++;
		                } else if(c == 'I' && s.charAt(i+1) == 'V'){
		                    total += 4;
		                    i++;
		                } else { 
		                    if(c == 'M'){
		                        total += 1000;
		                    } else if (c == 'D'){
		                        total += 500;
		                    } else if (c == 'C'){
		                        total += 100;
		                    } else if (c == 'L'){
		                        total += 50;
		                    } else if (c == 'X'){
		                        total += 10;
		                    } else if (c == 'V'){
		                        total += 5;
		                    } else if (c == 'I'){
		                        total++;
		                    }
		                }
		            }
		            
		            
		            
		            else{ //If we are at the end of the string just check its value 
		                if(c == 'M'){
		                    total += 1000;
		                } else if (c == 'D'){
		                    total += 500;
		                } else if (c == 'C'){
		                    total += 100;
		                } else if (c == 'L'){
		                    total += 50;
		                } else if (c == 'X'){
		                    total += 10;
		                } else if (c == 'V'){
		                    total += 5;
		                } else if (c == 'I'){
		                    total++;
		                }
		            }  
		        }
		        System.out.println(total);
		        System.out.println("want to try again if then press 1");
		        int n = Stringutil.getNumber();
		        if(n == 1){
		        	convertRomantoInteger();
		        }else{
			        System.out.println("Thanks");
		        }
		    }  
	private static boolean detectCapitalworduse() {
		// TODO Auto-generated method stub
		String s = Stringutil.createString();
		int length = s.length();
		int flag = 0;
		boolean _bool = false;
		if(length == 1){
            return true;
        }
		if(s.charAt(0) >='a' && s.charAt(0) <= 'z'){
			flag = 1;
		}
		if(s.charAt(0) >='A' && s.charAt(0) <= 'Z'){
			if(s.charAt(1) >='a' && s.charAt(1) <= 'z'){
				flag = 2;
			}else{
				flag = 3;
			}
		}
		System.out.println(flag);
		for(int i=1;i<length;){
			if((s.charAt(i) >='a' && s.charAt(i) <= 'z' && (flag == 1 || flag == 2)) || (s.charAt(i) >='A' && s.charAt(i) <= 'Z') && flag == 3){
				i++;
			}else{
				return false;
			}
		}
		return true;
	}
	private static boolean canconstructTheMagazine(){
			String note = Stringutil.createString();
			String magazine = Stringutil.createString();
			int arr[] = new int[26];
			for(int i=0;i<magazine.length();i++){
				arr[magazine.charAt(i)-'a']++;
			}
			for(int i=0;i<note.length();i++){
				if(arr[note.charAt(i)-'a']-- <= 0){
					return false;
				};
			}
			System.out.println("hello");
			return true;
	}
	private static boolean continousAbsent(){
		String student = Stringutil.createString();
		int count =0;
		for(int i=0;i<student.length();i++){ 
			if(student.charAt(i)=='A'){
				count ++;
			}else if(i <= student.length()-3 && student.charAt(i) == 'L' && student.charAt(i+1) == 'L' &&student.charAt(i+2) == 'L'){
				return false;
			}
		}
		if(count == 2){
			return false;
		}
		return true;
	}
	private static void addTwoString() {
		// TODO Auto-generated method stub
		String str = Stringutil.createString();
		String addStr = Stringutil.createString();
		int n =str.length(), m = addStr.length();
		StringBuffer s = new StringBuffer();
		n--;
		m--;
		int carry = 0,addition=0;
		while(n >= 0 || m >= 0){
			int d1 = (n>=0)?str.charAt(n--)-'0':0;
			int d2 = (m>=0)?addStr.charAt(m--)-'0':0;
			addition = carry + d1 + d2;
			s.append(addition%10);
			carry = addition/10;

		}
		s.reverse();
		System.out.println(s);
	}
	private static void maximumscore(){
		String str = Stringutil.createString();
		int n = str.length();
		String s = "";
		int zerocount = 0,onecount=0,maxcount=0;
		s = (String) str.subSequence(0, 1);
		zerocount = getzerocount(s,'0');
		s = (String) str.subSequence(1, n);
		System.out.println(s);
		onecount = getzerocount(s,'1');
		maxcount =onecount+zerocount;
		 if(n <= 2){
				System.out.println(maxcount);
				return;
	        }
		for(int i=1;i<n-1;i++){
			if(str.charAt(i) == '0'){
				zerocount++;
			}else{
				onecount--;
			}
			int temp = zerocount+onecount;
			if(maxcount < temp){
				maxcount=temp;
			}
		}
		System.out.println(maxcount);
	}
	
	private static int getzerocount(String s, char c) {
		// TODO Auto-generated method stub
		int count =0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==c){
				count++;
			}
		}
		return count;
	}
	private static boolean longpressedstring(){
		String name = Stringutil.createString();
		String typed = Stringutil.createString();
		 if(typed.length()< name.length())  return false; 
	        if(typed.length() == name.length()) return typed.equals(name); 
	        
	        int nameIndex = 0;
	        for(int i = 0; i< typed.length(); i++){
	            if(nameIndex < name.length() && typed.charAt(i) == name.charAt(nameIndex)){
	                nameIndex++;
	            } else if(i>0 && typed.charAt(i) == typed.charAt(i-1)){
	                continue;
	            } else return false;
	        }
	        if(nameIndex == name.length())
	            return true;
	        else 
	            return false;
	    
	}
	private static void addBinary(){
		String a = Stringutil.createString();
		String b = Stringutil.createString();
		int n = a.length()-1;
		int m = b.length()-1;
		int sum = 0 , carry = 0;
		StringBuffer result = new StringBuffer();
		while(n>= 0 || m >=0){
			int bit1 = n>=0?Integer.parseInt(String.valueOf(a.charAt(n))):0;
			int bit2 = m>=0?Integer.parseInt(String.valueOf(b.charAt(n))):0;
			sum = carry ^ bit1^bit2;
			carry=(carry & bit1) | (carry & bit2) | (bit1 & bit2);
			result.append(String.valueOf(sum));
			n--;m--;
		}
		if(carry > 0)
            result.append(String.valueOf(carry));
		result.reverse();
		System.out.println(result);
	}
	private static String convertfromintegertobinary(int sum) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer();
		while(sum != 0){ 
			System.out.println(sum);
			str.append(sum%2);
			sum = sum/2;
		}
		return str.toString();
	}



	private static int convertfrombinarytointeger(String str){
		int n = 0,j=0;
		int length = str.length();
		for(int i=length-1;i>=0;i--){
			n += (str.charAt(i) - '0') * Math.pow(2, j);
			j++;
		}
		return n;
	}
	private static void minnoofmovesforanagram(){
		String s = Stringutil.createString();
		String t = Stringutil.createString();
		int[] arr = new int[26];
		for(int i=0;i<s.length();i++){
			arr[s.charAt(i)-'a']++;
		} 
		 for(int i=0;i<t.length();i++){
			arr[t.charAt(i)-'a']--;
		}
		int ans=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > 0) ans += arr[i];
        }
        System.out.println(ans);
	}
	private static void thesmallestString(){
		
		int n = Arrayutil.getNumber();
		int k = Arrayutil.getNumber();
		String s = Stringutil.createString();
		String t = Stringutil.createString();
		StringBuffer  str = new StringBuffer(t);
		
		int arr[][] = new int[k][2];
		for(int i=0;i<k;i++){
			for(int j=0;j<2;j++){
				arr[i][j] = Arrayutil.getNumber();
			}
		}
		for(int i=0;i<k;i++){
			if((int)(str.charAt(arr[i][0])-'a') > (int)(str.charAt(arr[i][1])-'a')){
				str.setCharAt(arr[i][0], t.charAt(arr[i][1]));
				str.setCharAt(arr[i][1], t.charAt(arr[i][0]));
			}
		}
		System.out.println(str);
	}
	/*
	 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
		Output:
		[
		  ["ate","eat","tea"],
		  ["nat","tan"],
		  ["bat"]
		]
	 */
	public void groupAnagrams(){
		
	}
	private static void partElections(){
		List s = new List();
		int n = Arrayutil.getNumber();
		for(int i=0;i<n;i++){
			String str = Stringutil.createString();
			s.add(str);
		}
		//int size = s.size();
		
	}
	/* 
	 *  Remove Adjacent chars from teh string
	 */
	public static void removeAdjacentDuplicate(){
				String s = Stringutil.createString();
		        int i = 0, n = s.length();
		        char[] res = s.toCharArray();
		        for (int j = 0; j < n; ++j, ++i) {
		            res[i] = res[j];
		            if (i > 0 && res[i - 1] == res[i]) // count = 2
		                i -= 2;
		        }
		        System.out.println(new String(res, 0, i));
	}
	public static void removeAdjacentDuplicate2(){
		String s = Stringutil.createString();
        int i = 0, n = s.length();
        int n1 = Arrayutil.getNumber();
        char[] res = s.toCharArray();
        int count[] = new int[n];
        for (int j = 0; j < n; ++j, ++i) {
        	res[i] = res[j];
        	if(i>0 && res[i] == res[i-1]){
        		count[i] = count[i-1]+1;
        	}else{
        		count[i] = 1;
        	}
        	if(count[i] == n1){
        		i -= n1;
        	}
        }
        System.out.println(new String(res, 0, i));
	}
	
	/* Microsoft practise
	 * Given an array of words, print all anagrams together. 
	 * For example, if the given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat tac act dog god”.
	
	 * 
	 * A simple method is to create a Hash Table. 
	 * Calculate the hash value of each word in such a way that all anagrams have the same hash value.
	 * Populate the Hash Table with these hash values. 
	 * Finally, print those words together with same hash values. 
	 * A simple hashing mechanism can be modulo sum of all characters. 
	 * With modulo sum, two non-anagram words may have same hash value. This can be handled by matching individual characters.

		Following is another method to print all anagrams together. 
		Take two auxiliary arrays, index array and word array. 
		Populate the word array with the given sequence of words. 
		Sort each individual word of the word array. 
		Finally, sort the word array and keep track of the corresponding indices. 
		After sorting, all the anagrams cluster together. 
		Use the index array to print the strings from the original array of strings.
	 */
	public static void printanagramstogether() {
		int num = Stringutil.getNumber();
		String[] strList = Stringutil.arraySting(num);
		
		HashMap<Character,Integer> tempMap ;
		HashMap<HashMap<Character,Integer>,ArrayList<String>> map = new HashMap<HashMap<Character,Integer>,ArrayList<String>>();
		ArrayList<String> strings;
		for(int i=0;i<strList.length;i++) {
			System.out.println(i);
			String str = strList[i];
			tempMap = new HashMap<Character,Integer>();
			for(int j=0;j<str.length();j++) {
				if(tempMap.containsKey(str.charAt(j))) {
					int x =  tempMap.get(str.charAt(j));
					tempMap.put(str.charAt(j), x+1);
				}else {
					tempMap.put(str.charAt(j), 1);
				}
			}
			if(map.containsKey(tempMap)) {
				 strings = map.get(tempMap);
				strings.add(str);
				map.put(tempMap,strings);
			}else {
				strings = new ArrayList();
				strings.add(str);
				map.put(tempMap,strings);
			}
		}
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for(HashMap<Character,Integer> temp :map.keySet()) {
			result.add(map.get(temp));
		}
		System.out.println(result);
	}
	
}
