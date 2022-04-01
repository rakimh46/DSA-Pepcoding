public class digitfrequency {
    public static void main(String[] args) {
        int n = 994543234; // number
        int f = 4; // frequncy

        int count = 0;
        while (n != 0) {
            if (n % 10 == f) {
                count++;
            }
            n=n/10;
        }
        System.out.println(count);

    }
}