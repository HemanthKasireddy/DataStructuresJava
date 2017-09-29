package com.bridgeit.datastrucers.Programs;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import com.bridgeit.datastrucers.Utility.Utility;

//class WeeklyCalender {
	/*enum Months{ January,February,March,April,May,June,July,August,September,October,November,December }
	enum Days   { Sun,Mon,Tue,Wed,Thu,Fri,Sat }

    int daysInMonth[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
       
    //Method to match the given month and return its maximum days
    public  int findMaxDay(int mname, int y) {    
    	
        if((y%400==0) || (y%4==0)) {
        	daysInMonth[2]=29;
        }   
        return  daysInMonth[mname];     
    }
     
    // Method to match the given weekday name and return its weekday no.
     public  int findDayNo(String wname){ 
    	 
    	 int find = 0;
    	 for(int i=0; i<7; i++) {
    		 
    	 	if(wname.equalsIgnoreCase(Days.values()[i].name())) {
    	 		find = i; 
    	 	}
          }
        return find;
    }
     
    // Method for creating the calendar
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
     
      private void printCalendar(LinkedList<String> daysList, LinkedList<String> datesList, int month, int year) {  
        
    	System.out.println("\n\t-----------------------------------------------------------");
        System.out.println("\t\t\t   "+Months.values()[month-1]+" "+year); 
        System.out.println("\t-------------------------------------------------------------"); 
        
        Iterator<String> iteratorDays=daysList.iterator();
        
         while(iteratorDays.hasNext()){
                System.out.printf("%10s",daysList.removeFirst());
         }

        System.out.println();
        System.out.println("\t--------------------------------------------------------------"); 
         
        int lineCount=0;
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
    
      
	*//**
	 * This method for finding a first day in month
	 * 
	 * @param year
	 * @param month
	 * @return
	 *//*
	public String findMonthDay(int year, int month) {
		  
		 Calendar c=new GregorianCalendar();
		 c.set(Calendar.DAY_OF_MONTH, 1);		
		 YearMonth yearMonth = YearMonth.of( year,month );  
		 LocalDate firstOfMonth = yearMonth.atDay( 1 );
		 //System.out.println(Days.values()[(firstOfMonth.getDayOfWeek().getValue())]);
		 String startingDayOfMonth =Days.values()[firstOfMonth.getDayOfWeek().getValue()].name();
		
		 return startingDayOfMonth;
	}   
}*/
public class WeeKDay {
	 public static void main(String args[])
	    {
			int mname=Integer.parseInt(args[0]);
			int year=Integer.parseInt(args[1]);
			
			//WeeklyCalender weeklyCalender = new WeeklyCalender();

	        int maxDaysInMonth = Utility.findMaxDay(mname,year);
	        
	        String firstDayOfMonth=Utility.findMonthDay(year,mname);
	        
	        int dayNumberInMonth = Utility.findDayNo(firstDayOfMonth); 
	        
	        Utility.fillCalendarQueue(maxDaysInMonth, dayNumberInMonth, mname, year);

      }
}
