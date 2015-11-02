package br.univel.banco;

import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import br.univel.Clientes;
/**
 * @author user
 * Classe criada implementado da interface Dao para os comandos do banco 
 * 31/10/2015 às 16:40
 */
public class ClienteDaoImplementacao implements ClienteDao {

	private Clientes c = null;

	public void inserir(Clientes c) throws SQLException {

		Connection con = getConnection();

		PreparedStatement ps;
		ps = con.prepareStatement("INSERT INTO clientes(nome, telefone, endereco, cidade, Estado, email, genero)"
				+ "values(?,?,?,?,?,?,?)");

		ps.setString(1, c.getNome());
		ps.setString(2, c.getTelefone());
		ps.setString(3, c.getEndereco());
		ps.setString(4, c.getCidade());
		ps.setString(5, c.getEstado().getNome());
		ps.setString(6, c.getEmail());
		ps.setString(7, c.getGenero().toString());

		int res = ps.executeUpdate();
		ps.close();
		con.close();

		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

	}	
	private static Connection con;
	public Connection getConnection(){
		
		if (con == null){ 
			try{ 
				String url = "jdbc:postgresql://localhost:5432/SistemaVendas";
				String user = "postgres";
				String pass = "dadedi24072011";
					
				con = DriverManager.getConnection(url, user, pass);
			} catch (SQLException e){ 
				System.out.println("Erro ao abrir conexão");
				e.printStackTrace();
			}
		}
		synchronized (con) {
		return con; 
	}
}


	public void atualizar(Clientes c) {


	}
	public void excluir(Clientes c) {


	}
	public Clientes buscar(int id) {

		return null;
	}
	public List<Clientes> listar() {

		return null;
	}
}