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
        Motores c;
        Scanner leer = new Scanner(System.in);
        int opc;
        
        do{
            System.out.println("TALLER MECANICO AUTOMOTRIZ");
            System.out.println("1.- Agregar motor a almacen de entrada");
            System.out.println("2.- Acerca de...");
            System.out.println("3.- Mover de almacenEntrada a pila 1");
            System.out.println("4.- Mover de almacenEntrada a pila 2");
            System.out.println("5.- Mover de pila 1 a pila 2");
            System.out.println("6.- Mover de pila 2 a pila 1");
            System.out.println("7.- Mover de pila 1 a almacenSalida");
            System.out.println("8.- Mover de pila 2 a almacenSalida");
            System.out.println("9.- Salir");
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
                
                case 9:
                    System.out.println("Saliendo...");
                    break;
                case 3:
                    
                    if(almacenEntrada.isVacia()){
                        System.out.println("El almacen entrada esta vacio");
                        break;
                    }
                    else if(pila1.isLlena()){
                        System.out.println("La pila 1 esta llena");
                        break;
                    }
                    
                    try{
                        c = almacenEntrada.peek();
                        almacenEntrada.pop();
                        pila1.push(c);
                        System.out.println("El motor se cambio a la pila 1 exitosamente");
                        leer.nextLine();
                        leer.nextLine();
                        
                    }catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    
                        if(almacenEntrada.isVacia()){
                        System.out.println("El almacen entrada esta vacio");
                        break;
                    }
                    else if(pila2.isLlena()){
                        System.out.println("La pila 2 esta llena");
                        break;
                    }
                    
                    try{
                        c = almacenEntrada.peek();
                        almacenEntrada.pop();
                        pila2.push(c);
                        System.out.println("El motor se cambio a la pila 2 exitosamente");
                        leer.nextLine();
                        leer.nextLine();
                        
                    }catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                case 5:
                        if(pila1.isVacia()){
                        System.out.println("La pila 1 vacio");
                        break;
                    }
                    else if(pila2.isLlena()){
                        System.out.println("La pila 2 esta llena");
                        break;
                    }
                    
                    try{
                        c = pila1.peek();
                        pila1.pop();
                        pila2.push(c);
                        System.out.println("El motor se cambio de pila 1 a pila 2");
                        System.out.println(c);
                        leer.nextLine();
                        leer.nextLine();
                        
                    }catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                    
                case 6:
                    
                        if(pila1.isVacia()){
                        System.out.println("La pila 1 vacio");
                        break;
                    }
                    else if(pila2.isLlena()){
                        System.out.println("La pila 2 esta llena");
                        break;
                    }
                    
                    try{
                        c = pila2.peek();
                        pila2.pop();
                        pila1.push(c);
                        System.out.println("El motor se cambio de pila 2 a pila 1");
                        System.out.println(c);
                        leer.nextLine();
                        leer.nextLine();
                        
                    }catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    
                    break;
                    
                case 7:
                    if(pila1.isVacia()){
                        System.out.println("La pila 1 esta vacia");
                        break;
                    }
                    else if(almacenSalida.isLlena()){
                        System.out.println("El almacen de salida esta lleno");
                        break;
                    }
                    
                    try{
                        c = pila1.peek();
                        pila1.pop();
                        almacenSalida.push(c);
                        System.out.println("El motor se envio al almacen de salida");
                        System.out.println(c);
                        leer.nextLine();
                        leer.nextLine();
                        
                    }catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 8:
                        if(pila2.isVacia()){
                        System.out.println("La pila 2 esta vacia");
                        break;
                    }
                    else if(almacenSalida.isLlena()){
                        System.out.println("El almacen de salida esta lleno");
                        break;
                    }
                    
                    try{
                        c = pila2.peek();
                        pila2.pop();
                        almacenSalida.push(c);
                        System.out.println("El motor se envio al almacen de salida");
                        System.out.println(c);
                        leer.nextLine();
                        leer.nextLine();
                        
                    }catch(IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    
                    
                    break;
                default:
                    System.out.println("Seleccione una opcion valida");
            }
        
        }while(opc != 9);
        
    }
    
}
