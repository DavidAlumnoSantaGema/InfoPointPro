package ListCellRenderer;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import InfoPointPro.Cuenta;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
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
		labelAvisos.setText(String.valueOf(value.getAvisos().size()));
		labelLibros.setText(String.valueOf(value.getLibrosAlquilados().size()));
		
		if (isSelected)
		{
			this.setBackground(list.getSelectionBackground());
		}
		
		setOpaque(true);
		return this;
	}

}
