package ds;

public class _5_QueueUsingArrayWithFixedCapacity {

    private String[] queue;
    private int tail = 0;

    public _5_QueueUsingArrayWithFixedCapacity (int capacity) {
        this.queue = new String[capacity];
    }

    public void enqueue (String item) {
        this.queue[this.tail] = item;
        this.tail = this.tail + 1;
    }

    public String dequeue () {
        String item = this.queue[0];
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
            data = data + this.queue[i] + ", ";
        }
        return data;
    }

    public static void main (String args[]) {
        _5_QueueUsingArrayWithFixedCapacity queue = new _5_QueueUsingArrayWithFixedCapacity(4);
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