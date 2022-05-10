import java.util.ArrayDeque;
import java.util.Queue;

public class ZeroOneMatrix {

    public static class Pair {
        int r, c, d;

        Pair(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        Queue<Pair> qu=new ArrayDeque<>();

        int[][] res=new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j]==0){
                    qu.add(new Pair(i, j, 0));
                }
            }
        }

        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(qu.size()>0){
            Pair rem=qu.remove();
            
            res[rem.r][rem.c]=rem.d;

            for (int d = 0; d < 4; d++) {
                int rdash=rem.r +dir[d][0], cdash=rem.c+dir[d][1];

                if(rdash<0 || cdash<0 || rdash>=mat.length || cdash >= mat[0].length || mat[rdash][cdash]!=1){
                    continue;
                }
                mat[rdash][cdash]=0;
                qu.add(new Pair(rdash, cdash, rem.d+1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int[][] ans= updateMatrix(mat);
        for (int[] is : ans) {
            for (int val : is) {
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }
}
