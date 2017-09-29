/**
 * 
 * @author Hemanth
 * Desc -> Read the Text from a file, split it into words and arrange it as Linked List.
 *  Take a user input to search a Word in the List. If the Word is not found then add it to the list,
 *  and if it found then remove the word from the List. In the end save the list into a file
 * I/P -> Read from file the list of Words and take user input to search a Text
 * O/P -> The List of Words to a File.
 *
 */
package com.bridgeit.datastrucers.Programs;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgeit.datastrucers.Utility.Utility;


public class UnOrderedList {
	
	public static void main (String []args) { 
	    File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/WordsSearchFile");

		Scanner scanner=new Scanner(System.in);
		try {
		
			System.out.println("Enter the string you want to search");
			String userSearch=scanner.nextLine();
			String[] integersArray=Utility.readingDataFromFile(file);
			LinkedList<String> linkedList=  Utility.addingArrayElemntsToToLinkedList(integersArray);
			Utility.userEntrySearching(file,linkedList,userSearch); 
			Utility.displayingListWords(file);
			
		} catch(Exception ex) {
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	} 
} 