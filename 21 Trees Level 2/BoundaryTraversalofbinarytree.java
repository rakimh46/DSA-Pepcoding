import java.io.*;
import java.util.*;

public class BoundaryTraversalofbinarytree {
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

    static ArrayList<Integer> ans = new ArrayList<>();;

    public static void Contructboundary(Node node) {
        if (node == null) {
            return;
        }
        ans.add(node.data);
        printBoundaryLeft(node.left);
        leaves(node.left);
        leaves(node.right);
        printBoundaryRight(node.right);
        return;
    }

    public static void printBoundaryLeft(Node node) {
        if (node == null)
            return;

        if (node.left != null) {
            ans.add(node.data);
            printBoundaryLeft(node.left);
        } else if (node.right != null) {
            ans.add(node.data);
            printBoundaryLeft(node.right);
        }
    }

    public static void leaves(Node node) {
        if (node == null) {
            return;
        }

        leaves(node.left);
        if (node.left == null && node.right == null) {
            ans.add(node.data);
        }
        leaves(node.right);
    }

    public static void printBoundaryRight(Node node) {
        if (node == null)
            return;

        if (node.right != null) {
            printBoundaryRight(node.right);
            ans.add(node.data);
        } else if (node.left != null) {
            printBoundaryRight(node.left);
            ans.add(node.data);
        }
    }

    public static ArrayList<Integer> boundary(Node node) {
        Contructboundary(node);
        return ans;
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
        ArrayList <Integer> t=boundary(root);
        System.out.println(t);
    }

}
