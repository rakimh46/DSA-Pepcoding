
import java.io.*;
import java.util.*;

public class LargestBstSubtree {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static class BSTSolver {
        int max;
        int min;
        boolean isBST;
        Node LBSTNode;
        int LBSTSize;

        BSTSolver(int max, int min, boolean isBST, Node LBSTNode, int LBSTSize) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.LBSTNode = LBSTNode;
            this.LBSTSize = LBSTSize;
        }
    }

    public static BSTSolver IsBinarySearchTree(Node node) {
        if (node == null) {
            return new BSTSolver(Integer.MIN_VALUE, Integer.MAX_VALUE, true, null, 0);
        }
        BSTSolver lRes = IsBinarySearchTree(node.left);
        BSTSolver rRes = IsBinarySearchTree(node.right);

        int max = Math.max(node.data, Math.max(lRes.max, rRes.max));
        int min = Math.min(node.data, Math.max(lRes.min, rRes.min));
        boolean isBST = lRes.isBST && rRes.isBST && node.data > lRes.max && node.data < rRes.min;
        Node LBSTNode = null;
        int LBSTSize = 0;
        if (isBST) {
            LBSTNode = node;
            LBSTSize = lRes.LBSTSize + rRes.LBSTSize + 1;
        } else if (lRes.LBSTSize > rRes.LBSTSize) {
            LBSTNode = lRes.LBSTNode;
            LBSTSize = lRes.LBSTSize;
        } else {
            LBSTNode = rRes.LBSTNode;
            LBSTSize = rRes.LBSTSize;
        }

        return new BSTSolver(max, min, isBST, LBSTNode, LBSTSize);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        // write your code here
        BSTSolver obj = IsBinarySearchTree(root);
        System.out.println(obj.LBSTNode.data + "@" + obj.LBSTSize);
    }

}