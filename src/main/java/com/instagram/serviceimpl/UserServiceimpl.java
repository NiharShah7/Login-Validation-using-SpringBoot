package com.instagram.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.instagram.dbutil.DButil;
import com.instagram.service.UserService;

@Service
public class UserServiceimpl implements UserService {

	Connection conn;
	int flag=0;
	public  UserServiceimpl() throws ClassNotFoundException, SQLException {
		
		conn=DButil.getConnection();
		
	}
	
	@Override
	public int loginValidation(String username, String password) {
	
	
		try {
			PreparedStatement ps= conn.prepareStatement("select * from  instagramlogin  where username= '"+username+"'");
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
					System.out.println("login sucessfull............");
					System.out.println("name="+rs.getString(1)+ "  username="+rs.getString(2)+ "  password="+rs.getString(3));
					flag=1;
				}
				else {
					
					System.out.println("invaliid username and password");
					System.out.println("name="+rs.getString(1)+ "  username="+rs.getString(2)+ "  password="+rs.getString(3));
					flag=0;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	
	
	
}
