package br.univel.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Clientes;
import br.univel.Conexao;
import br.univel.Estado;
import br.univel.Genero;
/**
 * @author user
 * Classe criada implementado da interface Dao para os comandos do banco 
 * 31/10/2015 �s 16:40
 */
public class ClienteDaoImplementacao implements DaoGenerico<Clientes>  {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Clientes c = null;
	private List<Clientes> lista = null;
	private Connection con = Conexao.getInstace().conOpen();
	public void inserir(Clientes c) {
		try {
			ps = con.prepareStatement("INSERT INTO clientes (nome, telefone, endereco, cidade, estado, email, genero) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome()
					+ "\n Cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Clientes c) {
		try {
			ps = con.prepareStatement("UPDATE clientes SET nome = ?,"
					+ " telefone = ?, endereco = ?, cidade = ?, estado = ?,"
					+ " email = ?, genero = ? WHERE ID_C = " + c.getId());
			ps.setString(1, c.getNome());
			ps.setString(2, c.getTelefone());
			ps.setString(3, c.getEndereco());
			ps.setString(4, c.getCidade());
			ps.setString(5, c.getEstado().name());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getGenero().name());
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cliente: " + c.getNome()
					+ "\n Atualizado com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deletar(int id) {
		try {
			ps = con.prepareStatement("DELETE FROM clientes WHERE ID_C =" + id);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Clientes buscarUm(int id) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE WHERE ID_C = " + id);
			rs.next();
			if (rs.getString("NOME") != null) {
				c = new Clientes(rs.getString("NOME"), rs.getString("TELEFONE"),
						rs.getString("ENDERECO"), rs.getString("CIDADE"),
						Estado.valueOf(Estado.class, rs.getString("ESTADO")),
						rs.getString("EMAIL"), Genero.valueOf(Genero.class,
								rs.getString("GENERO")));
			}
			rs.close();
			st.close();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Cliente buscarUm(int id) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT NOME, TELEFONE, ENDERECO, CIDADE, ESTADO, EMAIL, GENERO "
					+ "FROM CLIENTE WHERE ID_C = " + id);
			rs.next();
			if (rs.getString("NOME") != null) {
				c = new Clientes(rs.getString("NOME"), rs.getString("TELEFONE"),
						rs.getString("ENDERECO"), rs.getString("CIDADE"),
						Estado.valueOf(Estado.class, rs.getString("ESTADO")),
						rs.getString("EMAIL"), Genero.valueOf(Genero.class,
								rs.getString("GENERO")));
			}
			rs.close();
			st.close();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}