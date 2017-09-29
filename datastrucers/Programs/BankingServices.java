package com.bridgeit.datastrucers.Programs;

import java.util.LinkedList;
import com.bridgeit.datastrucers.Utility.Utility;

public class BankingServices {
	
	public static void main(String[] args){
		System.out.println("Welcome to my bank:");
		System.out.println("please maintain a queue :");
		LinkedList<String> queue=Utility.createQueue();
		LinkedList<String> finalQueue=	Utility.selectService(queue);
		Utility.displayUserAmount(finalQueue);
	}
}
