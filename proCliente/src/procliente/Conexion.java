/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danieLzamora
 */
public class Conexion extends Thread{

    private Integer port;
    private String ip;
    //private Integer puertoProfesor;
    //private String ipProfesor;
    //private Integer numeroEquipo;
    
    public Conexion(String ip, Integer port)
    {
        this.ip = ip;
        this.port = port;
       
    }
    
    @Override
    public void run()
    {
        this.enviandoArchivo(this.ip, this.port);
    }
    
    
    private void enviandoArchivo(String ipNodoSiguient, Integer portnodoSiguiente) {
        // TODO code application logic here
       
        try{
               sleep(2001);
               //argunmento 0 es el ip, argumento 1 es el puerto
               Socket cliente = new Socket(ipNodoSiguient, portnodoSiguiente);
               PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
               salida.println("archivo");           
               salida.close();
               cliente.close();
            } catch (Exception e) {
                System.out.println("Yo tengo la papa");
}
}
}
