public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < height.length && j > 0) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
    //input [1,8,6,2,5,4,8,3,7]
    //output 49
}
