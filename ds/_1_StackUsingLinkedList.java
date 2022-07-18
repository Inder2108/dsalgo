package ds;

import java.util.Iterator;

/*
 * Push and Pop are always at the begining of the List
 * Performance: This ensures constant time in worst case
*/
public class _1_StackUsingLinkedList<Item> implements Iterable<Item> {

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

    public Iterator<Item> iterator () {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext () {
            return this.current != null;
        }

        public Item next () {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main (String[] args) {
        _1_StackUsingLinkedList<String> linkedList = new _1_StackUsingLinkedList<String>();
        linkedList.push("This");
        linkedList.push("is");
        linkedList.push("a");
        linkedList.push("Linked");
        linkedList.push("List");
        linkedList.pop();

        for (String linkedListItem : linkedList) {
            System.out.println(linkedListItem);
        }
    }

}