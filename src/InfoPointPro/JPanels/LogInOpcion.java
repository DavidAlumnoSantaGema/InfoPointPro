package InfoPointPro.JPanels;

import javax.swing.JPanel;
import javax.swing.KeyStroke;

import InfoPointPro.LogIn;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

public class LogInOpcion extends JPanel
{
	private static final long serialVersionUID = 1L;
	private LogIn login;
	

	public LogInOpcion(LogIn login)
	{
		this.login = login;
        
		JButton buttonLogIn = new JButton("Iniciar sesión");
		buttonLogIn.setBackground(new Color(255, 237, 186));
		buttonLogIn.setBounds(139, 26, 157, 54);
		buttonLogIn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "press");
		buttonLogIn.setMnemonic(KeyEvent.VK_I);
		buttonLogIn.setToolTipText("(Alt+I) Ventana Inicio Sesión");
		setBackground(new Color(184, 140, 92));
		buttonLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ChangePanel("iniciarsesion");
			}
		});
		setLayout(null);
		add(buttonLogIn);
		
		JButton buttonSignUp = new JButton("Crear cuenta");
		buttonSignUp.setBackground(new Color(255, 237, 186));
		buttonSignUp.setBounds(139, 115, 157, 54);
		buttonSignUp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "press");
		buttonSignUp.setMnemonic(KeyEvent.VK_C);
		buttonSignUp.setToolTipText("(Alt+C) Ventana Crear Cuenta");
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
