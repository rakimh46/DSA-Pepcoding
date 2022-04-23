//Buy And Sell Stocks With Transaction Fee - Infinite Transactions Allowed
import java.util.Scanner;
public class BuyAndSellStocksWithTransactionFee {
    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = scn.nextInt();
            }
            int f = scn.nextInt(); // transcation fee

            int buyState = 0;
            int sellState = 0;
            // Shortcut
            for (int i = 0; i < prices.length; i++) {
                if (i == 0) {
                    buyState = -prices[0];
                } else {
                    buyState = Math.max(buyState, sellState - prices[i]);
                    sellState = Math.max(sellState, prices[i] - f + buyState);
                }
            }
            System.out.println(sellState);
            // for (int i = 0; i < prices.length; i++) {
            //     if (i == 0) {
            //         buyState = -prices[0];
            //     }else{
            //         int tempBuy=sellState-prices[i];
            //         int tempSell=prices[i]-f+buyState;
            //         buyState=Math.max(buyState, tempBuy);
            //         sellState=Math.max(sellState, tempSell);
            //         }
            //     }
        }
    }
}
