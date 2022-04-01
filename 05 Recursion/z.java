public class z {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println(facorial(5));
    }

    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    public static int facorial(int n) {
        if (n > 2) {
            return n * facorial(n - 1);
        }

        return 1;

    }

}
