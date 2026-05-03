class BinarySearchTree {
    // Root of the BST
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // --- Public Insert Method ---
    // Calls the recursive insert method
    void insert(int key) {
        root = insertRec(root, key);
    }

    // --- Recursive Insert Method ---
    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* Return the unchanged node pointer */
        return root;
    }

    // --- Public Traversal Method (In-Order) ---
    // Calls the recursive inOrder method
    void inOrder() {
        inOrderRec(root);
    }

    // --- Recursive In-Order Traversal ---
    // A recursive function to perform in-order traversal
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    // get the tree in it's original structure: root, left nodes, then right nodes
    void preOrder() {
        preOrderRec(root);
    }

    void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " "); // Print the root
            preOrderRec(root.left);          // Traverse left
            preOrderRec(root.right);         // Traverse right
        }
    }

}

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BST_Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Inserting the following elements: 50, 30, 20, 40, 70, 60, 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(15);
        tree.insert(37);
        tree.insert(85);
        tree.insert(59);

        // Print in-order traversal of the BST (should be sorted)
        System.out.println("In-order traversal of the constructed BST is:");
        tree.inOrder();
        // Expected Output: 20 30 40 50 60 70 80

        System.out.println();
        System.out.println("The order of the tree structure is: ");
        tree.preOrder();


    }
}
