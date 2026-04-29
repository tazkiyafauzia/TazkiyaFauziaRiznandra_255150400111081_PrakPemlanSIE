public class BinaryTree {
    Node root;

    public void add(String data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        root.add(data);
    }

    public void preTraverse(Node node) {
        if (node == null) return;
        System.out.printf("[%s]", node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void inTraverse(Node node) {
        if (node == null) return;
        inTraverse(node.left);
        System.out.printf("[%s]", node.data);
        inTraverse(node.right);
    }

    public void postTraverse(Node node) {
        if (node == null) return;
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.printf("[%s]", node.data);
    }

    public void levelTraverse(Node node) {
        if (node == null) return;
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.printf("[%s]", current.data);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public int countNodes(Node node){
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeafs(Node node){
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeafs(node.left) + countLeafs(node.right);
    }

    public int height(Node node){
        if (node == null) return 0;
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();

        String[] data = {"satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas", "duabelas", "tigabelas", "empatbelas", "limabelas", "enambelas", "tujuhbelas", "delapanbelas", "sembilanbelas", "duapuluh", "duasatu", "duadua", "duatiga", "duaempat", "dualima", "duaenam", "duatujuh", "duadelapan", "duasembilan", "tigapuluh"};

        java.util.Random rng = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            String nilai = data[rng.nextInt(data.length)];
            System.out.printf("Nilai %s dimasukkan.\n", nilai);
            tree.add(nilai);
        }

        System.out.print("Pre-order: ");
    tree.preTraverse(tree.root);
        System.out.println();

        System.out.print("In-order: ");
        tree.inTraverse(tree.root);
        System.out.println();

        System.out.print("Post-order: ");
        tree.postTraverse(tree.root);
        System.out.println();

        System.out.print("Level-order: ");
        tree.levelTraverse(tree.root);
        System.out.println();

        System.out.println("Jumlah node: " + tree.countNodes(tree.root));

        System.out.println("Jumlah Leaf: " + tree.countLeafs(tree.root));

        System.out.println("Tinggi tree: " + tree.height(tree.root));
    }
}
