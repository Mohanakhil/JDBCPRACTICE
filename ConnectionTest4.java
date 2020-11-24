//WAP TO GET ALL RECORDS OF SALGRADE FROM ORACLE
package com.ora.japp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class ConnectionTest4 
{
public static void main(String args[]) throws Exception
{
Class.forName("oracle.jdbc.driver.OracleDriver");//OPTIONAL
//LOAD  JDBC DRIVER CLASS TO REGISTER JDBC DRIVER SOFTWARE WITH DRIVERMANAGER SERVICE
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
//CREATE STATEMENT OBJECT
Statement st=con.createStatement();
//SEND AND EXECUTE THE QUERY
ResultSet rs=st.executeQuery("SELECT *FROM SALGRADE");
//PROCESS THE RESULT
while(rs.next()==true)
{ System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
}//end of while
//close all jdbc objects
rs.close();
st.close();
con.close();
}//end of main
}//end of class