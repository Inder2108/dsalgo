package ds;

import java.util.Iterator;

public class _2_StackUsingArrayWithFixedCapacity<Item> implements Iterable<Item> {

    private Item[] stack;
    private int head = 0;

    @SuppressWarnings("unchecked")
    public _2_StackUsingArrayWithFixedCapacity(int capacity) {
        // Arrays do not support Generics and hence we need to add a cast to Generic Type explicitly
        this.stack = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        this.stack[this.head] = item;
        this.head = this.head + 1;
    }

    public Item pop() {
        Item item = this.stack[this.head - 1];
        this.stack[this.head - 1] = null;
        this.head = this.head - 1;
        return item;
    }

    public boolean isEmpty() {
        return this.head == 0;
    }

    public Iterator<Item> iterator () {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {
        private int current = 0;

        public boolean hasNext () {
            return stack[this.current] != null;
        }

        public Item next () {
            Item item = stack[this.current];
            current = current + 1;
            return item;
        }
    }

    public static void main (String[] args) {
        _2_StackUsingArrayWithFixedCapacity<String> stack = new _2_StackUsingArrayWithFixedCapacity<String>(4);
        stack.push("One");
        stack.pop();
        stack.push("One");
        stack.push("Two");
        stack.pop();
        stack.pop();
        stack.push("Three");
        stack.push("Four");

        for (String item : stack) {
            System.out.println(item);
        }
    }
}