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

import InfoPointPro.MainAPP;
import ListCellRenderer.CellRendererCuentas;

public class VentanaAdminClientes extends JPanel
{
	private DefaultListModel listaCuentas = new DefaultListModel();

	public VentanaAdminClientes()
	{
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(597, 11, 639, 417);
		setLayout(null);
		
		JLabel lblTituloClientes = new JLabel("Clientes");
		lblTituloClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloClientes.setBounds(10, 11, 257, 24);
		add(lblTituloClientes);
		
		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(10, 46, 257, 240);
		add(scrollPaneClientes);
		
		JList listClientes = new JList();
		listClientes.setModel(listaCuentas);
		listClientes.setCellRenderer(new CellRendererCuentas());
		scrollPaneClientes.setViewportView(listClientes);
		
		JButton buttonCrearClientes = new JButton("Añadir cliente");
		buttonCrearClientes.setBounds(10, 297, 120, 49);
		add(buttonCrearClientes);
		
		JButton buttonBorrarCliente = new JButton("Borrar cliente");
		buttonBorrarCliente.setBounds(147, 297, 120, 49);
		add(buttonBorrarCliente);
		
		JButton buttonAdmin = new JButton("Hacer Admin");
		buttonAdmin.setBounds(10, 357, 120, 49);
		add(buttonAdmin);
		
		JButton buttonAlquilarLibro = new JButton("Alquilar Libro");
		buttonAlquilarLibro.setBounds(147, 357, 120, 49);
		add(buttonAlquilarLibro);
		
		UpdateCuentaList();
	}
	
	private void UpdateCuentaList()
	{
		listaCuentas.clear();
		listaCuentas.addAll(MainAPP.bbdd.getCuentas());
	}
}
