package LinkedLists;

/**
 * @author theorist
 * Write code to remove duplicates from an unsorted linked list.
 */

class Node {
	int data;
	Node prev;
	Node next;
	Node(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}
class LinkedList {
	Node head;
	Node tail;
	int length;
	public LinkedList() {
		head = new Node(0);
		head.next = tail;
		head.prev = null;
		tail = new Node(0);
		tail.next = null;
		tail.prev = head;
	}
	void add(Node node) {
		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
		length++;
	}
	
	void reverse(Node node) {
		Node oneBefore = node.prev;
		Node twoBefore = node.prev.prev;
		Node oneAfter = node.next;
		
		oneAfter.prev = oneBefore;
		twoBefore.next = node;
		oneBefore.prev = node;
		oneBefore.next = node.next;

		node.prev = twoBefore;
		node.next = oneBefore;
		
	}
	void print() {
		Node cur = head;
		while (cur.next!=tail) {
			cur = cur.next;
			System.out.print(cur.data+", ");
		}
		System.out.println();
	}
}
public class RemoveDups {
	public static void main(String[] args) { 
		LinkedList linkedList = new LinkedList();
		linkedList.add(new Node(5));
		linkedList.add(new Node(4));
		linkedList.add(new Node(3));
		linkedList.add(new Node(2));
		linkedList.add(new Node(1));
		
		linkedList.print();
		
		int length = linkedList.length;
		while (length > 0) {
			Node cur = linkedList.tail.prev;
			while (cur.prev != linkedList.head) {
				if(cur.data < cur.prev.data) {

					linkedList.reverse(cur);					
				} else {
					cur = cur.prev;
				}
			}
			length--;
		}
		linkedList.print();
	}
}
