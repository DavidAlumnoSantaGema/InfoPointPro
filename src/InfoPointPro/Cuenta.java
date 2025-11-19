package InfoPointPro;

import java.io.Serializable;

public class Cuenta implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String password;
	private boolean admin;
	
	
    public Cuenta()
    {
    	
    }
    
    
	public Cuenta(String nombre, String password)
	{
		super();
		this.nombre = nombre;
		this.password = password;
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
