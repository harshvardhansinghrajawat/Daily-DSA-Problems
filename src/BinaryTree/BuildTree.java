package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    // In this code we have -
    // Build Tree
    // Tree Traversal => preorder, inorder, postorder, levelorder

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

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if (nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        //PREORDER TRAVERSAL O(n)
        public static void preorder(Node root){
            if (root == null) return;
            System.out.print(root.data + " "); //root
            preorder(root.left);               //left
            preorder(root.right);              //right
        }

        //INORDER TRAVERSAL O(n)
        public static void inorder(Node root){
            if (root == null) return;
            inorder(root.left);                //left
            System.out.print(root.data + " "); //root
            inorder(root.right);               //right
        }

        //POSTORDER TRAVERSAL O(n)
        public static void postorder(Node root){
            if (root == null) return;
            postorder(root.left);              //left
            postorder(root.right);             //right
            System.out.print(root.data + " "); //root
        }

        //LEVELORDER TRAVERSAL O(n)
        public static void levelorder(Node root){
            if (root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Node currNode = q.remove();
                if (currNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+ " ");
                    if (currNode.left != null){
                        q.add(currNode.left);
                    }
                    if (currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }


    
    public static void main(String[] args) {
        //int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int nodes[] = {1,2,4,-1,-1,5,6,7,-1,-1,-1,-1,3,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        //preorder traversal
        tree.preorder(root);

        System.out.println();

        //inorder traversal
        tree.inorder(root);

        System.out.println();

        //postorder traversal
        tree.postorder(root);

        System.out.println();

        //postorder traversal
        tree.levelorder(root);

    }
}
