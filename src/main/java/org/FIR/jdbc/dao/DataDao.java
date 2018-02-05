package org.FIR.jdbc.dao;

import org.FIR.entity.FIRGameUser;
import org.FIR.jdbc.base.DataBase;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataDao {
	

	public void addUser(String userName,String password) throws Exception{

		Connection conn= DataBase.getConnection();
		System.out.println(conn);

		String sql="" +
				"insert into user_firgame" +
"(user_name,user_password)" +
				"values(" +
				"?,?)";

		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, userName);
		ptmt.setString(2, password);
		ptmt.execute();
	}

	public void addRecord(long userId,int result,String recordString) throws Exception{

		Connection conn= DataBase.getConnection();
		System.out.println(conn);

		String sql="" +
				"insert into record_firgame" +
				"(user_Id,result,record_string)" +
				"values(" +
				"?,?,?)";

		PreparedStatement ptmt=conn.prepareStatement(sql);
		ptmt.setString(1, String.valueOf(userId));
		ptmt.setString(2, String.valueOf(result));
		ptmt.setString(3, recordString);
		ptmt.execute();
	}


	public void updateUserRecord(long userId,int result) throws Exception{

		Connection conn= DataBase.getConnection();
		System.out.println(conn);

		String sql1="update user_firgame set win_times=win_times+1 where user_id=?";
		String sql2="update user_firgame set falure_times=falure_times+1 user_id=?";
		if (result>=0) {
			PreparedStatement ptmt = conn.prepareStatement(sql1);
			ptmt.setString(1, String.valueOf(userId));
			ptmt.execute();
		}else {
			PreparedStatement ptmt = conn.prepareStatement(sql2);
			ptmt.setString(1, String.valueOf(userId));
			ptmt.execute();
		}
	}

	public String getPassword(String ashes) throws Exception{
		System.out.println("findpsw");
		String psw=null;

		Connection conn=DataBase.getConnection();
		
	    Statement stmt=conn.createStatement();
	    ResultSet rsd= stmt.executeQuery("select user_password from user_firgame where user_name='"+ashes+"'");
	    if(rsd.next()){
		psw=rsd.getString("user_password");}
	    return psw;
		}

	public long getId(String ashes) throws Exception{
		System.out.println("findid");
		Long rt=null;

		Connection conn=DataBase.getConnection();

		Statement stmt=conn.createStatement();
		ResultSet rsd= stmt.executeQuery("select user_id from user_firgame where user_name='"+ashes+"'");
		if(rsd.next()){
			rt=rsd.getLong("user_id");}
		return rt;
	}


	}