package com.bridgeit.datastrucers.Utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Deque;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Utility {
	enum Months{ January,February,March,April,May,June,July,August,September,October,November,December }
	enum Days   { Sun,Mon,Tue,Wed,Thu,Fri,Sat }

	/**
	 * @param userArithmeticExpression
	 * @return
	 * @author Hemanth
	 * <p> This method for parentheses checking
	 */
	public static Stack<Character> parenthesesChecking(String userArithmeticExpression) {
		Stack<Character> stack=new Stack<Character>();

		try{
			
			for(int i=0;i<userArithmeticExpression.length();i++){
				
				if(userArithmeticExpression.charAt(i)=='('){
					
					stack.push(userArithmeticExpression.charAt(i));
					
				} else 	if(userArithmeticExpression.charAt(i)==')'){
					if (stack.size()>0){
					     stack.pop();
					}else {
						System.out.println("Arithmetic Expression is not Balanced");
						System.exit(0);
					}
					
				}
			}
		}catch(Exception ex){
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				ex.printStackTrace();
			}
		return stack;
	}
	
	/**
	 * @param stack
	 * @author Hemanth
	 * this method for checking stack is empty or not if stack is empty
	 * number of "(" and ")" are equal means expression have balanced parentheses
	 * else expression have unbalanced parentheses
	 *  
	 */
	public static void parenthesesBalancedChecking(Stack<Character> stack) {
		
		if(stack.isEmpty()==true){
			System.out.println("Arithmetic Expression is Balanced");
		}
		else{
			System.out.println("Arithmetic Expression is not Balanced");
		}
		
	}
  
    //Method to match the given month and return its maximum days
    /**
     * @param mname
     * @param y
     * @return
     * @author Hemanth
     * <p> This method for finding maximum days in month
     */
    public static  int findMaxDay(int mname, int y) {    
        int daysInMonth[]={0,31,28,31,30,31,30,31,31,30,31,30,31};

        if((y%400==0) || (y%4==0)) {
        	daysInMonth[2]=29;
        }   
        return  daysInMonth[mname];     
    }
     
   
     /**
     * @param wname
     * @return
     * @author Hemanth
     * Method to match the given weekday name and return its weekday no.
     */
    public static  int findDayNo(String wname){ 
    	 
    	 int find = 0;
    	 for(int i=0; i<7; i++) {
    		 
    	 	if(wname.equalsIgnoreCase(Days.values()[i].name())) {
    	 		find = i; 
    	 	}
          }
        return find;
    }
     
     /**
     * @param maxDaysInMonth
     * @param dayNumberInMonth
     * @param month
     * @param year
     * @author Hemanth
     * This method for creating the calendar
     */
    public static void fillCalendar(int maxDaysInMonth, int dayNumberInMonth, int month, int year) {
    	 
    	LinkedList<String> daysList=new LinkedList<String>();
    	LinkedList<String>datesList=new LinkedList<String>();
        for(int i=0;i<Days.values().length;i++){
            daysList.addFirst(Days.values()[i].name());
        } 
        
        for(int i=0;i<dayNumberInMonth;i++){
        	datesList.addFirst("");
        }
      
        int daysCount=0;
        for(int i=0;i<maxDaysInMonth;i++){
        	daysCount++;
        	datesList.addFirst(Integer.toString(daysCount));
        }
        
        
        printCalendar(daysList,datesList , month, year); //Calling method to print the calendar
    }
    
     /**
     * @param maxDaysInMonth
     * @param dayNumberInMonth
     * @param month
     * @param year
     * @author Hemanth
     * This method for creating the calendar in queue
     */
    public static void fillCalendarQueue(int maxDaysInMonth, int dayNumberInMonth, int month, int year) {
     	LinkedList<String> daysList=new LinkedList<String>();
     	LinkedList<String>datesList=new LinkedList<String>();
         for(int i=0;i<Days.values().length;i++){
             daysList.addLast(Days.values()[i].name());
         } 
         
         for(int i=0;i<dayNumberInMonth;i++){
         	datesList.addFirst("");
         }
       
         int daysCount=0;
         for(int i=0;i<maxDaysInMonth;i++){
         	daysCount++;
         	datesList.addLast(Integer.toString(daysCount));
         }
         
         
         printCalendar(daysList,datesList , month, year); //Calling method to print the calendar
     }
     
      /**
     * @param daysList
     * @param datesList
     * @param month
     * @param year
     * @author Hemanth
     * This method for dispaly the calendar 
     */
    public static void printCalendar(LinkedList<String> daysList, LinkedList<String> datesList, int month, int year) {  
        
    	System.out.println("\n\t-----------------------------------------------------------");
        System.out.println("\t\t\t   "+Months.values()[month-1]+" "+year); 
        System.out.println("\t-------------------------------------------------------------"); 
        
        Collections.reverse(daysList);
        Iterator<String> iteratorDays=daysList.iterator();
        
         while(iteratorDays.hasNext()){
                System.out.printf("%10s",daysList.removeFirst());
         }
        System.out.println();
        System.out.println("\t--------------------------------------------------------------"); 
         
        int lineCount=0;
        Collections.reverse(datesList);
        
        Iterator<String> iteratorDates=datesList.iterator();
        while(iteratorDates.hasNext()){
        	
        	lineCount++;
        	System.out.printf("%10s",datesList.removeFirst());
        	if(lineCount%7==0){
        		System.out.println();
             }
        }
        System.out.println();
            System.out.println("\n\t------------------------------------------------------------"); 
        }
    

	/** 
	 * @param year
	 * @param month
	 * @return
	 * @author Hemanth
	 * This method for finding a first day in month
	 */
	public static String findMonthDay(int year, int month) {
		  
		 Calendar c=new GregorianCalendar();
		 c.set(Calendar.DAY_OF_MONTH, 1);		
		 YearMonth yearMonth = YearMonth.of( year,month );  
		 LocalDate firstOfMonth = yearMonth.atDay( 1 );
		 //System.out.println(Days.values()[(firstOfMonth.getDayOfWeek().getValue())]);
		 String startingDayOfMonth =Days.values()[firstOfMonth.getDayOfWeek().getValue()].name();
		
		 return startingDayOfMonth;
	}   

	/**
	 * @param file
	 * @return
	 * @author Hemanth
	 * This method for reading file data 
	 * by using of file reader reading data from file putting in to the buffer reader
	 * and reading line by line data from buffer reader 
	 * and splitting data by space and putting into the Integer array
	 */
	public static String[] readingDataFromFile(File file) {
		String []integersArray=null;
		BufferedReader bufferedReader=null;
		FileReader fileReader=null;
	    try {
	    	//checking file is exist or not
			if (file.exists()) {
				// checking file can have read permission or not
				
				 if(file.canRead()) {
					 
				    	//creating file reader object with parameter of file object 
					    fileReader=new FileReader(file); 
	 
					    // creating bufferedReader object of BufferedReader
					    //reading entire data of file into bufferedReader 
					    bufferedReader=new BufferedReader(fileReader);
					    String s;
					    
					    //reading line by line data  of bufferedReader and storing into string
					    // splitting with space and storing into words array

					    while((s=bufferedReader.readLine())!=null){    	
						       integersArray=s.trim().split(" ");
				        }	
					    
				   } else {
					   System.out.println("you can't read this file");
				  }
				
	         } else {
	      	       System.out.println("File not exists");
	         }
	    } catch(Exception ex){
		
	    	System.out.println("The \" "+ex+" \" Exception is raised");
	    	ex.printStackTrace();
	    } finally {
	    	try {
	    		fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return integersArray;
		
	}
	
	
	/**
	 * @param integersArray
	 * @return
	 * @author Hemanth
	 *  This method for adding elements to Map 
	 *  and adding elements form integer array to Map 
	 *  by using put method
	 */
	public static HashMap<Integer, String> addingArrayElemntsToMap(String [] integersArray){
		
		HashMap<Integer, String> map=new HashMap<Integer,String>();

		for(int i=0;i<integersArray.length;i++){
				map.put(i, integersArray[i]);
		}
		return map;
	}
	
	/**
	 * @param map 
	 * @return 
	 * @author Hemanth
	 *  This method for adding elements to linked list
	 *  and adding elements form Map to linked list 
	 *  by using add method  and while adding converting to integer
	 *  because in Map data is string type
	 */
	
	public static LinkedList<String> addingMapElementsToLinkedList(HashMap<Integer, String> map) {
		LinkedList<String> linkedList=new LinkedList<String>();

		// adding data from words array to liked list object
			for( String s:map.values()) {
				linkedList.add(s);
			}
			return linkedList;
	}
	
	
	/**
	 * @param file
	 * @param linkedList
	 * @param userSearch
	 * @author Hemanth
	 * This method for checking the user entry is present in the linked list
	 * if user entry present in the linked list removing that element from list
	 * if element is not there adding that element to linked list
	 * and overwriting previous data on file with linked list data  
	 * by using file writer and buffer writer
	 */
	public static void userEntrySearching(File file,LinkedList<String> linkedList,String userSearch) {
		
		BufferedWriter bufferedWriter=null;
		FileWriter fileWriter=null;
		  try {
	        	//checking the user entry is present in the linked list
	        	// if exist removing element from linked list
	        	//if it's not there adding to linked list
	        	
					if(linkedList.contains(userSearch)==true) {
						
						linkedList.remove(userSearch);
						//System.out.println(linkedList.size());
						System.out.println("\" "+userSearch+" \" Element was removed from file");
						
					  } else {
						  linkedList.add(userSearch);
						  //System.out.println(linkedList.size());
						   System.out.println("\" "+userSearch+" \" Element was added to file");
			               Collections.sort(linkedList);
					  }
					 LinkedHashSet <String> set=new LinkedHashSet();
					 set.addAll(linkedList);
					//taking all the liked list data as a string 
					  String ss="";
					  for(String str:set){
						  ss=ss+" "+str;
					  }
					   //string re writing into the file 
					   fileWriter = new FileWriter(file);
					   bufferedWriter = new BufferedWriter(fileWriter);
					   bufferedWriter.write(ss);
					   bufferedWriter.flush();
					   bufferedWriter.close();
					   
	            } catch(Exception ex) {
				
				    System.out.println("The \" "+ex+" \" Exception is raised");
				    ex.printStackTrace();
			    }
		
	}
	
	/**
	 * @param file
	 * @author Hemanth
	 * This method for displaying file data to user screen 
	 * by using of file reader reading a data from file putting in to the buffer reader
	 * and reading line by line data from buffer reader 
	 */
	public static void displayingListWords(File file) {

		BufferedReader bufferedReader=null;
		FileReader fileReader=null;
		try {
			
			if(file.canRead()) {
					fileReader=new FileReader(file);
					bufferedReader=new BufferedReader(fileReader);
					String s;
					while((s=bufferedReader.readLine())!=null) {
						
						 System.out.println(s);	
						
						}
			 } else {
				
					   System.out.println("you can't read this file");
				    }
	     } catch(Exception ex) {
				
				System.out.println("The \" "+ex+" \" Exception is raised");
				ex.printStackTrace();
			} finally {
				 try {
						fileReader.close();
						bufferedReader.close();
				} catch(Exception ex) {
					
					System.out.println("The \" "+ex+" \" Exception is raised");
					ex.printStackTrace();
				}
		}
		
	}
	

	/**
	 * @param integersArray
	 * @return
	 * This method for reading file data 
	 * by using of file reader reading data from file putting in to the buffer reader
	 * and reading line by line data from buffer reader 
	 * and splitting data by space and putting into the Integer array
	 */
	public static LinkedList<String> addingArrayElemntsToToLinkedList(String[] integersArray) {
		LinkedList<String> linkedList=new LinkedList<String>();
		// adding data from words array to liked list object
					for( String s:integersArray){
						linkedList.add(s);
					}
	return linkedList;
					
	}

	/**
	 * @param userString
	 * @param popingString
	 * @author Hemanth
	 * <p>This method for checking whether given string is palindrome or not 
	 */
	public static void isStringPalindrome(String userString,String popingString) {
		if(userString.equals(popingString)){
     	   System.out.println("Given string is palindrome: ");
        } else {
     	   System.out.println("Given string is not palindrome: ");
        }		
	}

	/**
	 * @param deque
	 * @return
	 * @author Hemanth
	 * <p>This method for poing elemnts form deque
	 */
	public static String popingElementsDequeRare(Deque<Character> deque) {
		String popingString="";
		try {
			//System.out.println(deque.size());
			while(!deque.isEmpty()){
				popingString=popingString+deque.removeLast();
			}
		}catch(Exception ex){
			
			System.out.println("The \" "+ex+" \" Exception is raised");
			ex.printStackTrace();
		}	
		return popingString;
	}

	/**
	 * @param userString
	 * @return
	 * @Hemanth
	 * <p> This method for pushing elements DequeRare
	 */
	public static Deque<Character> pushingElementsDequeRare(String userString) {
		Deque<Character> deque=new ArrayDeque<Character>();

		try {
			
			for(int i=0;i<userString.length();i++){
				deque.addLast(userString.charAt(i));
			}
	}catch(Exception ex){
		
		System.out.println("The \" "+ex+" \" Exception is raised");
		ex.printStackTrace();
	}
		return deque;
	}
	/**
	 * @param low
	 * @param high
	 * @return
	 * @author Hemanth
	 * <p>This method for find prime numbers in given range
	 */
	public static  ArrayList<Integer> primeNumbers(int low,int high) {
		
		ArrayList<Integer> primeNumbersList=new ArrayList<Integer>();
		
			for(int i = 2; i <=high; i++) {
                 boolean isPrime=true;
	             for( int j = 2; j < i; j++){
	             
	                 if(i % j == 0) {
	                 
	                     isPrime=false;
	                 }    
	             }
	             if(isPrime) 
	            	 primeNumbersList.add(i);   
	             
	         }
		return primeNumbersList;
	}
	
	/**
	 * @param arrayList
	 * @author Hemanth
	 * <p>This method for print 2d array manner 
	 */
	public static void printArray(	ArrayList<Integer> arrayList){
		int [][]integerArray=new int[10][25];
		Iterator<Integer> iterator=arrayList.iterator();
	    int k=0;
        int l=0;
        int m=0;

        while(iterator.hasNext()){
        	int temp=iterator.next();                    
        	k=temp/100;
        	if(k!=m){
        		m=k;
        		l=0;
        	}
        	integerArray[k][l++]=temp;	  
		}
        for(int ii[]:integerArray){
        	for(int j:ii){
        		if(j==0){
                	System.out.print("  ");
                	continue;
        		}
        	    System.out.printf("%5d",j);
        	}
        	System.out.println();
        }	
	}

	/**
	 * @param primeAnagrams
	 * @author Hemanth
	 * <p>This method for generate anagram Queue 
	 */
	public static void generateAnagramQueue(int[][] primeAnagrams) {
		
		LinkedList<Integer> queue=new LinkedList<Integer>();
		Iterator<Integer> iterator=null;
		for(int []i:primeAnagrams) {
			for(int j:i){
			queue.addLast(j);;
		}
		}
		iterator=queue.iterator();
        System.out.println("Anagrams are: ");
		while(iterator.hasNext()){
		int ele = queue.removeFirst();
		if (ele==0){
			continue;
		}
			System.out.print(ele+"  ");
		}
	}
	
	/**
	 * @param low
	 * @param high
	 * @return
	 * @author Hemanth
	 * <p>This method for generate prime numbers array 	 
	 * */
	public static int[][] primeNumbersArray(int low, int high){
		int [][]primeNumbersArray= new int[10][25];

		int l=0;
		int k=0;
		int m=0;
		for(int i=2;i<high;i++){
			int flag=0;
			for(int j=2;j<=(i/2);j++){
				if(i%j==0){
					flag=1;
					break;
				}
			}if(flag==0){
				k=i/100;
				if(k!=m){
					m=k;
					l=0;
				}
				primeNumbersArray[k][l++]=i;
				
			}
		}
		return primeNumbersArray;
	}
	
	/**
	 * @param primeAnagrams
	 * @author Hemanth
	 * <p>This method for display prime anagrams array 	 
	 */
	public static void printPrimeAnagram(int [][]primeAnagrams){
		System.out.println("*****************Anagramsss are : ");
		for(int i=0;i<primeAnagrams.length;i++){
			for(int j=0;j<primeAnagrams[i].length;j++){
				if(primeAnagrams[i][j]!=0)
					System.out.print(primeAnagrams[i][j]+"\t");
				else
					System.out.print("   "+"\t");
			}System.out.println();
		}
	}
	
	/**
	 * @param primeNonAnagrams
	 * @author Hemanth
	 * <p>This method for display non  prime anagrams array 	
	 */
	public static void printPrimeNonAnagram(int [][]primeNonAnagrams){
		System.out.println("**********************Non Anagramsss");
		for(int i=0;i<primeNonAnagrams.length;i++){
			for(int j=0;j<primeNonAnagrams[i].length;j++){
				if(primeNonAnagrams[i][j]==0)
					System.out.print("");
				else
					System.out.printf(primeNonAnagrams[i][j]+"\t");
			}System.out.println();
		}
	}
	
	/**
	 * @param primeNumbersArray
	 * @return
	 * @author Hemanth
	 * <p>This method for anagram checking
	 */
	public static int[][] anagramChecking(int[][] primeNumbersArray) {
		
		int primeAnagramsArray[][]= new int[10][8];
		for(int i=0; i<primeNumbersArray.length;i++){
			int a=0;
			for(int j=0;j<primeNumbersArray[i].length;j++){
				if(primeNumbersArray[i][j]==0) {
					break;
				}
				int flag1=0;
				char[] c1=Integer.toString(primeNumbersArray[i][j]).toCharArray();
				char[] c2=Arrays.copyOf(c1, c1.length);
				Arrays.sort(c2);
				
				for(int k=j+1;k<primeNumbersArray[i].length;k++) {
					char[] c3=String.valueOf(primeNumbersArray[i][k]).toCharArray();
					char[] c4=Arrays.copyOf(c3, c3.length);
					Arrays.sort(c4);
					if(Arrays.equals(c2, c4)){
						flag1=1;
						int s=Integer.parseInt(new String(c3));
						primeAnagramsArray[i][a++]=s;
					}
				} if(flag1==1) {
					int s=Integer.parseInt(new String(c1));
					primeAnagramsArray[i][a++]=s;
				}
			}
		}
		return primeAnagramsArray;
	}
	
	/**
	 * @param primeNumbersArray
	 * @param primeAnagramsArray
	 * @return
	 * @author Hemanth
	 * <p>This method for non anagrams 
	 */
	public static int[][] nonAnagram( int[][] primeNumbersArray,int [][]primeAnagramsArray){
		int[][] nonAnagramsArray= new int[10][17];
		for(int i=0;i<primeNumbersArray.length;i++){
			int a=0;
			for(int j=0;j<primeNumbersArray[i].length;j++){
				int flag=0;
				for(int k=0;k<primeAnagramsArray[i].length;k++){
					if(primeNumbersArray[i][j]==primeAnagramsArray[i][k]){
						flag=1;
						break;
					}
				 }if(flag==0) {
					nonAnagramsArray[i][a++]=primeNumbersArray[i][j];
				  }
			}
		}
		return nonAnagramsArray;
	}

	/**
	 * @param primeArray
	 * @author Hemanth
	 * <p>This method for generate anagram stack
	 */
	public  static void generateAnagramStack(int[][] primeArray) {
		
		LinkedList<Integer> stack=new LinkedList<Integer>();
		Iterator<Integer> iterator=null;
		for(int []i:primeArray) {
			for(int j:i){
			stack.addFirst(j);
			}
		}
		iterator=stack.iterator();
		
		while(iterator.hasNext()){
			int ele = stack.removeFirst();
			if (ele==0){
				continue;
			}
				System.out.print(ele+"  ");
			}
		
	}
		
	/**
	 * @param n
	 * @return
	 * @author Hemanth
	 * <p>This method for find number of possibles to generate binary search tree
	 */
	public static long findPossibles(int n) {
	
		String t1 = fact(2*n);
		String t2 = fact(n+1);
		String t3 = fact(n);
		long count1 = Long.parseLong(t1)/(Long.parseLong(t2)*Long.parseLong(t3));
		return count1;
    }
	/**
	 * @param n
	 * @return
	 * @author Hemanth
	 * <p>This method for find number of possibles 
	 */
	public static String fact(int n) {
       BigInteger fact = new BigInteger("1");
       for (int i = 1; i <= n; i++) {
           fact = fact.multiply(new BigInteger(i + ""));
       }
       return fact.toString();
	}

	/**
	 * @return
	 * * @author Hemanth
	 * <p>This method for create queue in the bank
	 */
	public static LinkedList<String> createQueue() {
		Scanner scanner=new Scanner(System.in);
		LinkedList<String> queue=new LinkedList<String>();
		boolean check=true;
		try {
				do {
					System.out.println("press \"Y\" for srevices from us: ");
					String choice=scanner.nextLine().toLowerCase();
					if(choice.equals("y")) {
						System.out.println("Enter your Name: ");
						String name=scanner.nextLine();
						String balance="10000";
						String PersonAccount=name+" "+balance;
						queue.addLast(PersonAccount);
						
					} else {
						     System.out.println("if you dont want a service press \"Y\"");
						     String userChoice=scanner.nextLine();
						     if(userChoice.equals("y")) {
						    	 return queue;
						     } else {
						    	 check=true;
						     }
					}
				} while(check);
		} catch(Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} finally {
		}
		return queue;

	}

	/**
	 * @param queue
	 * @return
	 * @author Hemanth
	 * <p>This method for providing services to users  
	 */
	public static  LinkedList<String> selectService(LinkedList<String> queue) {
		
		Scanner scanner=new Scanner(System.in);
		boolean check=true;
		LinkedList<String> queue1=new LinkedList<String>();
		try {
				do {
					System.out.println("select your service: \n1.Deposit \n2.Withdrawl");
					int choice=scanner.nextInt();
					switch(choice) {
					
					case 1:  System.out.println("Enter your amount to deposit   : ");
							 int depositAmount=scanner.nextInt();
							 String person=deposit(queue,depositAmount);
							 queue1.add(person);
							// queue.removeFirst();
							 break;
							 
					case 2:  System.out.println("Enter your amount to withdrawl : ");
							 int withdrawlAmount=scanner.nextInt(); 
							 String person1=withdrawl(queue,withdrawlAmount);
							 queue1.add(person1);
							// queue.removeFirst();
							 break;
					default: System.out.println("Your enterd wrong choice: ");		
					}
				
					if(queue.isEmpty()) {
						check=false;
					}
				}while(check);
		} catch (Exception ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} finally {
		}
		return queue1;
	}

	/**
	 * @param queue
	 * @param withdrawlAmount
	 * @return
	 * @author Hemanth
	 * <p>This method for withdraw amount from his account
	 */
	private static String withdrawl(LinkedList<String> queue, int withdrawlAmount) {
		
		String[] personDetails=queue.removeFirst().split(" ");
		int balance=Integer.parseInt(personDetails[1]);
		int finalBalance=balance-withdrawlAmount;
		return (personDetails[0]+" "+finalBalance);
		//return queue;
	}

	/**
	 * @param queue
	 * @param depositAmount
	 * @return
	 * @author Hemanth
	 * <p>This method for deposit amount to his account
	 */
	private static String deposit(LinkedList<String> queue, int depositAmount) {
		
		String[] personDetails=queue.removeFirst().split(" ");
		int balance=Integer.parseInt(personDetails[1]);
		int finalBalance=balance+depositAmount;
		return(personDetails[0]+" "+finalBalance);
		//return queue;
	}

	/**
	 * @param finalQueue
	  * @author Hemanth
	 * <p>This method for display  user amount from his account
	 */
	public static void displayUserAmount(LinkedList<String> finalQueue) {
		
		System.out.println("Details of users: ");
		
		while(!finalQueue.isEmpty()) {
			System.out.println(finalQueue.removeFirst());
		}
	}

	/**
	 * @param file
	 * @return
	 * @author Hemanth
	 * <p> This method for reading data from file  and adding to list
	 */
	public static String[] readDataFromFile(File file) {
		
		String []integersArray=null;
		BufferedReader bufferedReader=null;
		FileReader fileReader=null;
	    try {
	    	//checking file is exist or not
			if (file.exists()) {
				// checking file can have read permission or not
				
				 if(file.canRead()) {
					 
				    	//creating file reader object with parameter of file object 
					    fileReader=new FileReader(file); 
	 
					    // creating bufferedReader object of BufferedReader
					    //reading entire data of file into bufferedReader 
					    bufferedReader=new BufferedReader(fileReader);
					    String s;
					    
					    //reading line by line data  of bufferedReader and storing into string
					    // splitting with space and storing into words array

					    while((s=bufferedReader.readLine())!=null){    	
						       integersArray=s.trim().split(" ");
				        }	
					    for(String str:integersArray) {
					    	generateKeys(str);
					    }
				   } else {
					   System.out.println("you can't read this file");
				  }
				
	         } else {
	      	       System.out.println("File not exists");
	         }
	    } catch(Exception ex){
		
	    	System.out.println("The \" "+ex+" \" Exception is raised");
	    	ex.printStackTrace();
	    } finally {
	    	try {
	    		fileReader.close();
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    return integersArray;
	
	}

	/**
	 * @param key
	 * @author Hemanth
	 * <p>This method for creating map key and value 
	 */
	public static void generateKeys(String key) {
		
		int remainder=Integer.parseInt(key)%11;
		fillingToMap(key,remainder);
	}
	
	static Map<Integer,LinkedList<String>> map=new LinkedHashMap<Integer,LinkedList<String>>();
	static LinkedList<String>list=new LinkedList<String>();
	/**
	 * @return
	 * @author Hemanth
	 * <p> This method for adding elements from map to linked list
	 */
	public static LinkedList<String> addingMapElementsToLinkedList( ) { 
		LinkedList<String> linkedList=new LinkedList<String>();

		// adding data from words array to liked list object
			for( LinkedList list:map.values()) {
				for(Object obj:list ) {
					linkedList.add((String)obj);
				}
			}
			return linkedList;
	}
	/**
	 * @param value
	 * @param key
	 * @author Hemanth
	 * <p>This method for adding elements to Map 
	 */
	private static void fillingToMap(String value, int key) {
		
	
		if(map.containsKey(key)) {
			list.addLast(value);
			map.put(key, list);
		} else {
			LinkedList<String>list1=new LinkedList<String>();

			list1.add(value);
			map.put(key, list1);
		}
		
	}
}
