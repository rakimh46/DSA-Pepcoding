import java.util.ArrayList;
import java.util.Stack;

public class NodeToRootPath {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int ele) {
        // write your code here
        if (node.data == ele) {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(node.data);
            return base;
        }
        for (Node child : node.children) {
            ArrayList<Integer> res = nodeToRootPath(child, ele);
            if (res.size() > 0) {
                res.add(node.data);
                return res;
            }

        }
        return new ArrayList<Integer>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }


    public static void main(String[] args) throws Exception {
        int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };
        int data = 120;

        Node root = construct(arr);
        ArrayList<Integer> path = nodeToRootPath(root, data);
        System.out.println(path);
        // display(root);
    }

}