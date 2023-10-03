import java.util.LinkedList;
import java.util.Random;
import java.time.LocalDate;

public class Carrera {
	private LinkedList<Piloto> corredores;
	private Circuito pista;
    private LocalDate fecha;
    private long digFecha;
	private boolean realizada;

	// Constructores
    	
	public Carrera (LinkedList<Piloto> corredores, Circuito pista, int dia, int mes, int anio) {
		setCorredores(corredores);
		setPista(pista); 
        setFecha(dia, mes, anio);
        concatFechaLong(dia,mes,anio);
	}
	
	// métodos extra

	public void concatFechaLong(int dia, int mes, int anio) {
        String a = String.valueOf(anio);
        String m = String.valueOf(mes);
        String d = String.valueOf(dia);

		if(dia < 10){
			d = "0" + d;
		}

		if(mes < 10) {
			m = "0" + m;
		}

        this.digFecha = Long.parseLong(a+m+d);
    }
	
	public void iniciarCarrrera() {
		carreraRealizada();
        System.out.println("FECHA: " + this.fechaToString());
        System.out.println(this.pista.toString());
		generarPosiciones();
		int cantidadVueltas = getPista().getVueltas();
		for(int j = 0; j < cantidadVueltas; j++) {
			generarPosiciones();
			System.out.printf("Vuelta %d:\n\n", j + 1);
			
			try {
				Thread.sleep((this.pista.getKilometros()*20)+this.pista.getCurvas()/1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			imprimirPosiciones();

		}
        darPuntos();
        Piloto corredor = this.corredores.getFirst();
        System.out.println(corredor.getNombre() + " FUE EL GANADOR DE ESTA CARRERA CON "
        		+ corredor.getPuntos() + " PUNTOS.");
        System.out.println("PROVIENE DE " + corredor.getNacionalidad() + ". HIZO ESTO CON EL CARRO " 
                + this.corredores.getFirst().getCarro() + " Y TIENE UN TOTAL DE "
                + corredor.getPuntos() + " PUNTOS");
	}	
	
	public void reposicionarPilotos() {
		Piloto[] corredoresAux = new Piloto[this.corredores.size()];

		while(!this.corredores.isEmpty()){
			int indice = this.corredores.getFirst().getPosicion();
			indice--;
			corredoresAux[indice] = this.corredores.remove();
		}

		for(Piloto corredor : corredoresAux) {
			this.corredores.add(corredor);
		}
	}

	public void imprimirPosiciones() {
		for(Piloto corredor : this.corredores) {
			int posc = corredor.getPosicion();
			String nombre = corredor.getNombre();
			System.out.printf("Posición [%d]: %s\n", posc, nombre);
		}
		System.out.println();
	}

	public void darPuntos() {

		this.corredores.getFirst().sumarVictorias();

		for(int j = 0; j < this.corredores.size(); j++) {
			int puntos = this.corredores.size() - j;
			this.corredores.get(j).sumarPuntos((short) puntos);
		}
	}

	public void generarPosiciones() {
		int[] posiciones = new int[this.corredores.size()];
		Random rand = new Random();

		for(int j = 0; j < posiciones.length; j++) {
			posiciones[j] = j + 1;
                        //System.out.println("J = " + j);
                        //System.out.println("POSICIONES = " + Arrays.toString(posiciones));
		}

		for(int j = 0; j < this.corredores.size(); j++) {
			int posicion;
			do {
				posicion = rand.nextInt(posiciones.length);
                                //System.out.println("POSICION = " + posicion);
			} while(posiciones[posicion] == 0);

			this.corredores.get(j).setPosicion((byte) posiciones[posicion]);
			posiciones[posicion] = 0;
		}

		reposicionarPilotos();
	}

    public String fechaToString() {
        int dia = this.fecha.getDayOfMonth(); 
        int mes = this.fecha.getMonthValue(); 
        int anio = this.fecha.getYear(); 

        return dia+"/"+mes+"/"+anio;
    }

	public void carreraRealizada() {
		this.realizada = true;
	}

	// getters
	
	public LinkedList<Piloto> getPosiciones() {
		reposicionarPilotos();
		return this.corredores;
	}
	
	public LinkedList<Piloto> getCorredores() {
		return this.corredores;
	}

	public Circuito getPista() {
		return this.pista;
	}

    public LocalDate getFecha() {
        return this.fecha;
    } 

    public long getDigFecha() {
        return this.digFecha;
    } 

	public boolean getRealizada() {
		return this.realizada;
	}

	// setters

	public void setCorredores(LinkedList<Piloto> corredores) {
		this.corredores = new LinkedList<>(corredores); 
	}

	public void setPista(Circuito pista) {
		this.pista = pista;
	}
    
    public void setFecha(int dia, int mes, int anio) {
        this.fecha = LocalDate.of(anio, mes, dia);
    }
}
