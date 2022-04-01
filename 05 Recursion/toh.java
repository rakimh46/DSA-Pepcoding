/**
 * Tower Of Hanoi
 */
public class toh {
    public static void main(String[] args) {
        int n = 3;
        int source = 10;
        int destination = 11;
        int helper = 12;

        toh(n, source, destination, helper);
    }

    public static void toh(int n,int source,int destination,int helper) {
        if(n==0){
            return;
        }

        toh(n-1,source,helper,destination);
        System.out.println(n+"["+source+" -> "+destination+"]");
        toh(n-1, helper, destination, source);
    }

}
