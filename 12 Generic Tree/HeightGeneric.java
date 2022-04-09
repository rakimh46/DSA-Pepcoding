import java.util.ArrayList;
import java.util.Stack;

public class HeightGeneric {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int height(Node node) {
        // write your code here
        int hi = -1;
        for (Node child : node.children) {
            int res = height(child);
            if (res > hi) {
                hi = res;
            }
        }

        return hi + 1;
    }

    public static Node construct(Integer[] input) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = input[i];

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

    public static void display(Node node){
        System.out.print(node.data+" -> ");
        for(Node child : node.children){
            System.out.print(child.data+" ");
        }
        System.out.println(".");

        for(Node child : node.children){
            display(child);
        }
    } 

    public static void main(String[] args) throws Exception {
        Integer input[] = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};

        Node root = construct(input);
        int h = height(root);
        System.out.println(h);
        // display(root);
    }

}