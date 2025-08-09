package com.data.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNode{

    int data;
    BinaryTreeNode left, right;

    BinaryTreeNode(int data){
        this.data = data;
        left = right = null;
    }
}

public class BinaryTree {

    BinaryTreeNode root;

    // Inorder Traversal (Left → Root → Right)
    void inOrder(BinaryTreeNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Preorder Traversal (Root → Left  → Right)
    void preOrder(BinaryTreeNode node){
        if(node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Postorder Traversal (Left → Right → Root )
    void postOrder(BinaryTreeNode node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Search method (DFS)
    boolean search(BinaryTreeNode root, int data){
        if(root == null) return false;
        if(root.data == data){
            return true;
        }
        return search(root.left, data) || search(root.right, data);
    }

    // Insertion ( level order insertion )
    void insert(int data){
        if(root == null){
            root = new BinaryTreeNode(data);
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            BinaryTreeNode node = queue.poll();

            if(node.left == null){
                node.left = new BinaryTreeNode(data);
                break;
            }else{
                queue.add(node.left);
            }

            if(node.right == null){
                node.right = new BinaryTreeNode(data);
                break;
            } else {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // Insert nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);

        System.out.println("INORDER: ");
        tree.inOrder(tree.root);

        System.out.println("\nPREORDER: ");
        tree.preOrder(tree.root);

        System.out.println("\nPOSTORDER: ");
        tree.postOrder(tree.root);

    }

}
