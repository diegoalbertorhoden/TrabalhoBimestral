package br.univel;
/**
 * @author Diego Alberto Rhoden
 *4 de nov de 2015 às 01:43:25
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private Connection con;

	private static Conexao inst;
	private Conexao(){}	
	public static Conexao getInstance(){
		if(inst == null )
			return inst = new Conexao();
		return inst;
	}

	public Connection conOpen(){
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/SistemaVendas";
		String user = "root";
		String pass = "admin";
		try {
			Class.forName(driverName);
			return con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void conClose(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

