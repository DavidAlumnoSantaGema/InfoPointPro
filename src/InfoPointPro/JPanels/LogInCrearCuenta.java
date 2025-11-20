package InfoPointPro.JPanels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import InfoPointPro.Cuenta;
import InfoPointPro.LogIn;
import InfoPointPro.Main;

public class LogInCrearCuenta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private LogIn login;

	public LogInCrearCuenta(LogIn login)
	{
		this.login = login;
		setBounds(100, 100, 450, 216);
		setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(10, 43, 414, 24);
		contentPanel.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(124, 78, 180, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel lblContrasea = new JLabel("Contraseña");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
			lblContrasea.setBounds(10, 113, 414, 24);
			contentPanel.add(lblContrasea);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 148, 180, 24);
		contentPanel.add(passwordField);
		
		JLabel lblTitulo = new JLabel("Nueva cuenta");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(10, 11, 414, 24);
		contentPanel.add(lblTitulo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						for (Cuenta cuenta : Main.bbdd.getCuentas())
						{
							if (cuenta.getNombre().equals(textField.getText()))
							{
								// Existe usuario no crear cuenta
							}
						}
						// No existe usuario crear cuenta
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				login.getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ChangePanel("opcion");
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void ChangePanel(String panel)
	{
		CardLayout cl = (CardLayout) login.getContentPane().getLayout();
		cl.show(login.getContentPane(), panel);
	}
}
