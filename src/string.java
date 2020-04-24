import java.util.HashSet;
import java.util.LinkedList;


public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DefrangingIpAddress();
		//decNumbertoAplhabet();
		stringmatchinginarray();
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
	}
}
