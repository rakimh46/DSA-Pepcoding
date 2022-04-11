/**
Ceil And Floor In Generic Tree
5 april 22:23
 */
import java.io.*;
import java.util.*;

public class CeilAndFloor {
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

    static int ceil=Integer.MAX_VALUE;
    static int floor=Integer.MIN_VALUE;;

    public static void ceilAndFloor(Node node, int val) {
        // Write your code here
        if(node.data>val){
            if(node.data<ceil){
                ceil=node.data;
            }
        }else if(node.data<val){
            if(node.data>floor){
                floor=node.data;
            }
        }
        for(Node child:node.children){
            ceilAndFloor(child, val);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        ceilAndFloor(root, data);
        System.out.println("CEIL = " + ceil);
        System.out.println("FLOOR = " + floor);
    }

}