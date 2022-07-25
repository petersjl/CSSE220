package sll.algorithms;

import sll.ILinkedList;
import sll.IListNode;
import sll.ListNode;
import sll.SinglyLinkedList;

// TODO: complete sll.SinglyLinkedList first, then use it to complete these problems.
public class Algorithms {
	/**
	 * 
	 * Write a function that takes an array of integers and returns a linked
	 * list. The linked list should contain only the integers in the original
	 * list that begin with the number 1.
	 * 
	 * So arraylistOf1s({123,456,1, 21}) yields [123, 1]
	 */
	public static SinglyLinkedList arraylistOf1s(int[] integers) {
		SinglyLinkedList list = new SinglyLinkedList();
		for(int i: integers) {
			if(Integer.toString(i).charAt(0) == '1') {
				list.add(i);
			}
		}
		return list;
	}

	/**
	 * Takes a list of numbers in sorted (ascending) order and a number to add.
	 * 
	 * Adds the number in the correct place in the sorted list.
	 * 
	 * so insertIntoSorted([1,5,9],6) yields [1,5,6,9]
	 * 
	 */
	public static void insertIntoSorted(ILinkedList list, int number) {
		if(list.size() == 0) {
			list.add(number);
		}
		else {
			int under = number - 1;
			int low = list.getFirst().getElement();
			if(under < low) {
				list.insertAtIndex(0, number);
				return;
			}
			while(under > low && !list.contains(under)) {
				under--;
			}
			int index = list.indexOf(under);
			int indextoadd = index + 1;
			list.insertAtIndex(indextoadd, number);
			return;
		}
	}

	/**
	 * Takes a linked list and removes all numbers longer than 3 digits from the
	 * list.
	 * 
	 * So removeLongNumbers([1,1000,3,99999,999]) yields [1, 3, 999]
	 */
	public static void removeLongNumbers(ILinkedList list) {
		if(list.size() == 0) {return;}
		ListNode current = (ListNode)list.getFirst();
		while(current.next != null) {
			if(Integer.toString(current.element).length() > 3) {
				list.remove(current.element);
			}
			current = current.next;
		}
	}

	/**
	 * Returns whether the given linked list is sorted in increasing order.
	 * 
	 * So checkSorted([1,2,3]) yields true.
	 * checkSorted ([1,3,2]) yields false.
	 * checkSorted ([]) yields true.
	 */
	public static boolean checkSorted(ILinkedList list) {
		if(list.size() == 0 || list.size() == 1) {return true;}
		ListNode current = (ListNode) list.getFirst().getNext();
		ListNode prev = (ListNode) list.getFirst();
		while(current.next != null) {
			if(current.element < prev.element) {return false;}
			prev = current;
			current = current.next;
		}
		if(current.element < prev.element) {return false;}
		return true;
	}

	/**
	 * Duplicates all elements of the list.
	 * 
	 * So doubleList([1, 2, 3]) yields [1, 1, 2, 2, 3, 3].
	 */
	public static void doubleList(ILinkedList list) {
		if(list.size() == 0) {return;}
		ListNode current = (ListNode)list.getFirst();
		while(current.next != null) {
			ListNode node = new ListNode(current.element, current.next);
			current.next = node;
			current = node.next; 
		}
		ListNode node = new ListNode(current.element, current.next);
		current.next = node;
	}

	/**
	 * Returns whether the list represents a Fibonacci sequence.
	 * 
	 * Recall: fib(i) = fib(i-1) + fib(i-2)
	 * 
	 * [0,1] is too short to be a fibonacci sequence. [1,2,3] is a fibonacci
	 * sequence because 3 = 2 + 1. [0,1,1] is a fibonacci sequence because 1 = 1
	 * + 0. [1,4,5,9,14] is a fibonacci sequence.
	 */
	public static boolean isFibonacciSequence(ILinkedList list) {
		if(list.size() < 3) {return false;}
		ListNode one = (ListNode)list.getFirst();
		ListNode two = one.next;
		ListNode three = two.next;
		while(three.next != null) {
			if(one.element + two.element != three.element) {return false;}
			one = two;
			two = three;
			three = three.next;
		}
		if(one.element + two.element != three.element) {return false;}
		return true;
	}

	/**
	 * Gets the value of the ith node.
	 * 
	 * If i==0, return the value of the given node.
	 * 
	 * If you are passed an invalid index you should throw an IndexOutOfBoundsException.
	 * 
	 */
	public static Integer recursiveGet(int index, IListNode iListNode) {
		if(iListNode == null) {throw new IndexOutOfBoundsException();}
		if(index == 0) {return iListNode.getElement();}
		else {
			if(iListNode.getNext() == null) {
				throw new IndexOutOfBoundsException();
			}
			return recursiveGet(index - 1, iListNode.getNext());
		}


	}

}
