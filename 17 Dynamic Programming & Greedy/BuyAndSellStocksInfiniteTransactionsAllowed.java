import java.util.Scanner;

public class BuyAndSellStocksInfiniteTransactionsAllowed {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = scn.nextInt();
            }

            int bp = 0; // buyng point
            int sp = 0; // selling point
            int profit = 0;

            for (int day = 1; day < prices.length; day++) {
                if (prices[sp] < prices[day]) {
                    sp = day;
                } else if (prices[sp] > prices[day]) {
                    profit += prices[sp] - prices[bp];
                    bp = day;
                    sp = day;
                }
            }
            profit += prices[sp] - prices[bp];
            System.out.println(profit);
        }
    }
}
