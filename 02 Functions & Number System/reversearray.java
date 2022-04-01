public class reversearray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        reverse(arr);
        display(arr);

    }

    public static void display(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i]+" ");
            i++;
        }

    }

    public static void reverse(int[] arr) {
        int i = 0,j=arr.length-1;
        while (i==j || i<j ) {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

    }
}
