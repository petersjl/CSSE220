package sll;

/**
 * This class provides a basic implementation of a singly linked list. It's
 * motivated by the implementation in Big Java, 5e, ch. 16.1.
 * 
 * @author TODO <YOUR_NAME> on <DATE>.
 */
public class SinglyLinkedList implements ILinkedList {

	/**
	 * Note that in addition to a head (first) pointer
	 * this list contains a last pointer.  Be sure to
	 * BOTH first and last up to date in all your code.
	 */
	private ListNode first;
	private ListNode last;

	/**
	 * These are needed for the test code.
	 */
	@Override
	public IListNode getFirst() {
		return first;
	}

	@Override
	public IListNode getLast() {
		return last;
	}
	
	@Override
	public void setFirst(IListNode first){
		this.first = (ListNode) first;
	}
	
	@Override
	public void setLast(IListNode last){
		this.last = (ListNode) last;
	}
	
	/**
	 * Constructs a new, empty linked list.
	 */
	public SinglyLinkedList() {
		this.first = null;
		this.last = null;
	}
	

	@Override
	public String toString() {
		if (this.first == null) {
			return "[]";
		}
		String result = "[";
		ListNode current = this.first;
		//while (current != this.last) {
		while (current.next != null) {
			result += (current.element + ", ");
			current = current.next;
		}
		result += current.element + "] first=["+this.first.getElement()+"] last=["+this.last.getElement()+"]";
		return result;
	}
	
	/**
	 *  WARNING: add(Integer element) must be completed before OTHER tests can pass!
	 *  
	 * 	Make sure to complete this method FIRST before trying the other ones.
	 *  
	 *  This method should add the given element to the end of this list.
	 */
	@Override
	public void add(Integer element) {
		if(first == null) {
			ListNode node = new ListNode(element, null);
			this.first = node;
			this.last = node;
		}
		else {
			ListNode node = new ListNode(element, null);
			this.last.next = node;
			this.last = node;
		}
	}

	
	/**
	 * WARNING: add(Integer element) must be completed before this test can pass!
	 * 
	 *  This method should return the number of elements in the list.
	 */
	@Override
	public Integer size() {
		if(this.first == null) {
			return 0;
		}
		else if(this.first.next == null) {
			return 1;
		}
		else {
			ListNode current = this.first;
			int count = 1;
			while(current.next != null) {
				count++;
				current = current.next; 
			}
			return count;
		}
	}
	
	
	/**
	 *  This method should insert the given element at the given index in the list.
	 *  This DOES NOT replace the element at an index, but inserts an element. 
	 *   
	 *  If you are passed an invalid index you should throw an IndexOutOfBoundsException.
     *  
     *  Note that this inserts a value at the specific index NOT a value.
     *  Please also note that it is LEGAL to insert at the END of the list.
     *  
     *  Examples:
     *  [2, 6]          ->    insertAtIndex(1, 7)    ->   [2, 7, 6]
     *  [2, 7, 6]       ->    insertAtIndex(0, 8)    ->   [8, 2, 7, 6]
     *  [8, 2, 7, 6]    ->    insertAtIndex(4, 9)    ->   [8, 2, 7, 6, 9]
     *   ^  ^  ^  ^  ^
     *   |  |  |  |  |
     *   0  1  2  3  4 <- indices 
	 */
	@Override
	public void insertAtIndex(int index, Integer element) throws IndexOutOfBoundsException {
		if(index > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		else if(index == 0 && first == null) {
			ListNode node = new ListNode(element, this.first);
			this.first = node;
			this.last = node;
		}
		else if(index == 0){
			ListNode node = new ListNode(element, this.first);
			this.first = node;
		}
		else if(index == this.size()) {
			this.add(element);
		}
		else {
			int in = 0;
			ListNode current = this.first;
			while(in < index-1) {
				in++;
				current = current.next;
			}
			ListNode node = new ListNode(element,current.next);
			current.next = node;
		}
		
	}
	
	
	/**
	 * 	This method should return true if the list contains the given element
	 *  and false if it does not.
	 * 
	 */
	@Override
	public boolean contains(Integer element) {
		if(this.first == null) {
			return false;
		}
		else{
			ListNode current = this.first;
			while(current.next != null) {
				if(current.element == element) {
					return true;
				}
				current = current.next;
			}
			if(current.element == element) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 *  This method should attempt to remove the FIRST occurrence of the
	 *  given element in the list.
	 *  
	 *  If the element is found and removed, return true
	 *  otherwise if the element is not found, then return false.
	 */
	@Override
	public boolean remove(Integer element) {
		if(first == null) {
			return false;
		}
		else if(this.first.next == null && this.first.element == element) {
			this.first = null;
			this.last = null;
			return true;
		}
		else if(this.first.next == null && this.first.element != element) {
			return false;
		}
		else if(first.element == element) {
			first = first.next;
			return true;
		}
		else {
			ListNode current = this.first.next;
			ListNode prev = this.first;
			while(current.next != null) {
				if(current.element == element) {
					prev.next = current.next;
					return true;
				}
				prev = current;
				current = current.next;
			}
			if(current.element == element) {
				prev.next = current.next;
				last = prev;
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 *  This method should return the index of the FIRST occurrence of the 
	 *  given element, OR -1 if the element is not found in the list.
	 * 
	 */
	@Override
	public int indexOf(Integer element) {
		if(!this.contains(element)) {
			return -1;
		}
		else {
			ListNode current = first;
			int index = 0;
			while(current.next != null) {
				if(current.element == element) {
					return index;
				}
				index++;
				current = current.next;
			}
			if(current.element == element) {
				return index;
			}
		}
		return -1;
	}

	
	/**
	 * Replaces the element at the given index with the new element.
	 * RETURNS the OLD element.
	 * 
	 * The method should throw an IndexOutOfBoundsException if an invalid index is 
	 * provided.
	 */
	@Override
	public Integer set(int index, Integer element) throws IndexOutOfBoundsException {
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(this.size() == 0) {
			throw new IndexOutOfBoundsException();
		}
		if(index > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		else if(index == 0){
			int old = first.element;
			first.element = element;
			return old;
		}
		else {
			int ind = 0;
			ListNode current = first;
			while(ind < index) {
				ind++;
				current = current.next;
			}
			int old = current.element;
			current.element = element;
			return old;
		}
	}
}
