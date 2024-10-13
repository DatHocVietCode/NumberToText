package NumberToText;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  
	    System.out.print("Nhập vào một số nguyên bé hơn " + Integer.MAX_VALUE + " : ");
	    int number = scanner.nextInt();  

		NumToText converter = new NumToText(number);
		String result = converter.getTextFromNum();
		System.out.print(result);
	}
	
}
