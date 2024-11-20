package BinaryTree;

public class DiameterOfTree {
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

    public static int height(Node root){
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh) + 1;
    }

    //APPOURCH 1
    public static int diameterOfTree(Node root){ //O(N^2)
        if (root == null) return 0;

        int leftD = diameterOfTree(root.left);
        int leftH = height(root.left);
        int rightD = diameterOfTree(root.right);
        int rightH = height(root.right);

        int selfD = leftH + rightH + 1;

        return Math.max(selfD, Math.max(leftD,rightD));
    }

    static class Info{
        int diam;
        int ht;

        public Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    //APPOURCH 2
    public static Info diameter(Node root){//O(N)
        if (root == null){
            return new Info(0,0);
        }
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
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

        System.out.println(diameterOfTree(root));
        System.out.println(diameter(root).diam);

    }
}
