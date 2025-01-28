package com.wipro;
import java.time.LocalDate;
public class CheckLeap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         LocalDate today=LocalDate.now();
         if(today.isLeapYear()) {
        	 System.out.println("It's Leap year");
         }
         else {
        	 System.out.println("Not a Leap Year");
         }
         
	}

}
