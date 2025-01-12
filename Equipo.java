import java.util.HashSet;
import java.util.Iterator;

public class Equipo{
    private String nombre;
    private HashSet<Piloto> pilotos = new HashSet<>();
    private int puntos;
    
    public Equipo(String nombre){
        setNombre(nombre);
        this.puntos = 0;
    }
    
    public void addPiloto(Piloto piloto){
        this.pilotos.add(piloto);
        Piloto.addPiloto(piloto); // Añadiendo al total de pilotos en la Clase Piloto
    }
    
    public void listarPilotos(){
        int i = 1;
        Iterator<Piloto> iterador = pilotos.iterator();
        while(iterador.hasNext()){
            Piloto piloto = iterador.next();
            System.out.println("*** PILOTO NO. " + i + " ***");
            System.out.println("NOMBRE: " + piloto.getNombre());
            System.out.println("EDAD: " + piloto.getEdad());
            System.out.println("NACIONALIDAD: " + piloto.getNacionalidad());
            System.out.println("CARRO: " + piloto.getCarro());
            System.out.println("VICTORIAS: " + piloto.getVictorias());
            System.out.println("PUNTOS: " + piloto.getPuntos());
            i++;
        }
    }
    
    public void sumarPuntos(){
        int puntosExtra = 0;
        for(Piloto corredor : pilotos) {
            puntosExtra += corredor.getPuntos();
        }

        this.puntos += puntosExtra - this.puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<Piloto> getPilotos() {
        return this.pilotos;
    }

    public void setPilotos(HashSet<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
