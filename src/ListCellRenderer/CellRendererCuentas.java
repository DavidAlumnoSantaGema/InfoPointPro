package ListCellRenderer;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import InfoPointPro.Cuenta;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

public class CellRendererCuentas extends JPanel implements ListCellRenderer<Cuenta>
{
	private static final long serialVersionUID = 1L;
	private JLabel labelNombre;
	private JLabel labelAvisos;
	private JLabel labelLibros;
	
	
	public CellRendererCuentas()
	{
		setLayout(new GridLayout(1, 0, 0, 0));
		labelNombre = new JLabel();
		labelNombre.setText("a");
		add(labelNombre);
		
		labelAvisos = new JLabel();
		labelAvisos.setText("b");
		add(labelAvisos);
		
		labelLibros = new JLabel();
		labelLibros.setText("c");
		add(labelLibros);
	}
	

	@Override
	public Component getListCellRendererComponent
		(JList<? extends Cuenta> list,
		Cuenta value,
		int index,
		boolean isSelected,
		boolean cellHasFocus)
	{
		labelNombre.setText(value.getNombre());
		labelAvisos.setText("Avisos: " + String.valueOf(value.getAvisos().size()));
		labelLibros.setText("Libros: " + String.valueOf(value.getLibrosAlquilados().size()));
		
		labelNombre.setForeground(Color.BLACK);
		labelAvisos.setForeground(Color.BLACK);
		labelLibros.setForeground(Color.BLACK);
		
		this.setBackground(list.getBackground());
		if (value.isAdmin())
		{
			this.setBackground(new Color(128, 0, 0));
			labelNombre.setForeground(Color.WHITE);
			labelAvisos.setForeground(Color.WHITE);
			labelLibros.setForeground(Color.WHITE);
		}
		if (isSelected)
		{
			this.setBackground(list.getSelectionBackground());
			labelNombre.setForeground(Color.BLACK);
			labelAvisos.setForeground(Color.BLACK);
			labelLibros.setForeground(Color.BLACK);
		}
		
		setOpaque(true);
		return this;
	}

}
