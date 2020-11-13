/*mport edu.princeton.cs.algs4.ResizingArrayQueue;
import edu.princeton.cs.algs4.ResizingArrayStack;

public class TreeTraversal {

    static class Node {
        int key;
        Node left;
        Node right;
        Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
        Node(int key) {
            this.key = key;
        }
    }

    public static void traverseBreadthFirst(Node root) {
        ResizingArrayQueue<Node> q = new ResizingArrayQueue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node n = q.dequeue();
            StdOut.println(n.key);
            if (n.left != null) {
                q.enqueue(n.left);
            }
            if (n.right != null) {
                q.enqueue(n.right);
            }
        }
    }

    public static void traverseDepthFirst(Node root) {
        ResizingArrayStack<Node> stack = new ResizingArrayStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            StdOut.println(n.key);
            if (n.right != null) {
                stack.push(n.right);
            }            if (n.left != null) {
                stack.push(n.left);
            }
        }
    }

    public static void traversePreorder(Node root) {
        if (root != null) {
            StdOut.println(root.key);
            traversePreorder(root.left);
            traversePreorder(root.right);
        }
    }


    public static void traverseInorder(Node root) {
        if (root != null) {
            traverseInorder(root.left);
            StdOut.println(root.key);
            traverseInorder(root.right);
        }
    }
    public static void traversePostorder(Node root) {
        if (root != null) {
            traversePostorder(root.left);
            traversePostorder(root.right);
            StdOut.println(root.key);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(4,
                                // Left subtree
                                new Node(2, new Node(6), new Node(1)),
                                // Right subtree
                                new Node(5, new Node(7), new Node(3)));
        traversePostorder(root);
    }

}*/
