import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	
	static final String username = "root";
	static final String password = "fast";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		final String url = "jdbc:mysql:///prac";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		
		Statement st = con.createStatement();
		
		PreparedStatement pt = con.prepareStatement("INSERT INTO person VALUES (?, ?, ?, ?)");
		pt.setInt(1, 2);
		pt.setString(2, "Wasif");
		pt.setString(3, "Shemale");
		pt.setString(4, "");
		
		pt.executeUpdate();

		ResultSet rs = st.executeQuery("SELECT * FROM person");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)  + " " + rs.getString(2)  + " " + rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
