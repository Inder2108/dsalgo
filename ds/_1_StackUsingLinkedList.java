package ds;

/*
 * Push and Pop are always at the begining of the List
 * Performance: This ensures constant time in worst case
*/
public class _1_StackUsingLinkedList<Item> {

    private class Node {
        Item item;
        Node next;
    };

    private Node head = null;

    public void push(Item item) {
        Node oldHead = this.head;
        this.head = new Node();
        this.head.item = item;
        this.head.next = oldHead;
    }

    public Item pop() {
        Item item = this.head.item;
        this.head = this.head.next; 
        return item;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}