import java.util.Scanner; 
class GrowingRivalry {
	public static void main (String[] args) {
                      String s;
					  Scanner sc=new Scanner(System.in);
					  int n=sc.nextInt();
					  sc.nextLine();
					  s=sc.nextLine();
					 int count=0, count1=0;
					 for(int i=0;i<n;i++){
						 if(s.charAt(i)=='N'){
							 count=count+1;
						 }
						 else if(s.charAt(i)=='T')
						 {
							 count1=count1+1;
						 }
					 }
					 String si=(count>count1)?"Nutan": "Tusla";
					 System.out.println(si);
	}
}