class linkedlist {

	//Node class
	static class Node {
		int data;
		Node next;
		Node (int d) {
			data = d;
			next = null;
		}
	}
	
	/*    Variables    */
	Node head;


	/*   Medthods      */
	public static linkedlist addFirst(linkedlist list, int val) {
		Node newData = new Node(val);
		newData.next = list.head;
		list.head = newData; //update list

		return list;
	}

	public static linkedlist addLast(linkedlist list, int val) {
		Node newData = new Node(val);

		//case if list is empty Last
		if (list.head == null) {
			list.head = newData;
			return list;
		}

		//if list not empty
		Node temp = list.head;
		while (temp.next != null) temp = temp.next; 
		temp.next = newData; 
		return list;
	}

	//returns node if found, null otherwise
	public static Node Search(linkedlist list, int val) {
		Node temp = list.head;

		while((temp != null) && (temp.data != val)) temp = temp.next;

		if (temp == null) return null;
		else return temp;
	}

	//delete all data equal to val
	public static linkedlist deleteByKey(linkedlist list, int val) {
		//get rid if first element
		while((list.head != null) && (list.head.data == val)) {
			list.head = list.head.next;
		}

		// delete non start keys
		Node prev = null, curr = list.head;	

		while (curr != null) {
			if(curr.data == val) {
				prev.next = curr.next;
				curr = curr.next;
				
			} else {
				prev = curr;
				curr = curr.next;
			}
		}

		return list;
	}


	public static void printList(linkedlist list) {
		Node temp = list.head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		linkedlist list = new linkedlist();
		int var = 3;
		list = addLast(list,3);
		list = addLast(list,3);
		list = addLast(list,1);
		list = addLast(list,8);
		list = addLast(list,2);
		list = addLast(list,3);
		list = addLast(list,6);
		list = addLast(list,23);
		list = addLast(list,3);


//		list = addFirst(list,3);
//		list = addFirst(list,1);
//		list = addFirstlist,8);
//		list = addFirstlist,2);
//		list = addFirstlist,6);
//		list = addFirstlist,23);
		list = deleteByKey(list,3);
		Node searchTest = Search(list,var);


		printList(list);
		if (searchTest == null) System.out.println(var + " is not in list");
		else System.out.println(searchTest.data + " is in the list");

	}


}
