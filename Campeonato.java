import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate; 

public class Campeonato {
    private String premio; 
    private ArrayList<Equipo> equipos;
    private HashMap<LocalDate, Carrera> carreras;

    public Campeonato(String premio, ArrayList<Equipo> equipos, Map<LocalDate, Carrera> carreras) {
        this.premio = premio;
        setEquipos(equipos);
        setCarreras(carreras);
    }

    public Campeonato(String premio) {
        this.premio = premio;
    }

    public void iniciarCampeonato() {
        int j = 1;
        LinkedList<Carrera> listaCarreras = getListaCarreras(carreras);
        sortCarreras(listaCarreras);
        String enterKey;

        Main.scan.nextLine();
        for (Carrera c : listaCarreras) {
            System.out.println("Carrera numero "+ (j++)); 
            System.out.println("Presione enter para continuar, o escriba 'exit' para salir.");
            enterKey = Main.scan.nextLine();
            if(enterKey.equalsIgnoreCase("exit")) {
                break;
            }
            c.iniciarCarrrera();
            sumarPuntosEquipo();
        }
    }

    public LinkedList<Carrera> getListaCarreras(HashMap<LocalDate, Carrera> carrera) {
        return new LinkedList<Carrera>(carreras.values()); 
    }

    public void sumarPuntosEquipo() {
        for(int j = 0; j < this.equipos.size(); j ++) {
            this.equipos.get(j).sumarPuntos();
        }
        System.out.println("LOS EQUIPOS TIENEN ESTA CANTIDAD DE PUNTOS: ");
        for(Equipo e : this.equipos){
            System.out.println(e.getNombre() + ": " + e.getPuntos());
        }
    }

    public void resultados() {
        int lugar = 1; 

        sortGanadores();
        System.out.println("Clasificacion por equipo: ");
        for (Equipo e: this.equipos) {
            System.out.println((lugar++)+". "+e.getNombre());
        }

        lugar = 1;
        Piloto.sortPilotos();
        System.out.println("Clasificacion por piloto: ");
        for (Piloto p : Piloto.totalPilotos) {
            System.out.println((lugar++)+". "+p.getNombre());
        }    
        
        System.out.println("EL EQUIPO QUE GANÓ EL PREMIO " + getPremio() + " ES: "
                + this.equipos.get(0).getNombre());
        
        this.equipos.get(0).listarPilotos();
    }

    public void sortGanadores() {
        int n = equipos.size();
        int j;
        for (int i = 0; i<n; i++) {
            Equipo index = this.equipos.get(i);
            j = i-1;
            while (j>=0 && this.equipos.get(j).getPuntos() > index.getPuntos()) {
                this.equipos.set(j+1, this.equipos.get(j));
                j--;
            }
            this.equipos.set(j+1, index);
        }
    }

    public void sortCarreras(LinkedList<Carrera> c) {
        int n = c.size();
        int j;
        for (int i = 0; i<n; i++) {
            Carrera index = c.get(i);
            j = i-1;
            while (j>=0 && c.get(j).getDigFecha() > index.getDigFecha()) {
                c.set(j+1, c.get(j));
                j--;
            }
            c.set(j+1, index);
        }
    }

    public ArrayList<Equipo> getEquipos() {
        return this.equipos;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = new ArrayList<>(equipos); 
    }

    public HashMap<LocalDate, Carrera> getCarreras() {
        return this.carreras; 
    }

    public void setCarreras(Map<LocalDate, Carrera> carreras) {
        this.carreras = new HashMap<>(carreras);
    }

    public String getPremio() {
        return premio;
    }
    
}
