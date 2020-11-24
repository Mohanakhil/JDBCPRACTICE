//WAP TO DISPLAY DETAILS OF TRANSACTION IN ORACLE DB TABLE BY TAKING BILLCODE AS INPUT
package com.ora.japp;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class SelectQueryTest3
{ public static void main(String args[]) throws Exception
{ //PREPARE THE SQL QUERY
Scanner scan=new Scanner(System.in);         //FOR READING INPUT
System.out.println("enter billcode");
String billCode=scan.next().toUpperCase();
billCode="'"+billCode+"'";
String query= "SELECT *FROM SMARTSHOP WHERE BILLCODE="+billCode;
//PRINT THE QUERY FOR SELF CONFIRMATION
System.out.println(query);
//LOAD THE JDBC DRIVER CLASS (OPTIONAL ) ONLY FOR WORKING WITH OLD VERSIONS
Class.forName("oracle.jdbc.driver.OracleDriver");
//ESTABLISH THE CONNECTION
Connection con=DriverManager.getConnection("jdbc:oracle:thin:1521:ORCL","scott","tiger");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(query);
if(rs.next()==true)
{ System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
}
else System.out.println("NO RECORDS ARE FOUND");
//CLOSE ALL JDBC OBJECTS
rs.close();
st.close();
con.close();
}}