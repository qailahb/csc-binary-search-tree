/** Binary Search Tree Class
 *  Sorts through entries of text files and places into a binary tree structure
 *  Compiled from existing binary search trees on the internet
 */

public class BinarySearchTree {
    /** Class containing chidren of current node and key value */
    public class Node {
       
        public Account data;
        public Node left;
        public Node right;

        public Node(Account data) {
            this.data = data;
            /** Declare children nodes null initially */
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    /** Method searching for existing data in tree */
    public Account fetch(String username) {
        return fetch(this.root, username);
    }
    
    private Account fetch(Node root, String username) {
        if (root == null) {
            return null;
        } 

        int compareResult = root.data.getAccount().compareTo(username);

        if (compareResult == 0) {
            return root.data;
        } 
        else if (compareResult > 0)  {
            return fetch(root.left, username);
        }

        return fetch(root.right, username);
    }


    /** Method to insert new data into tree */
    public void insert(Account newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, Account newData) {
        if (root == null) {
            root = new Node(newData);
            return root;
        }
        else {

            int compareResult = root.data.compareTo(newData);

            if (compareResult > 0) {
                root.left = insert(root.left, newData);
            } 
            else {
                root.right = insert(root.right, newData);
            }
        }

        return root;
    }


    /** Method to delete data from tree */
    public void delete(String username) {
        root = delete(root, username);
    }

    private Node delete(Node root, String username) {
        if (root==null) {
            return root;
        }

        int compareResult = root.data.getAccount().compareTo(username);

        if (compareResult > 0) {
            root.right = delete(root.right, username);
        }
        else if (compareResult < 0) {
            root.left = delete(root.left, username);
        }
        else {
            if (root.left==null) {
                return root.right;
            }
            else if (root.right==null) {
                return root.left;
            }

            root.data = minimumValue(root.right);
            root.right = delete(root.right, root.data.getAccount());
        }
        return root;
    }
    /** Method returning the minimum of a node's children
     *  Used when deleting a node, and replacing it is necessary
     */
    private Account minimumValue(Node root) {
        Account minValue = root.data;

        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }

        return minValue;
    }
    

    /** Inorder traversal, recurring through left and then right node and printing the data of the node */
    public void inOrder() {
        inOrder(root);
        
        System.out.println();
    }

    public void inOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inOrder(root.left);
            inOrder(root.right);
        }
        return;
    }
}