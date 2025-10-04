/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacionpilasmotores;
import com.abc.estdatos.TdaPila;
import java.util.Scanner;
/** 
 *
 * @author Astra
 */
public class SimulacionPilasMotores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TdaPila<Motores> pila1 = new TdaPila<>(7); 
        TdaPila<Motores> pila2 = new TdaPila<>(7);
        TdaPila<Motores> almacenEntrada = new TdaPila<>(100);
        TdaPila<Motores> almacenSalida = new TdaPila<>(100);
        Scanner leer = new Scanner(System.in);
        int opc;
        
        do{
            System.out.println("TALLER MECANICO AUTOMOTRIZ");
            System.out.println("1.- Agregar motor a almacen de entrada");
            System.out.println("2.- Acerca de...");
            System.out.println("3.- Salir");
            System.out.print("Seleccione una opcion: ");
            opc = leer.nextInt();
            leer.nextLine();
            
            switch(opc){
                case 1:
                    System.out.println("Marca: ");
                    String marca = leer.nextLine();
                    System.out.println("Modelo: ");
                    String modelo = leer.nextLine();
                    System.out.println("Potencia: ");
                    int potencia = leer.nextInt();
                    Motores motor1 = new Motores(marca, modelo, potencia); 
                    almacenEntrada.push(motor1);
                    System.out.println("Motor agregado a almacen de entrada "+motor1);
                break;    
                case 2:
                    System.out.println("Acerca de:");
                    System.out.println("Simulacion de motores");
                    System.out.println("Equipo 5");
                    System.out.println("Integrantes:");
                    System.out.println("Gudiño Ochoa Luis Gustavo");
                    System.out.println("Ramírez Leal Saúl Alejandro");
                    System.out.println("Reyes Cázares Aldo Emanuel");    
                    System.out.println();
                break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
            }
        
        }while(opc != 3);
        
    }
    
}
