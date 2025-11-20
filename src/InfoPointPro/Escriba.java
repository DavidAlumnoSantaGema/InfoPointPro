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
	private static final String RUTAAVISOS = "avisos.dat";
	private static final String RUTALIBROS = "libros.dat";
	
	
	public static ArrayList<Aviso> LeerAvisos()
	{
		try
		{
	        File file = new File(RUTAAVISOS);
	        if (!file.exists())
	        {
	            file.createNewFile();
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	            oos.writeObject(new ArrayList<Cuenta>());
	            oos.close();
	        }
	        
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTAAVISOS));
			ArrayList<Aviso> avisos = (ArrayList<Aviso>) ois.readObject();
			ois.close();
			return avisos;
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
	
	
	public static void GuardarAvisos(ArrayList<Aviso> avisos)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTAAVISOS));
			oos.writeObject(avisos);
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
	
	public static ArrayList<Libro> LeerLibros()
	{
		try
		{
	        File file = new File(RUTALIBROS);
	        if (!file.exists())
	        {
	            file.createNewFile();
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
	            oos.writeObject(new ArrayList<Cuenta>());
	            oos.close();
	        }
	        
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTALIBROS));
			ArrayList<Libro> libros = (ArrayList<Libro>) ois.readObject();
			ois.close();
			return libros;
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
	
	
	public static void GuardarLibros(ArrayList<Libro> libros)
	{
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTALIBROS));
			oos.writeObject(libros);
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
