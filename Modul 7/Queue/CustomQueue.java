public class CustomQueue {
    private Node head, tail;
    private int size = 0;

    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail != null) tail.next = n;
        tail = n;
        if (head == null) head = tail;
        size++;
    }

    public int dequeue() {
        if (head == null)
            throw new RuntimeException("Queue is empty.");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Custom Queue: ");
        Node command = head;
        while (command != null){
            System.out.print(command.data);
            if(command.next != null)
                System.out.print(", ");
            command = command.next;
        }
        System.out.println();
    }

    public void peek(){
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Head of Queue: " + head.data);
        return;
    }

    public static void main(String[] args){
        CustomQueue queue = new CustomQueue();
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);

        queue.dequeue();
        queue.enqueue(35);
        queue.enqueue(45);
        queue.print();
        queue.peek();
    }
}
