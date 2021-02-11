package DataStructures.tree;

/**
 *
 *                   a
 *                  / \
 *                 b   g
 *                / \
 *               c   d
 *              /
 *             e
 *              \
 *               f
 *
 * Pre-Order - Root is visited first, then left, then right subtree. A -> B -> C -> E -> F -> D -> G
 * Post-Order - Root is visited last, left then right then root. F -> E -> C -> D -> B -> G -> A
 * In-order Traversal - Left subtree is visited first, then the root and later the right sub-tree. E -> F -> C -> B -> D -> A -> G
 */
public class TreeTraversal {
    public static void main(String[] args) {
        Node node = generateNode();
        System.out.println("===========Pre order traversal - Always go to the root node first. root, left, right ==========");
        preOrderTraversal(node);
        System.out.println("===========Post order traversal - Always go to the root node last. left, right, root ==========");
        postOrderTraversal(node);
        System.out.println("===========Post order traversal - Always go left first. left, root, right==========");
        inOrderTraversal(node);
    }

    public static void preOrderTraversal(Node n){
        if(n == null){
            return;
        }
        System.out.println(n.value + " ");
        preOrderTraversal(n.left);
        preOrderTraversal(n.right);
    }

    public static void postOrderTraversal(Node n){
        if(n == null){
            return;
        }

        postOrderTraversal(n.left);
        postOrderTraversal(n.right);
        System.out.println(n.value + " ");
    }

    public static void inOrderTraversal(Node n){
        if(n == null){
            return;
        }

        inOrderTraversal(n.left);
        System.out.println(n.value + " ");
        inOrderTraversal(n.right);
    }

    public static Node generateNode(){
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");

        a.left = b;
        a.right = g;

        b.left = c;
        b.right = d;

        c.left = e;

        e.right = f;

        return a;
    }
}
