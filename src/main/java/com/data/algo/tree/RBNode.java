package com.data.algo.tree;

import org.springframework.stereotype.Component;


class RBNode {
    int data;
    RBNode parent, left, right;
    boolean color; // true for red, false for black
    
    public RBNode(int data) {
        this.data = data;
        this.color = true; // new nodes are always red
        left = right = parent = null;
    }
}

class RedBlackTree {
    private RBNode root;
    private final RBNode NIL;
    
    public RedBlackTree() {
        NIL = new RBNode(0);
        NIL.color = false;
        root = NIL;
    }
    
    private void leftRotate(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        
        if (y.left != NIL) {
            y.left.parent = x;
        }
        
        y.parent = x.parent;
        
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        
        y.left = x;
        x.parent = y;
    }
    
    private void rightRotate(RBNode x) {
        RBNode y = x.left;
        x.left = y.right;
        
        if (y.right != NIL) {
            y.right.parent = x;
        }
        
        y.parent = x.parent;
        
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        
        y.right = x;
        x.parent = y;
    }
    
    private void fixInsert(RBNode k) {
        RBNode u;
        while (k.parent.color) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color) {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;
                if (u.color) {
                    u.color = false;
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = false;
                    k.parent.parent.color = true;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) break;
        }
        root.color = false;
    }
    
    public void insert(int key) {
        RBNode node = new RBNode(key);
        node.parent = null;
        node.left = NIL;
        node.right = NIL;
        node.color = true;
        
        RBNode y = null;
        RBNode x = this.root;
        
        while (x != NIL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        
        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }
        
        if (node.parent == null) {
            node.color = false;
            return;
        }
        
        if (node.parent.parent == null) return;
        
        fixInsert(node);
    }
    
    // Search method
    public RBNode search(RBNode root, int key) {
        if (root == NIL || key == root.data) return root;
        if (key < root.data) return search(root.left, key);
        return search(root.right, key);
    }
}