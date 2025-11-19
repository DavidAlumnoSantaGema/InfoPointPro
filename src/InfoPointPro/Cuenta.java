package InfoPointPro;

public class Cuenta
{
	private String nombre;
	private String password;
	
	
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
}
