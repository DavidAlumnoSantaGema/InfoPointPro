package InfoPointPro;

public class Libro
{
	private String titulo;
	private String autor;
	private String sinopsis;
	private int numEjemplares;
	
	public Libro(String titulo, String autor, String sinopsis, int numEjemplares)
	{
		this.titulo = titulo;
		this.autor = autor;
		this.sinopsis = sinopsis;
		this.numEjemplares = numEjemplares;
	}
	
	public boolean SameAs(Libro libro)
	{
		return libro.getTitulo().equals(titulo)
			&& libro.getAutor().equals(autor)
			&& libro.getSinopsis().equals(sinopsis);
	}
	
	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public boolean SameAsEjemplaresInlcuded(Libro libro)
	{
		return SameAs(libro) && numEjemplares == libro.getNumEjemplares();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public int getNumEjemplares() {
		return numEjemplares;
	}
}
