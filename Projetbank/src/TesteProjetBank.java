import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteProjetBank {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/projetbank"; 
		String log = "root";
		String pwd = "";
		
		try {
			Class.forName(driver); 
			Connection connection = DriverManager.getConnection(url, log, pwd); 
			Statement statement = connection.createStatement(); 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	




