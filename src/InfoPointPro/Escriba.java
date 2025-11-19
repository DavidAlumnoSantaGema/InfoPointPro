package InfoPointPro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Escriba
{
	private static final String RUTACUENTAS = "cuentas.dat";
	
	
	public static ArrayList<Cuenta> LeerCuentas()
	{
		try
		{
	        File file = new File(RUTACUENTAS);
	        if (!file.exists())
	        {
	            file.createNewFile();
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	            oos.writeObject(new ArrayList<Cuenta>());
	            oos.close();
	        }
	        
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTACUENTAS));
			ArrayList<Cuenta> cuentas = (ArrayList<Cuenta>) ois.readObject();
			ois.close();
			return cuentas;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public static void GuardarCuentas(ArrayList<Cuenta> cuentas)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTACUENTAS));
			oos.writeObject(cuentas);
			oos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
