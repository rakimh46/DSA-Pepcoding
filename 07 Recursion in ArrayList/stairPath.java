import java.util.ArrayList;

public class stairPath {

    public static void main(String[] args) throws Exception {
        int n=5;
        System.out.println( getStairPaths(n));
    }

    public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        if(n<0){
            return new ArrayList<String>();
        }
        ArrayList<String> path1=getStairPaths(n-1);
        ArrayList<String> path2=getStairPaths(n-2);
        ArrayList<String> path3=getStairPaths(n-3);


        ArrayList<String> mylist=new ArrayList<>();
        
        for (String l : path1) {
            mylist.add("1"+l);
        }
        for (String l : path2) {
            mylist.add("2"+l);
        }
        for (String l : path3) {
            mylist.add("3"+l);
        }
        
        return mylist;
    }

}