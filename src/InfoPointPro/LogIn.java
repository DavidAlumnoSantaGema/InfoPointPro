package InfoPointPro;

import javax.swing.JDialog;

import InfoPointPro.JPanels.*;
import java.awt.CardLayout;

public class LogIn extends JDialog
{
	private static final long serialVersionUID = 1L;
	private LogInOpcion opcion;
	private LogInIniciarSesion iniciarSesion;
	private LogInCrearCuenta crearCuenta;
	
	/**
	 * Create the dialog.
	 */
	public LogIn()
	{
		setBounds(100, 100, 450, 250);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		opcion = new LogInOpcion(this);
		iniciarSesion = new LogInIniciarSesion(this);
		crearCuenta = new LogInCrearCuenta(this);
	
		getContentPane().add(opcion, "opcion");
		getContentPane().add(iniciarSesion, "iniciarsesion");
		getContentPane().add(crearCuenta, "crearcuenta");
	}
}
