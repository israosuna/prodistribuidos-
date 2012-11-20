/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procliente;

/**
 *
 * @author osorioabel
 */
public class Datos {
    
    private static String ip_vecino="";
    private static int puerto_salida;
    private static int puerto_entrada;
    private static int id_nodo;
  
    
    public Datos() {
        
        
    }
    
    public Datos(String ip_vecino, int puerto_salida , int puerto_entrada) {
        
        Datos.ip_vecino=ip_vecino;
        Datos.puerto_salida=puerto_salida;
        Datos.puerto_entrada=puerto_entrada;
        
    }
    
    public static void setArgumentos(String ip_vecinos, int puerto_salidas, int id_nodos)   
    {
         Datos.ip_vecino=ip_vecinos;
         
         Datos.puerto_salida=puerto_salidas;
         Datos.id_nodo=id_nodos;
         
     
       
    }

 
    

    public static String getIp_vecino() {
        return ip_vecino;
    }

    public static void setIp_vecino(String ip_vecino) {
        Datos.ip_vecino = ip_vecino;
    }

    public static int getPuerto_salida() {
        return puerto_salida;
    }

    public static void setPuerto_salida(int puerto_salida) {
        Datos.puerto_salida = puerto_salida;
    }

    public static int getPuerto_entrada() {
        return puerto_entrada;
    }

    public static void setPuerto_entrada(int puerto_entrada) {
        Datos.puerto_entrada = puerto_entrada;
    }


    
    
    
}
