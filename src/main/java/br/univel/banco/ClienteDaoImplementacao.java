package br.univel.banco;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

import br.univel.Clientes;
import br.univel.Produtos;
import br.univel.Usuarios;

/**
 * @author user
 * Classe criada implementado da interface Dao para os comandos do banco 
 * 31/10/2015 às 16:40
 */
public class ClienteDaoImplementacao implements ClienteDao {

	private static Connection con;
	private HashMap<Integer, Clientes> clientes = new HashMap<>();
	private HashMap<Integer, Produtos> produtos = new HashMap<>();
	private HashMap<Integer, Usuarios> usuarios = new HashMap<>();
	private HashMap<Integer, Vendas> vendas = new hashMap<>();

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