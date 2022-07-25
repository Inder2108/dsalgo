package ds;

import java.util.Iterator;

/*
 * enque and deque are always at the begining of the List
 * Performance: This ensures constant time in worst case
*/
public class _4_QueueUsingLinkedList<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    };

    private Node head = null;
    private Node tail = null;

    public void enque(Item item) {
        Node oldTail = this.tail;
        this.tail = new Node();
        this.tail.item = item;
        this.tail.next = null;

        if (isEmpty()) {
            this.head = this.tail;
        } else {
            oldTail.next = this.tail;
        }
    }

    public Item deque() {
        Item item = this.head.item;
        this.head = this.head.next;

        if (isEmpty()) {
            this.tail = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Iterator<Item> iterator () {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext () {
            return this.current != null;
        }

        public Item next () {
            Item item = this.current.item;
            this.current = this.current.next;
            return item;
        }
    }

    public static void main (String[] args) {
        _4_QueueUsingLinkedList<String> queue = new _4_QueueUsingLinkedList<String>();
        queue.enque("This");
        queue.enque("is");
        queue.enque("a");
        queue.enque("Linked");
        queue.enque("List");
        queue.deque();

        for (String item : queue) {
            System.out.println(item);
        }
    }
}