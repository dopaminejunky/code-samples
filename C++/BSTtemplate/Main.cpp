/*
 * Created on Sat Dec 01 2018
 *
 * Copyright (c) 2018 Roger Robertson Jr
 */
#include "Tree.h"

int main(int argc, char const *argv[])
{
    Tree<int>* leftUnbalanced = new Tree<int>();
    cout << "LEFT UNBALANCED" << endl;
    leftUnbalanced->add(5);
    leftUnbalanced->add(7);
    leftUnbalanced->add(4);
    leftUnbalanced->add(3);
    leftUnbalanced->add(2);
    leftUnbalanced->add(1);
    cout << "INORDER" << endl;
    leftUnbalanced->inorder();
    cout << endl;
    cout << "PREORDER" << endl;
    leftUnbalanced->preorder();
    cout << endl;
    cout << "POSTORDER" << endl;
    leftUnbalanced->postorder();
    cout << endl;
    delete leftUnbalanced;
    Tree<int>* rightUnbalanced = new Tree<int>();
    cout << "RIGHT UNBALANCED" << endl;
    rightUnbalanced->add(1);
    rightUnbalanced->add(2);
    rightUnbalanced->add(3);
    rightUnbalanced->add(4);
    rightUnbalanced->add(5);
    cout << "PREORDER" << endl;
    rightUnbalanced->preorder();
    cout << endl;
    cout << "INORDER" << endl;
    rightUnbalanced->inorder();
    cout << endl;
    cout << "POSTORDER" << endl;
    rightUnbalanced->postorder();
    cout << endl;
    delete rightUnbalanced;
    Tree<int>* balanced = new Tree<int>();
    cout << "BALANCED" << endl;
    balanced->add(50);
    balanced->add(35);
    balanced->add(77);
    balanced->add(64);
    balanced->add(22);
    balanced->add(100);
    balanced->add(10);
    cout << "PREORDER" << endl;
    balanced->preorder();
    cout << endl;
    cout << "INORDER" << endl;
    balanced->inorder();
    cout << endl;
    cout << "POSTORDER" << endl;
    balanced->postorder();
    cout << endl;
    return 0;
}
