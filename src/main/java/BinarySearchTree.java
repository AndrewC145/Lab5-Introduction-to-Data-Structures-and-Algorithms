/**
 * A generic Binary Search Tree (BST) implementation that supports
 * insertion, search, deletion, tree traversals, height calculation,
 * size calculation, and checking if the tree is empty.
 *
 * @param <T> the type of elements stored in the BST; must be comparable
 */
public class BinarySearchTree<T extends Comparable<T>> implements BST<T> {

    /**
     * A node of the Binary Search Tree.
     * Holds a value and references to left and right children.
     *
     * @param <T> the type of data stored in the node
     */
    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    private TreeNode<T> root;
    private int size;
    /**
     * Creates an empty Binary Search Tree.
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Inserts a new value into the BST.
     *
     * @param data the value to insert
     */
    @Override
    public void insert(T data) {
        if(data==null){
            throw new NullPointerException();
        }
        root = insertRecursive(root, data);
    }

    /**
     * Recursive helper for inserting values into the BST.
     *
     * @param current the current node
     * @param data the value to insert
     * @return the updated node reference
     */
    public TreeNode<T> insertRecursive(TreeNode<T> current, T data) {
        if (current == null) {
            size++;
            return new TreeNode<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertRecursive(current.left, data);
        } else if (data.compareTo(current.data) > 0) {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    }

    /**
     * Checks if the tree contains the specified value.
     *
     * @param data the value to search for
     * @return true if the value exists in the tree
     */
    @Override
    public boolean contains(T data) {
        return containsRecursive(root, data);
    }

    /**
     * Recursive helper for contains().
     */
    private boolean containsRecursive(TreeNode<T> current, T data) {
        if (current == null) return false;

        int compare = data.compareTo(current.data);

        if (compare == 0) return true;
        if (compare < 0) return containsRecursive(current.left, data);

        return containsRecursive(current.right, data);
    }

    /**
     * Deletes a value from the BST.
     *
     * @param data the value to delete
     */
    @Override
    public void delete(T data) {
        if(data==null){
            throw new NullPointerException();
        }
        root = deleteRecursive(root, data);
    }

    /**
     * Recursive helper for delete().
     */
    private TreeNode<T> deleteRecursive(TreeNode<T> current, T data) {
        if (current == null) {
            return null;
        }

        int compare = data.compareTo(current.data);

        if (compare < 0) {
            current.left = deleteRecursive(current.left, data);
        } else if (compare > 0) {
            current.right = deleteRecursive(current.right, data);
        } else {
            size--;
            // Case 1: No children
            if (current.left == null && current.right == null) {
                return null;
            }
            // Case 2: One child
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            // Case 3: Two children
            T smallestValue = findMin(current.right);
            current.data = smallestValue;
            size++;
            current.right = deleteRecursive(current.right, smallestValue);
        }

        return current;
    }

    /**
     * Finds the smallest value in a subtree.
     */
    private T findMin(TreeNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    /**
     * Performs in-order traversal (Left, Root, Right).
     * Prints elements in sorted order.
     */
    @Override
    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(TreeNode<T> node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    /**
     * Performs pre-order traversal (Root, Left, Right).
     */
    @Override
    public void preOrderTraversal() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * Performs post-order traversal (Left, Right, Root).
     */
    @Override
    public void postOrderTraversal() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(TreeNode<T> node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * Performs level-order traversal (Breadth-First Search).
     */
    @Override
    public void levelOrderTraversal() {
        if (root == null) return;

        java.util.Queue<TreeNode<T>> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        System.out.println();
    }

    /**
     * Computes the height of the tree.
     *
     * @return height of the tree; -1 if empty
     */
    @Override
    public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(TreeNode<T> node) {
        if (node == null) return -1;
        return 1 + Math.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    /**
     * Computes the total number of nodes in the tree.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the BST is empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
