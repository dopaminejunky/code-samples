//----------------------------bintree.h-----------------------------
// Roger Robertson : CSS502
// Created: 21 Jan 2019
// Last Modified: 31 Jan 2019
// -----------------------------------------------------------------
// A binary search tree and associated functions including height
// calculation and reading data into an array
// -----------------------------------------------------------------


#ifndef BINTREE_H_
#define BINTREE_H_
#include "nodedata.h"
class BinTree {				// you add class/method comments and assumptions

friend ostream& operator<<(ostream& out, const BinTree& tree);

public:
	BinTree();								// constructor
	BinTree(const BinTree &) noexcept;				// copy constructor
	~BinTree();								// destructor, calls makeEmpty	
	bool isEmpty() const;					// true if tree is empty, otherwise false
	void makeEmpty();						// make the tree empty so isEmpty returns true
	BinTree& operator=(const BinTree &);
	bool operator==(const BinTree &) const;
	bool operator!=(const BinTree &) const;
	bool insert(NodeData* node);
	bool retrieve(const NodeData& data , NodeData *& pointer);
	void displaySideways() const;			// provided below, displays the tree sideways
    int getHeight(const NodeData& data);
    void bstreeToArray(NodeData* []);
    void arrayToBSTree(NodeData* []);	

private:
	struct Node {
		NodeData* data;						// pointer to data object
		Node* left;							// left subtree pointer
		Node* right;						// right subtree pointer
	};
	Node* root;								// root of the tree
	
    // utility functions
    void inorderHelper(Node* const& node) const;
    void sideways(Node*, int) const;			// provided below, helper for displaySideways()
	Node* copyHelper(const Node *node);
    bool insert(NodeData*, Node*& node);
	bool retrieve(const NodeData& data, NodeData*& pointer, Node* node);
	void deleteHelper(Node*& node);
	void arrayHelper(Node* const& node, NodeData* array[], int* count);
	Node* treeHelper(Node*& node, NodeData* array[], int start, int end);
	int getTreeHeight(Node* node, int height);
	int getNodeHeight(Node* node, const NodeData& data, int height);

};
#endif // !BINTREE_H_
