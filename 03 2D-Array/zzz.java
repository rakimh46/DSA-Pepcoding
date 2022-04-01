public class zzz {
    public static void main(String[] args) {
        int[][] a1 = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        int[][] a2 = { { 10, 11 },
                { 12, 13 },
                { 14, 15 } };

        if (a1[0].length != a2.length) {
            System.out.println("invalid");
        } else {
            int[][] mat = new int[a1.length][a2[0].length];

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    int val=0;
                    for (int j2 = 0; j2 < a2.length; j2++) {
                        val+=a1[i][j2]*a2[j2][j];
                    }
                    mat[i][j]=val;
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }

        }
    }

}