/*
 * Created on Sat Dec 01 2018
 * 
 * BST and sorts, using templates
 *
 * Copyright (c) 2018 Roger Robertson Jr
 */
#ifndef TREE_H_
#define TREE_H_
#include <iostream>
using namespace std;

// apparently necessary for proper compilation
template<class T>
class Node;

// according to the internet, implementing templated methods
// in the header file is the only 'portable' way of doing it
template<class T>
class Tree {

    public:
    Tree() { root = nullptr; }
    ~Tree() { }
    void add(T data) { add(root, data);}
    void preorder() { preorder(root); }
    void inorder() { inorder(root); }
    void postorder() { postorder(root); }

    // let's try a private internal class
    private:
    class Node {
        public:
        Node(T data) { this->data = data; } 
        ~Node() { }
        T data;
        Node* left;
        Node* right;
        int count = 1;
    };

    private:
    Node* root;

    Node* preorder(Node*& node) {
        if (node != nullptr) {
        cout << " " << node->data << " ";
        preorder(node->left);
        preorder(node->right);
        }    
    }

    Node* inorder(Node*& node) {
        if (node != nullptr) {
        preorder(node->left);
        cout << " " << node->data << " ";
        preorder(node->right);
        }
    }

    Node* postorder(Node*& node) {
        if (node != nullptr) {
        postorder(node->right);
        cout << " " << node->data << " ";
        postorder(node->left);
        }
    }

    Node* add(Node*& node, T data) {    
        // if empty tree, root becomes new node
        if (node == nullptr) {
            node =  new Node(data);
            return node;
        }
        // if root != nullptr, compare and recurse
        // if node with that data exists, increment counter
        if (data < node->data) {
            node->left = add(node->left, data);
        } else if (data > node->data) {
            node->right= add(node->right, data);
        } else if (data == node->data) {
            node->count++;
        }
        return node;
    }



};
#endif // !TREE_H_