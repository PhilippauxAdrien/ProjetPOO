package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.AccountantBean;
import utils.Role;

public class AccountantDao {
	
public static int save(AccountantBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into user(firstname,lastname,email,password,address,role) values(?,?,?,?,?,?)");
		ps.setString(1,bean.getFirstname());
		ps.setString(2,bean.getLastname());
		ps.setString(3,bean.getEmail());
		ps.setString(4,bean.getPassword());
		ps.setString(5,bean.getAddress());
                ps.setString(6,bean.getRole());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	return status;
}
public static boolean validate(String email,String password){
	boolean status=false;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=? and role=?");
		ps.setString(1,email);
		ps.setString(2,password);
                ps.setString(3, Role.ACCOUNTANT.getValue());
                System.out.println(ps.toString());
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	return status;
}
public static int update(AccountantBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update user set firstname=?,lastname=?,email=?,password=?,address=? where id=?");
		ps.setString(1,bean.getFirstname());
		ps.setString(2,bean.getLastname());
		ps.setString(3,bean.getEmail());
		ps.setString(4,bean.getPassword());
		ps.setString(5,bean.getAddress());
		ps.setInt(6,bean.getId());
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	return status;
}	

public static int delete(int id){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from user where id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	return status;
}

public static List<AccountantBean> getAllRecords(){
	List<AccountantBean> list=new ArrayList<AccountantBean>();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from user where role=?");
                ps.setString(1, Role.ACCOUNTANT.getValue());
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			AccountantBean bean=new AccountantBean();
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
                        bean.setRole(rs.getString(7));
			list.add(bean);
		}
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	
	return list;
}

public static AccountantBean getRecordById(int id){
	AccountantBean bean=new AccountantBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from user where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
                        bean.setRole(rs.getString(7));
		}
		con.close();
	}catch(Exception ex){
            System.out.println(ex);
        }
	
	return bean;
}
}
