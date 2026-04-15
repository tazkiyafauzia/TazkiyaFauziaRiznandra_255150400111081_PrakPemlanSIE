public class SingleLinkedList {
    Node head, tail;
    int size = 0;

    void init() { head = null; }

    boolean isEmpty() { return size == 0; }
    
    int size() { return size; }

    void addFirst(Node data) {
        if (isEmpty()) {
            head = data;
            tail = data;
        } else {
            data.next = head;
            head = data;
        }
        size++;
    }

    void addLast(Node data) {
        if (isEmpty()) {
        head = data;
        tail = data;
        } else {
            tail.next = data;
            tail = data;
        }
        size++;
    }

    Node findByValue (String value){
        Node node = head;
        int index = 0;
        while (node != null) {
            if(node.data.equals(value)) {
                System.out.println("Node " + value + " found in index: " + index);
                return node;
            }
            index++;
            node = node.next;
        }
        System.out.println("Node " + value + " not found");
        return null;
    }

    Node findByIndex (int index){
        if (index < 0 || index >= size) {
            System.out.println("Index " + index + " out of bounds");
            return null;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        System.out.println("Node found at index " + index + ": " + node.data);
        return node;
    }

    void deleteByIndex (int index){
        if (index < 0 || index >= size) {
            System.out.println("Index " + index + " out of bounds");
            return;
        }
        Node node = head;
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node prevNode = null;
            for (int i = 0; i < index; i++) {
                prevNode = node;
                node = node.next;
            }
            prevNode.next = node.next;
            if (node == tail) {
                tail = prevNode;
            }
        }
        size--;
        System.out.println("Deleted node: " + node.data);
        return;
    }

    void deleteByValue (String value){
        Node node = head;
        Node prevNode = null;
        while (node != null) {
            if(node.data.equals(value)) {
                if (prevNode == null) {
                    head = head.next;
                } else {
                    prevNode.next = node.next;
                    if (node == tail) {
                        tail = prevNode;
                    }
                }
                size--;
                System.out.println("Deleted node: " + node.data);
                return;
            }
            prevNode = node;
            node = node.next;
        }
        System.out.println("Node " + value + " not found");
        return;    
    }

    void addByIndex (int index, Node data) {
        if (index < 0 || index > size) {
            System.out.println("Index " + index + " out of bounds");
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node prevNode = head;
            for (int i = 0; i < index - 1; i++) {
                prevNode = prevNode.next;
            }
            data.next = prevNode.next;
            prevNode.next = data;
            size++;
        }
        System.out.println("Node " + data.data + " added at index " + index);
    }

    void addAfterValue (String value, Node data) {
        Node node = head;
        while (node != null) {
            if(node.data.equals(value)) {
                data.next = node.next;
                node.next = data;
                if (node == tail) {
                    tail = data;
                }
                size++;
                System.out.println("Node " + data.data + " added after node " + value);
                return;
            }
            node = node.next;
        }
        System.out.println("Node " + value + " not found. Node " + data.data + " not added.");
    }

    void addBeforeValue (String value, Node data) {
        if (head == null) {
            System.out.println("List is empty. Node " + data.data + " not added.");
            return;
        }
        if (head.data.equals(value)) {
            addFirst(data);
            System.out.println("Node " + data.data + " added before node " + value);
            return;
        }
        Node prevNode = null;
        Node node = head;
        while (node != null) {
            if(node.data.equals(value)) {
                data.next = node;
                if (prevNode != null) {
                    prevNode.next = data;
                }
                size++;
                System.out.println("Node " + data.data + " added before node " + value);
                return;
            }
            prevNode = node;
            node = node.next;
        }
        System.out.println("Node " + value + " not found. Node " + data.data + " not added.");
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();

        System.out.println("Head: " + list.head);
        System.out.println("Tail: " + list.tail);

        list.addFirst(new Node("A"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addFirst(new Node("B"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);

        list.addLast(new Node("C"));
        System.out.println("Head: " + list.head.data);
        System.out.println("Tail: " + list.tail.data);   

        list.findByValue("B");

        list.findByIndex(1);

        list.deleteByIndex(1);

        list.deleteByValue("C");

        list.addByIndex(1, new Node("D"));

        list.addAfterValue("B", new Node("E"));

        list.addBeforeValue("E", new Node("F"));

    }

}
