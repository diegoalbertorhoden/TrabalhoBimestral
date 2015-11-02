package br.univel.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import br.univel.Clientes;
import br.univel.Produtos;
import br.univel.Usuarios;
import br.univel.Vendas;

/**
 * @author Diego Alberto Rhoden
 * Classe para infos do banco 
 * 01/11/2015 às 14:06
 */
public class Banco {
	private HashMap<Integer, Clientes> clientes = new HashMap<>();
	private HashMap<Integer, Produtos> produtos = new HashMap<>();
	private HashMap<Integer, Usuarios> usuarios = new HashMap<>();
	private HashMap<Integer, Vendas> vendas = new HashMap<>();
	
	private static Banco b;
	
	private static Connection con;
	String url = "jdbc:postgresql://localhost:5432/SistemaVendas";
	String user = "postgres";
	String pass = "dadedi24072011";

	public Connection getConnection() {

		if (con == null) {
			try {
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (con) {
			return con;
		}
	}

	Banco() {
	}

	public static Banco getBanco() {
		if (b == null) {
			b = new Banco();
		}
		return b;

	}

	public static HashMap getHash(String x) {
		switch (x) {
		case "Cliente":
			return getBanco().clientes;
		case "Produto":
			return getBanco().produtos;
		case "Usuario":
			return getBanco().usuarios;
		case "Venda":
			return getBanco().vendas;
		default:
			return null;
		}

	}
}
