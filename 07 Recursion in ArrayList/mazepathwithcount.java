import java.util.ArrayList;

public class mazepathwithcount {
    public static void main(String[] args) {
        // int[] arr=new int[n][m]
        int n = 3; // size of array in row
        int m = 3; // size of array in column
        System.out.println(maze(0, 0, n-1, m-1 ));
    }

    public static ArrayList<String> maze(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if (sr > dr || sc > dc) {
            return new ArrayList<String>();
        }
        ArrayList<String> mylist = new ArrayList<>();

        for (int ms = 1; ms <= dc - sc; ms++) {
            ArrayList<String> hpath = maze(sr, sc + ms, dr, dc);
            for (String s : hpath) {
                mylist.add("h" + ms + s);
            }
        }

        for (int ms = 1; ms <= dr - sr; ms++) {
            ArrayList<String> vpath = maze(sr + ms, sc, dr, dc);
            for (String s : vpath) {
                mylist.add("v" + ms + s);
            }
        }

        for (int ms = 1; ms <= dr - sr && ms <= dc - sc; ms++) {
            ArrayList<String> dpath = maze(sr + ms, sc + ms, dr, dc);
            for (String s : dpath) {
                mylist.add("d" + ms + s);
            }
        }

        return mylist;
    }
}
