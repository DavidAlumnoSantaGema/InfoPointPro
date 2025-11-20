package InfoPointPro;

import java.util.ArrayList;

public class BBDD
{
	private ArrayList<Cuenta> cuentasBBDD;
	private ArrayList<Libro> librosBBDD;
	private ArrayList<Aviso> avisosBBDD;


	public BBDD()
	{
		this.cuentasBBDD = Escriba.LeerCuentas();
		this.librosBBDD = Escriba.LeerLibros();
		this.avisosBBDD = Escriba.LeerAvisos();
	}
	
	public void GuardarAviso(Aviso aviso)
	{
		avisosBBDD.add(aviso);
		Escriba.GuardarAvisos(avisosBBDD);
	}
	
	public ArrayList<Cuenta> getCuentas() {
		return cuentasBBDD;
	}

	public ArrayList<Libro> getLibros() {
		return librosBBDD;
	}

	public ArrayList<Aviso> getAvisos() {
		return avisosBBDD;
	}

	/**
	 * Guarda el libro en la lista de libros y guarda el archivo.<br>
	 * Si se ha introducido un número con los mismos datos que uno que ya existe en la lista, se añade 1 a la cantidad del libro encontrado.
	 * @param libro El libro a guardar
	 */
	public void GuardarLibro(Libro libro)
	{
		for (int i = 0; i < librosBBDD.size(); i++)
		{
			Libro libroBBDD = librosBBDD.get(i);
			if (libroBBDD.SameAs(libro))
			{
				libroBBDD.setNumEjemplares(libroBBDD.getNumEjemplares() + 1);
				Escriba.GuardarLibros(librosBBDD);
				return;
			}
		}
		librosBBDD.add(libro);
		Escriba.GuardarLibros(librosBBDD);
	}
	
	/**
	 * Guarda la cuenta en la lista de cuentas y guarda el archivo.
	 * @param cuenta La cuenta a guardar
	 * @return True si la cuenta se ha podido guardar. False si ya existe una cuenta con el mismo usuario.
	 */
	public boolean GuardarCuenta(Cuenta cuenta)
	{
		for (int i = 0; i < cuentasBBDD.size(); i++)
		{
			if (cuentasBBDD.get(i).getNombre().equals(cuenta.getNombre()))
			{
				return false;
			}
		}
		cuentasBBDD.add(cuenta);
		Escriba.GuardarCuentas(cuentasBBDD);
		return true;
	}
}
