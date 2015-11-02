package br.univel.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.Clientes;
import br.univel.Produtos;
import br.univel.Usuarios;
import br.univel.Vendas;

/**
 * @author user
 * Classe criada implementado da interface Dao para os comandos do banco 
 * 31/10/2015 às 16:40
 */
public class ClienteDaoImplementacao implements ClienteDao {
	
	public void inserir(String nome) {
//		c.getCidade();
//		c.getEmail();
//		c.getEndereco();3
//		c.getTelefone();
		Clientes c = new Clientes();
		c.getNome();
		JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso, bagual");
		
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