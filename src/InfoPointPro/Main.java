package InfoPointPro;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main
{
	private static ArrayList<Cuenta> cuentasBBDD;
	
	public static void main(String[] args)
	{
		
	}
	
	
	private static void CargarCuentas()
	{
		cuentasBBDD = Escriba.LeerCuentas();
	}
}
