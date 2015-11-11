package br.univel.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class MolduraAbstrata extends JPanel {

	private JButton btnFechar;

	protected abstract void configura();

	public void setCloseAction(ActionListener action){
		btnFechar.addActionListener(action);
	}

	public MolduraAbstrata() {
		setForeground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblOl = new JLabel("Pagina Principal!");
		lblOl.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_lblOl = new GridBagConstraints();
		gbc_lblOl.insets = new Insets(0, 0, 0, 5);
		gbc_lblOl.gridx = 0;
		gbc_lblOl.gridy = 0;
		panel.add(lblOl, gbc_lblOl);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setBackground(Color.LIGHT_GRAY);
		add(panel_1, BorderLayout.SOUTH);

		btnFechar = new JButton("Fechar");
		panel_1.add(btnFechar);

		configura();
	}
}

