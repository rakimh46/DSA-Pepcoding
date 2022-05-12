public class ColoringBorder {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, color, grid[row][col], new boolean[grid.length][grid[0].length]);
        return grid;
    }

    // static int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int[][] grid, int row, int col, int color, int pcolor, boolean[][] vis) {
        vis[row][col] = true;
        int count = 0;

        // 1st way all direction check;
        // for(int d=0;d<4;d++){
        // int rdash=row+dir[d][0];
        // int cdash=col+dir[d][1];

        // if(rdash<0 || cdash<0 || rdash>=grid.length || cdash>=grid[0].length){
        // continue;
        // }
        // if(vis[rdash][cdash]==true){
        // count++;
        // }else if(grid[rdash][cdash]==pcolor){
        // count++;
        // dfs(grid,rdash,cdash,color,pcolor,vis);
        // }
        // }

        if (row - 1 >= 0) {
            if (vis[row - 1][col] == true) {
                count++;
            } else if (grid[row - 1][col] == pcolor) {
                count++;
                dfs(grid, row - 1, col, color, pcolor, vis);
            }
        }

        if (col - 1 >= 0) {
            if (vis[row][col - 1] == true) {
                count++;
            } else if (grid[row][col - 1] == pcolor) {
                count++;
                dfs(grid, row, col - 1, color, pcolor, vis);
            }
        }

        if (row + 1 < grid.length) {
            if (vis[row + 1][col] == true) {
                count++;
            } else if (grid[row + 1][col] == pcolor) {
                count++;
                dfs(grid, row + 1, col, color, pcolor, vis);
            }
        }

        if (col + 1 < grid[0].length) {
            if (vis[row][col + 1] == true) {
                count++;
            } else if (grid[row][col + 1] == pcolor) {
                count++;
                dfs(grid, row, col + 1, color, pcolor, vis);
            }
        }

        if (count != 4) {
            grid[row][col] = color;
        }

    }
}
