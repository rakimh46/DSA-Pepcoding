import java.io.*;
import java.util.*;

public class LevelOrder {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void levelOrder(Node node) {
        // write your code here
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while (qu.size() > 0) {
            Node tmp = qu.remove();
            System.out.print(tmp.data + " ");
            for (Node child : tmp.children) {
                qu.add(child);
            }
        }
        System.out.println(".");
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        levelOrder(root);
    }

}