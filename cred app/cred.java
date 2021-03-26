package credapp;
import java.sql.*;  
import java.util.Scanner;
class cred{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/connection","root","sql@123");  
//here first is database name, root is username and password  
System.out.println("Connected with DataBase");
//Statement stmt=con.createStatement();  
//stmt.execute("create table student(studentid int(3), studentname varchar(10))");
System.out.println("Table is created");
PreparedStatement stmt=con.prepareStatement("insert into con values(?,?)");
Scanner obj=new Scanner(System.in);

while(true) {
	System.out.println("choose from below operation\n1)insert\n2)update\n3)delete\n4)show table\n5)exit");
	int no=obj.nextInt();

if(no==1||no==2||no==3||no==4)
{
	switch(no) {
		case 1:
			System.out.println("enter the id");
			int id=obj.nextInt();
			System.out.println("enter the name");
			String username=obj.next();
			stmt.setInt(1, id);
			stmt.setString(2,username);
			stmt.executeUpdate();
			break;
		case 2:
			System.out.println("enter the id to be updated");
			int id2=obj.nextInt();
			System.out.println("enter the name to be updated");
			String username2=obj.next();
			String up="UPDATE con SET name="+"'"+username2+"'"+"WHERE s_no="+id2;
			System.out.println(up);
			stmt.executeUpdate(up);
			System.out.println("data is updated");
			break;
		case 3:
			System.out.println("enter the id to be deleted");
			int id3=obj.nextInt();
			String del="DELETE FROM con WHERE s_no="+id3;
			stmt.executeUpdate(del);
			System.out.println("data is updated");
			break;
		case 4:
			ResultSet rs=stmt.executeQuery("select * from con");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
			break;
	}
}
else 
 {
 break;
 }
}

}catch(Exception e){ System.out.println(e);}  
}  
}