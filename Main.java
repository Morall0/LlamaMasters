
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;

public class Main{
    static void printFirstMenu(){
        System.out.println("QUE DESEA HACER DURANTE ESTA CORRIDA?");
        System.out.println("1. INICIAR CAMPEONATO");
        System.out.println("2. VER RESULTADOS DEL CAMPEONATO ANTERIOR");
        System.out.println("3. SALIR DEL PROGRAMA");
    }
    
    static Piloto scanPilotData(int i){ //Método de lectura de pilotos
        Scanner scanMan2 = new Scanner(System.in);
        String nombreP, nacionalidadP, carroP;
        int edadP;
        
        System.out.println("PILOTO NUMERO " + (i+1) + ":");
        System.out.println("INTRODUZCA EL NOMBRE DEL PILOTO");
        nombreP = scanMan2.nextLine();
        System.out.println("INTRODUZCA LA EDAD DEL PILOTO");
        edadP = scanMan2.nextInt();
        System.out.println("INTRODUZCA LA NACIONALIDAD DEL PILOTO");
        nacionalidadP = scanMan2.nextLine();
        System.out.println("INTRODUZCA EL CARRO DEL PILOTO");
        carroP = scanMan2.nextLine();
        
        Piloto newPilot = new Piloto(nombreP, edadP, nacionalidadP, carroP);
        
        return newPilot;
    }
    
    static Circuito scanCircuitData(){
        Scanner scanMan3 = new Scanner(System.in);
        String nombreC, locacionC, tipoC;
        short kilometrosC, vueltasC, curvasC;
        System.out.println("INTRODUZCA EL NOMBRE DEL CIRCUITO");
        
    }
    
    static Carrera scanRaceData(int i){
        System.out.println("CARRERA NUMERO " + i);
        System.out.println("INTRODUZCA ");
    }
    
    public static void main(String[] args) {
        Scanner scanMan = new Scanner(System.in);
        int userSelection1, userSelection2, userSelection3;
        String teamName;
        ArrayList<Equipo> auxiliary_TeamAL = new ArrayList<>();
        // Lista auxiliar para guardar a todos los equipos registrados, para
        // entonces adjuntarlos al Campeonato.
        
        System.out.println("BIENVENIDO AL SIMULADOR DE CARRERAS DE LA F1!");
        do{
            printFirstMenu();
            userSelection1 = scanMan.nextInt();
            switch(userSelection1){
                case 1:
                    
                    /* Se anidan dos ciclos for en los que se introducirán todos
                    los equipos que van a haber en el campeonato, así como los
                    pilotos que los conforman a todos.
                    */
                    System.out.println("CUANTOS EQUIPOS PARTICIPARÁN EN LA"
                            + " CARRERA?");
                    userSelection2 = scanMan.nextInt();
                    for(int i = 0;i<userSelection2;i++){
                        System.out.println("INTRODUZCA EL NOMBRE DEL EQUIPO"
                                + " NUMERO " + i);
                        teamName = scanMan.nextLine();
                        Equipo arbTeam = new Equipo(teamName);
                        System.out.println("INTRODUZCA EL NÚMERO DE PILOTOS "
                                + "EN ESTE EQUIPO.");
                        userSelection3 = scanMan.nextInt();
                        for(int j = 0;j<userSelection3;j++){
                            Piloto arbPilot = scanPilotData(j);
                            arbTeam.addPiloto(arbPilot);
                        }
                        auxiliary_TeamAL.add(arbTeam);
                    }
                    System.out.println("INTRODUZCA EL NÚMERO DE CARRERAS QUE "
                            + "SE CORRERÁN EN ESTE CAMPEONATO.");
                    userSelection2 = scanMan.nextInt();
                    for(int i=0;i<userSelection2;i++){
                        
                    }
                    
                    
                    
                    
            }
        }while(userSelection1 != 3);
    }
}