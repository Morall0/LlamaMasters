package POOProyecto1;

import java.util.ArrayList;
public class Piloto{

    public static ArrayList<Piloto> totalPilotos = new ArrayList<Piloto>();
    private String nombre;
    private int edad;
    private String nacionalidad;
    private String carro;
    private short victorias;
    private short puntos;
    private byte posicion;


    public Piloto(String nombre, int edad, String nacionalidad, String carro) {
        setNombre(nombre);
        setEdad(edad);
        setNacionalidad(nacionalidad);
        setCarro(carro);
        setVictorias((short)0);
        setPuntos((short)0);
        
    }

    public Piloto(String nombre, int edad, String nacionalidad, String carro, short victorias, short puntos) {
        setNombre(nombre);
        setEdad(edad);
        setNacionalidad(nacionalidad);
        setCarro(carro);
        setVictorias(victorias);
        setPuntos(puntos);
    }

    public static void addPiloto(Piloto piloto) {
        totalPilotos.add(piloto); 
    }

    public static void sortPilotos() {
        int n = totalPilotos.size();
        int j;
        for (int i = 0; i<n; i++) {
            Piloto index = totalPilotos.get(i);
            j = i-1;
            while (j>=0 && totalPilotos.get(j).getPuntos() > index.getPuntos()) {
                totalPilotos.set(j+1, totalPilotos.get(j));
                j--;
            }
            totalPilotos.set(j+1, index);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public short getVictorias() {
        return victorias;
    }

    public void setVictorias(short victorias) {
        this.victorias = victorias;
    }

    public short getPuntos() {
        return puntos;
    }

    public void setPuntos(short puntos) {
        this.puntos = puntos;
    }

    public byte getPosicion() {
        return posicion;
    }

    public void setPosicion(byte posicion) {
        this.posicion = posicion;
    }
    
    public void sumarPuntos(short cantidad){
        setPuntos((short)(this.puntos + cantidad));
    }
    
    public void sumarVictorias(){
        setVictorias((short)(this.victorias + 1));
    }
}
