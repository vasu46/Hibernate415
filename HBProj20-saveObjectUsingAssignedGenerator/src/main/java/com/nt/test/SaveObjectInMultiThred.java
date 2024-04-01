package com.nt.test;

public class SaveObjectInMultiThred {

	public static void main(String[] args) {
		TicketBookingOperation operation=new TicketBookingOperation();
		Thread th1=new Thread(operation);
		 th1.start();
		 
		 Thread th2=new Thread(operation);
		 th2.start();
		 
		 Thread th3=new Thread(operation);
		 th3.start();
				 
	}

}
