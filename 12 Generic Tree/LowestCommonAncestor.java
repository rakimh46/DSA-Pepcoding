import java.util.ArrayList;
import java.util.Stack;

public class LowestCommonAncestor {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    // main code
    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> d1path = nodeToRootPath(node, d1);
        ArrayList<Integer> d2path = nodeToRootPath(node, d2);

        int i = d1path.size() - 1, j = d2path.size() - 1;
        while (i >= 0 && j >= 0 && d1path.get(i) == d2path.get(j)) {
            i--;
            j--;
        }
        return d1path.get(i + 1);

    }

    public static void main(String[] args) throws Exception {

        int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
                -1 };

        int d1 = 120;
        int d2 = 80;

        Node root = construct(arr);
        int lca = lca(root, d1, d2);
        System.out.println(lca);
    }

}