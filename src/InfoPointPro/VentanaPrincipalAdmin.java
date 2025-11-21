package InfoPointPro;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import InfoPointPro.JPanels.VentanaAdminAvisos;
import InfoPointPro.JPanels.VentanaAdminClientes;
import InfoPointPro.JPanels.VentanaAdminLibros;
import ListCellRenderer.CellRendererCuentas;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipalAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean altoContrasteActivo = false;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalAdmin() {
		setTitle("Biblioteca Municipal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 864, 417);
		contentPane.add(tabbedPane);

		tabbedPane.addTab("Libros", null, new VentanaAdminLibros(), "Libros");
		tabbedPane.addTab("Avisos", null, new VentanaAdminAvisos(), "Avisos");
		tabbedPane.addTab("Clientes", null, new VentanaAdminClientes(), "Clientes");

		JMenuBar menuBar = new JMenuBar();
		JMenu lookMenu = new JMenu("Temas");

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			JMenuItem item = new JMenuItem(info.getName());
			item.addActionListener(e -> changeLookAndFeel(info.getClassName()));
			lookMenu.add(item);
		}

		JCheckBoxMenuItem highContrastItem = new JCheckBoxMenuItem("Alto Contraste");
		highContrastItem.addActionListener(e -> {
			altoContrasteActivo = highContrastItem.isSelected();
			actualizarAltoContraste(altoContrasteActivo);
		});

		lookMenu.addSeparator();
		lookMenu.add(highContrastItem);

		menuBar.add(lookMenu);
		setJMenuBar(menuBar);
<<<<<<< HEAD
=======
		
		menuBar.add(Box.createHorizontalGlue());
		
		JButton btnNewButton = new JButton("Cerrar Sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn login = new LogIn();
				login.setVisible(true);
				dispose();
			}
		});
		menuBar.add(btnNewButton);
		
		UpdateCuentaList();
	}
	
	private void UpdateCuentaList()
	{
		listaCuentas.clear();
		listaCuentas.addAll(MainAPP.bbdd.getCuentas());
>>>>>>> 0f755f80725b6aaa189fba3b208f08e6d0577a20
	}

	private void changeLookAndFeel(String className) {
		try {
			UIManager.setLookAndFeel(className);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void actualizarAltoContraste(boolean activo) {
		Color fondo = activo ? Color.BLACK : UIManager.getColor("Panel.background");
		Color texto = activo ? Color.WHITE : UIManager.getColor("Panel.foreground");

		applyColorsRecursively(contentPane, fondo, texto);

		JMenuBar menuBar = getJMenuBar();
		if (menuBar != null) {
			applyColorsRecursively(menuBar, fondo, texto);
		}

		SwingUtilities.updateComponentTreeUI(this);
	}

	private void applyColorsRecursively(Component comp, Color background, Color foreground) {
		comp.setBackground(background);
		comp.setForeground(foreground);

		if (comp instanceof Container container) {
			for (Component child : container.getComponents()) {
				applyColorsRecursively(child, background, foreground);
			}
		}
	}
}
