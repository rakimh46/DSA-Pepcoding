//sum of two arrays

public class sumtwoarrays {
    public static void main(String[] args) {
        int[] a1={3,1,0,7,5};
        int[] a2={1,1,1,1,1,1};

        sum(a1,a2);
    }

    public static void sum(int[] a1,int[] a2) {
        int n1=a1.length;
        int n2=a2.length;

        int[] sum=new int[n1>n2?n1:n2];

        int i=n1-1;
        int j=n2-1;
        int k=sum.length-1;

        int c=0; //carry
        while(k>=0){
            int d=c;

            if(i>=0){
                d=d+a1[i];
            }

            if(j>=0){
                d+=a2[j];
            }

            c=d/10;
            d=d%10;

            sum[k]=d;

            i--;
            j--;
            k--;
        }

        if(c!=0){
            System.out.print(c+" ");
        }

        for (int l : sum) {
            System.out.print(l+" ");
            
        }
        
        
    }
    
}
