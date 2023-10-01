import java.util.Date;
import java.util.ArrayList;

public class Campeonato {
    Private String premio; 
    private ArrayList<Equipo> equipos;
    HashMap<Date, Carrera> carreras;

    public Campeonato(String premio) {
        this.premio = premio;
        setCarreras();
    }

    public void iniciarCampeonato() {

    }

    public String resultados() {

    }

    public ArrayList<Equipo> getEquipos() {
        return this.equipos;
    }

    public void setEquipos(ArrayList<Equipos> equipos) {
        this.equipos = new ArrayList<>(equipos); 
    }
}


