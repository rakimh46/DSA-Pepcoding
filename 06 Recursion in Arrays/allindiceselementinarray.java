public class allindiceselementinarray {
    public static void main(String[] args) {
        int[] arr={15,11,10,4,3,4,4,5,9,7,4};
        int x=4;
        int[] ans=indices(arr,x,0,0);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int[] indices(int[] arr,int x,int i,int fsf){
        
        if(i==arr.length){
            return new int[fsf];
        }

        int[] res;
        if(arr[i]==x){
            res=indices(arr, x, i+1, fsf+1);
            res[fsf]=i;

        }else{
            res=indices(arr, x, i+1, fsf);
        }

        return res;
       

        
    }
}
