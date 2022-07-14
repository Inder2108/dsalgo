package ds;

public class _5_QueueUsingArrayWithFixedCapacity<Item> {

    private Item[] queue;
    private int tail = 0;

    @SuppressWarnings("unchecked")
    public _5_QueueUsingArrayWithFixedCapacity (int capacity) {
        this.queue = (Item[]) new Object[capacity];
    }

    public void enqueue (Item item) {
        this.queue[this.tail] = item;
        this.tail = this.tail + 1;
    }

    public Item dequeue () {
        Item item = this.queue[0];
        this.queue[0] = null;
        for (int i = 0; i <= this.tail; i++) {
            this.queue[i] = this.queue[i + 1];
        }
        this.tail = this.tail - 1;
        return item;
    }

    public boolean isEmpty () {
        return this.tail == 0;
    }

    public String toString () {
        String data = "";
        for (int i = 0; i < this.queue.length; i++) {
            data = data + this.queue[i].toString() + ", ";
        }
        return data;
    }

    public static void main (String args[]) {
        _5_QueueUsingArrayWithFixedCapacity<String> queue = new _5_QueueUsingArrayWithFixedCapacity<String>(4);
        System.out.println(queue.isEmpty());
        queue.enqueue("One");
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue.isEmpty());
        queue.enqueue("One");
        queue.enqueue("Two");
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.dequeue();
        System.out.println(queue.toString());
        queue.enqueue("Three");
        queue.enqueue("Four");
        System.out.println(queue.toString());
    }
}