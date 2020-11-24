//WAP TO CREATE JDBC APP THAT GIVES STUDENT DETAILS BASED ON STUDENT NO
package com.ora.japp;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class SelectQueryTest5
{ public static void main(String args[]) throws Exception
{
//TAKE THE INPUT FROM USER
Scanner scan=new Scanner(System.in);
System.out.println("enter student number");
String sno=scan.next();
sno="'"+sno+"'";
//PREPARE THE SQL QUERY 
String query= "SELECT SNO,SNAME,SADD,SAVG FROM STUDENT WHERE SNO="+sno;
System.out.println(query); // DISPLAY THE QUERY FOR SELF AWARENESS
//REGISTER THE ORACLE DRIVER (OPTIONAL)
Class.forName("oracle.jdbc.driver.OracleDriver");
//ESTABLISH THE CONNECTION
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
Statement st=con.createStatement();// CREATE STATEMENT OBJECT
ResultSet rs=st.executeQuery(query);// CREATE RESULTSET OBJECT

//PROCESS THE RESULT
if(rs.next())
{ System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
}
//CLOSE ALL JDBC OBJECTS
rs.close();
st.close();
con.close();
}}