//SELECT QUERY FOR EXTRACTING DEPT TABLE FROM ORACLE DB
package com.ora.japp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class ConnectionTest3
{
public static void main(String args[]) throws Exception
{ Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("SELECT *FROM DEPT");
while(rs.next()==true)
{ System.out.println(rs.getString(1)+" "+rs.getString(2));
}
rs.close();
st.close();
con.close();
}}