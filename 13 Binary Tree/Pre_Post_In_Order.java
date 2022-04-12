
import java.util.Stack;

public class Pre_Post_In_Order {
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

    public static void preorder(Node node) {
        if(node==null) return;

        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
    public static void postorder(Node node) {
        if(node==null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }
    public static void inorder(Node node) {
        if(node==null) return;

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }

    public static void main(String[] args) throws Exception {
        Integer input[] = { 10, 20, 40, null, null, 50, 80, null, null, null, 30, 60, null, 90, null, null, 70, null,
                null };
        Node root = construct(input);
        System.out.print("preoder   :- ");
        preorder(root);
        System.out.println();
        System.out.print("postoder  :- ");
        postorder(root);
        System.out.println();
        System.out.print("inoder    :- ");
        inorder(root);
        
    }

}
