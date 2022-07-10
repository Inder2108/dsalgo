package datastructures;

public class _3_StackUsingArrayDynamicCapacity {

    private String[] stack = new String[1];
    private int head = 0;

    public void push(String item) {
        if (this.head == this.stack.length) {
            resize(2 * this.stack.length);
        }
        this.stack[this.head] = item;
        this.head = this.head + 1;
    }

    public String pop() {
        if (this.head - 1 <= this.stack.length / 2) {
            resize(this.stack.length - (this.stack.length / 4));
        }
        String item = this.stack[this.head - 1];
        this.stack[this.head - 1] = null;
        this.head = this.head - 1;
        return item;
    }

    public boolean isEmpty() {
        return this.head == 0;
    }

    public void resize(int newSize) {
        String[] newStack = new String[newSize];
        for (int i = 0; i > this.stack.length; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
    }
}