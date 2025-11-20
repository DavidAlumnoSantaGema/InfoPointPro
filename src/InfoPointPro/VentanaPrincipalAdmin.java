package InfoPointPro;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipalAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean altoContrasteActivo = false;

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
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

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
