package jdbc_project.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDemo {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/endpointech_bootcamp", "root",
					"Root@12345");

			con.setAutoCommit(false);

			String insertQry = "insert into employee(name, age, dept) values(?, ?, ?)";
			String name = "Rahul";
			int age = 33;
			String dept = "HR";

			PreparedStatement preparedStatement = con.prepareStatement(insertQry);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, dept);

			int row = preparedStatement.executeUpdate();

			if (row == 1) {
				con.commit();
			}

			System.out.println("Data is inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
