//WRITE A JDBC APP TO GET DEPT DETAILS FROM ORACLE DB BASED ON GIVEN DEPTNO
package com.ora.japp;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
public class SelectTest4
{
public static void main(String args[]) throws Exception
{ Scanner scan=new Scanner(System.in); 
System.out.println("enter the deptno");
int no=scan.nextInt();
//PREPARE THE SQL QUERY
//SELECT *FROM EMP WHERE DEPTNO=20;
String query= "SELECT *FROM EMP WHERE DEPTNO="+no;
System.out.println(query);
 Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
boolean flag=false;
//PROCESS THE RESULTSET OBJECT
while(rs.next()==true)
{ System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
flag=true;
}
if(flag==false) System.out.println("RECORDS NOT FOUND");
else System.out.println("RECORDS ARE FOUND AND DISPLAYED");
//CLOSE ALL JDBC OBJECTS
rs.close();
st.close();
con.close();
}}