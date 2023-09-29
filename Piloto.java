public class Piloto{
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
    }

    public Piloto(String nombre, int edad, String nacionalidad, String carro, short victorias, short puntos) {
        setNombre(nombre);
        setEdad(edad);
        setNacionalidad(nacionalidad);
        setCarro(carro);
        setVictorias(victorias);
        setPuntos(puntos);
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
    
    void sumarPuntos(short cantidad){
        setPuntos((short)(this.puntos + cantidad));
    }
    
    void sumarVictorias(){
        setVictorias((short)(this.victorias + 1));
    }
}