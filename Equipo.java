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
    
    void addPiloto(Piloto piloto){
        pilotos.add(piloto);
    }
    
    void removePiloto(String eleccion){
        Iterator<Piloto> iterador = pilotos.iterator;
        while(iterador.hasNext()){
           Piloto piloto = iterador.next();
           if(piloto.getNombre().equals(eleccion)){
               pilotos.remove(piloto);
               break;
           }
        }
    }
    
    void sumarPuntos(int puntosASumar){
        setPuntos(this.puntos + puntosASumar);
    }
    
    void sumarCamp(){
        setCamp_Ganados((short)(this.camp_Ganados + 1));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(LinkedList<Piloto> pilotos) {
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