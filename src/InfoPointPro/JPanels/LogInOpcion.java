package InfoPointPro.JPanels;

import javax.swing.JPanel;

import InfoPointPro.LogIn;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class LogInOpcion extends JPanel
{
	private static final long serialVersionUID = 1L;
	private LogIn login;
	

	public LogInOpcion(LogIn login)
	{
		this.login = login;
		
		JButton buttonLogIn = new JButton("Iniciar sesión");
		buttonLogIn.setBounds(139, 26, 157, 54);
		buttonLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ChangePanel("iniciarsesion");
			}
		});
		setLayout(null);
		add(buttonLogIn);
		
		JButton buttonSignUp = new JButton("Crear cuenta");
		buttonSignUp.setBounds(139, 115, 157, 54);
		buttonSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ChangePanel("crearcuenta");
			}
		});
		add(buttonSignUp);

	}
	
	private void ChangePanel(String panel)
	{
		CardLayout cl = (CardLayout) login.getContentPane().getLayout();
		cl.show(login.getContentPane(), panel);
	}
}
