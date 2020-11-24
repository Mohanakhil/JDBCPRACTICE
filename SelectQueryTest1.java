//WRITE A JDBC  APPLICATION TO GET EMPNO,ENAME,JOB,SAL FROM EMP TABLE BASED ON GIVEN JOB FROM ENDUSER
package com.ora.japp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
public class SelectQueryTest1
{ public static void main(String args[]) throws Exception
{ Scanner scan=new Scanner(System.in);
System.out.println("enter employee job");//TAKING THE INPUT FROM USER;
String job=scan.next();
job="'"+job+"'";
//PREPARING SQL QUERY STATEMENT
String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB="+job;
System.out.println(query); 
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
boolean flag=false;
//PROCESS THE RESULTSET OBJECT
while(rs.next()==true)
{ flag=true;
System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
}
if(flag==false) System.out.println("NO RECORDS FOUND");
else System.out.println("RECORDS ARE DISPLAYED");
//CLOSE ALL JDBC OBJECTS
rs.close();
st.close();
con.close(); 


}}