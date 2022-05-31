import java.util.*;

public class TempleOfferings {

    public static int totaloffering(int[] height) {
        // write your code here
        int[] leftH = new int[height.length];
        int[] rightH = new int[height.length];

        leftH[0] = 1;
        int offer = 1;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[i - 1]) {
                offer++;
                leftH[i] = offer;
                continue;
            }
            offer = 1;
            leftH[i] = offer;
        }

        offer = 1;
        rightH[rightH.length - 1] = 1;
        for (int i = rightH.length - 2; i >= 0; i--) {
            if (height[i] > height[i + 1]) {
                offer++;
                rightH[i] = offer;
                continue;
            }
            offer = 1;
            rightH[i] = offer;
        }

        int total = 0;

        for (int i = 0; i < rightH.length; i++) {
            total += Math.max(leftH[i], rightH[i]);
        }
        return total;
    }

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        int height[] = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scn.nextInt();
        }
        System.out.println(totaloffering(height));
    }

}