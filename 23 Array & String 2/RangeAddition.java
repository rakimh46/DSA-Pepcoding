public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int ans[] = new int[length];

        for (int j = 0; j < updates.length; j++) {
            int start = updates[j][0];
            int end = updates[j][1];
            int value = updates[j][2];
            ans[start] += value;
            if (end + 1 < length) {
                ans[end + 1] += -value;
            }
        }

        for (int i = 1; i < ans.length; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
