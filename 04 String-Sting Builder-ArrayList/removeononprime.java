import java.util.ArrayList;
import java.util.Scanner;

public class removeononprime {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scn.nextInt());
        }

        solution(list);
        System.out.println(list);
    }

    public static boolean isprime(int num) {

        for (int fac = 2; fac * fac <= num; fac++) {
            if (num % fac == 0) {
                return false;
            }
        }
        return true;
    }

    public static void solution(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (isprime(list.get(i)) == false) {
                list.remove(i);
            }

        }

    }
}
