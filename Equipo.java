import java.util.LinkedList;

public class Equipo{
    private String nombre;
    private LinkedList<Piloto> pilotos = new LinkedList<>();
    private int puntos;
    private short camp_Ganados;
    
    void addPiloto(Piloto piloto){
        pilotos.add(piloto);
    }
    
    void removePiloto(int eleccion){
        /* Dependiendo de cómo manejemos la búsqueda de Piloto,
           añadiremos la lógica pertinente.
        */
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