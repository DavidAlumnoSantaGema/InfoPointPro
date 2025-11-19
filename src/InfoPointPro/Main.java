package InfoPointPro;

import java.util.ArrayList;

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
