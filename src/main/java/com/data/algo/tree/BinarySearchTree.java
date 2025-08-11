package com.data.algo.tree;

class BinarySearchNode{

    int data;
    BinarySearchNode left, right;

    BinarySearchNode(int data){
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {

    BinarySearchNode root;

    private BinarySearchNode insert(BinarySearchNode node, int key){
        if(node == null) return new BinarySearchNode(key);

        if(key < node.data){
            node.left = insert(node.left, key);
        }else if(key > node.data){
            node.right = insert(node.right, key);
        }

        return node;
    }

    private boolean search(BinarySearchNode node, int key){
        if(node == null) return false;
        if(node.data == key){
            return true;
        }else if(key < node.data){
            return search(node.left, key);
        }else{
            return search(node.right, key);
        }
    }

    private BinarySearchNode delete(BinarySearchNode node, int key){
        if(node == null) return null;
        if(key < node.data){
            node.left = delete(node.left, key);
        }else if(key > node.data){
            node.right = delete(node.right, key);
        }else{
            if(node.left == null ){
                return node.right;
            }else if(node.right == null ){
                return node.left;
            }

            node.data = min(node.right);
            node.right = delete(node.right, node.data);

        }

        return node;
    }

    private int min(BinarySearchNode node){
        int min = root.data;
        while(node.left != null){
            min = node.left.data;
            node = node.left;
        }
        return min;
    }

    void printTree(BinarySearchNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
            printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    // Pretty horizontal print
    void printHorizontal(BinarySearchNode node, int space) {
        if (node == null) return;

        // Increase distance between levels
        space += 5;

        // Process right child first
        printHorizontal(node.right, space);

        // Print current node after spaces
        System.out.println();
        for (int i = 5; i < space; i++) System.out.print(" ");
        System.out.print(node.data);

        // Process left child
        printHorizontal(node.left, space);
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        int[] values = {2, 1 , 5, 7};
        for (int val : values) {
            tree.root = tree.insert(tree.root, val);
        }
//        tree.printTree(tree.root, "", false);

       BinarySearchNode node = tree.insert(tree.root, 9);

        System.out.println("Node: "+ node.data);

        tree.printHorizontal(tree.root, 0);

        System.out.println("\n"+ tree.search(tree.root, 6));
    }
}
