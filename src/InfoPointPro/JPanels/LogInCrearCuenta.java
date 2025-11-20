package InfoPointPro.JPanels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import InfoPointPro.BBDD;
import InfoPointPro.Cuenta;
import InfoPointPro.LogIn;
import InfoPointPro.MainAPP;

import java.awt.Color;

public class LogInCrearCuenta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private LogIn login;

	public LogInCrearCuenta(LogIn login)
	{
		JLabel usuarioYaCreado = new JLabel("");
		usuarioYaCreado.setForeground(new Color(255, 0, 0));
		this.login = login;
		setBounds(100, 100, 450, 216);
		setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(new Color(255, 237, 186));

		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(10, 43, 414, 24);
		contentPanel.add(lblUsuario);
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(184, 140, 92));
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
		passwordField.setForeground(new Color(255, 255, 255));
		passwordField.setBackground(new Color(184, 140, 92));
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
			buttonPane.setBackground(new Color(255, 237, 186));
			add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBackground(new Color(184, 140, 92));
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (textField.getText().isEmpty() || passwordField.getPassword().length <= 0)
						{
							usuarioYaCreado.setForeground(Color.RED);
							usuarioYaCreado.setText("Nombre o contraseña vacíos.");
							return;
						}
						for (Cuenta cuenta : MainAPP.bbdd.getCuentas())
						{
							if (cuenta.getNombre().equals(textField.getText()))
							{
								usuarioYaCreado.setForeground(Color.RED);
								usuarioYaCreado.setText("Nombre de Usuario ya creado");
								return;
							}
						}
						Cuenta cuenta = new Cuenta(textField.getText(), String.valueOf(passwordField.getPassword())); 
						BBDD bbdd = new BBDD();
						bbdd.GuardarCuenta(cuenta);
						usuarioYaCreado.setForeground(Color.GREEN);
						usuarioYaCreado.setText("Usuario creado");
					}
				});
				
				buttonPane.add(usuarioYaCreado);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "press");
				okButton.getActionMap().put("press", new AbstractAction()
				{
				    @Override
				    public void actionPerformed(ActionEvent e) {
				        okButton.doClick();
				    }
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBackground(new Color(184, 140, 92));
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						usuarioYaCreado.setText("");
						textField.setText("");
						passwordField.setText("");
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
