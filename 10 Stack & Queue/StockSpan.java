// 8 mar
import java.util.Stack;
public class StockSpan {
    public static void main(String[] args) {
        int[] arr={2,5,9,3,1,12,6,8,7};
        int[] ans= stock(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] stock(int[] arr){
        int[] span=new int[arr.length];

        Stack<Integer> st=new Stack<>();
        st.push(0);
        span[0]=1;
        for (int i = 1; i < arr.length; i++) {
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                st.pop();
            }

            // newarr[i]=st.size()==0 ? -1 : st.peek();
            if(st.size()==0){
                span[i]=i+1;
            }else{
                span[i]=i-st.peek();
            }
            st.push(i);
        }

        return span;
    }
}
