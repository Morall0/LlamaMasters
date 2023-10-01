
import java.util.LinkedList;
import java.util.Random;

public class Carrera {
	
	private LinkedList<Piloto> corredores = new LinkedList()<>;
	private Circuito pista;

	// Constructores
	
	public Carrera (LinkedList<Piloto> corredores, Circuito pista) {
		setCorredores(corredores);
		setPista(pista); 
	}

	// public Carrera (Circuito pista) {
	// 	setPista(pista);
	// }
	
	// métodos extra
	
	public void iniciarCarrrera() {

		generarPosiciones();

		int cantidadVueltas = getPista().getVueltas();
		for(int j = 0; j < cantidadVueltas; j++) {
			generarPosiciones();
			System.out.printf("Vuelta %d:\n\n", j + 1);
			imprimirPosiciones();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
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
		for(int j = 0; j < this.corredores.size(); j++) {
			String nombre = this.corredores.get(j).getNombre;
			System.out.printf("Posición [%d]: %s\n", j + 1, nombre);
		}
		System.out.println();
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

	// setters
	
	// public void setCorredores(Piloto corredor) {
	// 	this.corredores.add(corredor);
	// }

	public void setCorredores(LinkedList<Piloto> corredores) {
		this.corredores = new LinkedList<>(corredores); 
	}

	public void setPista(Circuito pista) {
		this.pista = pista;
	}

	public void generarPosiciones() {
		int[] posiciones = new int[this.corredores.size()];
		Random rand = new Random();

		for(int j = 0; j < posiciones.length; j++) {
			posiciones[j] = j + 1;
		}

		for(int j = 0; j < this.corredores.size(); j++) {
			int posicion;
			do {
				posicion = rand.nextInt(posiciones.length);
			} while(posiciones[posicion] != 0);

			this.corredores.get(j).setPosicion(posiciones[posicion]);
			posiciones[posicion] = 0;
		}

		reposicionarPilotos();
	}
}
