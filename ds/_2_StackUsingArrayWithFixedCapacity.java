package ds;

public class _2_StackUsingArrayWithFixedCapacity<Item> {

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

    public static void main (String args[]) {
        _2_StackUsingArrayWithFixedCapacity<String> queue = new _2_StackUsingArrayWithFixedCapacity<String>(4);
        System.out.println(queue.isEmpty());
        queue.push("One");
        System.out.println(queue.isEmpty());
        queue.pop();
        System.out.println(queue.isEmpty());
        queue.push("One");
        queue.push("Two");
        System.out.println(queue.toString());
        queue.pop();
        System.out.println(queue.toString());
        queue.pop();
        System.out.println(queue.toString());
        queue.push("Three");
        queue.push("Four");
        System.out.println(queue.toString());
    }
}