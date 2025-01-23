import java.sql.*;



public class CreateDatabase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		try{
			// Step 1: Register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2: Establish the connection
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","Jhonytest#123");
		Statement stmt =	con.createStatement();
		System.out.println("inserting values");
		String sql = "Insert into student values(43)";
					stmt.executeUpdate(sql);
				} catch (Exception e) {
					System.out.println(e);

		}

}
}
