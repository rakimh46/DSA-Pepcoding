import java.io.*;
import java.util.*;

public class Maximum {
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

        if (((List<Maximum.Node>) st).size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  public static int max(Node node) {
    // write your code here
    int max=Integer.MIN_VALUE;
        for (Node child : node.children) {
            // int m=max(child);
            // if(max<m){
            //     max=m;
            // }
            max=Math.max(max,max(child));
        }
        // if(max<node.data){
        //     max=node.data;
        // }
        //System.out.println("1  "+max+"  "+node.data);
        //return max;
        return Math.max(max,node.data);
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
    int m = max(root);
    System.out.println(m);
    // display(root);
  }

}