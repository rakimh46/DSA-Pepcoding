import java.util.Scanner;

public class HouseRobberBT {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class robberyBT {
        int inRob; // with robbery
        int excRob; // without robbery

        robberyBT(int inRob, int excRob) {
            this.inRob = inRob;
            this.excRob = excRob;
        }
    }

    public static int HouseRobber(TreeNode root) {
        robberyBT obj = HouseRobberhelper(root);

        return Math.max(obj.excRob, obj.inRob);
    }

    private static robberyBT HouseRobberhelper(TreeNode node) {
        if(node==null){
            return new robberyBT(0, 0);
        }
        if (node.left == null && node.right==null) {
            return new robberyBT(node.val, 0);
        }
        robberyBT leftRob = HouseRobberhelper(node.left);
        robberyBT rigBtRob = HouseRobberhelper(node.right);

        int inRob = leftRob.excRob + rigBtRob.excRob + node.val;
        int excRob = Math.max(leftRob.inRob, leftRob.excRob) + Math.max(rigBtRob.inRob, rigBtRob.excRob);

        return new robberyBT(inRob, excRob);
    }

    // input_Section_====================================================================

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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}