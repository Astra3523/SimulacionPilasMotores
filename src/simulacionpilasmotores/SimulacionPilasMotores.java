/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacionpilasmotores;

import com.abc.estdatos.TdaPila;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Astra
 * //Vamos a intentar refactorizar este codigo
 */
public class SimulacionPilasMotores extends JFrame {

    TdaPila<Motores> pila1 = new TdaPila<>(7);
    TdaPila<Motores> pila2 = new TdaPila<>(7);
    Motores c;
    int pila1Cuenta = 0, pila2Cuenta = 0;

    private JButton btnAcercaDe;
    private JButton btnSalir;
    private JPanel pnlAlmacenEntrada;
    private JPanel pnlAlmacenSalida;
    private JLabel lblAlmacenEntrada;
    private JLabel lblAlmacenSalida;
    private JPanel pnlPila1;
    private JPanel pnlPila2;
    private JLabel lblPila1;
    private JLabel lblPila2;
    private JPanel[] pnlmotores = new JPanel[14]; //HAcemos un array con los 14 "Motores" q se que van a existir
    int index; //esto lo voy a ocupar para saber en q motor "voy"

    public SimulacionPilasMotores() {
        setSize(800, 600);
        setTitle("Pilas de motores");
        initComponents();
    }

    private void initComponents() {
        getContentPane().setLayout(null);
        btnAcercaDe = new JButton();
        btnSalir = new JButton();
        pnlAlmacenEntrada = new JPanel();
        pnlAlmacenSalida = new JPanel();
        lblAlmacenEntrada = new JLabel();
        lblAlmacenSalida = new JLabel();
        pnlPila1 = new JPanel();
        pnlPila2 = new JPanel();
        lblPila1 = new JLabel();
        lblPila2 = new JLabel();
        for (int i = 0; i < pnlmotores.length; i++) { // hacemos todos nuestros motores pero pues invisibles 
            JPanel rect = new JPanel();

            rect.setBounds(90, 90, 100, 30); // posicion inicial apilada
            rect.setBackground(Color.GREEN);
            rect.setVisible(false); // empiezan ocultos
            add(rect);
            pnlmotores[i] = rect;
            makeDraggable(rect, pnlPila2, pnlPila1); // que cada uno pueda arrastrarse
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });

        //Configuramos el boton para salir lol
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(50, 350, 70, 30);

        //Configuramos el boton de acerca de
        btnAcercaDe.setText("Acerca de...");
        btnAcercaDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
        pnlAlmacenSalida.setBounds(590, 90, 120, 200);
        pnlAlmacenSalida.setBackground(java.awt.Color.BLACK);
        getContentPane().add(pnlAlmacenSalida);
        lblAlmacenSalida.setText("Almacen de Salida");
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

    private void crearMotor(MouseEvent e) {
        if (index < pnlmotores.length) {
            pnlmotores[index].setVisible(true);
            index++;
        }
    }

    private void makeDraggable(JPanel panel, JPanel pnlPila1, JPanel pnlPila2) {
        final Point[] clickPoint = {null};
        final String[] origen = {null};
        final Point[] originalPos = {panel.getLocation()};
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                clickPoint[0] = e.getPoint();
                originalPos[0] = panel.getLocation();
                if (panel.getBounds().intersects(pnlAlmacenEntrada.getBounds())) {
                    origen[0] = "almacenEntrada";
                } else if (panel.getBounds().intersects(pnlPila1.getBounds())) {
                    origen[0] = "pila1";
                } else if (panel.getBounds().intersects(pnlPila2.getBounds())) {
                    origen[0] = "pila2";
                }
                
                if ("pila1".equals(origen[0])) {
                    int topY = pnlPila1.getY() - panel.getHeight() * pila1Cuenta;
                    // Solo el que está justo en la cima puede moverse
                    if (panel.getY() != topY) {
                        clickPoint[0] = null;
                    }
                } else if ("pila2".equals(origen[0])) {
                    int topY = pnlPila2.getY() - panel.getHeight() * pila2Cuenta;
                    if (panel.getY() != topY) {
                        clickPoint[0] = null;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (origen[0]) {
                    case "almacenEntrada":
                        if (panel.getBounds().intersects(pnlPila1.getBounds())) {
                            //Tda
                            if (pila1.isLlena()) {
                                JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "La pila 1 esta llena");
                                panel.setLocation(originalPos[0]);
                                break;
                            }
                            String marca = JOptionPane.showInputDialog(SimulacionPilasMotores.this, "Ingrese la marca del motor: ");
                            String modelo = JOptionPane.showInputDialog(SimulacionPilasMotores.this, "Ingrese el modelo del motor: ");
                            int potencia = Integer.parseInt(JOptionPane.showInputDialog(SimulacionPilasMotores.this, "Ingrese la potencia del motor: "));
                            Motores motor1 = new Motores(marca, modelo, potencia);
                            pila1.push(motor1);
                            JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "Motor anadido a la pila 1 exitosamente");

                            //Visual
                            System.out.println("El origen de este motor es: " + origen[0]);
                            origen[0] = "pila1";
                            System.out.println("¡Llegó a la pila 1!");
                            panel.setLocation(pnlPila1.getX(), pnlPila1.getY() - panel.getHeight() * (pila1Cuenta + 1));
                            pila1Cuenta++;

                        } else if (panel.getBounds().intersects(pnlPila2.getBounds())) {
                            //Tda
                            if (pila2.isLlena()) {
                                JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "La pila 2 esta llena");
                                panel.setLocation(originalPos[0]);
                                break;
                            }
                            String marca = JOptionPane.showInputDialog(SimulacionPilasMotores.this, "Ingrese la marca del motor: ");
                            String modelo = JOptionPane.showInputDialog(SimulacionPilasMotores.this, "Ingrese el modelo del motor: ");
                            int potencia = Integer.parseInt(JOptionPane.showInputDialog(SimulacionPilasMotores.this, "Ingrese la potencia del motor: "));
                            Motores motor1 = new Motores(marca, modelo, potencia);
                            pila2.push(motor1);
                            JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "Motor anadido a la pila 2 exitosamente");

                            //Visual
                            System.out.println("El origen de este motor es: " + origen[0]);
                            origen[0] = "pila2";
                            System.out.println("¡Llegó a la pila 2!");
                            panel.setLocation(pnlPila2.getX(), pnlPila2.getY() - panel.getHeight() * (pila2Cuenta + 1));
                            pila2Cuenta++;
                        } else if(panel.getBounds().intersects(pnlAlmacenSalida.getBounds())){
                            JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "Todos los motores deben ser registrados antes de enviarse al exterior");
                            panel.setLocation(originalPos[0]);
                            
                        }
                        else {
                            System.out.println("El origen de este motor es: " + origen[0]);
                            panel.setLocation(originalPos[0]);
                            System.out.println("No llegó a ninguna pila");
                        }
                        break;

                    case "pila1"://Cuando el origen del motor es la pila 1 queire decir q estamos moviendo A pila 2
                        if (panel.getBounds().intersects(pnlPila2.getBounds())) {
                            //Tda
                            if (pila1.isVacia()) {
                                JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "No hay nada en la pila 1");
                                panel.setLocation(originalPos[0]);
                                break;
                            } else if (pila2.isLlena()) {
                                JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "La pila 2 esta llena");
                                panel.setLocation(originalPos[0]);
                                break;
                            }

                            try {
                                c = pila1.peek(); // se lleva la pila 1 hasta el tope
                                pila1.pop();// se saca la pila 1 del tope
                                pila2.push(c); // se mete la pila 1 a la pila 2
                                System.out.println("El motor se cambio de pila 1 a pila 2");
                                System.out.println(c);

                            } catch (IllegalStateException a) {
                                System.out.println(a.getMessage());
                            }

                            //Visual
                            pila1Cuenta--;
                            System.out.println("El origen de este motor es: " + origen[0]);
                            origen[0] = "pila2";
                            System.out.println("¡Llegó a la pila 2!");
                            panel.setLocation(pnlPila2.getX(), pnlPila2.getY() - panel.getHeight() * (pila2Cuenta + 1));
                            pila2Cuenta++;
                        } else if (panel.getBounds().intersects(pnlAlmacenSalida.getBounds())) {
                            try {
                                Motores c = pila1.pop();   // Saca el motor del tope de la pila 2
                                pila1Cuenta--;              // Actualiza el contador visual
                                panel.setVisible(false);    // Opcional: oculta el panel
                                index--;
                                panel.setLocation(90, 90);
                                System.out.println("El motor " + c + " salió al almacén de salida");
                            } catch (IllegalStateException ex) {
                                System.out.println(ex.getMessage()); // Si la pila estaba vacía
                                panel.setLocation(originalPos[0]);  // Regresa a su posición original
                            }
                        } else {
                            System.out.println("El origen de este motor es: " + origen[0]);
                            panel.setLocation(originalPos[0]);
                            System.out.println("No llegó a ninguna pila");
                        }
                        break;

                    case "pila2": //Cuando el origen del motor es la pila 2 quiere decir q estamos moviendo A pila1
                        if (panel.getBounds().intersects(pnlPila1.getBounds())) {
                            if (pila2.isVacia()) {
                                JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "La pila 2 esta vacia");
                                panel.setLocation(originalPos[0]);
                                break;
                            } else if (pila1.isLlena()) {
                                JOptionPane.showMessageDialog(SimulacionPilasMotores.this, "La pila 1 esta llena");
                                panel.setLocation(originalPos[0]);
                                break;
                            }

                            try {
                                c = pila2.peek(); // se lleva la pila 2 hsta el tope 
                                pila2.pop(); // se saca la pila 2 del tope
                                pila1.push(c); // se mete la pila 2 a la pila 1
                                System.out.println("El motor se cambio de pila 2 a pila 1");
                                System.out.println(c);

                            } catch (IllegalStateException a) {
                                System.out.println(a.getMessage());
                            }

                            //Visual
                            pila2Cuenta--;
                            System.out.println("El origen de este motor es: " + origen[0]);
                            origen[0] = "pila1";
                            System.out.println("¡Llegó a la pila 1!");
                            panel.setLocation(pnlPila1.getX(), pnlPila1.getY() - panel.getHeight() * (pila1Cuenta + 1));
                            pila1Cuenta++;
                            System.out.println(pila2.isVacia());
                        } else if (panel.getBounds().intersects(pnlAlmacenSalida.getBounds())) {
                            try {
                                Motores c = pila2.pop();   // Saca el motor del tope de la pila 2
                                pila2Cuenta--;              // Actualiza el contador visual
                                panel.setVisible(false);    // Opcional: oculta el panel
                                index--;
                                panel.setLocation(90, 90);
                                System.out.println("El motor " + c + " salió al almacén de salida");
                            } catch (IllegalStateException ex) {
                                System.out.println(ex.getMessage()); // Si la pila estaba vacía
                                panel.setLocation(originalPos[0]);  // Regresa a su posición original
                            }
                        } else {
                            System.out.println("El origen de este motor es: " + origen[0]);
                            panel.setLocation(originalPos[0]);
                            System.out.println("No llegó a ninguna pila");
                        }

                        break;
                }
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (clickPoint[0] == null) return;
                int x = panel.getX() + e.getX() - clickPoint[0].x;
                int y = panel.getY() + e.getY() - clickPoint[0].y;
                panel.setLocation(x, y);
            }
        });
    }

    private void btnAcercaDeActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Simulacion de motores \n Equipo 5\n Integrantes \n Saul Alejandro Ramirez Leal \n Gudiño Ochoa Luis Gustavo \n Reyes Cázares Aldo Emanuel");
    }

    private void btnSalirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }

    public static void main(String[] args) {

        new SimulacionPilasMotores().setVisible(true);


    }

}
