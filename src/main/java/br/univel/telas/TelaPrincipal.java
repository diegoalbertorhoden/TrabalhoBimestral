package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.univel.login.PainelLogin;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

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
		setTitle("Sistema para Lojas de Cal\u00E7ados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnCadastro = new JMenu("Cadastros");
		menuBar.add(mnCadastro);

		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				TelaProdutos tp = new TelaProdutos();
				tabbedPane.addTab("Cadastro de Produtos ", tp);
			}
		});

		mnCadastro.add(mntmProdutos);

		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				TelaClientes tc = new TelaClientes();
				tabbedPane.addTab("Cadastro de Clientes", tc);

			}
		});
		mnCadastro.add(mntmClientes);

		JMenuItem mntmUsurios = new JMenuItem("Usu\u00E1rios");
		mntmUsurios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MioloUsuarios tu = new MioloUsuarios();
				tabbedPane.addTab("Cadastro de Usu�rios", tu);
			}
		});
		mnCadastro.add(mntmUsurios);

		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);

		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mntmNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaVendas tv = new TelaVendas();
				tabbedPane.addTab("Fazer Venda", tv);
			}
		});
		mnVendas.add(mntmNovaVenda);

		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		menuBar.add(mnRelatrios);

		JMenuItem mntmNewMenuItem = new JMenuItem("Produtos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaRelatorioProdutos y = new TelaRelatorioProdutos();
				tabbedPane.addTab("Relat�rio de Produtos", y);
			}
		});
		mnRelatrios.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaRelatorioClientes x = new TelaRelatorioClientes();
				tabbedPane.addTab("Relat�rio de Clientes", x);
			}
		});
		mnRelatrios.add(mntmNewMenuItem_1);

		JMenuItem mntmVendas = new JMenuItem("Vendas");
		mntmVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaRelatorioVendas trv = new TelaRelatorioVendas();
				tabbedPane.addTab("Relat�rio de Vendas", trv);
			}
		});
		mnRelatrios.add(mntmVendas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		tabbedPane = new JTabbedPane(SwingConstants.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}
	//copiado do exemplo do professor
	
	PainelLogin painelLogin = new PainelLogin(acaoOk);
	glass = new BlockPanel(painelLogin);
	//-----------------------------------

	setGlassPane(glass);

	glass.setVisible(true);
}

	
	private void blockParaLogin() {
		Runnable acaoOk = () -> {
			glass.setVisible(false);
			glass = new BlockPanel();
		};
	
	protected void block() {
		setGlassPane(glass);
		glass.setVisible(true);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i =0; i < 5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				glass.setVisible(false);
			}
		}).start();
	
}
