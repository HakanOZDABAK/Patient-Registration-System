import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Baglanti {
	static ResultSet yap() {
		
		ResultSet myRs = null;
			try {
				Connection myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/hasta_kayit_sistemi","root","1234Akdeniz");
				Statement myStatt = myConn.createStatement();
				myRs = myStatt.executeQuery("select * from hastalar");
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return myRs;
			
			
	}
	

}
