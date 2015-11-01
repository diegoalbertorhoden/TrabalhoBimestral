package br.univel.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.univel.Clientes;

/**
 * @author user
 * Classe criada implementado da interface Dao para os comandos do banco 
 * 31/10/2015 às 16:40
 */
public class ClienteDaoImplementacao implements ClienteDao {

	private static Connection con;

	private Connection getConnection(){
		synchronized (con) {
			if (con == null){

			}
			return con;
		}
	}

	public void inserir(Clientes c) {
		String sql = "INSERT INTO .........";
//		try(PreparedStatement ps = getConnection().prepareStatement(sql)){
//
//		}catch (SQLException e){
//			e.printStackTrace();
//		}

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