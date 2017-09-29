
/**
 * @author Hemanth
 * Desc -> Take an Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) 
 * where parentheses are used to order the performance of operations.
 *  Ensure parentheses must appear in a balanced fashion.
 *  
 * I/P -> read in Arithmetic Expression such as (5+6)∗(7+8)/(4+3)(5+6)∗(7+8)/(4+3) 
 * 
 * O/P -> True or False to Show Arithmetic Expression is balanced or not.
 *
 */

package com.bridgeit.datastrucers.Programs;

import java.util.Scanner;
import java.util.Stack;

import com.bridgeit.datastrucers.Utility.Utility;
	

public class BalancedParentheses {
	
	public static void main(String[] args){
		Scanner scanner=new Scanner(System.in);
		try{
			System.out.println("Enter your Arithmetic Expression: ");
		    String userArithmeticExpression=scanner.nextLine();
		    Stack<Character> stack= Utility.parenthesesChecking(userArithmeticExpression);
		    Utility.parenthesesBalancedChecking(stack);
	       }catch(Exception ex){
	   		
	   		System.out.println("The \" "+ex+" \" Exception is raised");
	   		ex.printStackTrace();
	   	}finally {
	   		scanner.close();
	   	}
	}

}
