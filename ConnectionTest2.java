//SELECT QUERY IN ORACLE DATABASE
package com.ora.japp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class ConnectionTest2
{ public static void main(String args[]) throws Exception
{ Class.forName("oracle.jdbc.driver.OracleDriver");//FOR OLD VERSIONS OF JDBC
//LOAD JDBC DRIVER CLASS TO REGISTER JDBC DRIVER SOFTWARE WITH DRIVERMANAGER SERVICE
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
//CREATE STATEMENT OBJECT OF JDBC
if(con==null) System.out.println("connection not established");
Statement st=con.createStatement();
//SEND AND EXECUTE THE SELECT SQL QUERY IN DB SOFTWARE AND GET JDBC RESULTSET OBJECT
ResultSet rs=st.executeQuery("SELECT *FROM EMP");
//PRINT THE RESULT
while(rs.next()==true)
{System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
}//end of while
//close all jdbc objects
rs.close();
st.close();
con.close();
}}//end of class






