// Binary Search Tree Class

public class BinarySearchTree {

    public class Node {
       
        public Account data;
        public Node left;
        public Node right;

        public Node(Account data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // Method to search for existing data
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


    // Method to insert new Data
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


    // Method to delete data
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

    private Account minimumValue(Node root) {
        Account minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
    

    // Traversal
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


    public static void main(String[] args) {};

    // public static void main(String[] args) {
    //     // Creating the object of BinarySearchTree class
    //     BinarySearchTree bst = new BinarySearchTree();
    //     // call the method insert
    //     bst.insert(8);
    //     bst.insert(5);
    //     bst.insert(9);
    //     bst.insert(3);
    //     bst.insert(7);
    //     bst.inOrder();
    //     System.out.println(bst.search(7));
        
    // }
}