package com.CabBokking;

import java.sql.SQLException;
import java.util.*;
public class CabManagement {

	 public static void main(String[] args) throws SQLException
	    {
	        booking_options bp= new booking_options(); 
	        Scanner sc = new Scanner(System.in);  
	        Boolean flag = true;
	        String c="y";
	        
	        do 
	        {
	        	while(c.equals("y")) {
	        	try {
	            System.out.println("press 1 to Login as Admin");
	            System.out.println("press 2 to Login as Manager");
	            System.out.println("press 3 to Login as Employee");
	            System.out.println("press 4 to choose EXIT");

	            
	            int op = sc.nextInt();
	            
	            switch(op)
	            {
	            case 1: bp.admin();
	                flag = false;
	                break;
	            case 2: bp.Manager();
	                flag = false;
	                break;
	            case 3: bp.Employee();
	            	break;
	            case 4: 
	                System.exit(0);
	            default : System.out.println("wrong choice u have entered");
	                System.out.println("Please Enter the Correct One");
	                break;
	            }
	        }
	        catch(InputMismatchException ex)
	        {
	      	  System.out.println("please Enter the correct INPUT_TYPE DETAILS "+ex);
	        }
	        	System.out.println("want to continue. press y/n");
	            c = sc.next();
				}
	        }
	        while(flag);
	    }
}