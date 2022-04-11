
//Node With Maximum Subtree Sum
import java.io.*;
import java.util.*;

public class MaximumSubtreeSum {
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

    static int max;
    static Node maxsumnode;

    public static int maximumsum(Node node) {
        int sum=0;
        for (Node child : node.children) {
            int csum=maximumsum(child); //csum is child sum
            sum+=csum;
        }
        sum += node.data;
        if(sum>max){
            max=sum;
            maxsumnode=node;
        }
        return sum;
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
        // write your code here
        max = Integer.MIN_VALUE;
        maxsumnode = null;
        maximumsum(root);
        System.out.println(maxsumnode.data+"@"+max);
    }

}
