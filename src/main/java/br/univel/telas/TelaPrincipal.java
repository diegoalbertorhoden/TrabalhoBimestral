package br.univel.telas;

/**
 * @author Diego Alberto Rhoden Principal
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.univel.login.Bloqueador;
import br.univel.login.Login;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private Bloqueador pelicula;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setExtendedState(Frame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {

		setAutoRequestFocus(false);

		bloquearTelaPrincipal();

		setTitle("Sistema para Lojas de Cal\u00E7ados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);

		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		mntmProdutos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirTelaProdutos();
			}
		});

		mnCadastro.add(mntmProdutos);

		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		mntmClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				abrirTelaClientes();
			}
		});
		mnCadastro.add(mntmClientes);

		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mntmUsurios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_MASK));
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaUsuarios();
			}
		});
		mnCadastro.add(mntmUsurios);

		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);

		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mntmNovaVenda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, InputEvent.CTRL_MASK));
		mntmNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaVendas();
			}
		});
		mnVendas.add(mntmNovaVenda);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		JMenuItem mntmNewMenuItem = new JMenuItem("Produtos");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, InputEvent.CTRL_MASK));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaRelProdutos();
			}
		});
		mnRelatrios.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, InputEvent.CTRL_MASK));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaRelClientes();
			}
		});
		mnRelatrios.add(mntmNewMenuItem_1);

		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, InputEvent.CTRL_MASK));
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaRelVendas();
			}
		});
		mnRelatrios.add(mntmVendas);

		JMenu mnBloquearTela = new JMenu("Sistema");
		menuBar.add(mnBloquearTela);

		JMenuItem mntmBloquearTela = new JMenuItem("Bloquear Tela");
		mntmBloquearTela.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, InputEvent.CTRL_MASK));
		mntmBloquearTela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				block();
			}
		});
		mnBloquearTela.add(mntmBloquearTela);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(SwingConstants.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void block() {
		setGlassPane(pelicula);
		pelicula.setVisible(true);

		new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				pelicula.setVisible(false);
				bloquearTelaPrincipal();

			}
		}).start();
	}

	private void abrirTelaRelVendas() {
		final TelaRelatorioVendas trv = new TelaRelatorioVendas();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(trv);
			}
		};
		trv.setCloseAction(action);
		tabbedPane.addTab("Relatório de Vendas", trv);
		mostrarUltima();
	}

	private void abrirTelaRelClientes() {
		final TelaRelatorioClientes x = new TelaRelatorioClientes();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(x);
			}
		};
		x.setCloseAction(action);
		tabbedPane.addTab("Relatório de Clientes", x);
		mostrarUltima();
	}

	private void abrirTelaRelProdutos() {
		final TelaRelatorioProdutos y = new TelaRelatorioProdutos();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(y);
			}
		};
		y.setCloseAction(action);
		tabbedPane.addTab("Relatório de Produtos", y);
		mostrarUltima();
	}

	private void abrirTelaVendas() {
		final TelaVendas tv = new TelaVendas();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tv);
			}
		};
		tv.setCloseAction(action);
		tabbedPane.addTab("Fazer Venda", tv);
		mostrarUltima();
	}

	private void abrirTelaUsuarios() {
		final TelaUsuarios tu = new TelaUsuarios();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tu);
			}
		};
		tu.setCloseAction(action);
		tabbedPane.addTab("Cadastro de Usuários", tu);
		mostrarUltima();
	}

	private void abrirTelaClientes() {
		final TelaClientes tc = new TelaClientes();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tc);
			}
		};
		tc.setCloseAction(action);
		tabbedPane.addTab("Cadastro de Clientes", tc);
		mostrarUltima();
	}

	private void abrirTelaProdutos() {
		final TelaProdutos tp = new TelaProdutos();
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(tp);
			}
		};
		tp.setCloseAction(action);
		tabbedPane.addTab("Cadastro de Produtos", tp);
		mostrarUltima();
	}

	private void bloquearTelaPrincipal() {

		Runnable acaoOk = new Runnable() {
			public void run() {
				pelicula.setVisible(false);
				pelicula = new Bloqueador();
			}
		};

		Login telaLogin = new Login(acaoOk);
		pelicula = new Bloqueador(telaLogin);
		setGlassPane(pelicula);
		pelicula.setVisible(true);

	}

	private void mostrarUltima() {
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
	}
}