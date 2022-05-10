import java.util.Scanner;

public class RecoverBst {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode prev, a, b;

    public static void recoverTree(TreeNode root) {
        prev = null;
        a = null;
        b = null;
        recoverTreeHelper(root);
        if (a != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }

    public static boolean recoverTreeHelper(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean lres = recoverTreeHelper(node.left);
        if (lres == false) {
            return false;
        }
        if (prev == null) {
            prev = node;
        } else {
            if (prev.val > node.val) {
                b = node;
                if (a == null) {
                    a = prev;
                } else {
                    return false;
                }
            }
            prev = node;
        }
        boolean rres = recoverTreeHelper(node.right);
        if (rres == false) {
            return false;
        }
        return true;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
