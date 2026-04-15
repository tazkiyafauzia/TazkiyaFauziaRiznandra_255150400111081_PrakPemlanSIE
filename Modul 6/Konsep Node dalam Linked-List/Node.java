public class Node {
    Objects data;
    Node next;

    public static void main(String[] args) {
        Node node = new Node();
        node.data = "A";

        System.out.println("node    : " + node);
        System.out.println("data    : " + node.data);     
        System.out.println("pointer : " + node.next);
    }
}
