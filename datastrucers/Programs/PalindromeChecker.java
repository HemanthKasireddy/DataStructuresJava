package com.bridgeit.datastrucers.Programs;

import java.util.Deque;
import java.util.Scanner;

import com.bridgeit.datastrucers.Utility.Utility;

public class PalindromeChecker {
	public static void main(String []args) {
		Scanner scanner =new Scanner(System.in);
		try {
			
			System.out.println("Enter a string :");
			String userString=scanner.nextLine();
			//StringPalindromeChecker stringPalindromeChecker=new StringPalindromeChecker(userString);
			Deque<Character> deque=	Utility.pushingElementsDequeRare(userString);
			String popingString=Utility.popingElementsDequeRare(deque);
			Utility.isStringPalindrome( userString,popingString);
			
		} catch(Exception ex) {
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}

}
