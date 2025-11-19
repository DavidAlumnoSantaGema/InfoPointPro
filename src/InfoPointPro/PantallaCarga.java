package InfoPointPro;

import javax.swing.*;
import java.awt.*;

public class PantallaCarga extends JFrame {

    private JProgressBar progressBar;
    private JLabel messageLabel;
    private int progress = 0;

    public PantallaCarga() {
        setUndecorated(true);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(98, 51, 7));

        JLabel title = new JLabel("Cargando Biblioteca", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(255, 237, 186));

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(255, 237, 186));
        progressBar.setBackground(new Color(160, 108, 63));
        progressBar.setFont(new Font("Arial", Font.BOLD, 24));

        messageLabel = new JLabel("Conectando...", SwingConstants.CENTER);
        messageLabel.setForeground(new Color(255, 237, 186));

        add(title, BorderLayout.NORTH);
        add(progressBar, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);

        setVisible(true);

        startLoading();
    }

    private void startLoading() {
        Timer timer = new Timer(50, e -> {
            progress++;
            progressBar.setValue(progress);

            if (progress == 30) messageLabel.setText("Conectando...");
            if (progress == 60) messageLabel.setText("Cargando estilos...");
            if (progress == 90) messageLabel.setText("Iniciando Biblioteca...");

            if (progress >= 100) {
                ((Timer) e.getSource()).stop();
                dispose();

                new LogIn().setVisible(true);

                System.out.println("Pantalla de carga finalizada");
            }
        });

        timer.start();
    }

    public static void main(String[] args) {

        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);

        new PantallaCarga();
    }
}
