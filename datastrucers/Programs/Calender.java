package com.bridgeit.datastrucers.Programs;

import com.bridgeit.datastrucers.Utility.Utility;


public class Calender {
	
		 public static void main(String args[])
		    {
				int mname=Integer.parseInt(args[0]);
				int year=Integer.parseInt(args[1]);
				
		        int maxDaysInMonth = Utility.findMaxDay(mname,year);
		        String firstDayOfMonth=Utility.findMonthDay(year,mname);
		        
		        int dayNumberInMonth = Utility.findDayNo(firstDayOfMonth); 
		        
		        Utility.fillCalendar(maxDaysInMonth,dayNumberInMonth,mname,year);
		    }
	}

