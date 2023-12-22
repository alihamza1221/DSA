package TREE;

import java.util.LinkedList;
import java.util.Queue;

public class binarytree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // build the tree sturctre
    static class Btree {
        static int idex = -1;

        public Node buildtree(int nodes[]) {
            idex++;
            if (idex >= nodes.length || nodes[idex] == -1) {
                return null;
            }
            Node newnode = new Node(nodes[idex]);
            newnode.left = buildtree(nodes);
            newnode.right = buildtree(nodes);
            return newnode;
        }

        // treversal
        // .> pre-order travers
        // .> in-order travers
        // .> post-order travers

        public void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // 2
        public void inorder(Node root) {
            if (root == null) {
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // 3
        static void postorder(Node root) {
            if (root == null) {
                return;
            }

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        // BFS algo level order traverse
        public void levlorder(Node root) {
            if (root == null) {
                return;
            } else {
                Queue<Node> q = new LinkedList<>();
                q.offer(root);
                q.offer(null);
                while (!q.isEmpty()) {
                    Node curNode = q.poll();
                    if (curNode == null) {
                        System.out.println();
                        if (q.isEmpty()) {
                            break;
                        } else {
                            q.add(null);
                        }

                    } else {
                        System.out.print(curNode.data + " ");
                        if (curNode.left != null)
                            q.offer(curNode.left);
                        if (curNode.right != null)
                            q.offer(curNode.right);
                    }
                }

            }
        }

        // count the nodes in the tree ( Easy)
        public int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftnodes = countNodes(root.left);
            int rightnodes = countNodes(root.right);
            return leftnodes + rightnodes + 1;
        }

        // sum of the nodes in tree( Easy )
        public int sumNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int sumleft = sumNodes(root.left);
            int sumright = sumNodes(root.right);

            return sumleft + sumright + root.data;
        }

        // hieght of the tree (Easy)

        public int height(Node root) {
            if (root == null) {
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);

            return Math.max(left, right) + 1;
        }

        // find diameter of the tree
        // >>> Tip diamemeter can be found in to ways
        // >> without root like the max diameter of the sub-tree--->left + right
        // >> considering root like height of the left branch and the right branch

        public int diameter(Node root) {
            if (root == null) {
                return 0;
            }
            // with-out root
            int leftdiam = diameter(root.left);
            int rightdiam = diameter(root.right);

            int height = height(root.left) + height(root.right) + 1;

            return Math.max(Math.max(leftdiam, rightdiam), height);
        }
        /* Time complexity => O(N^2) */

        // method 2 optimze ( Medium)

        public class diameterinfo {
            int diam;
            int height;

            // constructer
            diameterinfo(int diam, int height) {
                this.diam = diam;
                this.height = height;
            }
        }

        public diameterinfo diameter2(Node root) {
            if (root == null) {
                return new diameterinfo(0, 0);
            }
            diameterinfo left = diameter2(root.left);
            diameterinfo right = diameter2(root.right);

            int ht = Math.max(left.height, right.height) + 1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.height + right.height + 1;

            int max = Math.max(Math.max(diam1, diam2), diam3);

            diameterinfo newDiameter = new diameterinfo(max, ht);
            return newDiameter;
        }

        // does the given tree matches with any subtree of our tree

        public boolean matches(Node root, Node subtree) {
            if (subtree == null) {
                return true;
            } else if (root == null) {
                return false;
            }

            if (root == subtree) {
                return matchfound(root, subtree);
            } else
                return matches(root.left, subtree) && matches(root.right, subtree);
        }

        public boolean matchfound(Node root, Node subtree) {
            if (root == null && subtree == null) {
                return true;
            } else if (root.left == null && subtree == null) {
                return false;
            }

            if (root.data == subtree.data) {
                return matchfound(root.left, subtree.left) && matchfound(root.right, subtree.right);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        Btree tree = new Btree();
        Node root = tree.buildtree(data);
        System.out.println(root.data);
        tree.preorder(root);
        System.out.println();
        tree.inorder(root);
        System.out.println();
        tree.postorder(root);
        System.out.println();
        tree.levlorder(root);
        System.out.println();

        System.out.println("count: " + tree.countNodes(root));
        System.out.println("sum: " + tree.sumNodes(root));
        System.out.println("height: " + tree.height(root));
        System.out.println("diameter1: " + tree.diameter(root));
        System.out.println("diameter2: " + tree.diameter2(root).diam);

        System.out.println("Matches? " + tree.matches(root, root));

    }
}
