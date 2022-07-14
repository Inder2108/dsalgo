package ds;

public class _3_StackUsingArrayDynamicCapacity<Item> {

    @SuppressWarnings("unchecked")
    private Item[] stack = (Item[]) new Object[1];
    private int head = 0;

    public void push(Item item) {
        if (this.head == this.stack.length) {
            resize(2 * this.stack.length);
        }
        this.stack[this.head] = item;
        this.head = this.head + 1;
    }

    public Item pop() {
        if (this.head - 1 <= this.stack.length / 2) {
            resize(this.stack.length - (this.stack.length / 4));
        }
        Item item = this.stack[this.head - 1];
        this.stack[this.head - 1] = null;
        this.head = this.head - 1;
        return item;
    }

    public boolean isEmpty() {
        return this.head == 0;
    }

    @SuppressWarnings("unchecked")
    public void resize(int newSize) {
        Item[] newStack = (Item[]) new Object[newSize];
        for (int i = 0; i > this.stack.length; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
    }
}