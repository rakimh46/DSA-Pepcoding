import java.util.Scanner;

public class PaintHouse {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[][] ColorRate = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    ColorRate[i][j] = scn.nextInt();
                }
            }
            int colorR = 0;
            int colorB = 0;
            int colorG = 0;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    colorR = ColorRate[0][0];
                    colorB = ColorRate[0][1];
                    colorG = ColorRate[0][2];

                } else {
                    int temR = Math.min(colorB, colorG) + ColorRate[i][0];
                    int temB = Math.min(colorR, colorG) + ColorRate[i][1];
                    int temG = Math.min(colorR, colorB) + ColorRate[i][2];

                    colorR = temR;
                    colorB = temB;
                    colorG = temG;
                }
            }
            System.out.println(Math.min(colorR, Math.min(colorB, colorG)));
        }

    }
}
