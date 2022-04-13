import java.io.*;
import java.util.*;

public class Diameter {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    //first method
    static int dia;
    public static int diameter1(Node node) {
        // write your code here
        if (node == null)
            return -1;

        int Ldia = diameter1(node.left);
        int Rdia = diameter1(node.right);

        if ((Ldia + Rdia + 2) > dia) {
            dia = Ldia + Rdia + 2;
        }

        return Math.max(Ldia, Rdia) + 1;
    }

    //2nd method
    public static class DiaSlover{
        int ht;
        int dia;
        DiaSlover(int ht,int dia){
            this.ht=ht;
            this.dia=dia;
        }
    }

    public static DiaSlover Diameter2(Node node){
        if(node==null){
            return new DiaSlover(-1, 0);
        }
        DiaSlover left=Diameter2(node.left);
        DiaSlover right=Diameter2(node.right);

        int ht=Math.max(left.ht, right.ht)+1;
        // int d=left.dia+right.dia+2;
        // int c=Math.max(left.dia,right.dia);
        int dia=Math.max(left.ht+right.ht+2,Math.max(left.dia,right.dia));

        return new DiaSlover(ht,dia);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        // dia = 0;
        // diameter1(root);
        // System.out.println(dia);
        System.out.println(Diameter2(root).dia);
    }

}