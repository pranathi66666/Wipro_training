package com.wipro;
import java.time.LocalDate;
public class DateAfter3Years {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate today=LocalDate.now();
		LocalDate future1=today.plusYears(3);
		LocalDate future2=future1.plusWeeks(12);
        System.out.println(future1);
        System.out.println(future2);
	}

}
