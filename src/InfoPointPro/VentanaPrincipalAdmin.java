package InfoPointPro;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import ListCellRenderer.CellRendererCuentas;

import javax.swing.border.BevelBorder;

public class VentanaPrincipalAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean altoContrasteActivo = false;
	private DefaultListModel listaCuentas = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				VentanaPrincipalAdmin frame = new VentanaPrincipalAdmin();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

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
		
		JPanel panelLibros = new JPanel();
		panelLibros.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLibros.setBounds(10, 11, 277, 417);
		contentPane.add(panelLibros);
		panelLibros.setLayout(null);
		
		JLabel lblTituloLibros = new JLabel("Libros");
		lblTituloLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLibros.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloLibros.setBounds(10, 11, 257, 24);
		panelLibros.add(lblTituloLibros);
		
		JScrollPane scrollPaneLibros = new JScrollPane();
		scrollPaneLibros.setBounds(10, 46, 257, 300);
		panelLibros.add(scrollPaneLibros);
		
		JList listLibros = new JList();
		scrollPaneLibros.setViewportView(listLibros);
		
		JButton buttonCrearLibro = new JButton("Añadir libro");
		buttonCrearLibro.setBounds(10, 357, 120, 49);
		panelLibros.add(buttonCrearLibro);
		
		JButton buttonBorrarLibro = new JButton("Borrar libro");
		buttonBorrarLibro.setBounds(147, 357, 120, 49);
		panelLibros.add(buttonBorrarLibro);
		
		JPanel panelAviso = new JPanel();
		panelAviso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelAviso.setBounds(297, 11, 290, 417);
		contentPane.add(panelAviso);
		panelAviso.setLayout(null);
		
		JLabel lblTituloAvisos = new JLabel("Avisos");
		lblTituloAvisos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAvisos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloAvisos.setBounds(10, 11, 270, 24);
		panelAviso.add(lblTituloAvisos);
		
		JScrollPane scrollPanelAvisos = new JScrollPane();
		scrollPanelAvisos.setBounds(10, 46, 270, 300);
		panelAviso.add(scrollPanelAvisos);
		
		JList listAvisos = new JList();
		scrollPanelAvisos.setViewportView(listAvisos);
		
		JButton buttonCrearAviso = new JButton("Crear aviso");
		buttonCrearAviso.setBounds(10, 357, 120, 49);
		panelAviso.add(buttonCrearAviso);
		
		JButton buttonBorrarAviso = new JButton("Borrar aviso");
		buttonBorrarAviso.setBounds(160, 357, 120, 49);
		panelAviso.add(buttonBorrarAviso);
		
		JPanel panelClientes = new JPanel();
		panelClientes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelClientes.setBounds(597, 11, 277, 417);
		contentPane.add(panelClientes);
		panelClientes.setLayout(null);
		
		JLabel lblTituloClientes = new JLabel("Clientes");
		lblTituloClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTituloClientes.setBounds(10, 11, 257, 24);
		panelClientes.add(lblTituloClientes);
		
		JScrollPane scrollPaneClientes = new JScrollPane();
		scrollPaneClientes.setBounds(10, 46, 257, 300);
		panelClientes.add(scrollPaneClientes);
		
		JList listClientes = new JList();
		listClientes.setModel(listaCuentas);
		listClientes.setCellRenderer(new CellRendererCuentas());
		scrollPaneClientes.setViewportView(listClientes);
		
		JButton buttonCrearClientes = new JButton("Añadir cliente");
		buttonCrearClientes.setBounds(10, 357, 120, 49);
		panelClientes.add(buttonCrearClientes);
		
		JButton buttonBorrarCliente = new JButton("Borrar cliente");
		buttonBorrarCliente.setBounds(147, 357, 120, 49);
		panelClientes.add(buttonBorrarCliente);

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
		
		UpdateCuentaList();
	}
	
	private void UpdateCuentaList()
	{
		listaCuentas.clear();
		listaCuentas.addAll(Main.bbdd.getCuentas());
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
