/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procliente;

/**
 * Clase que sirve de puente entre la interfaz y la lectura de la lista
 * de archivos xml para poder cargar la lista de archivos
 * @author ignaciocardenas
 */
public class Archivo {

    private String nombre;
    private String tamano;
    private String diacreado;
    private String diamodificado;
    private String usuario;
    
    public Archivo() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Archivo(String nombre, String tamano, String diacreado, String diamodificado) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.diacreado = diacreado;
        this.diamodificado = diamodificado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

   

    public String getDiacreado() {
        return diacreado;
    }

    public void setDiacreado(String diacreado) {
        this.diacreado = diacreado;
    }

    public String getDiamodificado() {
        return diamodificado;
    }

    public void setDiamodificado(String diamodificado) {
        this.diamodificado = diamodificado;
    }

}
