package com.exercise17excepcionhandling.app;
import com.exercise17excepcionhandling.model.MyOwnException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptions {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		int number1 = 0;
		
		Scanner kInput = new Scanner(System.in);
		
		for (int i = 0; i < 10; i++) {
			try
			{
				System.out.println("Input a number between 0-10 for index " + i);
				numbers[i] = kInput.nextInt();
				checkNumber(numbers[i]);
			}
			catch (NumberFormatException | InputMismatchException e)
			{
				System.out.println("Hey, the number you input is wrong. Do it again!!");
				kInput.next();
				i--;
			}
			catch (MyOwnException e) 
			{
				System.out.println(e);
				kInput.next();
				i--;
			}
		}
		
		
		kInput.close();
	}
	
	private static void checkNumber(int n) throws MyOwnException 
	{
		if (n < 0 || n > 10) {
			throw new MyOwnException("The number error");
		}
	}

}
