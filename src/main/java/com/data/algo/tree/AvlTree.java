package com.data.algo.tree;

class SBTNode{

    int data, height;
    SBTNode left, right;

    SBTNode(int data){
        this.data = data;
        height = 1;
    }
}

// Self Balancing Tree
public class AvlTree {

    SBTNode root;

    private int height(SBTNode node){
        return node == null ? 0 : node.height;
    }

    int max(int a, int b){
        return ( a > b ) ? a : b;
    }

    private SBTNode leftRotate(SBTNode x){

        /*          x
                       \
                        y
                          \
                            z
        * */

        SBTNode y = x.right; // this is y
        SBTNode T2 = y.left; // null

        y.left = x;
        x.right = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        /*
                        y
                      /    \
                     x       z
        * */

        return y;

    }

    private SBTNode rightRotate(SBTNode x){
        /*          x ( 2 )
                  /
                 y ( 1 )
                /
               z ( 1 )
        * */
        SBTNode y = x.left;
        SBTNode T2 = y.right;

        y.right = x;
        x.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return y;
    }

    int getBalance(SBTNode node){
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    SBTNode insert(SBTNode node, int key){
        if(node == null) return new SBTNode(key);

        if(key < node.data){
            node.left = insert(node.left, key);
        }else if(key > node.data){
            node.right = insert(node.right, key);
        }else{
            return node;
        }

        node.height = max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // LL CASE
        if(balance > 1 &&  key < node.left.data){
            return rightRotate(node);
        }

        //  RR CASE
        if(balance < -1 &&  key > node.right.data){
            return leftRotate(node);
        }

        // LR CASE
        if(balance > 1 && key > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL CASE
        if(balance < -1 &&  key < node.right.data){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    SBTNode search(SBTNode node, int key){
        if(node == null) return null;
        if(key < node.data){
            return search(node.left, key);
        }
        return search(node.right, key);
    }
}
