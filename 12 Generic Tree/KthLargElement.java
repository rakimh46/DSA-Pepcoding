//Kth Largest Element In Tree
//6 April 19:25
import java.io.*;
import java.util.*;

public class KthLargElement {
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
    
    static int ceil;
    static int floor;

    public static int ceilAndFloor(Node node, int val) {
        if(node.data>val){
            if(node.data<ceil){
                ceil=node.data;
            }
        }else if(node.data<val){
            if(node.data>floor){
                floor=node.data;
            }
        }

        for (Node child : node.children) {
            ceilAndFloor(child, val);
        }
        return floor;
    }

    public static int kthLargest(Node node, int k) {
        // write your code here
        int ans=Integer.MAX_VALUE;
        while(k!=0){
            floor=Integer.MIN_VALUE;
            ceilAndFloor(node, ans);
            ans=floor;
            k--;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int k = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        int kthLargest = kthLargest(root, k);
        System.out.println(kthLargest);
    }

}