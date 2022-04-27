import java.util.*;

public class CrosswordPuzzleHackerRank {

    public static void solution(char[][] arr, String[] words, int vidx) {
        if (vidx == words.length) {
            print(arr);
            return;
        }
        String word = words[vidx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (CanPlacedHorizontal(arr, word, i, j)) {
                        boolean[] wePlaced = PlacedHorizontal(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unPlacedHorizontal(arr, wePlaced, i, j);
                    }

                    if (CanPlacedVertical(arr, word, i, j)) {
                        boolean[] wePlaced = PlacedVertical(arr, word, i, j);
                        solution(arr, words, vidx + 1);
                        unPlacedVertical(arr, wePlaced, i, j);
                    }
                }

            }
        }
    }

    public static boolean CanPlacedHorizontal(char[][] arr, String word, int row, int col) {
        if (col - 1 >= 0 && arr[row][col - 1] != '+') {
            return false;
        } else if (col + word.length() < arr[0].length && arr[row][col + word.length()] != '+') {
            return false;
        }

        for (int jj = 0; jj < word.length(); jj++) {
            if (col + jj >= arr[0].length) {
                return false;
            }
            if (arr[row][col + jj] == '-' || arr[row][col + jj] == word.charAt(jj)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean CanPlacedVertical(char[][] arr, String word, int row, int col) {
        if (row - 1 >= 0 && arr[row - 1][col] != '+') {
            return false;
        } else if (row + word.length() < arr[0].length && arr[row + word.length()][col] != '+') {
            return false;
        }

        for (int ii = 0; ii < word.length(); ii++) {
            if (row + ii >= arr[0].length) {
                return false;
            }
            if (arr[row + ii][col] == '-' || arr[row + ii][col] == word.charAt(ii)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean[] PlacedHorizontal(char[][] arr, String word, int row, int col) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int jj = 0; jj < wePlaced.length; jj++) {
            if (arr[row][col + jj] == '-') {
                arr[row][col + jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
        return wePlaced;
    }

    public static boolean[] PlacedVertical(char[][] arr, String word, int row, int col) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int ii = 0; ii < wePlaced.length; ii++) {
            if (arr[row + ii][col] == '-') {
                arr[row + ii][col] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
        return wePlaced;
    }

    public static void unPlacedHorizontal(char[][] arr, boolean[] wePlaced, int row, int col) {
        for (int jj = 0; jj < wePlaced.length; jj++) {
            if (wePlaced[jj]) {
                arr[row][col + jj] = '-';
                wePlaced[jj] = false;
            }
        }
    }

    public static void unPlacedVertical(char[][] arr, boolean[] wePlaced, int row, int col) {
        for (int ii = 0; ii < wePlaced.length; ii++) {
            if (wePlaced[ii]) {
                arr[row + ii][col] = '-';
                wePlaced[ii] = false;
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char board[][] = new char[10][10];
            for (int i=0; i < 10; i++) {
                String line = scanner.nextLine();
                for (int j=0; j < 10; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
            String wordLine = scanner.nextLine();
            String words[] = wordLine.split(";");
            
            LinkedList<String> wordList = new LinkedList<String>();
            for (int i=0; i < words.length; i++) {
                wordList.add(words[i]);
            } 
            solution(board, words, 0);
        }
    }
}
