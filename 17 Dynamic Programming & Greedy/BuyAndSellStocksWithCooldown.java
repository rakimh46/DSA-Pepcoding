
//Buy And Sell Stocks With Cooldown - Infinite Transaction Allowed
import java.util.Scanner;

public class BuyAndSellStocksWithCooldown {
    public static void main(String[] args) {

        try (Scanner scn = new Scanner(System.in)) {
            int n = scn.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = scn.nextInt();
            }

            int buyState=0; //buying state
            int sellState=0; //selling state
            int cSellState=0; //cooldown selling state
            
            for (int i = 0; i < prices.length; i++) {
                if(i==0){
                    buyState=-prices[i];
                    sellState=0;
                    cSellState=0;
                }else{
                   // System.out.println(buyState+"  "+sellState+"  "+cSellState);
                    int tempbuyState=Math.max(buyState, cSellState-prices[i]); 
                    int tempsellState=Math.max(sellState, buyState+prices[i]);
                    int tempcSellState=sellState;
                    buyState=tempbuyState;
                    sellState=tempsellState;
                    cSellState=tempcSellState;
                }
            }
            //System.out.println(buyState+"  "+sellState+"  "+cSellState);
            System.out.println(sellState);
        }
    }
}
