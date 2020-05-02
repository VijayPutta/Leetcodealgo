import java.util.*;
public class BinaryTree {
	public static void main(String[] args){
		//reachthenumberwithminsteps();
		//getThesumofdepthtravesal();
		//twoTreeIdenticalSequence();
		trimTheNodes();
	}
	public static class Node{
		int data;
		Node left,right;
		public Node(int d) {
			data=d;
			left=null;
			right=null;
		}
		public Node(){
			
		}
	}
	Node root;
	/*Leetcode problem which is incompletely done	 */
	private static void reachthenumberwithminsteps() {
		// TODO Auto-generated method stub
		int number = Arrayutil.getNumber(),
				temp = 0;
		Queue q = new LinkedList();
		q.add(0);
		int count = 0;
		int queuesize = 0;
		while(!q.isEmpty()){
			temp = (int)q.poll();
			System.out.println(temp+"temp");
		        if(temp == number){
		        	System.out.println(count);
		        	return;
		        }
		        queuesize++;
		        System.out.println(queuesize+"queuesize");
		        System.out.println(count+"queuesize");
		        if(queuesize == Math.pow(2, count)){
		            count++;
		        	queuesize = 0;
		        }
		        System.out.println("hello");
				q.add(temp-count);
				q.add(temp+count);
				System.out.println(temp-count);
				System.out.println(temp+count);
		}

	}
	private static void getThesumofdepthtravesal(){
		Node n = new Node(1);
		
		n.left = new Node(0);
		n.right = new Node(1);
		
		n.left.left = new Node(0);
		n.left.right = new Node(1);
		
		n.right.left = new Node(0);
		n.right.right = new Node(1);
		
		int sum = calculatepreorderdepth(n,0);
		System.out.println(sum);
	}
	private static int calculatepreorderdepth(Node n, int val) {
		// TODO Auto-generated method stub
		if(n == null){
			return 0;
		}
		val = val *2 + n.data;
        return n.left == n.right ? val : calculatepreorderdepth(n.left, val) + calculatepreorderdepth(n.right, val);

	}
	public static Node convertarraytotree(int[] arr){
		Node n = new Node();
		return n = recursiveFun(arr,n,0);
		
	}
	private static Node recursiveFun(int[] arr, Node root, int i) {
		// TODO Auto-generated method stub
		 if (i < arr.length) { 
	            Node temp = new Node(arr[i]); 
	            root = temp; 
	  
	            // insert left child 
	            root.left = recursiveFun(arr, root.left,2 * i + 1); 
	  
	            // insert right child 
	            root.right = recursiveFun(arr, root.right,2 * i + 2); 
	        } 
	        return root;
	}
	private static void twoTreeIdenticalSequence(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		int[] sarr = Arrayutil.createArray();
		Node n1 = convertarraytotree(sarr);
		ArrayList list = new ArrayList();
		ArrayList list1 = new ArrayList();
		list = getSequenceofleafs(list,n);
		list1 = getSequenceofleafs(list1, n1);
		// For printing the listing 
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
//		for(int i=0;i<list1.size();i++){
//			System.out.println(list1.get(i));
//		}
		System.out.println(list.equals(list1));
//		printTree(n);
//		printTree(n1);
	}
	private static ArrayList getSequenceofleafs(ArrayList list, Node n) {
		// TODO Auto-generated method stub
		getLeafs(list,n);
		return list;
	}
	private static void getLeafs(ArrayList list, Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return;
		}
		
		getLeafs(list,n.left);
		if(n.left == null && n.right == null){
			list.add(n.data);
		}
		getLeafs(list,n.right);
	}
	private static void printTree(Node n) {
		// TODO Auto-generated method stub
		InorderTraversal(n);
	}
	private static void InorderTraversal(Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return;
		}
		InorderTraversal(n.left);
		System.out.println(n.data);
		InorderTraversal(n.right);
	}
	private static void trimTheNodes(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		int l = Arrayutil.getNumber();
		int r = Arrayutil.getNumber();
		n = trimRecursively(n,l,r);
		printTree(n);
	}
	private static Node trimRecursively(Node n, int l, int r) {
		// TODO Auto-generated method stub
		if(n == null){
			return null;
		}
		if(n.data < l){
			return trimRecursively(n.right, l, r);
		}
		if(n.data > r){
			return trimRecursively(n.left, l, r);
		}
		n.left = trimRecursively(n.left, l, r);
		n.right = trimRecursively(n.right, l, r);
		
		return n;
	}
}
