import java.util.Stack;

/**
 * Next Greater Element To The Right
 */
public class practice {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 9, 3, 1, 12, 6, 8, 7 };
        int[] ans = nextgreater(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int[] nextgreater(int[] arr) {
        int n = arr.length;
        int[] narr = new int[n];
        narr[n - 1] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];
            while (st.size() > 0 && val >= st.peek()) {
                st.pop();
            }

            narr[i]=st.size()==0 ? -1 : st.peek();
            st.push(val);
        }

        return narr;
    }

}
