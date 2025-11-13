package InfoPointPro;
import javax.swing.*;
import java.awt.*;

public class PantallaCarga extends JFrame {

    private JProgressBar progressBar;
    private JLabel messageLabel;

    public PantallaCarga() {
        setUndecorated(true);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(98, 51, 7));

        JLabel title = new JLabel("AAAAAAAAAA", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color (255, 237, 186));

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color (255, 237, 186));
        progressBar.setBackground(new Color (160, 108, 63));

        messageLabel = new JLabel("Conectando...", SwingConstants.CENTER);
        messageLabel.setForeground(new Color (255, 237, 186));

        add(title, BorderLayout.NORTH);
        add(progressBar, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);

        setVisible(true);

        simulateLoading();
    }

    private void simulateLoading() {
        try {            	
        	int a = 0;
            int b = 1;
            for (int i = 0; i <= 100; i++) {

            	if(a < b) {
            		Thread.sleep(a);
                	progressBar.setValue(i);

                	if (i == 30) messageLabel.setText("Cargando módulos...");
                	if (i == 60) messageLabel.setText("Conectando con la base de datos...");
                	if (i == 90) messageLabel.setText("Iniciando interfaz...");
                	
                	a = b + a;

                	if (i == 100) {
                		dispose();
                		new LogIn().setVisible(true);
                	}
            	}else {
            		Thread.sleep(b);
                	progressBar.setValue(i);

                	if (i == 30) messageLabel.setText("Cargando módulos...");
                	if (i == 60) messageLabel.setText("Conectando con la base de datos...");
                	if (i == 90) messageLabel.setText("Iniciando interfaz...");
                	
                	b = a + b;

                	if (i == 100) {
                		dispose();
                		new LogIn().setVisible(true);
                	}
            	}
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PantallaCarga();
    }
}
