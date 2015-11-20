package br.univel.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.univel.classes.Usuarios;

public class UsuarioDaoImplementacao implements DaoGenerico<Usuarios> {

	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;
	private Usuarios u = null;
	private List<Usuarios> lista = null;
	private Connection con = Conexao.getInstance().conOpen();

	@Override
	public int inserir(Usuarios usr) {

		try {
			ps = con.prepareStatement("INSERT INTO usuarios (id_cliente, cliente, senha) VALUES (?, ?, MD5(?))");
			ps.setInt(1, usr.getIdCliente());
			ps.setString(2, usr.getCliente());
			ps.setString(3, usr.getSenha());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int atualizar(Usuarios u) {
		
		try {
			ps = con.prepareStatement("UPDATE usuarios SET id_cliente = ?, cliente = ? , senha = ? WHERE id_usuario = "+ u.getId());
			ps.setInt(1, u.getIdCliente());
			ps.setString(2, u.getCliente());
			ps.setString(3, u.getSenha());
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int excluir(int id_usuario) {
		
		try {
			ps = con.prepareStatement("DELETE FROM usuarios WHERE id_usuario = "+id_usuario);
			int res = ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Usuarios buscar(int id_usuario) {
		try{
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_cliente, cliente, senha FROM usuarios WHERE id_usuariosuario = "
				+ id_usuario);
		rs.next();
		if (rs.getString("cliente") != null) {
			u = new Usuarios();
			u.setId(id_usuario);
			u.setIdCliente(rs.getInt("id_cliente"));
			u.setCliente(rs.getString("cliente"));
			u.setSenha(rs.getString("senha"));
			rs.close();
			st.close();
			return u;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}

	@Override
	public List<Usuarios> listar() {
		
		lista = new ArrayList<Usuarios>();
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT id_usuario, id_cliente, cliente, senha FROM usuarios");
			while (rs.next()) {				
				u = new Usuarios();
				u.setId(rs.getInt("id_usuario"));
				u.setIdCliente(rs.getInt("id_cliente"));
				u.setCliente(rs.getString("cliente"));
				u.setSenha(rs.getString("senha"));
				lista.add(u);
			}
			rs.close();
			st.close();
			if (lista != null)
				return lista;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public Connection getCon(){
		return con;
	}
	public boolean Autentica(String user, String pass){
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT cliente, senha FROM usuarios WHERE cliente = "+user+"' AND senha = MD5('"+pass+"')");
			boolean v = rs.next();
			return v;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;		
	}
}