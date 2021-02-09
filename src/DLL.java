//$Id$

public class DLL {
	Node head;
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int d){
			data = d;
		}
	}
	public Node addNode(int data,Node head) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
		}
		else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			newNode.prev = temp;
			newNode.next = null;
			temp.next = newNode;
		}
		return head;
	}
	public Node addNodeAtFirst(Node head,int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		newNode.prev = null;
		head.prev = newNode;
		head = newNode;
		return head;
	}
	public Node addAfterNode(Node head,int data,int temp) {
		Node curHead = head;
		while(curHead!=null && curHead.data != temp) {
			curHead = curHead.next;
		}
		Node newNode = new Node(data);
		Node next = curHead.next;
		newNode.next = curHead.next;
		curHead.next = newNode;
		newNode.prev = curHead;
		next.prev = newNode;
		return head;
	}
	public Node addBeforeNode(Node head,int data, int temp) {
		Node curHead = head;
		Node next=curHead;
		while(curHead!=null && curHead.data != temp) {
			curHead = curHead.next;
			next = curHead;
		}
		Node newNode = new Node(data);
		
		newNode.next = curHead;
		//curHead.next = newNode;
		newNode.prev = next;
		next.next = newNode;
		return head;
	}
	public void printTheDLL(Node temp) {
		while(temp != null) {
			System.out.println(temp.data);
			System.out.println(temp.next);
			System.out.println(temp.prev);
			System.out.println("\n");
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL list = new DLL();
		for(int i=0;i<10;i++) {
			list.head = list.addNode(i,list.head);
		}
		list.head = list.addNodeAtFirst(list.head, 11);
		list.head = list.addAfterNode(list.head, 15, 7);
		list.head = list.addBeforeNode(list.head, 13, 7);
		list.printTheDLL(list.head);
	}

}
