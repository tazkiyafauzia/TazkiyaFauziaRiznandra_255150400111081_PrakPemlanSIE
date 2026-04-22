public class CustomStack {
    Node top;
    int size = 0;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
        size++;
    }

    public int pop() {
        if (top == null)
        throw new RuntimeException("Stack is empty.");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    public static void main(String[] args){
        CustomStack custom = new CustomStack();
        custom.push(1);
        custom.push(2);
        custom.push(3);
        custom.push(4);
        
        CustomStack temp = new CustomStack();

        temp.push(custom.pop());
        temp.push(custom.pop());
        temp.push(custom.pop());

        custom.push(5);

        while(!temp.isEmpty()){
            custom.push(temp.pop());
        }
        
        System.out.println("First data: " + custom.peek());

        System.out.print("Custom Stack: ");
        while (!custom.isEmpty()) {
            System.out.print("[" + custom.pop() + "]");
        }
        System.out.println("End.");
        
        custom.push(5);
    }
}
