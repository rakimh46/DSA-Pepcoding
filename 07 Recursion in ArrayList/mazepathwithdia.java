import java.util.ArrayList;

public class mazepathwithdia {
    public static void main(String[] args) {
        //int[] arr=new int[n][m]
        int n=3; //size of array in row 
        int m=3; //size of array in column
       System.out.println( maze(0, 0, n-1, m-1));
    }

    public static ArrayList<String> maze(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> base= new ArrayList<>();
            base.add("");
            return base;
        }
        if(sr > dr || sc > dc){
            return new ArrayList<String>();
        }
        ArrayList<String> hpath= maze(sr , sc+1, dr, dc);
        ArrayList<String> vpath= maze(sr+1 , sc, dr, dc);
        ArrayList<String> dpath= maze(sr+1 , sc+1, dr, dc);
    
        ArrayList<String> mylist= new ArrayList<>();

        for(String s: hpath){
            mylist.add("h"+s);
        }
        for(String s: vpath){
            mylist.add("v"+s);
        }
        for(String s: dpath){
            mylist.add("d"+s);
        }

        return mylist;
    }
}
