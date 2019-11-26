package util;

import java.sql.Connection;
import java.sql.DriverManager;

//连接数据库的类

public class Conn {
	public static String DBDRRIVER="com.mysql.jdbc.Driver";
	public static String DBURL="jdbc:mysql://localhost:3306/myblog?characterEncoding=utf8";
	public static String  DBNAME="root";
	public static String DBPWD="password";
	static Connection con=null;
	
	
	public static Connection getCon() {
		 try {
   		  //加载驱动
			Class.forName(DBDRRIVER);
			//连接数据库
			con=DriverManager.getConnection(DBURL, DBNAME, DBPWD);
//			System.out.print(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 System.out.println(e);
			e.printStackTrace();
		}
		 return con;
	}
	public static void main(String[] args) {

		getCon();

	}
    
}
