import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;

public class Main{
    static Scanner scan = new Scanner(System.in);
    static void printFirstMenu(){
        System.out.println("\nQUE DESEA HACER DURANTE ESTA EJECUCION?");
        System.out.println("1. Iniciar Campeonato");
        System.out.println("2. Ver carreras");
        System.out.println("3. Salir del programa");
        System.out.print("Opcion: ");
    }
    
    static Piloto scanPilotData(){ //Metodo de lectura de pilotos
        String nombreP, nacionalidadP, carroP;
        int edadP;
        
        System.out.print("Nombre: ");
        nombreP = scan.nextLine();
        System.out.print("Edad: ");
        edadP = scan.nextInt();
        scan.nextLine();
        System.out.print("Nacionalidad: ");
        nacionalidadP = scan.nextLine();
        System.out.print("Carro: ");
        carroP = scan.nextLine();
        
        Piloto newPilot = new Piloto(nombreP, edadP, nacionalidadP, carroP);
        
        return newPilot;
    }
    
    //TODO: Completar metodo
    static Circuito scanCircuitData(){
        String nombreC, locacionC, tipoC;
        short kilometrosC, vueltasC, curvasC;

        System.out.println("CIRCUITO");
        System.out.print("Nombre: ");
        nombreC = scan.nextLine();
        System.out.print("Locacion: ");
        locacionC = scan.nextLine();
        System.out.print("Tipo: ");
        tipoC = scan.nextLine();
        System.out.print("Kilometros: ");
        kilometrosC = scan.nextShort();
        System.out.print("Vueltas: ");
        vueltasC = scan.nextShort();
        System.out.print("Curvas: ");
        curvasC = scan.nextShort();

        return new Circuito(nombreC, locacionC, tipoC, kilometrosC, vueltasC, curvasC);
    }
    
    //TODO: Completar metodo
    static Carrera scanRaceData(){
        Circuito circuito;
        LinkedList<Piloto> listaPilotos = new LinkedList<>(Piloto.totalPilotos);

        int dia, mes, anio;
        System.out.println("Introduzca la fecha de la carrera");
        System.out.print("Dia: ");
        dia = scan.nextInt();
        System.out.print("Mes: ");
        mes = scan.nextInt();
        System.out.print("Año: ");
        anio = scan.nextInt();
        scan.nextLine();
        circuito = scanCircuitData();

        return new Carrera(listaPilotos, circuito, dia, mes, anio);
    }
    
    public static void main(String[] args) {
        int opMain, nEquipos, nPilotos, nCarreras;
        String teamName, premio;
        Campeonato campeonato;
        ArrayList<Equipo> teamsAL = new ArrayList<>();
        // Lista auxiliar para guardar a todos los equipos registrados, para
        // entonces adjuntarlos al Campeonato.
        
        System.out.println("BIENVENIDO AL SIMULADOR DE CARRERAS DE LA F1!");
        do{
            printFirstMenu();
            opMain = scan.nextInt();
            scan.nextLine();
            switch(opMain){
                case 1:
                    
                    /* Se anidan dos ciclos for en los que se introduciran todos
                    los equipos que van a haber en el campeonato, asi como los
                    pilotos que los conforman a todos.
                    */
                    System.out.println("\nCAMPEONATO!");
                    System.out.println("Cual sera el PREMIO del campeonato?");
                    premio = scan.nextLine();
                    System.out.println("\nRegistro de los Equipos");
                    System.out.print("Cantidad de equipos: ");
                    nEquipos = scan.nextInt();
                    scan.nextLine();
                    
                    for(int i = 1;i<=nEquipos;i++){
                        System.out.println("\n#### EQUIPO " +i+" ####");

                        System.out.print("Nombre del equipo: ");
                        teamName = scan.nextLine();
                        Equipo arbTeam = new Equipo(teamName);

                        System.out.print("Cantidad de pilotos: ");
                        nPilotos = scan.nextInt();
                        scan.nextLine();

                        for(int j = 1;j<=nPilotos;j++){
                            System.out.println("- PILOTO "+j+" -");
                            Piloto arbPilot = scanPilotData();
                            arbTeam.addPiloto(arbPilot);
                        }

                        teamsAL.add(arbTeam);
                    }

                    System.out.print("\nCantidad de CARRERAS DEL CAMPEONATO: ");
                    nCarreras = scan.nextInt();
                    scan.nextLine();
                    HashMap<LocalDate, Carrera> carreras = new HashMap<>();
                    for(int i=1;i<=nCarreras;i++){
                        System.out.println("\nCarrera numero "+i);
                        Carrera carrera = scanRaceData();
                        carreras.put(carrera.getFecha(), carrera);
                    }

                    campeonato = new Campeonato(premio, teamsAL, carreras);
                    campeonato.iniciarCampeonato();
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("\nSaliendo...");
                    break;

                default:
                    System.out.println("\nSelecciona una opcion valida!");
                    break;
            }
        }while(opMain != 3);
        scan.close();
    }
}
