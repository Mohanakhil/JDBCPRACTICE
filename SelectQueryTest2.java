//WRITE A JDBC APP TO FETCH THE DETAILS OF EMPLOYEE TABLE BY  EMPNO
package com.ora.japp;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class SelectQueryTest2
{ public static void main(String args[]) throws Exception
{ Scanner scan=new Scanner(System.in);
System.out.println("enter empno of employee ");
int empno=scan.nextInt();
//CONSTRUCTION OF QUERY
String query= "SELECT * FROM EMP WHERE EMPNO="+empno;
System.out.println(query);
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
boolean flag=false;
//PROCESS THE RESULT
while(rs.next())
{  flag=true;
System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)); 
}
if(flag==false) System.out.println("NO RECORDS FOUND");
else System.out.println("records are found and displayed");
//CLOSING OF JDBC OBJECTS
rs.close();
st.close();
con.close();
}}