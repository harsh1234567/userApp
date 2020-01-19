package UtilityMethod;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Users.UserEntity;

public class Dao {

	 public  List<UserEntity> getData(Connection connection){
	       	 
		  List<UserEntity> ls=new ArrayList<UserEntity>();
			
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from user");
			//	PrintWriter out = response.getWriter();
			 while (resultSet.next()) {
				 UserEntity us=new UserEntity();
				 us.setFirstName(resultSet.getString(1));
	             us.setLastName(resultSet.getString(2));
				 us.setEmail(resultSet.getString(3));
				 ls.add(us);

			 }
			//	out.print("</table>");

			} catch (SQLException e) {
				e.printStackTrace();
			}

			  return ls;
	 }
}
