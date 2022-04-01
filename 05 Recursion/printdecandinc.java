public class printdecandinc{
    public static void main(String[] args) {
        int n=10;

        solution(n);
    }

    public static void solution(int n) {

        if(n<1){
            return; 
        }
        System.out.print(n+" ");
        solution(n-1);   
        System.out.print(n+" ");
    }
}