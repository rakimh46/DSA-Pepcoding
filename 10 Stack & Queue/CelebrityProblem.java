import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 0, 1 }, 
                        { 0, 0, 0, 0 }, 
                        { 1, 1, 0, 1 }, 
                        { 1, 1, 1, 0 } };

        Celebrity(arr);
    }

    public static void Celebrity(int[][] arr){
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            st.push(i);
        }

        while(st.size()>1){
            int p1=st.pop(), p2=st.pop();
            if(arr[p1][p2]==1){
                //p2  is celebrity
                st.push(p2);
            }else{
                //p1 is celebrity
                st.push(p1);
            }
        }
        int possibleAns=st.pop();

        for (int c = 0; c < arr[0].length; c++) {
            if(arr[possibleAns][c]==1){
                System.out.println("none");
                return;
            }
        }

        for (int r = 0; r < arr.length; r++) {
            if(arr[r][possibleAns]==0 && r!=possibleAns){
                System.out.println("none");
                return;
            }
        }

        System.out.println("Celebrity is "+possibleAns);

    } 
}
