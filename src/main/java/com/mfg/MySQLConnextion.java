import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	public static void main(String[] args){
		//数据库连接字符串
		String url = "jdbc:mysql://localhost:3306/login";
		//数据库用户名
		String user = "MufengGang";
		//数据库密码
		String password = "MufengG6018";

		Connection conn = null;
		try{
			//加载并注册JDBC驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection(url, user, password);
			if(conn != null)
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to connect!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e. printStackTrace();
		} finally {
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStachTrace();
			}
		}
	}
}