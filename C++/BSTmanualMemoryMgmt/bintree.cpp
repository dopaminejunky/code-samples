//----------------------------bintree.cpp-----------------------------
// Roger Robertson : CSS502
// Created: 21 Jan 2019
// Last Modified: 31 Jan 2019
// -----------------------------------------------------------------
// A binary search tree and associated functions including height
// calculation and reading data into an array
// -----------------------------------------------------------------

#include "bintree.h"

//-----------------Constructors and Destructor--------------------------
BinTree::BinTree() 
{
    root = nullptr;
}
// Copy constructor
BinTree::BinTree(const BinTree& otherTree) noexcept
{
    root = copyHelper(otherTree.root);
}

// Destructor
BinTree::~BinTree() 
{
    makeEmpty();
}
//---------------------------------------------------------------------

//-------------------isEmpty---------------------------------
// Returns boolean if tree is empty or not
//-------------------------------------------------------------
bool BinTree::isEmpty() const
{
    if (root != nullptr)
        return false;
    else
        return true;
}

//---------------------makeEmpty---------------------
// Empties the tree
// -------------------------------------------------
void BinTree::makeEmpty()
{
    deleteHelper(root);
    root = nullptr;
}

//-----------------operator=-------------------------------
// Assignment operator overload
// ----------------------------------------------------------
BinTree& BinTree::operator=(const BinTree& otherTree)
{
    root = otherTree.root;
    return *this;
}

//---------------operator==,operator!=----------------------------
// Equality and inequality operator overloads
// ----------------------------------------------------------------
bool BinTree::operator==(const BinTree& otherTree) const
{

    return root == otherTree.root;
}

bool BinTree::operator!=(const BinTree& otherTree) const
{
    if (*this == otherTree)
        return false;
    else
        return true;
}
//----------------------------------------------------------------------

//-------------------------insert--------------------------------------
// Public insert method
// Returns true if successfully added data, false if fails
//---------------------------------------------------------------------
bool BinTree::insert(NodeData* data)
{
    return insert(data, root);
}

//------------------------- displaySideways ---------------------------------
// Displays a binary tree as though you are viewing it from the side;
// hard coded displaying to standard output.
// Preconditions: NONE
// Postconditions: BinTree remains unchanged.
void BinTree::displaySideways() const {
	sideways(root, 0);
}

//---------------------------- Sideways -------------------------------------
// Helper method for displaySideways
// Preconditions: NONE
// Postconditions: BinTree remains unchanged.
void BinTree::sideways(Node* current, int level) const {
	if (current != nullptr) {
		level++;
		sideways(current->right, level);

		// indent for readability, 4 spaces per depth level 
		for (int i = level; i >= 0; i--) {
			cout << "    ";
		}

		cout << *current->data << endl;        // display information of object
		sideways(current->left, level);
	}
}

//---------------inorderHelper-----------------------
// Print node data from an inorder traversal
// -------------------------------------------------
void BinTree::inorderHelper(Node* const& node) const
{
    if (node != nullptr)
    {
        inorderHelper(node->left);
        cout << *node->data << " ";
        inorderHelper(node->right);
    }
    
}
//------------------copyHelper------------------------
// Private recursive helper for deep copy
// ----------------------------------------------------
BinTree::Node* BinTree::copyHelper(const Node *node)
{
    if (node == nullptr)
    {
        delete node;
        return nullptr;
    }
    else
    {
        Node* temp = new Node();
        temp->data = node->data;
        temp->left = copyHelper(node->left);
        temp->right = copyHelper(node->right);
        return temp;
    }
}

//------------------insert--------------------------
// Private recursive overload for insert
//---------------------------------------------------
bool BinTree::insert(NodeData* data, Node*& node)
{
    if (node == nullptr) 
    {
        Node* temp = new Node();
        temp->data = data;
        temp->left = nullptr;
        temp->right = nullptr;
        node = temp;
        temp = nullptr;
        delete temp;
        return true;
        
    }
    
    else
    {   if (*data < *node->data) 
        {
        insert(data, node->left);
        } 
        else if (*data > *node->data) 
        {
            insert(data, node->right);
        } 
        else if (*data == *node->data)
        {
            
            return false;
        }
        else
        {
            delete node->data;
            delete node;
            return false;
        }
    }
}

//------------------------retrieve----------------------------------
// Returns a boolean if data is present in tree
// Sets a pointer to the data if found
// -----------------------------------------------------------------
bool BinTree::retrieve(const NodeData& data, NodeData*& pointer)
{
    return retrieve(data, pointer, this->root);
}

//---------------------operator<<-------------------------------------
// Stream output; returns inorder traversal of tree
// ------------------------------------------------------------------
ostream& operator<<(ostream& out, const BinTree& tree)
{
    tree.inorderHelper(tree.root);
    out << endl;
    return out;
}

//--------------------retrieve-----------------------
// Private recursive overload for retrieve
// Returns boolean value for data's existence in tree
// Sets pointer to the value if found
// -------------------------------------------------
bool BinTree::retrieve(const NodeData& data, NodeData*& pointer, Node* node)
{
    if (node == nullptr)
        return false;
    else
    {
        if (*node->data == data)
        {
            pointer = node->data;
            return true;
        }
        else if (*node->data > data)
            retrieve(data, pointer, node->left);
        else
            retrieve(data, pointer, node->right); 
    }
}

//------------------getHeight-------------------------------
// Returns height of given node data, starting at a leaf.
// Return 0 if data is not found
// ---------------------------------------------------------
int BinTree::getHeight(const NodeData& data)
{
    return getNodeHeight(root, data, 0) - getTreeHeight(root, 0) ; 
    
}

//-----------------getTreeHeight-----------------------------
// Private recursive function to calculate height of tree
// Returns an integer for longest path from root to leaf
// ----------------------------------------------------------
int BinTree::getTreeHeight(Node* node, int height)
{
    if (node == nullptr)
        return 0;
    int level = getTreeHeight(node->left, height+1);
    if (level != 0)
        return level;
    return getTreeHeight(node->right, height+1);
}

//-------------------getNodeHeight------------------------
// Returns height of a node from the root, if found
// Returns 0 if not found
// ---------------------------------------------------------
int BinTree::getNodeHeight(Node* node, const NodeData& data, int height)
{
    if (node == nullptr)
        return 0;
    if (*node->data == data)
        return height;
    int level = getNodeHeight(node->left, data, height+1);
    if (level != 0)
        return level;
    return getNodeHeight(node->right, data, height+1);
}

//-------------bstreeToArray,arrayToBSTree--------------------
// Convert a binary tree to an array and vice versa
// ------------------------------------------------------------
void BinTree::bstreeToArray(NodeData* array[])
{
    int* count = new int(0);
    arrayHelper(root, array, count);
    delete count;
    makeEmpty();
    cout << endl;

}

void BinTree::arrayToBSTree(NodeData* array[])
{
    int count = 0;
    while (array[count] != nullptr)
    {
        count++;
    }
    treeHelper(root, array, 0, count - 1);
    for (int i = 0; i < count; i++)
        delete array[i];
    cout << endl;
}
//--------------------------------------------------------------

//----------------deleteHelper-----------------------------------
// Private recursive function to cleanly delete node data
//----------------------------------------------------------------
void BinTree::deleteHelper(Node*& node)
{
    if (node != nullptr)
    {
        deleteHelper(node->left);
        deleteHelper(node->right);
        delete node->data;
        delete node;
    }
}

//--------------------arrayHelper------------------------------
// Private recursive function to populate a given array with NodeData*
// Also prints inorder traversal to console
// --------------------------------------------------------------
void BinTree::arrayHelper(Node* const& node, NodeData* array[], int* count)
{

    if (node != nullptr)
    {
        arrayHelper(node->left, array, count);
        array[*count] = new NodeData(*node->data);
        *count = *count + 1;
        if (node->data != nullptr)
            cout << *node->data << ", ";
        arrayHelper(node->right, array, count);
    }
}

//---------------------------treeHelper------------------------------
// Private recursive function to create a balanced BST from NodeData* []
// -------------------------------------------------------------------
BinTree::Node* BinTree::treeHelper(Node*& node, NodeData* array[], int start, int end)
{
    if (start > end)
        return nullptr;
    int middle = (start + end) / 2;
    insert(new NodeData(*array[middle]));

    treeHelper(node, array, start, middle - 1);
    treeHelper(node, array, middle + 1, end);
    return node;
}
