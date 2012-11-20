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
public class Usuario {

    private String usuario;
    private String clave;
    private String carpeta;

    public Usuario() {
    }

    public Usuario(String usuario, String clave, String carpeta) {
        this.usuario = usuario;
        this.clave = clave;
        this.carpeta = carpeta;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    
    
    
    
    
}