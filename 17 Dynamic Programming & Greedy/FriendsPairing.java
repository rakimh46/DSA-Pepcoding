//31 may
//21:50
public class FriendsPairing {
    public static void main(String[] args) {
        int n=40;
        int dp[]=new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            if(i==0 || i==1){
                dp[i]=1;
            }else{
                dp[i]=dp[i-1]+(i-1)*dp[i-2];
            }
        }
        System.out.println(dp[n]);
    }
}
