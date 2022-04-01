import java.util.Scanner;

public class apple {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        if(str.equals("Apple")){
            System.out.println("Gravity");
        }else{
            System.out.println("Space");
        }
    }
}
