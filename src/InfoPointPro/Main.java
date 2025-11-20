package InfoPointPro;

import java.awt.Color;

import javax.swing.UIManager;

public class Main
{
	public static BBDD bbdd;
	
	public static void main(String[] args)
	{
		bbdd = new BBDD();

		
		for (int i = 0; i < bbdd.getCuentas().size(); i++)
		{
			System.out.println(bbdd.getCuentas().get(i).toString());
		}
		
		//CreateLoadingBar();
		VentanaPrincipalAdmin frame = new VentanaPrincipalAdmin();
		frame.setVisible(true);
	}
	
	private static void CreateLoadingBar()
	{
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);

        new PantallaCarga();
	}
}
