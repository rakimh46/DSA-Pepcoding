/**
 * PowerLogarithmic
 */
public class PowerLogarithmic {

    public static void main(String[] args) {
        int digit=2;
        int power=5;

        System.out.println( solution(digit,power));
    }

    public static int solution(int d,int p) {
        if(p==0){
            return 1;
        }
        int xn=solution(d, p/2)*solution(d, p/2);

        if(p%2==1){
            xn=xn*d;
        }
        return xn;
    }
}