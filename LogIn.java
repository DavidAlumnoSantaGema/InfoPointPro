package InfoPointPro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LogIn extends JDialog
{
	private static final String USER = "Admin";
	private static final String PASS = "Admin123";
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the dialog.
	 */
	public LogIn() {
		setBounds(100, 100, 450, 216);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(10, 11, 414, 24);
		contentPanel.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(124, 36, 180, 24);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel lblContrasea = new JLabel("Contraseña");
			lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
			lblContrasea.setBounds(10, 71, 414, 24);
			contentPanel.add(lblContrasea);
		}
		
		passwordField = new JPasswordField();
		passwordField.setBounds(124, 102, 180, 24);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (textField.getText().equals(USER) && String.valueOf(passwordField.getPassword()).equals(PASS))
						{
							//AppNotas app = new AppNotas();
							//app.setVisible(true);
							//LogIn.this.dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
