
import java.io.*;
import java.util.*;

public class IterativePreorderAndPostorder {
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

    public static class TranversalSolver{
        int state;
        Node node;
        TranversalSolver(Node node){
            this.node=node;
            this.state=-1;
        }
    }

    public static void IterativePreandPostOrder(Node root) {
        // write your code here
        Stack<TranversalSolver> st=new Stack<>();

        st.push(new TranversalSolver(root));
        String pre="",post="";
        while(st.size()>0){
            TranversalSolver topPair=st.peek();
            if(topPair.state==-1){
                //pre
                pre+=topPair.node.data+" ";
                topPair.state++;
            }else if(topPair.state==topPair.node.children.size()){
                //post
                post+=topPair.node.data+" ";
                st.pop();
            }else{
                st.push(new TranversalSolver(topPair.node.children.get(topPair.state++)));
            }
        }
        System.out.println(pre);
        System.out.println(post);
        
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
        IterativePreandPostOrder(root);
    }

}