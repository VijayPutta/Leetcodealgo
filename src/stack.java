import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;


public class stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nextgreaterelement();
		slidingwindowmax();
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
	public static void slidingwindowmax(){
		int[] arr = Arrayutil.createArray();
		int k = Arrayutil.getNumber();
		int res[] = new int[arr.length-k+1];
		  PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1)); // stores values

		for(int i=0;i<k;i++){
			maxPQ.add(arr[i]);
		}
		
		int j=0;
		res[0]= maxPQ.peek();
		for(int i=k;i<arr.length;i++){
			maxPQ.remove(arr[i-k]);
			maxPQ.add(arr[i]);
	        res[i- k+1]= maxPQ.peek();
	    }
//		for(int i=k;i<arr.length;i++){
//			res[j++] =(int) maxPQ.peek();
//			maxPQ.remove(arr[i-k]);
//			maxPQ.add(i);
//		}
		
		Arrayutil.printArray(res);
	}
	
	

}
