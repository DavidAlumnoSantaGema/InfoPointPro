package InfoPointPro;

import java.io.Serializable;
import java.util.ArrayList;

public class Cuenta implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String password;
	private boolean admin;
	private ArrayList<Libro> librosAlquilados;
	private ArrayList<Aviso> avisos;
	
	
    public Cuenta()
    {
    	
    }
    
	public Cuenta(String nombre, String password)
	{
		super();
		this.nombre = nombre;
		this.password = password;
		librosAlquilados = new ArrayList<Libro>();
		avisos = new ArrayList<Aviso>();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (admin)
		{
			sb.append('!');
		}
		sb.append(nombre + " ");
		sb.append("Tiene " + librosAlquilados.size() + " libros alquilados ");
		sb.append("Tiene " + avisos.size() + " avisos");
		return sb.toString();
	}
    
    
	public ArrayList<Libro> getLibrosAlquilados() {
		return librosAlquilados;
	}

	public ArrayList<Aviso> getAvisos() {
		return avisos;
	}

	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	public String getNombre() {
		return nombre;
	}


	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}
}
