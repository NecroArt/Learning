//��� �� ��������
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.*;

public class HellowWorld 
{
	/**
	 * @param args
	 */
	public static void main(String[] adding_id, String[] severity)
	{
		String url = "jdbc:odbc:dBase";
		//�������� adding_id �� sql-��������
		//��������� ������� ����������� id  � ��
		//executeQuery
		//"SELECT top 1 * from New_id where id = " + adding_id + ";"
		
		//���� ������ id ��� - �� ��������� ���������� � sql-�������
//		executeUpdate
//		"insert into New_id (`Id` ,`Severity`) value ( '" + adding_id + "', " + Severity + ");"
		
		//����� ������� ��������� � ������������� ������ id
		public class Example1 { 

		     public static void main(String args[]) { 
		         Example1 example = new Example1(); 
		         example.run(); 
		     } 

		     public void run() { 
		         Connection con = null; 
		         try { 
		             con = openConnection(); 
		             String sSQL = "Select field1, field2 from table_name where cond1=c1 and cond2=c2"; 
		             Statement statement = con.createStatement(); 
		             ResultSet resultSet = statement.executeQuery(sSQL); 
		             while(resultSet.next()){ 
		                 String field1 = resultSet.getString("field1"); 
		                 String field2 = resultSet.getString("field2"); 
		                 /*   ���        String field1 = resultSet.getString(1); 
		                                 String field2 = resultSet.getString(2); 
		                 */ 
		                 statement.close(); 
		             } 
		         } catch (SQLException e) { 
		             System.err.println("Errors occurs when communicating with the database server: " + e.getMessage()); 
		         } catch (ClassNotFoundException e) { 
		             System.err.println("Cannot find the database driver"); 
		         } finally { 
		             // Never forget to close database connection 
		             closeConnection(con); 
		         } 
		     } 

		     private Connection openConnection() throws SQLException, ClassNotFoundException { 
		         // Load the PostgreSQL database driver 
		         Class.forName("org.postgresql.Driver"); 
		         String host = "matterhorn.usc.edu"; 
		         String port = "5432"; 
		         String dbName = "cwan"; 
		         String userName = "cwan"; 
		         String password = "mypassword"; 

		         // Construct the JDBC URL 
		         String dbURL = "jdbc:postgresql://" + host + ":" + port + "/" + dbName; 
		         return DriverManager.getConnection(dbURL, userName, password); 
		     } 

		     private void closeConnection(Connection con) { 
		         try { 
		             con.close(); 
		         } catch (SQLException e) { 
		             System.err.println("Cannot close connection: " + e.getMessage()); 
		         } 
		     } 
		 }
//		System.out.println(new Date ());
	}

}
