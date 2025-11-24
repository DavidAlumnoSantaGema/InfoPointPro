package InfoPointPro.JPanels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAdminLibrosAsignados extends JPanel
{
	public VentanaAdminLibrosAsignados()
	{
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(297, 11, 346, 340);
		setLayout(null);
		
		JLabel lblTituloLibros = new JLabel("Libros");
		lblTituloLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLibros.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloLibros.setBounds(10, 11, 326, 25);
		add(lblTituloLibros);
		
		JScrollPane scrollPanelAvisos = new JScrollPane();
		scrollPanelAvisos.setBounds(10, 47, 326, 230);
		add(scrollPanelAvisos);
		
		JList listLibros = new JList();
		scrollPanelAvisos.setViewportView(listLibros);
		
		JButton buttonAsignarLibros = new JButton("Asignar libro");
		buttonAsignarLibros.setBounds(20, 288, 134, 36);
		add(buttonAsignarLibros);
		
		JButton buttonQuitarLibro = new JButton("Quitar libro");
		buttonQuitarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonQuitarLibro.setBounds(186, 288, 134, 36);
		add(buttonQuitarLibro);
	}
	
}
