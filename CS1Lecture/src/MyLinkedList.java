
import java.util.Scanner; 
public class MyLinkedList { 
	private class Node { 
		private Object data; 
		private Node next; 
		public Node(Object data) { 
			this.data = data;
			next = null; 
		} 
	} 
	private Node head;
	/* List head pointer */
	public MyLinkedList() { 
		head = null; 
	} 
	public void add(Object data) { 
		Node n = new Node(data); 
		n.next = head; 
		head = n; 
	}
	public String toString() { 
		String result = "\" ";
		Node temp = head;
		while (temp != null) { 
			result += temp.data + " , "; 
			temp = temp.next;
		} 
		return result + "\"";
	} 
	public boolean find(Object obj) { 
		Node temp = head; 
		while (temp != null) { 
			if (temp.data.equals(obj))
				return true;
			temp = temp.next; 
		} 
		return false; 
	} 
	public Object getLastElement() { 
		if (head == null) return null; 
		Node curr = head; 
		while (curr.next != null){
			curr = curr.next;
			return curr.data; 
		}
		return curr;
	} 

	/* TODO When this code fails? */ 
	public void insertElementAfter(Object targetElement, Object toInsert) { 
		Node cursor = head; 
		while (cursor != null) { 
			if (cursor.data.equals(targetElement)) { 
				Node n = new Node(toInsert); 
				n.next = cursor.next; 
				cursor.next = n; break; 
			} 
			else cursor = cursor.next; 
		} 
	} 

	/* TODO When this code fails? */ 
	public void delete(Object targetElement) { 
		Node prev = null, curr = head; 
		while (curr != null) { 
			if (curr.data.equals(targetElement)) { 
				if (curr == head) 
					head = head.next; 
				else prev.next = curr; break; 
			} 
			else { 
				prev = curr; 
				curr = curr.next; 
			} 
		} 
	} 
	public void insertElementBefore(Object targetElement, Object toInsert) { 
		Node prev = null, curr = head; 
		while (curr != null) { 
			if (curr.data.equals(targetElement)) { 
				Node n = new Node(toInsert); 
				if (curr == head) { 
					n.next = head; 
					head = n; 
				} 
				else { 
					prev.next = n; 
					n.next = curr; 
					break;
				} 
			} 
			else { 
				prev = curr; 
				curr = curr.next;
			}
		} 
	} 
	public static void main(String[] args) { 
		String answ="none"; 
		String item=""; 
		Scanner input = new Scanner(System.in); MyLinkedList L = new MyLinkedList(); System.out.println("Your initial list is :"+L); 
		while (answ.equals("add")||answ.equals("delete")||answ.equals("none")){ 
			System.out.println("1. If you want to insert an element, enter the word : add. \n2. If you want to delete an element, input the word: delete"); answ=input.next(); 
			if (answ.equals("add")){ System.out.print("Input the element to be added: "); 
			item=input.next(); 
			L.add(item); 
			} 
			else{ 
				if (answ.equals("delete")){ 
					System.out.print("Input the element to be deleted: "); 
					item=input.next(); 
					L.getLastElement();
				} 
			} 
			System.out.println("\nYour current list is :"+L+"\n");
		}
	}
}