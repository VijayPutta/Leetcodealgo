import java.util.Scanner;


public class Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkedlist list=new Linkedlist();
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the length of linked list");
		int l=in.nextInt();
				
		Node head2=null;
		for(int i=0;i<l;i++) {
			int data=in.nextInt();
			list.head=list.addNode(data,list.head);
		}
		System.out.println("entered the values");
		reverseLinkedList(list.head);
	}
	 Node head;
	public class Node{
		int data;
		Node next;
		Node(int data){
			this.data =  data;
			this.next = null;
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
