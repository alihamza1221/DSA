public class BST {
    class Node {
        int val;
        int height;
        Node right;
        Node left;

        Node(int val) {
            this.val = val;
            this.height = 1;
        }
    }

    // build tree
    public Node buildTree(int[] nums) {
        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            root = Insert(root, nums[i]);
        }
        return root;
    }

    public Node Insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val > root.val) {
            root.right = Insert(root.right, val);
        } else if (val < root.val) {
            root.left = Insert(root.left, val);
        }
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balacingFactor = isBalanced(root.left, root.right);

        if (balacingFactor > 1 && val < root.left.val) {
            return rotateRight(root);
        }

        if (balacingFactor > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (balacingFactor < -1 && val > root.right.val) {
            return rotateLeft(root);
        }

        if (balacingFactor < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    // inorder traversal
    public void printTree(Node root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    // height
    static int height = 0;

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        height = Math.max(left, right) + 1;
        return height;
    }

    // left and right rotations
    Node rotateRight(Node root) {
        Node child = root.left;
        Node subTree = child.right;

        child.right = root;
        root.left = subTree;

        // Update heights
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;

        return child;
    }

    Node rotateLeft(Node root) {
        Node child = root.right;
        Node subTree = child.left;

        child.left = root;
        root.right = subTree;

        // Update heights
        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        child.height = Math.max(getHeight(child.left), getHeight(child.right)) + 1;

        return child;
    }

    // print in range
    public void inRangePrint(Node root, int x, int y) {
        if (root == null)
            return;

        if (root.val >= x && root.val <= y)
            System.out.print(root.val + " ");

        if (x < root.val)
            inRangePrint(root.left, x, y);

        if (y > root.val)
            inRangePrint(root.right, x, y);
    }
    // delete a node from the tree

    public Node delete(Node root, int val) {
        if (root == null)
            return null;

        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            // Node to delete is found

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node has two children, find the in-order successor (IS)
            Node IS = findSuccessor(root.right);
            root.val = IS.val;

            // Delete the in-order successor from the right subtree
            root.right = delete(root.right, IS.val);
        }

        return root;
    }

    // balanced or not
    public int isBalanced(Node left, Node right) {
        return getHeight(left) - getHeight(right);
    }

    Node findSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

class Solution {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        BST.Node root = bst.buildTree(nums);
        bst.printTree(root);
        System.out.println();
        System.out.println(bst.getHeight(root));
        bst.inRangePrint(root, 3, 6);
        System.out.println();
        bst.delete(root, 1);
        bst.printTree(root);
        System.out.println();
        System.out.println(bst.getHeight(root));

        // check balanced
        System.out.println(bst.isBalanced(root.left, root.right));
    }
}
