public class DoubleLinkedList {
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
            head.prev = data;
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
            data.prev = tail;
            tail = data;
    }
        size++;
    }

    void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void printReverse() {
        Node current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
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
        if(index < size / 2) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
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
            else {
                head.prev = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.prev.next = node.next;
            if (node == tail) {
                tail = node.prev;
            } else {
                node.next.prev = node.prev;
            }
        }
        size--;
        System.out.println("Deleted node: " + node.data);
        return;
    }

    void deleteByValue (String value){
        Node node = head;
        while (node != null) {
            if(node.data.equals(value)) {
                if (node == head) {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    } else {
                        head.prev = null;
                    }
                } else {
                    node.prev.next = node.next;
                    if (node == tail) {
                        tail = node.prev;
                    } else {
                        node.next.prev = node.prev;
                    }
                }
                size--;
                System.out.println("Deleted node: " + node.data);
                return;
            }
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
            data.prev = prevNode;
            prevNode.next.prev = data;
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
                data.prev = node;
                if (node == tail) {
                    tail = data;
                } else {
                    node.next.prev = data;
                }
                node.next = data;
                size++;
                System.out.println("Node " + data.data + " added after node " + value);
                return; 
            }
            node = node.next;
        }
        System.out.println("Node " + value + " not found. Node " + data.data + " not added.");
    }

    void addBeforeValue (String value, Node data) {
        Node node = head;
        while (node != null) {
            if(node.data.equals(value)) {
                data.next = node;
                data.prev = node.prev;
                if (node == head) {
                    head = data;
                } else {
                    node.prev.next = data;
                }
                node.prev = data;
                size++;
                System.out.println("Node " + data.data + " added before node " + value);
                return; 
            }
            node = node.next;
        }
        System.out.println("Node " + value + " not found. Node " + data.data + " not added.");
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B"); 
        Node nodeC = new Node("C"); 

        list.addLast(nodeA);
        System.out.println("head : " + list.head.data);
        System.out.println("tail : " + list.tail.data);

        list.addLast(nodeB);
        System.out.println("head : " + list.head.data);
        System.out.println("tail : " + list.tail.data);

        list.addLast(nodeC);
        System.out.println("head : " + list.head.data);
        System.out.println("tail : " + list.tail.data);

        list.print();

        System.out.println("Next of B " + nodeB.next.data);
        System.out.println("Prev of B " + nodeB.prev.data);

        list.printReverse();

        list.findByValue("B");

        list.findByIndex(1);

        list.deleteByIndex(1);

        list.deleteByValue("C");

        list.addByIndex(1, new Node("D"));

        list.addAfterValue("A", new Node("E"));

        list.addBeforeValue("E", new Node("F"));
    }

}
