/**
 * @author Hemanth
 * Read .a List of Numbers from a file and arrange it ascending Order in a Linked List. 
 * Take user input for a number, if found then pop the number out of the list else insert the number in appropriate position
 * I/P -> Read from file the list of Numbers and take user input for a new number
 * Logic -> Create a Ordered Linked List having Numbers in ascending order. 
 * O/P -> The List of Numbers to a File.
 */

package com.bridgeit.datastrucers.Programs;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

import com.bridgeit.datastrucers.Utility.Utility;



class OrderedList{

public static void main(String []args){
	  Scanner scanner=new Scanner(System.in);
	 try {
			File file=new File("/home/bridgeit/Desktop/Hemanth_WorkSpace/IntegerSearchFile");

		    System.out.println("Enter the integer element want to serach: ");
		  String userSearch=scanner.nextLine();
		 // OrderedLinkedList orderedLinkedList=new OrderedLinkedList(userSearch);
		  
			 String []integersArray =Utility.readingDataFromFile(file);
		//	 HashMap<Integer,String> map= Utility.addingArrayElemntsToMap(integersArray);
			 LinkedList<String> linkedList=  Utility.addingArrayElemntsToToLinkedList(integersArray);
		     Utility.userEntrySearching(file,linkedList,userSearch); 
		     Utility.displayingListWords(file);
        }catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
}

}
