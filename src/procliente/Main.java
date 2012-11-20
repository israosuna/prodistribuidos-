/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procliente;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author karenbar
 */
public class Main {
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

  
        
        Login iniciarSesion = new Login();
        iniciarSesion.setVisible(true);
        // TODO code application logic here
         int idnodo = Integer.valueOf(args[0]);
         XMLnodos xmlnodo = new XMLnodos();    
         xmlnodo.cargaArchivos(idnodo);
        Recibir R = new Recibir(Datos.getPuerto_entrada());
        R.run();
    }

}
