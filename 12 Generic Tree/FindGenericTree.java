import java.util.*;

public class FindGenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
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

    public static Node construct(Integer[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
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

    public static boolean find(Node node, int ele) {
        // write your code here
        if (node.data == ele)
            return true;

        for (Node child : node.children) {
            if (find(child, ele))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Integer input[] = { 10, 20, 50, null, 60, null, null, 30, 70, null, 80, 110, null, 120, null, null, 90, null,
                null, 40, 100, null, null, null };
        Node root = construct(input);
        int data=30;
        boolean flag = find(root, data);
        System.out.println(flag);
        // display(root);
    }

}
