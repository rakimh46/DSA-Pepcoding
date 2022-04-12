import java.util.Stack;

public class Size_Sum_Maximum_Height {
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

    public static int size(Node node) {
        // write your code here
        if (node == null) {
            return 0;
        }
        int lsize = size(node.left);
        int rsize = size(node.right);
        return lsize + rsize + 1;
    }

    public static int sum(Node node) {
        // write your code here
        if (node == null) {
            return 0;
        }
        int lsum = sum(node.left);
        int rsum = sum(node.right);
        return lsum + rsum + node.data;
    }

    public static int max(Node node) {
        // write your code here
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int lmax = max(node.left);
        int rmax = max(node.right);

        return Math.max(node.data, Math.max(lmax, rmax));
    }

    public static int height(Node node) {
        // write your code here
        if (node == null) {
            return 0;
        }
        int lheigh = height(node.left);
        int rheigh = height(node.right);
        return Math.max(lheigh, rheigh) + 1;
    }

    public static void main(String[] args) throws Exception {
        Integer input[] = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70, null,
                null };
        Node root = construct(input);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }

}
