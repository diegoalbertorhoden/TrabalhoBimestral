package br.univel.login;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Login extends JPanel {

	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnEntrar;

	public Login() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{36, 0, 0, 395, -4, 18, 0, 7, 0};
		gridBagLayout.rowHeights = new int[]{20, 20, 23, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblUsurio = new JLabel("Usuário");
		GridBagConstraints gbc_lblUsurio = new GridBagConstraints();
		gbc_lblUsurio.anchor = GridBagConstraints.WEST;
		gbc_lblUsurio.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsurio.gridx = 2;
		gbc_lblUsurio.gridy = 1;
		add(lblUsurio, gbc_lblUsurio);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Senha");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 2;
		add(passwordField, gbc_passwordField);

		btnEntrar = new JButton("Entrar");
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.anchor = GridBagConstraints.NORTH;
		gbc_btnEntrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEntrar.gridx = 3;
		gbc_btnEntrar.gridy = 3;
		add(btnEntrar, gbc_btnEntrar);
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				textField.requestFocus();
			}
		});
		
	}

	public Login(final Runnable acaoOk) {
		this();
		btnEntrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().equals("root")
						&& new String(passwordField.getPassword()).equals("root")) {
					acaoOk.run();
				} else {
					JOptionPane.showMessageDialog(Login.this,
							"Usuário ou senha inválido!");
				}
			}
		});

	}

}
