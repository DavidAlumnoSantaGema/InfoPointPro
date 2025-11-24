package InfoPointPro.JPanels;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import InfoPointPro.Cuenta;
import InfoPointPro.MainAPP;
import ListCellRenderer.CellRendererCuentas;
import javax.swing.border.EmptyBorder;

import Dialogs.FormularioCrearCliente;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaAdminClientes extends JPanel
{
	private DefaultListModel listaCuentas = new DefaultListModel();

	public VentanaAdminClientes()
	{
		setBackground(new Color(255, 237, 186));
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(597, 11, 864, 417);
		setLayout(null);
		
		JLabel lblTituloClientes = new JLabel("Clientes");
		lblTituloClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloClientes.setBounds(10, 11, 284, 24);
		add(lblTituloClientes);
		
		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(10, 46, 284, 325);
		add(scrollPaneClientes);
		
		JList listClientes = new JList();
		scrollPaneClientes.setViewportView(listClientes);
		listClientes.setModel(listaCuentas);
		listClientes.setCellRenderer(new CellRendererCuentas());
		
		JButton buttonCrearClientes = new JButton("Añadir cliente");
		buttonCrearClientes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				FormularioCrearCliente crearCliente = new FormularioCrearCliente(VentanaAdminClientes.this);
				crearCliente.setModal(true);
				crearCliente.setVisible(true);
			}
		});
		buttonCrearClientes.setBounds(304, 46, 194, 32);
		add(buttonCrearClientes);
		
		JButton buttonBorrarCliente = new JButton("Borrar cliente");
		buttonBorrarCliente.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selIndex = listClientes.getSelectedIndex();
				if (selIndex > -1)
				{
					Cuenta cuenta = (Cuenta)listClientes.getSelectedValue();
				}
			}
		});
		buttonBorrarCliente.setBounds(304, 89, 194, 32);
		add(buttonBorrarCliente);
		
		JButton buttonAdmin = new JButton("Hacer Admin");
		buttonAdmin.setBounds(304, 132, 194, 32);
		add(buttonAdmin);
		
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(508, 11, 346, 360);
		add(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 346, 360);
		contentPane.add(tabbedPane);
		
		tabbedPane.addTab("Libros asignados", new VentanaAdminAvisos());
		tabbedPane.addTab("Avisos asignados", new VentanaAdminLibrosAsignados());
		
		UpdateCuentaList();
	}
	
	public void UpdateCuentaList()
	{
		listaCuentas.clear();
		listaCuentas.addAll(MainAPP.bbdd.getCuentas());
	}
}
