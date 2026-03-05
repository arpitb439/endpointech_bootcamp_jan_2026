package jdbc_project.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSelectDemo {

	public static void main(String[] args) {

		try {
//			1. Loading the JDBC driver 
			Class.forName("com.mysql.cj.jdbc.Driver");

//			2. Establish the connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/endpointech_bootcamp", "root",
					"Root@12345");

//			3. Creating the statement
			Statement stmt = con.createStatement();

//			4. Executing the query using statement object
			ResultSet rs = stmt.executeQuery("select * from employee");

//			5. Handle/DIsplay result
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " - " + rs.getString("name") + " - " + rs.getInt("age") + " - "
						+ rs.getString("dept"));
			}

//			6. close Result set
			rs.close();

//			7. close statement
			stmt.close();

//			8. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
