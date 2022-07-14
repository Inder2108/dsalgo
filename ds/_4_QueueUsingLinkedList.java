package ds;

/*
 * enque and deque are always at the begining of the List
 * Performance: This ensures constant time in worst case
*/
public class _4_QueueUsingLinkedList<Item> {

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
}