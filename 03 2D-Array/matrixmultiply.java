public class matrixmultiply{
    public static void main(String[] args) {
        int[][] a1={{1,2,3},
                    {4,5,6},
                    {7,8,9}};

        int[][] a2={{10,11},
                    {12,13},
                    {14,15}};

        int[][] ans= matrix(a1,a2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] matrix(int[][] a1,int[][] a2) {

        int[][] mat=new int[a1.length][a2[0].length]; 

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int  val=0;
                for(int k=0;k<a1[0].length;k++){
                    val+=a1[i][k]*a2[k][j];
                }
                mat[i][j]=val;
            }
        }




        return mat;
    }
}