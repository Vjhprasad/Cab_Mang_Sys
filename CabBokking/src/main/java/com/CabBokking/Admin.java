package com.CabBokking;
import java.sql.*;
import java.util.*;
public class Admin {

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
		
	public void Adm_Mng() throws SQLException {
		
		Connection con = getconn();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Mng_Approval");
		//System.out.println("id\t\E_id\t\\t\password\t\Request");
		System.out.println();
		while(rs.next())
		{	
			System.out.println("id:"+rs.getInt(1)+" E_id:"+rs.getInt(2)+" username:"+rs.getString(3)+" Request:"+rs.getString(4));
			System.out.println();
		}
		
		String s1 = "y";
		
		System.out.println("Add Manager. Press y/n");
		String s = sc.next();
		while(s1.equals("y")) {
		if(s.equals("y"))
		{
			
			try
			{
				String ins = "insert into managers(ID,USerName,Password) values(?,?,?)";
				PreparedStatement stmt1 = con.prepareStatement(ins);
				
				System.out.println("Enter username:");
				String us = sc.next();
				System.out.println("Enter password:");
				String ps = sc.next();
				
				stmt1.setInt(1,0);
				stmt1.setString(2, us);
				stmt1.setString(3, ps);
				int a =stmt1.executeUpdate();
				if(a>0)
					System.out.println("***Manager Added Successfully***");
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("please enter the correct INput_TYPE "+e);
			}
			
		}
		System.out.println("want to add another Manager. Press y/n");
		s1=sc.next();
		}
	}

	public void Adm_Emp() throws SQLException {
		
		Connection con = getconn();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Emp_BkDetails");
		//System.out.println("id\t\E_id\t\\t\password\t\Request");
		System.out.println();
		while(rs.next())
		{	
			System.out.println("id:"+rs.getInt(1)+" username:"+rs.getString(2)+" location:"+rs.getString(3)+" Destination:"+rs.getString(4)+" cab_No:"+rs.getInt(5));
			System.out.println();
		}
		

		String s1 = "y";
		
		System.out.println("Add Employee. Press y/n");
		String s = sc.next();
		while(s1.equals("y")) {
		if(s.equals("y"))
		{
			
			try
			{
				String ins = "insert into employees(ID,E_UserName,E_Password) values(?,?,?)";
				PreparedStatement stmt1 = con.prepareStatement(ins);
				
				System.out.println("Enter username:");
				String us = sc.next();
				System.out.println("Enter password:");
				String ps = sc.next();
				
				stmt1.setInt(1,0);
				stmt1.setString(2, us);
				stmt1.setString(3, ps);
				int a =stmt1.executeUpdate();
				if(a>0)
					System.out.println("***Employee Added Successfully***");
				
			}
			catch(InputMismatchException e)
			{
				System.out.println("please enter the correct INput_TYPE "+e);
			}
			
		}
		System.out.println("want to add another Employee. Press y/n");
		s1=sc.next();
		}

		
	}

	public void Adm_cab() throws SQLException  {
		Connection con = getconn();
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from cab");
		while(rs.next())
		{
			System.out.println("id:"+rs.getInt(1)+" cb_No:"+rs.getInt(2)+" cab_Type:"+rs.getString(3));
			System.out.println();
		}
		
		Boolean flag2 = true;
		String c = "y";
		do {
			while(c.equals("y")) {
			System.out.println("press 1 for add a cab");
			System.out.println("press 2 for update a cab");
			System.out.println("Press 3 for delete a Cab");
			System.out.println("press 4 to LogOut");
			int op = sc.nextInt();
			
			switch(op)
			{
			case 1:
				try {
				String s1 = "insert into cab(id, cb_No, cab_Type) values(?,?,?)";
			    PreparedStatement stmt1 = con.prepareStatement(s1);
				
			    System.out.println("Enter cab number:");
			    int cn = sc.nextInt();
			    System.out.println("Enter cab type:");
			    String ct = sc.next();
			    
			    stmt1.setInt(1,0);
			    stmt1.setInt(2,cn);
			    stmt1.setString(3,ct);
			    int c1 = stmt1.executeUpdate();
			    System.out.println( "***cab Added***");
				}
			    catch(InputMismatchException ex)
			    {
			    	System.out.println("please enter the correct INPUT_TYPE DETAILS "+ex);
			    }
				
				flag2 = false;
				break;	
			case 2:
				System.out.println("which one do u want to update(cb_No,cab_Type)");
				String u1 = sc.next();
				
				String qry = new String();
				if(u1.equals("cb_No"))
				{
					System.out.println("Enter a value (cab number)");
					int u2 = sc.nextInt();
					System.out.println("Enter id number:");
					int u3 = sc.nextInt();
					qry = "update cab set "+u1+"='"+u2+"' where id="+u3;
					
				}else
				{
					System.out.println("Enter a value (cab type)");
					String u2 = sc.next();
					System.out.println("Enter id number:");
					int u3 = sc.nextInt();
					qry = "update cab set "+u1+"='"+u2+"' where id="+u3;
				}
				Statement stmt1 = con.createStatement();
		        stmt1.executeUpdate(qry);
		        System.out.println("Your Query was Successfully Updated");
				
				
				flag2=false;
				break;
			case 3:
				try {
				System.out.println("Enter id number to delete");
				int cn = sc.nextInt();
				Statement stmt2= con.createStatement();
				String s2 = "delete from cab where id="+cn;
				stmt2.executeUpdate(s2);
				System.out.println("***cab deleted***");
				}catch(InputMismatchException e)
				{
					System.out.println("please enter the correct INPUT_TYPE DETAILS "+e);
				}
				
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
		
	}
