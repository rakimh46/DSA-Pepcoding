public class fibo {
    public static void main(String[] args) {
       System.out.println( fibo(3));
    }

    public static int fibo(int n){
        if(n<2){
            return n;
        }

        int a =fibo(n-1); 
        System.out.println("1  "+a);
        int b=fibo(n-2);
        System.out.println("2  "+b);
        int ans=a+b;
        System.out.println("3  "+ans);

        return ans;
    }
}
