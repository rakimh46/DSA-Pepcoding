public class powerLinear {
    public static void main(String[] args) {
        int digit=2;
        int power=5;

        System.out.println( solution(digit,power));
    }

    public static int solution(int d,int p) {
        if(p==1){
            return d;
        }
        return  solution(d, p-1) * d;
    }
}
