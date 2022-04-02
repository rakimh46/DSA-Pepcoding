/**
 * knightstour
 */
public class knightstour {

    public static void main(String[] args) {
        int n=5;
        int r=2; //row 
        int c=0; //column
        printKnightsTour(new int[n][n],r,c,1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int moveno) {

        if(r<0 || c<0 || r>=chess.length || c>=chess[0].length || chess[r][c]!=0){
            return;
        }
        chess[r][c]=moveno;
        if(moveno==chess.length*chess[0].length){
            //chess[r][c]=moveno;
            display(chess);
            chess[r][c]=0;
            return;
        }
        
        printKnightsTour(chess, r-2, c+1, moveno+1); //dir 1
        printKnightsTour(chess, r-1, c+2, moveno+1); //dir 2
        printKnightsTour(chess, r+1, c+2, moveno+1); //dir 3
        printKnightsTour(chess, r+2, c+1, moveno+1); //dir 4
        printKnightsTour(chess, r+2, c-1, moveno+1); //dir 5
        printKnightsTour(chess, r+1, c-2, moveno+1); //dir 6
        printKnightsTour(chess, r-1, c-2, moveno+1); //dir 7
        printKnightsTour(chess, r-2, c-1, moveno+1); //dir 8

        chess[r][c]=0; //unmark
    }

    public static void display(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        
    }

/*
-2+1
-1+2
+1+2
+2+1
+2-1
+1-2
-1-2
-2-1
*/ 

}