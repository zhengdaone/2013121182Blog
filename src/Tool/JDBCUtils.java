package Tool;

import java.sql.*;


public final class JDBCUtils {
	private static String url = "jdbc:mysql://localhost:3306/2013121182_Blog";
	private static String user = "root"; 
	private static String password = "123qwe"; 
	public JDBCUtils() { 
		
	}
	static { 
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			} 
		catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
			throw new ExceptionInInitializerError(e); 
			} 
		} 
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  return null;
		} 
		} 
	public static void release(Connection connection, Statement statement,ResultSet rs ) { 
		try { 
			if (rs != null) 
				rs.close(); 
			} catch (SQLException e) { 
				e.printStackTrace(); 
				} 
		finally { 
			try { 
				if (statement != null)  
					statement.close();
				} catch (SQLException e) { 
					e.printStackTrace(); 
					} 
			finally { 
				if (connection != null) 
					try {
						connection.close(); 
						} catch (SQLException e) { 
							e.printStackTrace(); 
							} 
				} 
			}  
		}
	public boolean executeUpdate(String sql) {
		// TODO Auto-generated method stub
		return false;
	}
	public ResultSet executeQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	} 
	} 

