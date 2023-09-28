
public class Circuito {

	private String nombre;
	private String locacion;
	private String tipo;
	private short kilometros;
	private short vueltas;
	private short curvas;


	// Constructores
	
	public Circuito(String nombre, String locacion, String tipo, short kilometros, short curvas) {
		setNombres(nombre);
		setLocacion(locacion);
		setTipo(tipo);
		setKilometros(kilometros);
		setVueltas(1);
		setCurvas(curvas);
	}

	public Circuito(String nombre, String locacion, String tipo, short kilometros, short vueltas, short curvas) {
		setNombres(nombre);
		setLocacion(locacion);
		setTipo(tipo);
		setKilometros(kilometros);
		setVueltas(vueltas);
		setCurvas(curvas);
	}
	
	// getters
	
	public String getNombre() {
		return this.nombre;
	}

	public String getLocacion() {
		return this.locacion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public short getKilometros() {
		return this.kilometros;
	}

	public short getVueltas() {
		return this.vueltas;
	}

	public short getCurvas() {
		return this.curvas;
	}


	// setters
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setKilometros(short kilometros) {
		this.kilometros = kilometros;
	}

	public void setVueltas(short vueltas) {
		this.vueltas = vueltas;
	}

	public void setCurvas() {
		this.curvas = curvas;
	}


	// metodos adicionales
	
	public String toString() {
		String nom, loc, tip, km, v, curv;

		nom = "Nombre: " + getNombre() + "\n";
		loc = "Locacion: " + getLocacion() + "\n";
		tip = "Tipo: " + getTipo() + "\n";
		km = "Vueltas: " + getVueltas() + "\n";
		v = "Kilometros: " + getKilometros() + "\n";
		curv = "Curvas: " + getCurvas() + "\n";

		return nom + loc + tip + km + v + curv;
	}
}
