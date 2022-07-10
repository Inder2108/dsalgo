package datastructures;

public class _2_StackUsingArrayWithFixedCapacity {

    private String[] stack;
    private int head = 0;

    public _2_StackUsingArrayWithFixedCapacity(int capacity) {
        this.stack = new String[capacity];
    }

    public void push(String item) {
        this.stack[this.head] = item;
        this.head = this.head + 1;
    }

    public String pop() {
        String item = this.stack[this.head - 1];
        this.stack[this.head - 1] = null;
        this.head = this.head - 1;
        return item;
    }

    public boolean isEmpty() {
        return this.head == 0;
    }
}