/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacionpilasmotores;

/**
 *
 * @author Astra
 */
public class Motores {
    String marca;
    String modelo;
    int potencia;
    boolean origenEntrada;
    public Motores() {
    }

    public Motores(String marca, String modelo, int potencia) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.origenEntrada = true;
    }

    public boolean isOrigenEntrada() {
        return origenEntrada;
    }

    public void setOrigenEntrada(boolean origenEntrada) {
        this.origenEntrada = origenEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Motores{" + "marca=" + marca + ", modelo=" + modelo + ", potencia=" + potencia + '}';
    }
    
    
    
}
    
    

