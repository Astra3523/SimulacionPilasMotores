/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacionpilasmotores;
import com.abc.estdatos.TdaPila;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/** 
 *
 * @author Astra
 */
public class SimulacionPilasMotores extends JFrame{
        TdaPila<Motores> pila1 = new TdaPila<>(7); 
        TdaPila<Motores> pila2 = new TdaPila<>(7);
        TdaPila<Motores> almacenEntrada = new TdaPila<>(100);
        TdaPila<Motores> almacenSalida = new TdaPila<>(100);
        Motores c;
    
        private JButton btnAcercaDe;
        private JButton btnSalir;
        private JPanel pnlAlmacenEntrada;
        private JPanel almacenSalidaForma;
        private JLabel lblAlmacenEntrada;
        private JLabel lblAlmacenSalida;
        private JPanel pnlPila1;
        private JPanel pnlPila2;
        private JLabel lblPila1;
        private JLabel lblPila2;
        private JPanel[] pnlmotores = new JPanel[14]; //HAcemos un array con los 14 "Motores" q se que van a existir
        int index; //esto lo voy a ocupar para saber en q motor "voy"
        public SimulacionPilasMotores(){
            setSize(800, 600);
            setTitle("Pilas de motores");
            initComponents();
        }
        
        
        private void initComponents(){
            getContentPane().setLayout(null);
            btnAcercaDe = new JButton();
            btnSalir = new JButton();
            pnlAlmacenEntrada = new JPanel();
            almacenSalidaForma = new JPanel();
            lblAlmacenEntrada = new JLabel();
            lblAlmacenSalida = new JLabel();
            pnlPila1 = new JPanel();
            pnlPila2 = new JPanel();
            lblPila1 = new JLabel();
            lblPila2 = new JLabel();
            for (int i = 0; i < pnlmotores.length; i++) { // hacemos todos nuestros motores pero pues invisibles 
                JPanel rect = new JPanel();
                
                rect.setBounds(50, 60 + i*30, 100, 30); // posicion inicial apilada
                rect.setBackground(Color.GREEN);
                rect.setVisible(false); // empiezan ocultos
                add(rect);
                pnlmotores[i] = rect;

                makeDraggable(rect); // que cada uno pueda arrastrarse
        }
            
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });
        
        //Configuramos el boton para salir lol
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
               btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(50,350,70,30);
        
        //Configuramos el boton de acerca de
        btnAcercaDe.setText("Acerca de...");
        btnAcercaDe.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                btnAcercaDeActionPerformed(evt);
            }
            
        });
        getContentPane().add(btnAcercaDe);
        btnAcercaDe.setBounds(50, 400, 70, 30);
        
        //Configuramos el almacen de Entrada junto con su etiqueta
        pnlAlmacenEntrada.setBounds(90, 90, 120, 200); // x, y, ancho, alto
        pnlAlmacenEntrada.setBackground(java.awt.Color.BLACK); // color del rectángulo
        getContentPane().add(pnlAlmacenEntrada);
        lblAlmacenEntrada.setText("Almacen de Entrada");
        getContentPane().add(lblAlmacenEntrada);
        lblAlmacenEntrada.setBounds(90, 200, 120, 200);
        pnlAlmacenEntrada.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crearMotor(e);
            }  
        });
        
        
        
        //Configuramos el almacen de salida junto con su etiqueta
        almacenSalidaForma.setBounds(590, 90, 120, 200);
        almacenSalidaForma.setBackground(java.awt.Color.BLACK);
        getContentPane().add(almacenSalidaForma);
        lblAlmacenSalida.setText("Almacen de Entrada");
        getContentPane().add(lblAlmacenSalida);
        lblAlmacenSalida.setBounds(590, 200, 120, 200);
        
        //Configuramos la base de la pila 1
        pnlPila1.setBounds(450, 280, 100, 10); // x, y, ancho, alto
        pnlPila1.setBackground(java.awt.Color.GRAY); // color del rectángulo
        getContentPane().add(pnlPila1);
        lblPila1.setText("Pila 1");
        getContentPane().add(lblPila1);
        lblPila1.setBounds(250, 300, 100, 10);
        
        //Configuramos la base de la pila 2
        pnlPila2.setBounds(250, 280, 100, 10); // x, y, ancho, alto
        pnlPila2.setBackground(java.awt.Color.GRAY); // color del rectángulo
        getContentPane().add(pnlPila2);
        lblPila2.setText("Pila 2");
        getContentPane().add(lblPila2);
        lblPila2.setBounds(450, 300, 100, 10);
        
        
        }
        
        private void crearMotor(MouseEvent e){
                    if (index < pnlmotores.length) {
                        pnlmotores[index].setVisible(true);
                        index++;
                }
        }
        private void makeDraggable(JPanel panel) {
            final Point[] clickPoint = {null};
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    clickPoint[0] = e.getPoint();
                }
            });
            panel.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    int x = panel.getX() + e.getX() - clickPoint[0].x;
                    int y = panel.getY() + e.getY() - clickPoint[0].y;
                    panel.setLocation(x, y);
                }
            });
        }
        private void btnAcercaDeActionPerformed(ActionEvent evt){
            JOptionPane.showMessageDialog(this,"Simulacion de motores \n Equipo 5\n Integrantes \n Saul Alejandro Ramirez Leal \n Gudiño Ochoa Luis Gustavo \n Reyes Cázares Aldo Emanuel");
        }
        private void btnSalirActionPerformed(ActionEvent evt){
            System.exit(0);
        }
        private void exitForm(WindowEvent evt) {
            System.exit(0);
        }
        
        
    public static void main(String[] args) {

          new SimulacionPilasMotores().setVisible(true);

//        TdaPila<Motores> pila1 = new TdaPila<>(7); 
//        TdaPila<Motores> pila2 = new TdaPila<>(7);
//        TdaPila<Motores> almacenEntrada = new TdaPila<>(100);
//        TdaPila<Motores> almacenSalida = new TdaPila<>(100);
//        Motores c;
//        Scanner leer = new Scanner(System.in);
//        int opc;
//        
//        do{
//            System.out.println("TALLER MECANICO AUTOMOTRIZ");
//            System.out.println("1.- Agregar motor a almacen de entrada");
//            System.out.println("2.- Acerca de...");
//            System.out.println("3.- Mover de almacenEntrada a pila 1");
//            System.out.println("4.- Mover de almacenEntrada a pila 2");
//            System.out.println("5.- Mover de pila 1 a pila 2");
//            System.out.println("6.- Mover de pila 2 a pila 1");
//            System.out.println("7.- Mover de pila 1 a almacenSalida");
//            System.out.println("8.- Mover de pila 2 a almacenSalida");
//            System.out.println("9.- Salir");
//            System.out.print("Seleccione una opcion: ");
//            opc = leer.nextInt();
//            leer.nextLine();
//            
//            switch(opc){
//                case 1:  //Se ingresan los datos marca, modelo, y potencia
//                    System.out.println("Marca: ");
//                    String marca = leer.nextLine();
//                    System.out.println("Modelo: ");
//                    String modelo = leer.nextLine();
//                    System.out.println("Potencia: ");
//                    int potencia = leer.nextInt();
//                    Motores motor1 = new Motores(marca, modelo, potencia);  //Se crea objeto motor 1 para asignarlo a almacenEntrada 
//                    almacenEntrada.push(motor1);
//                    System.out.println("Motor agregado a almacen de entrada "+motor1);
//                break;
//                
//                case 2:
//                    System.out.println("Acerca de:");
//                    System.out.println("Simulacion de motores");
//                    System.out.println("Equipo 5");
//                    System.out.println("Integrantes:");
//                    System.out.println("Gudiño Ochoa Luis Gustavo");
//                    System.out.println("Ramírez Leal Saúl Alejandro");
//                    System.out.println("Reyes Cázares Aldo Emanuel");    
//                    System.out.println();
//                break;
//                
//                case 9:
//                    System.out.println("Saliendo...");
//                    break;
//                case 3:
//                    
//                    if(almacenEntrada.isVacia()){  //evita errores de codigo en el  alamcenamiento de los datos en estas condiciones 
//                        System.out.println("El almacen entrada esta vacio");
//                        break;
//                    }
//                    else if(pila1.isLlena()){
//                        System.out.println("La pila 1 esta llena");
//                        break;
//                    }
//                    
//                    try{
//                        c = almacenEntrada.peek(); // se utiliza la variable auxiliar c que viene d la clase motores , el almacen de entrada se lleva al tope
//                        almacenEntrada.pop(); //se saca el almacen de entrada 
//                        pila1.push(c);// se añade a la pila 1
//                        System.out.println("El motor se cambio a la pila 1 exitosamente");
//                        leer.nextLine();
//                        leer.nextLine();
//                        
//                    }catch(IllegalStateException e){
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 4:
//                    
//                        if(almacenEntrada.isVacia()){ // es veradero solo si no hay elementos ,si esta vacio no tiene sentido intentar sacar algo de el 
//                        System.out.println("El almacen entrada esta vacio");
//                        break;
//                    }
//                    else if(pila2.isLlena()){ //si la pila esta llena,no se pueden insertar mas elementos 
//                        System.out.println("La pila 2 esta llena");
//                        break;
//                    }
//                    
//                    try{
//                        c = almacenEntrada.peek();// se utiliza la variable auxiliar c que viene d la clase motores , el almacen de entrada se lleva al tope
//                        almacenEntrada.pop();//se saca el almacen de entrada
//                        pila2.push(c);//se añade a la pila 2
//                        System.out.println("El motor se cambio a la pila 2 exitosamente");
//                        leer.nextLine();
//                        leer.nextLine();
//                        
//                    }catch(IllegalStateException e){
//                        System.out.println(e.getMessage());
//                    }
//                    
//                    break;
//                case 5:
//                        if(pila1.isVacia()){
//                        System.out.println("La pila 1 vacio");
//                        break;
//                    }
//                    else if(pila2.isLlena()){
//                        System.out.println("La pila 2 esta llena");
//                        break;
//                    }
//                    
//                    try{
//                        c = pila1.peek(); // se lleva la pila 1 hasta el tope
//                        pila1.pop();// se saca la pila 1 del tope
//                        pila2.push(c); // se mete la pila 1 a la pila 2
//                        System.out.println("El motor se cambio de pila 1 a pila 2");
//                        System.out.println(c);
//                        leer.nextLine();
//                        leer.nextLine();
//                        
//                    }catch(IllegalStateException e){
//                        System.out.println(e.getMessage());
//                    }
//                    
//                    break;
//                    
//                case 6:
//                    
//                        if(pila1.isVacia()){
//                        System.out.println("La pila 1 vacio");
//                        break;
//                    }
//                    else if(pila2.isLlena()){
//                        System.out.println("La pila 2 esta llena");
//                        break;
//                    }
//                    
//                    try{
//                        c = pila2.peek(); // se lleva la pila 2 hsta el tope 
//                        pila2.pop(); // se saca la pila 2 del tope
//                        pila1.push(c); // se mete la pila 2 a la pila 1
//                        System.out.println("El motor se cambio de pila 2 a pila 1");
//                        System.out.println(c);
//                        leer.nextLine();
//                        leer.nextLine();
//                        
//                    }catch(IllegalStateException e){
//                        System.out.println(e.getMessage());
//                    }
//                    
//                    break;
//                    
//                case 7:
//                    if(pila1.isVacia()){
//                        System.out.println("La pila 1 esta vacia");
//                        break;
//                    }
//                    else if(almacenSalida.isLlena()){
//                        System.out.println("El almacen de salida esta lleno");
//                        break;
//                    }
//                    
//                    try{
//                        c = pila1.peek(); // se lleva la pila 1 hasta el tope, primer lugar 
//                        pila1.pop(); //  se saca la pila 1 de ese lugar
//                        almacenSalida.push(c); // se mete al almacenSalida
//                        System.out.println("El motor se envio al almacen de salida");
//                        System.out.println(c);
//                        leer.nextLine();
//                        leer.nextLine();
//                        
//                    }catch(IllegalStateException e){
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                    
//                case 8:
//                        if(pila2.isVacia()){
//                        System.out.println("La pila 2 esta vacia");
//                        break;
//                    }
//                    else if(almacenSalida.isLlena()){
//                        System.out.println("El almacen de salida esta lleno");
//                        break;
//                    }
//                    
//                    try{
//                        c = pila2.peek();// se lleva la pila 2 hasta el tope, primer lugar 
//                        pila2.pop();// se saca la pila 2 de ese lugar 
//                        almacenSalida.push(c); // se mete la pila 2 al almacenSalida
//                        System.out.println("El motor se envio al almacen de salida");
//                        System.out.println(c);
//                        leer.nextLine();
//                        leer.nextLine();
//                        
//                    }catch(IllegalStateException e){
//                        System.out.println(e.getMessage());
//                    }
//                    
//                    
//                    break;
//                default:
//                    System.out.println("Seleccione una opcion valida");
//            }
//        
//        }while(opc != 9);
        
    }
    
}
