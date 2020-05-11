import java.util.HashMap;
import java.util.Stack;


public class stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nextgreaterelement();
	}
	public static void nextgreaterelement(){
		Stack s = new Stack();
		int[] arr = Arrayutil.createArray();
		int[] arr1 = Arrayutil.createArray();
		HashMap map = new HashMap();
		int res[] = new int[arr.length];
		for(int i=0;i<arr1.length;i++){
			if(!s.isEmpty() && (int)s.peek() < arr1[i]){
				map.put(s.pop(), arr1[i]);
			}
			s.push(arr1[i]);
		}
		while(!s.isEmpty()){
			map.put(s.pop(), -1);
		}
		for(int i=0;i<arr.length;i++){
			res[i] = (int)map.get(arr[i]);
		}
		for(int i=0;i<arr.length;i++){
			System.out.println(res[i]);
		}
	}

}
