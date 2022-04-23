//Buy And Sell Stocks - One Transaction Allowed
public class BuyAndSellStocksOneTransactionAllowed {
    public static void main(String[] args) {
        int[] prices={11,6,7,19,4,1,6,18,4};

        int bday=0;
        int cprofit=0;
        int oprofit=0;

        for (int day = 1; day < prices.length; day++) {
            if(prices[bday]>prices[day]){
                bday=day;
            }

            cprofit=prices[day]-prices[bday];

            if(oprofit<cprofit){
                oprofit=cprofit;
            }
        }
        System.out.println(oprofit);
    

        // int sp=prices[0];
        // int bp=prices[0];
        // int[] profit=new int[prices.length];
        // for (int i = 1; i < prices.length-1; i++) {
        //     if(bp<prices[i+1]){
        //         sp=prices[i+1];
        //     }else if(bp>prices[i+1]) {
        //         bp=prices[i+1];
        //         sp=prices[i+1];
        //     }
        //     profit[i+1]=sp-bp;
        // }
        // int max=0;
        // for (int val : profit) {
        //     if(val>max){
        //         max=val;
        //     }
        // }
        // System.out.println(max);
    }
}
