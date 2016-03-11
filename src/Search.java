import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {

	public Search() {
		// TODO Auto-generated constructor stub
	}

	public boolean getsearch(){
		 int count=0;
		Scanner input= new Scanner(System.in);
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/test","root@localhost", "");
			while(true)
			{
			System.out.println("Please Select the Chocie of ur Search");
			System.out.println("\n 1.ID \n 2.Name \n 3.Age \n ");
			String Choice=input.nextLine();
			 
			 
			 if(Choice.equals("ID"))
			 {
				 count=0;
			 System.out.println("Please Enter the ID");
			 String Search=input.nextLine();
			 String q1 = "SELECT * FROM members WHERE ID LIKE'" + Search + "%'";
		    	Statement stmt2=conn.createStatement();
				ResultSet rs1=stmt2.executeQuery(q1);
				 while (rs1.next())
				 {
					System.out.println("\n ID:"+rs1.getString("ID")+"\n Name :"+rs1.getString("Name")+"\n Age :"+rs1.getString("Age")+"\n");
					count++;
				 }
				 System.out.println("Total Results :"+count);
		}
			 
			 else if(Choice.equals("Name"))
			 {
				 count=0;
			 System.out.println("Please Enter the Word");
			 String Search=input.nextLine();
			 String q1 = "SELECT * FROM members WHERE Name LIKE'" + Search + "%'";
		    	Statement stmt2=conn.createStatement();
				ResultSet rs1=stmt2.executeQuery(q1);
				 while (rs1.next())
				 {
					System.out.println("\n ID:"+rs1.getString("ID")+"\n Name :"+rs1.getString("Name")+"\n Age :"+rs1.getString("Age")+"\n");
					count++;
				 }
				 System.out.println("Total Results :"+count);
				 if(count==0)
				 {
					 String q = "select * from members";
				    	Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(q);
						 while (rs.next())
						 {
							System.out.println("ID :  "+rs.getString("ID")+" Name :"+rs.getString("Name")+"  Age :"+rs.getString("Age"));
						 }
				 }
		}
			 
			 else if(Choice.equals("Age"))
			 {
				 count=0;
			 System.out.println("Please Enter the Age");
			 String Search=input.nextLine();
			 String q1 = "SELECT * FROM members WHERE Age LIKE'" + Search + "%'";
		    	Statement stmt2=conn.createStatement();
				ResultSet rs1=stmt2.executeQuery(q1);
				 while (rs1.next())
				 {
					System.out.println("\n ID:"+rs1.getString("ID")+"\n Name :"+rs1.getString("Name")+"\n Age :"+rs1.getString("Age")+"\n");
					count++;
				 }
				 System.out.println("Total Results :"+count);
		}
			 else
			 {
				 System.out.println("Invalid Choice");
			 }
			 if(count==0)
			 {
				 String q = "select * from members";
			    	Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(q);
					 while (rs.next())
					 {
						System.out.println("ID :  "+rs.getString("ID")+" Name :"+rs.getString("Name")+"  Age :"+rs.getString("Age"));
					 }
			 }
			 
		}
		}
			 catch (SQLException e) 
			 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
