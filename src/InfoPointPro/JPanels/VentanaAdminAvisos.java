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

public class VentanaAdminAvisos extends JPanel
{
	public VentanaAdminAvisos()
	{
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setBounds(297, 11, 346, 340);
		setLayout(null);
		
		JLabel lblTituloAvisos = new JLabel("Avisos");
		lblTituloAvisos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAvisos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloAvisos.setBounds(10, 11, 326, 25);
		add(lblTituloAvisos);
		
		JScrollPane scrollPanelAvisos = new JScrollPane();
		scrollPanelAvisos.setBounds(10, 47, 326, 230);
		add(scrollPanelAvisos);
		
		JList listAvisos = new JList();
		scrollPanelAvisos.setViewportView(listAvisos);
		
		JButton buttonCrearAviso = new JButton("Crear aviso");
		buttonCrearAviso.setBounds(20, 288, 134, 36);
		add(buttonCrearAviso);
		
		JButton buttonBorrarAviso = new JButton("Borrar aviso");
		buttonBorrarAviso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonBorrarAviso.setBounds(188, 288, 134, 36);
		add(buttonBorrarAviso);
	}
	
}
