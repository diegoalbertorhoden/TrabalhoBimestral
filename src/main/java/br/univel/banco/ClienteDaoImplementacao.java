package br.univel.banco;

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
public class ClienteDaoImplementacao implements ClienteDao  {

		private Connection con;

		public ClienteDaoImplementacao() {
			
				try {
					abrirConexaoBancoDados();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		private void abrirConexaoBancoDados() throws SQLException, ClassNotFoundException {
			Class.forName("org.postgresql.Driver"); 
			
			String url = "jdbc:postgresql://localhost:5432/SistemaVendas";
			String user = "postgres";
			String pass = "dadedi24072011";
							
				con = DriverManager.getConnection(url, user, pass);
			
			
		}
		public void inserir(Clientes cliente) throws SQLException {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO clientes (id, nome, telefone, endereco, cidade, email) VALUES (?, ?, ?, ?, ?, ?)");

			ps.setInt(1, cliente.getId());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getTelefone());
			ps.setString(4, cliente.getEndereco());
			ps.setString(5, cliente.getCidade());
			ps.setString(6, cliente.getEmail());
			// ps.setObject(7, (Estado) cliente.getEstado());
			// ps.setObject(8, (Genero) cliente.getGenero());

			ps.executeUpdate();

			ps.close();

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