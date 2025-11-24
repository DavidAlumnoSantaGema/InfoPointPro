package InfoPointPro.JPanels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class VentanaAdminLibros extends JPanel
{
	public VentanaAdminLibros()
	{
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(10, 11, 864, 393);
		setLayout(null);
		
		JLabel lblTituloLibros = new JLabel("Libros");
		lblTituloLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLibros.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloLibros.setBounds(10, 11, 829, 25);
		add(lblTituloLibros);
		
		JScrollPane scrollPaneLibros = new JScrollPane();
		scrollPaneLibros.setBounds(20, 47, 819, 273);
		add(scrollPaneLibros);
		
		JList listLibros = new JList();
		scrollPaneLibros.setViewportView(listLibros);
		
		JButton buttonCrearLibro = new JButton("Añadir libro");
		buttonCrearLibro.setBounds(30, 331, 173, 47);
		add(buttonCrearLibro);
		
		JButton buttonBorrarLibro = new JButton("Borrar libro");
		buttonBorrarLibro.setBounds(666, 331, 173, 47);
		add(buttonBorrarLibro);
	}
	
}
