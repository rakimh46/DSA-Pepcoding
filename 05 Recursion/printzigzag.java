public class printzigzag {
    public static void main(String[] args) {
        zigzag(3);
    }

    public static void zigzag(int n) {
        if(n<1){
            return ;  
        }

        System.out.print(n+" ");
        zigzag(n-1);
        System.out.print(n+" ");
        zigzag(n-1);
        System.out.print(n+" ");
        
        
    }
}
