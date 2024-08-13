package practice;

public class PrintNumbers {

	public static void main(String[] args) {
		
	      printNumbers(0);
	}
	
	public static void printNumbers(int n)
	{
		if(n<=100)
		{
			System.out.println(n);
			printNumbers(n+1);
		}
	}
}
