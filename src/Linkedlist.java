import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist list=new Linkedlist();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the length of linked list");
		int l=in.nextInt();
				
		Node head2=null;
		Node head3 = null;
		for(int i=0;i<l;i++) {
			int data=in.nextInt();
			list.head=list.addNode(data,list.head);
		}
		System.out.println("entered the values");
		//reverseLinkedList(list.head);
		//oddEvenList(list.head);
		//list.addNumberwhichareinreverse(list.head);
		//list.nextgreaterNode(list.head);
		list.removenthNode(list.head);
	}
	
	Node head;
	public class Node{
		int data;
		Node next;
		Node() {}
		Node(int data) { this.data = data; }
		
		Node(int data,Node next){
			this.data =  data;
			this.next = next;
		}	
	}
	/*Iterative way of reversing a linked list
	 */
	private static void reverseLinkedList(Node head2) {
		// TODO Auto-generated method stub
		Node current = head2;
		Node prev = null;
		Node next = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head2 = prev;
		printLinkedList(prev);
	}
	/*
	 * Separate the odd and even positions
	 */
	private static void oddEvenList(Node head2){
		if(head2 == null){
			return;
		}
		Node oddNode = head2;
		Node evenNode = head2.next;
		Node temp = evenNode;
		while(temp != null && temp.next!= null){
			oddNode.next = oddNode.next.next ;
			temp.next = temp.next.next;
			oddNode = oddNode.next;
			temp = temp.next;
		}
		oddNode.next = evenNode;
		printLinkedList(head2);
		//printLinkedList(oddNode);
	}
	private void addNumberwhichareinreverse(Node head2){
		int sl = Arrayutil.getNumber();
		Linkedlist l = new Linkedlist();
		for(int i=0;i<sl;i++) {
			int data=Arrayutil.getNumber();
			l.head=l.addNode(data,l.head);
		}
		int n = Arrayutil.getNumber();
		if(n == 1){
			addNumber1(head2,l.head);
		}
	}
	private  void addNumber1(Node head2, Node head3) {
		// TODO Auto-generated method stub
		Node temp = new Node(0);
		Node curtemp = temp;
		
		int sum = 0;
		while(head2 != null || head3 != null){
			sum = sum / 10;
			if(head2 != null){
				sum+=head2.data;
				head2 = head2.next;
			}
			if(head3 != null){
				sum+=head3.data;
				head3 = head3.next;
			}
			curtemp.next = new Node(sum%10);
			curtemp = curtemp.next;	
		}
		if(sum/10 == 1){
			curtemp.next = new Node(1);
		}
		printLinkedList(temp.next);
	}
	private void nextgreaterNode(Node head2) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>();
        for (Node node = head2; node != null; node = node.next)
            A.add(node.data);
        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        for(int i=0;i<res.length;i++){
        	System.out.println(res[i]);
        }
	}
	private void removenthNode(Node head2){
		Node start = new Node(0);
		Node slow = start, fast = start;
	    slow.next = head2;
	    int n = Arrayutil.getNumber();
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	   printLinkedList(start.next);
	}
	private static void printLinkedList(Node head2) {
		// TODO Auto-generated method stub
		Node temp = head2;
		while(temp != null){
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public Node addNode(int d,Node head) {
		Node node=new Node(d);
		if(head==null) {
			head=node;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=node;
		}
		return head;
	}

}
