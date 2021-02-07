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
		list.printTheDLL(list.head);
	}

}
