package InfoPointPro;

public class Aviso
{
	private Cuenta cuenta;
	private Libro libro;
	private String mensaje;
	
	public Aviso(Cuenta cuenta, Libro libro, String mensaje)
	{
		this.cuenta = cuenta;
		this.libro = libro;
		this.mensaje = mensaje;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public Libro getLibro() {
		return libro;
	}

	public String getMensaje() {
		return mensaje;
	}
}
