//TO ESTABLISH CONNECTION WITH JDBC
package com.ora.japp;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionTest1
{ public static void main(String args[]) throws Exception
{
//REGISTER ORACLE THIN DRIVER WITH DRIVERMANAGER SERVICE
//CREATE JDBC DRIVER CLASS OBJECT
oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();
//REGISTER ORACLE DRIVER OBJECT WITH DRIVER MANAGEMENT SERVICE
DriverManager.registerDriver(driver);
//ESTABLISH THE CONNECTION WITH DATABASE SOFTWARE FROM JAVA APPLICATION
Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
if(con==null) System.out.println("connection not established");
else System.out.println("connection established");
}//main
}//class
