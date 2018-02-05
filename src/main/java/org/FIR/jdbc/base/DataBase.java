package org.FIR.jdbc.base;

import java.sql.*;

public class DataBase {
	private static Connection conn=null;
	
  public static void main(String args[]) throws SQLException {
    try {
      Class.forName("com.mysql.jdbc.Driver");

     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/drawend2017","root","root");

      System.out.println("Success connect Mysql server!");
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from user_firgame");

while (rs.next()) {
        System.out.println(rs.getString("user_id"));
      }
    }
    catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
    Statement stmt=conn.createStatement();
    ResultSet rsd= stmt.executeQuery("select user_name,user_password from user_firgame");
    int i=0;
    while (rsd.next()) {
    	String a,b;
    	i++;
    	a=rsd.getString("user_name");
    	b=rsd.getString("user_password");
        System.out.println(i+","+b+","+a);
      }
  }
  
  public static Connection getConnection(){
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        //Class.forName("org.gjt.mm.mysql.Driver");
	       System.out.println("Success loading Mysql Driver!");
	      }
	      catch (Exception e) {
	        System.out.print("Error loading Mysql Driver!");
	        e.printStackTrace();
	      }
	      try {
	        conn = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/drawend2017","root","root");

	        System.out.println("Success connect Mysql server!");
	        
	      }catch (Exception e) {
	            System.out.print("get data error!");
	            e.printStackTrace();
	          }
	      return conn;
  		}
}

