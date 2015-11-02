package br.univel.banco;

import java.sql.Connection;
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
		
	private String sql;
	private Connection con;
	public void inserir(Clientes c) throws SQLException {

	Banco b = new Banco();
		sql = "INSERT INTO CLIENTE(id, nome, telefone, endereco, cidade, Estado, email, genero)"
				+ "values(?,?,?,?,?,?,?,?)";
		con = b.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getId());
		ps.setString(2, c.getNome());
		ps.setString(3, c.getTelefone());
		ps.setString(4, c.getEndereco());
		ps.setString(5, c.getCidade());
//		ps.setString(6, c.getEstado().getNome());
		ps.setString(7, c.getEmail());
//		ps.setString(8, c.getGenero().toString());
		
		int res = ps.executeUpdate();
		ps.close();
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		
		
////		c.getCidade();
////		c.getEmail();
////		c.getEndereco();3
////		c.getTelefone();
//		Clientes c = new Clientes();
//		c.getNome();
//		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso, bagual");
		
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