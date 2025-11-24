package Dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import InfoPointPro.Cuenta;
import InfoPointPro.MainAPP;
import InfoPointPro.JPanels.VentanaAdminClientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioCrearCliente extends JDialog
{
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldPassword;
	VentanaAdminClientes ventana;


	public FormularioCrearCliente(VentanaAdminClientes ventana)
	{
		this.ventana = ventana;
		setTitle("Crear cliente");
		setBounds(100, 100, 450, 247);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel tituloNombre = new JLabel("Nombre");
		tituloNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tituloNombre.setBounds(10, 11, 414, 14);
		contentPanel.add(tituloNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(78, 36, 278, 20);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel tituloPassword = new JLabel("Contraseña");
		tituloPassword.setHorizontalAlignment(SwingConstants.CENTER);
		tituloPassword.setBounds(10, 67, 414, 14);
		contentPanel.add(tituloPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(78, 92, 278, 20);
		contentPanel.add(textFieldPassword);
		
		JCheckBox checkboxAdmin = new JCheckBox("Admin");
		checkboxAdmin.setBounds(177, 130, 80, 23);
		contentPanel.add(checkboxAdmin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						Cuenta nuevaCuenta = new Cuenta(textFieldNombre.getText(), textFieldPassword.getText());
						nuevaCuenta.setAdmin(checkboxAdmin.isSelected());
						if (MainAPP.bbdd.GuardarCuenta(nuevaCuenta))
						{
							JOptionPane.showMessageDialog(FormularioCrearCliente.this, "Cuenta guardada correctamente", "¡Exito!", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(FormularioCrearCliente.this, "No se ha podido guardar la cuenta", "¡Error!", JOptionPane.ERROR_MESSAGE);
						}
						ventana.UpdateCuentaList();
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
