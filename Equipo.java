package POOProyecto1;

import java.util.HashSet;
import java.util.Iterator;

public class Equipo{
    private String nombre;
    private HashSet<Piloto> pilotos = new HashSet<>();
    private int puntos=0;
    private short camp_Ganados=0;
    
    public Equipo(String nombre){
        setNombre(nombre);
    }
    
    public void addPiloto(Piloto piloto){
        pilotos.add(piloto);
        Piloto.addPiloto(piloto); // Añadiendo al total de pilotos en la Clase Piloto
    }
    
    public void removePiloto(String eleccion){
        Iterator<Piloto> iterador = pilotos.iterator();
        while(iterador.hasNext()){
           Piloto piloto = iterador.next();
           if(piloto.getNombre().equals(eleccion)){
               pilotos.remove(piloto);
               break;
           }
        }
    }
    
    public void listarPilotos(){
        Iterator<Piloto> iterador = pilotos.iterator();
        while(iterador.hasNext()){
            Piloto piloto = iterador.next();
            System.out.println("NOMBRE: " + piloto.getNombre());
            System.out.println("EDAD: " + piloto.getEdad());
            System.out.println("NACIONALIDAD: " + piloto.getNacionalidad());
            System.out.println("CARRO: " + piloto.getCarro());
            System.out.println("VICTORIAS: " + piloto.getVictorias());
            System.out.println("PUNTOS: " + piloto.getPuntos());
        }
    }
    
    public void sumarPuntos(){
        for(Piloto corredor : pilotos) {
            this.puntos += corredor.getPuntos();
        }
    }
    
    public void sumarCamp(){
        setCamp_Ganados((short)(this.camp_Ganados + 1));
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

    public short getCamp_Ganados() {
        return camp_Ganados;
    }

    public void setCamp_Ganados(short camp_Ganados) {
        this.camp_Ganados = camp_Ganados;
    }
}
