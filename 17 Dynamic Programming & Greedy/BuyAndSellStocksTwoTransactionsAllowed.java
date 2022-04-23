
//  One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
import java.util.Scanner;

public class BuyAndSellStocksTwoTransactionsAllowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }

        int[] Msell = MaximumProfitSell(prices);
        int[] Mbuy = MaximumProfitBuy(prices);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < Mbuy.length; i++) {
            int ans=Msell[i]+Mbuy[i];
            if(max<ans){
                max=ans;
            }
        }
        System.out.println(max);

    }

    public static int[] MaximumProfitSell(int[] prices) {
        int[] ans = new int[prices.length];

        int b = 0;
        int s = 0;
        for (int i = 0; i < ans.length; i++) {
            if (i == 0) {
                b = prices[0];
                s = prices[0];
            } else if (b > prices[i]) {
                b = prices[i];
                s = prices[i];
            } else if (b < prices[i]) {
                s = prices[i];
                ans[i] = s - b;
            }
            // System.out.println(b+" "+s+" "+ans[i]);
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            if(max<ans[i]){
                max=ans[i];
            }
            ans[i]=max;
        }
        return ans;
    }

    public static int[] MaximumProfitBuy(int[] prices) {
        int[] ans = new int[prices.length];
        int s = 0;
        for (int i = ans.length - 1; i >= 0; i--) {
            if(s<prices[i]){
                s=prices[i];
            }else if(s>prices[i]){
                ans[i]=s-prices[i];
            }
            // System.out.println(s+" "+ans[i]);
        }
        int max=Integer.MIN_VALUE;
        for (int i = ans.length - 1; i >= 0; i--) {
            if(max<ans[i]){
                max=ans[i];
            }
            ans[i]=max;
            //System.out.println(ans[i]);
        }
        return ans;
    }
}
