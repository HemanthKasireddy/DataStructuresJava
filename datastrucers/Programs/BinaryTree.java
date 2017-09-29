package com.bridgeit.datastrucers.Programs;

import java.util.Scanner;

import com.bridgeit.datastrucers.Utility.Utility;

public class BinaryTree {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number of times you want search: ");
			int count = scanner.nextInt();
			for (int i=1;i<=count;i++) {
				System.out.println("Enter the number of node.");
				long n = scanner.nextInt();
				long possibleCount = Utility.findPossibles((int) n);
				System.out.println(possibleCount);
			}
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception arrised");
		}
	}
}
