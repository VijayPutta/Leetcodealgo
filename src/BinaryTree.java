import java.util.*;
public class BinaryTree {
	int max = 0;
	Node root;
	public static void main(String[] args){
		//reachthenumberwithminsteps();
		//getThesumofdepthtravesal();
		//twoTreeIdenticalSequence();
		//trimTheNodes();
		BinaryTree b = new BinaryTree();
//		b.Diameterofthetree();
		//convertBsttoGreatertree();
		//b.treetilt();
		//b.printSecondMinNode();
		//kthsmallestNode();
		//b.minDiffInBST();
		//b.convertBSTtoGreaterBST();
		//b.convertArraytoBST();
		//b.getTheCousins();
		//b.validateBST();
		//b.pathofthesums();
		//b.pathofthesums1();
		b.verticalOrderSum();
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
	private static void printTree(Node n,int i) {
		// TODO Auto-generated method stub
		 if (i==1)
			InorderTraversal(n);
		else if (i==2)
			PreOrderTraversal(n);
		else
			PostOrderTraversal(n);
	}
	/* recursive traversal of tree */
	private static void InorderTraversal(Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return;
		}
		InorderTraversal(n.left);
		System.out.println(n.data);
		InorderTraversal(n.right);
	}
	private static void PreOrderTraversal(Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return;
		}
		System.out.println(n.data);
		PreOrderTraversal(n.left);
		PreOrderTraversal(n.right);
	}
	private static void PostOrderTraversal(Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return;
		}
		PostOrderTraversal(n.left);
		PostOrderTraversal(n.right);
		System.out.println(n.data);
	}
	/* iterative traversal of trees */
	private static void IterativeInorderTraversal(){
		int[] arr = Arrayutil.createArray();
		Stack s = new Stack();
		Node n = convertarraytotree(arr);
		s.add(n);
		
	}
	private static void trimTheNodes(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		int l = Arrayutil.getNumber();
		int r = Arrayutil.getNumber();
		n = trimRecursively(n,l,r);
		printTree(n,1);
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
	public void Diameterofthetree(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		
		recursiveDiamterofthetree(n);
		System.out.println(max);
	}
	public int recursiveDiamterofthetree(Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return 0;
		}
		int l = recursiveDiamterofthetree(n.left);
		int r = recursiveDiamterofthetree(n.right);
		max = Math.max(max, l+r);
		return 1+ Math.max(l,r);
	}
	public static void convertBsttoGreatertree(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		int cursum = 0;
		n = BSTPostOrderTraversal(n,cursum);
		printTree(n, 1);
	}
	private static Node BSTPostOrderTraversal(Node n,int csum) {
		// TODO Auto-generated method stub
		if(n == null){
			return null;
		}
		if(n.right != null){
			n.right = BSTPostOrderTraversal(n.right, csum);
			n.right.data = n.right.data + csum;
			csum += n.right.data;
		}
		n.data = n.data + csum ;
		if(n.left != null){
			n.left = BSTPostOrderTraversal(n.left, csum);
			n.left.data = n.left.data + csum;
			csum += n.left.data;
		}
		return n;
	}
	public void treetilt(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		recursiveTreeTilt(n);
		System.out.println(max);
	}
	public int recursiveTreeTilt(Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return 0;
		}
//		if(n.left != null){
//			int l = n.left.data;
//		}
//		if(n.right != null){
//			int r= n.right.data;
//		}
		int l = recursiveTreeTilt(n.left);
		 int r = recursiveTreeTilt(n.right);
		max += Math.abs(l-r);
		return l+r+n.data;
	}
	public void printSecondMinNode(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		int[] min = new int[2];
		min[0] = Integer.MAX_VALUE;
		min[1] = Integer.MAX_VALUE;
		recursiveprintSecondMin(n,min);
		System.out.print(min[1]);
	}
	private void recursiveprintSecondMin(Node n, int[] min) {
		// TODO Auto-generated method stub
		if(n == null){
			return;
		}
		if(n.data < min[0]){
			int temp = min[0];
			min[0] = n.data;
			min[1] = temp;
		}
		if(n.data > min[0] && n.data < min[1]){
			min[1] = n.data;
		}
		recursiveprintSecondMin(n.left,min);
		recursiveprintSecondMin(n.right,min);
	}
	private static void invertTree(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		n = recursiveinvertTree(n);
	}
	private static Node recursiveinvertTree(Node n) {
		// TODO Auto-generated method stub
		if(n == null){
			return null;
		}
		return null;
	}
	private static void kthsmallestNode(){
		int[] arr = Arrayutil.createArray();
		Node n = convertarraytotree(arr);
		int k = Arrayutil.getNumber();
		recursivekthsmallestNode(k,n);
	}
	private static void recursivekthsmallestNode(int k,Node n) {
		// TODO Auto-generated method stub
		LinkedList s = new LinkedList();
		while(true){
			while(n!= null){
				s.add(n);
				n = n.left;
			}		
			n = (Node) s.removeLast();
			k--;
			if(k==0){
				System.out.println(n.data);
			}
			n = n.right;
			
		}
	}
		/* For min distance btw two node */
	   	 int min = Integer.MAX_VALUE;
	     Node prev = null;
	    public int minDiffInBST() {
	    	int[] arr = Arrayutil.createArray();
			Node n = convertarraytotree(arr);
			recursiveminimumBST(n);
	        return min;
	     }
	    public void recursiveminimumBST(Node n){
	        if(n == null)
	            return;
	        recursiveminimumBST(n.left);
	        if(prev != null){
	            min = Math.min(min,n.data-prev.data);
	        }
	        prev = n;
	        recursiveminimumBST(n.right);
	    }
	    int sum = 0;
	    public Node convertBSTtoGreaterBST() {
	       // prev.val = 0;
	    	int[] arr = Arrayutil.createArray();
			Node root = convertarraytotree(arr);
	    	convertBSTInorderTraversal(root);
	        return root;
	    }
	    private void convertBSTInorderTraversal(Node n) {
			// TODO Auto-generated method stub
			if(n == null){
				return;
			}
	        
			InorderTraversal(n.right);
			n.data += sum;
	        sum = n.data;
			InorderTraversal(n.left);
	        
		}
	    /* minimal tree 
	     * Convert array to BST with minimum height*/
	    static Node _n;
	    public void convertArraytoBST(){
	    	System.out.println("Your into finding minimal tree");
	    	int[] arr = Arrayutil.createArray();
	    	_n = recursiveConvertarraytoBST(arr,0,arr.length-1);
	    	printTree(_n,1);
	    }
	    
		private Node recursiveConvertarraytoBST(int[] arr,int l,int h) {
			// TODO Auto-generated method stub
			if(l>h){
				return null;
			}
			int m = (l+h)/2;
			Node n = new Node(arr[m]);
			n.left = recursiveConvertarraytoBST(arr,l,m-1);
			n.right = recursiveConvertarraytoBST(arr,m+1,h);
			return n;
		}
		int xdepth = 0,ydepth = 0;
		Node xNode = null,yNode = null;
		public void getTheCousins(){
			int[] arr = Arrayutil.createArray();
			int x = Arrayutil.getNumber();
			int y = Arrayutil.getNumber();
			Node root = convertarraytotree(arr);
			depthOftheNode(root,x,y,1,null);
			if(xNode != yNode && xdepth == ydepth){
				System.out.println("there are cousins");
			}
		}
		public void depthOftheNode(Node root,int element,int element1,int depth,Node pNode){
			if(root == null){
				return;
			}
			if(root.data == element){
				xdepth = depth;
				xNode = pNode;
			}if(root.data == element1){
				ydepth = depth;
				yNode = pNode;
			}
			depthOftheNode(root.left,element,element1,depth+1,root);
			depthOftheNode(root.right,element,element1,depth+1,root);
		}
		public void validateBST(){
			int[] arr = Arrayutil.createArray();
			Node root = convertarraytotree(arr);
			Node min = null;
			Node max =null;
			boolean result = recursiveValidateBST(root,min,max);
			System.out.println(result);
		}
		private boolean recursiveValidateBST(Node n,Node min,Node max) {
			// TODO Auto-generated method stub
			if(n == null){
				return true;
			}
			boolean bool = false;
			if((min != null && n.data <= min.data )||( max != null && n.data >= max.data)){
				return false;
			}
			return recursiveValidateBST(n.left,min,n) &&recursiveValidateBST(n.right,n,max);
		}
		public void diameterOftheTree(){
				
		}
		/* Sum of the path should be from parent node to child node
		 */
		public void pathofthesums(){
			int[] arr = Arrayutil.createArray();
			Node root = convertarraytotree(arr);
			int sum = Arrayutil.getNumber();
			System.out.println(recursivepathofthesums(root,sum));
		}
		private boolean recursivepathofthesums(Node n, int sum) {
			// TODO Auto-generated method stub
			if(n == null)return false;
			if(n.right == null && n.left == null) return sum == n.data;
			
			return recursivepathofthesums(n.left,sum-n.data) || recursivepathofthesums(n.right,sum-n.data);
		}
		public void pathofthesums1(){
			int[] arr = Arrayutil.createArray();
			Node root = convertarraytotree(arr);
			int sum = Arrayutil.getNumber();
			System.out.println(pathSum(root,sum));
		}
		private int recursiveCall(Node n, int sum) {
			// TODO Auto-generated method stub
			if(n == null){
				return 0;
			}
			int count =0;
			if(n.data == sum){
				count++;
			}
			return count + recursiveCall(n.left,sum-n.data) +recursiveCall(n.right,sum-n.data);
		}
		public int pathSum(Node n, int sum) {
	        int curCount = recursiveCall(n, sum);
	        if (n == null) {
	            return 0;
	        }

	        return curCount + pathSum(n.left, sum) + pathSum(n.right, sum);
	    }
		HashMap map = new HashMap();
		
		public void verticalOrderSum(){
			int[] arr = Arrayutil.createArray();
			Node root = convertarraytotree(arr);
			recursiveverticalOrderSum(root,0);
			hashmap.printHashMap(map);
		}
		private void recursiveverticalOrderSum(Node n,int depth) {
			// TODO Auto-generated method stub
			if(n == null){
				return;
			}
			if(n!= null){
				map.put(depth, (int)map.getOrDefault(depth, 0)+n.data);
			}
			recursiveverticalOrderSum(n.left,depth-1);
			recursiveverticalOrderSum(n.right,depth+1);
		}
		
}
