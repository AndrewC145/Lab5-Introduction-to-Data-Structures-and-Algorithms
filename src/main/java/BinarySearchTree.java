public class BinarySearchTree<T extends Comparable<T>> implements BST<T>{
    @Override
    public void insert(Comparable data) {

    }

    @Override
    public boolean contains(Comparable data) {
        return false;
    }

    @Override
    public void delete(Comparable data) {

    }

    @Override
    public void inOrderTraversal() {

    }

    @Override
    public void preOrderTraversal() {

    }

    @Override
    public void postOrderTraversal() {

    }

    @Override
    public void levelOrderTraversal() {

    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }



}
