package BinaryTree;

public class CountNodeOfTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //COUNT THE NO. OF NODES IN A TREE  O(n)
    public static int nodesInTree(Node root){
        if (root == null) return 0;
        int lNodes = nodesInTree(root.left);
        int rNodes = nodesInTree(root.right);
        return (lNodes + rNodes + 1);
    }
    public static void main(String[] args) {
        /*
                    1            level 1
                   / \
                  2   3          level 2
                 / \ / \
                4  5 6  7        level 3
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("No. of nodes in a tree = " + nodesInTree(root));
    }
}
