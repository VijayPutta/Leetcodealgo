import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;


public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DefrangingIpAddress();
		//decNumbertoAplhabet();
		//stringmatchinginarray();
		//convertRomantoInteger();
//		boolean status = detectCapitalworduse();
//		Stringutil.printStatus(status);
		boolean status = canconstructTheMagazine();
		Stringutil.printStatus(status);
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
		                } else { //there are no matching pairs so just check value 
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
			return true;
	}
	
}
