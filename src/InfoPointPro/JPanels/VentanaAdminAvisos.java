package InfoPointPro.JPanels;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class VentanaAdminAvisos extends JPanel
{
	public VentanaAdminAvisos()
	{
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(297, 11, 726, 417);
		setLayout(null);
		
		JLabel lblTituloAvisos = new JLabel("Avisos");
		lblTituloAvisos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAvisos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloAvisos.setBounds(109, 59, 56, 25);
		add(lblTituloAvisos);
		
		JScrollPane scrollPanelAvisos = new JScrollPane();
		scrollPanelAvisos.setBounds(170, 7, 258, 130);
		add(scrollPanelAvisos);
		
		JList listAvisos = new JList();
		scrollPanelAvisos.setViewportView(listAvisos);
		
		JButton buttonCrearAviso = new JButton("Crear aviso");
		buttonCrearAviso.setBounds(433, 60, 87, 23);
		add(buttonCrearAviso);
		
		JButton buttonBorrarAviso = new JButton("Borrar aviso");
		buttonBorrarAviso.setBounds(525, 60, 91, 23);
		add(buttonBorrarAviso);
	}
	
}
