package coreJava;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class ask {
	Scanner sc = new Scanner(System.in);

	public void ask() {
		System.out.println("----------------------Menu-------------------------");
		System.out.println("1-- Add");
		System.out.println("2-- Display");
		System.out.println("3-- Update");
		System.out.println("4-- Remove");
		System.out.println("5-- Find Student");
		System.out.println("6-- Find Students by City or Standard");
		System.out.println("7-- Exit");
		System.out.println("-----------------------------------------------");
		System.out.println("Enter a choice : ");
		System.out.println("-----------------------------------------------");

		String choice = null;
		choice = sc.next();

		switch (choice) {
		case "1":
				addItem();
			break;
			
		case "2":
			display();
				
			break;

		case "3":
			   update();
			break;

		case "4":
			delete();
			break;
		case "5":
			displayOne();
			break;
			
		case "6":
			find();
			break;
			
		case "7":
			exit();
			break;


		default:
			break;
		}

	}

	public void addItem() {
		try
		{
			
			System.out.println("Enter Rollno");
			int rollNo=sc.nextInt();
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enter Contact No");
			String contactNo=sc.next();
			System.out.println("Enter City");
			String city=sc.next();
			System.out.println("Enter Email ID");
			String email=sc.next();
			System.out.println("Enter Standard");
			String standard=sc.next();
			
			Connection connection=Dbconnect.dbConnection();
		System.out.println("Connection is created ");
		Statement statement=connection.createStatement();
		String query="insert into `aegisisc`.`student`(`rollNo`,`name`,`contactNo`,`city`,`email`, `standard`) values('"+rollNo+"','"+name+"','"+contactNo+"','"+city+"','"+email+"','"+standard+"')";
		statement.executeUpdate(query);
		System.out.println("-----------------------------------------------");
		System.out.println(rollNo + ", "+name + ", "+contactNo + ", "+city + ", "+email + ", "+standard);
		
		display();
		
		}
		catch (Exception e) {
			System.out.println(e);
		}

			}
	
	public void delete() {
		try
		{
			
			System.out.println("Please enter Student Roll No Who u want to remove");
			String rollNo=sc.next();
			String sure = null;
			System.out.println("Are You sure want to delete (Y/N) : ");
			sure = sc.next();
			if (sure.equals("y")) {
				Connection connection=Dbconnect.dbConnection();
				Statement statement=connection.createStatement();
				String query ="DELETE FROM student WHERE (rollNo='"+rollNo+"')";
				statement.executeUpdate(query);
			} else {

			}
			

		display();

//		ask();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void display(){
		try
		{
			System.out.println("-----------------------------------------------");
			Connection connection=Dbconnect.dbConnection();
		Statement statement=connection.createStatement();
		ResultSet rs=statement.executeQuery("Select * FROM student ");// to show any one row use ex "where id=4" after result
//		System.out.println(rs);
		
		while(rs.next())
			{
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
		
		System.out.println("-----------------------------------------------");
		ask();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void displayOne(){
		try
		{
			System.out.println("-----------------------------------------------");
			
			
			System.out.println("1-- Want to search by Roll No");
			System.out.println("2-- Want to search by Name");
			String sure = null;
			sure = sc.next();
			if (sure.equals("1")) {
			System.out.println("Please enter Student Roll No");
			String rollNo=sc.next();
			Connection connection=Dbconnect.dbConnection();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("Select * from student WHERE (rollNo='"+rollNo+"')");
			System.out.println("-----------------------------------------------");
			while(rs.next())
			{
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
			} else if(sure.equals("2")) {
				System.out.println("Please enter Student Name");
				String name=sc.next();
				Connection connection=Dbconnect.dbConnection();
				Statement statement=connection.createStatement();
				ResultSet rs=statement.executeQuery("Select * from student WHERE (name='"+name+"')");
				System.out.println("-----------------------------------------------");
				while(rs.next())
				{
				System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				}
			}			
		
		System.out.println("-----------------------------------------------");
		ask();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void find(){
		try
		{
			System.out.println("-----------------------------------------------");
			
			
			System.out.println("1-- Want to search by City");
			System.out.println("2-- Want to search by Standard");
			String sure = null;
			sure = sc.next();
			if (sure.equals("1")) {
			System.out.println("Please enter City");
			String city=sc.next();
			Connection connection=Dbconnect.dbConnection();
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("Select * from student WHERE (city='"+city+"')");
			System.out.println("-----------------------------------------------");
			while(rs.next())
			{
			System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
			} else if(sure.equals("2")) {
				System.out.println("Please enter Standard");
				String standard=sc.next();
				Connection connection=Dbconnect.dbConnection();
				Statement statement=connection.createStatement();
				ResultSet rs=statement.executeQuery("Select * from student WHERE (standard='"+standard+"')");
				System.out.println("-----------------------------------------------");
				while(rs.next())
				{
				System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				}
			}			
		
		System.out.println("-----------------------------------------------");
		ask();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void update(){
		try
		{
			System.out.println("-----------------------------------------------");
			System.out.println("Enter Rollno");
			int rollNo=sc.nextInt();
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enter Contact No");
			String contactNo=sc.next();
			System.out.println("Enter City");
			String city=sc.next();
			System.out.println("Enter Email ID");
			String email=sc.next();
			System.out.println("Enter Standard");
			String standard=sc.next();			
			Connection connection=Dbconnect.dbConnection();
		Statement statement=connection.createStatement();
		String query="UPDATE `aegisisc`.`student` SET `name` = '"+name+"',`contactNo` = '"+contactNo+"',`city` = '"+city+"',`email` = '"+email+"',`standard` = '"+standard+"' WHERE (`rollNo` = '"+rollNo+"')";
		statement.executeUpdate(query);
		System.out.println("-----------------------------------------------");
		System.out.println("Record updated successfully");
		System.out.println("-----------------------------------------------");
		display();

//		ask();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void exit(){
		System.out.println("Exited Successfully");
	}

}
