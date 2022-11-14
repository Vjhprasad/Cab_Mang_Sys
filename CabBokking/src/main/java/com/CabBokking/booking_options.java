package com.CabBokking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class booking_options {

	Scanner sc = new Scanner(System.in);
	
	public Connection getconn()
    {
        Connection con = null;
        try
        {
            String url= "jdbc:mysql://localhost:3306/cab";
            String usernm="root";
            String pass="vijay@123456";
            con = DriverManager.getConnection(url,usernm,pass);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
	
	
	public void admin() throws SQLException {
	
		Boolean flag1 = true;
		do
		{
		System.out.println("Enter UserName:");
		String un = sc.next();
		System.out.println("Enter PassWord:");
		String pw = sc.next();
		
		Connection con = getconn();
		Statement stmt= con.createStatement();
		String s1= "select UserName,Password from admin";
		ResultSet rs = stmt.executeQuery(s1);
	   if(rs.next()) {
		if(rs.getString(1).equals(un) && rs.getString(2).equals(pw))
		{
			System.out.println("***Your Authentication Successfull***");
			flag1 = false;
		}
		else
		{
			System.out.println("\n please enter correct details");
		}
	}
	}while(flag1);
	
		Admin ad = new Admin();
		Boolean flag2 = true;
		String c = "y";
		do {
			while(c.equals("y")) {
			System.out.println("press 1 for Manager");
			System.out.println("press 2 for Employee");
			System.out.println("Press 3 for Cab");
			System.out.println("press 4 to LogOut");
			int op = sc.nextInt();
			
			switch(op)
			{
			case 1: 
				ad.Adm_Mng();
				flag2 = false;
				break;
			case 2:
				ad.Adm_Emp();
				flag2=false;
				break;
			case 3:
				ad.Adm_cab();
				flag2= false;
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("wrong choice");
			}
			System.out.println("want to continue as Admin. press y/n");
            c = sc.next();
			}
		}while(flag2);
	}
	
	
	
	public void Manager() throws SQLException {
		Connection con = getconn();
		Boolean flag1 = true;
		do
		{
		System.out.println("Enter UserName:");
		String un = sc.next();
		System.out.println("Enter PassWord:");
		String pw = sc.next();
		
		
		Statement stmt= con.createStatement();
		String s1= "select UserName,Password from managers";
		ResultSet rs = stmt.executeQuery(s1);
	   if(rs.next()) {
		if(rs.getString(1).equals(un) && rs.getString(2).equals(pw))
		{
			System.out.println("***Your Authentication Successfull***");
			flag1 = false;
		}
		else
		{
			System.out.println("\n please enter correct details");
		}
	}
	}while(flag1);
		
		

		try
		{
			String ins = "insert into mng_approval(id, E_id, Mng_username, cab_Request) values(?,?,?,?)";
			PreparedStatement stmt1 = con.prepareStatement(ins);
			
			System.out.println("Enter E_id");
			int id = sc.nextInt();
			System.out.println("Enter mng_username:");
			String us = sc.next();
			System.out.println("Enter cab_requs (Appove/Deny):");
			String ps = sc.next();
			
			stmt1.setInt(1,0);
			stmt1.setInt(2, id);
			stmt1.setString(3, us);
			stmt1.setString(4, ps);
			int a =stmt1.executeUpdate();
			if(a>0)
				System.out.println("***Status aploaded***");
			
		}
		catch(InputMismatchException e)
		{
			System.out.println("please enter the correct INput_TYPE "+e);
		}
		
	}

	
	
	
	public void Employee() throws SQLException {
		
		Connection con = getconn();
		Boolean flag1 = true;
		do
		{
		System.out.println("Enter UserName:");
		String un = sc.next();
		System.out.println("Enter PassWord:");
		String pw = sc.next();
		
		
		Statement stmt= con.createStatement();
		String s1= "select E_UserName, E_Password from employees";
		ResultSet rs = stmt.executeQuery(s1);
	   if(rs.next()) {
		if(rs.getString(1).equals(un) && rs.getString(2).equals(pw))
		{
			System.out.println("***Your Authentication Successfull***");
			flag1 = false;
		}
		else
		{
			System.out.println("\n please enter correct details");
		}
	}
	}while(flag1);
		
		

		try
		{
			String ins = "insert into Emp_BkDetails(Id, user_Name, location, destination, cab_No) values(?,?,?,?,?)";
			PreparedStatement stmt1 = con.prepareStatement(ins);
			
			System.out.println("Enter id");
			int id = sc.nextInt();
			System.out.println("Enter E_username:");
			String us = sc.next();
			System.out.println("Enter loaction:");
			String ps = sc.next();
			System.out.println("Enter destination:");
			String ds = sc.next();
			System.out.println("Enter cab_No:");
			int cb = sc.nextInt();
			
			
			stmt1.setInt(1,id);
			stmt1.setString(2, us);
			stmt1.setString(3, ps);
			stmt1.setString(4, ds);
			stmt1.setInt(5, cb);
			
			int a =stmt1.executeUpdate();
			if(a>0)
				System.out.println("***Booking Details aploaded***");
			
		}
		catch(InputMismatchException e)
		{
			System.out.println("please enter the correct INput_TYPE "+e);
		}
		
		
		
		
	}

}