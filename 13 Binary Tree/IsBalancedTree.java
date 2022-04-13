import java.util.*;

public class IsBalancedTree {
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

    static boolean balfac;

    public static int isbinary(Node node) {
        if(node==null){
            return -1;
        }
        int htleft = isbinary(node.left);
        int htright = isbinary(node.right);

        int BF = Math.abs(htleft - htright);
        if (BF > 1) {
            balfac = false;
        }
        return Math.max(htleft, htright) + 1;
    }

    public static void main(String[] args) throws Exception {
        Integer arr[] = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70, null,
            null };

        Node root = construct(arr);

        // write your code here
        isbinary(root);
        System.out.println(balfac);

    }

}