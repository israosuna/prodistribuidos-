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
 * @author daniel
 */
public class HiloReplicador extends Thread {

    private String ip_nodo_siguiente;
    private int puerto_salida;
    private int puerto_entrada;
    private File archivo;
    
    private String usuario;

    public HiloReplicador(String ip_nodo_siguiente, int puerto_entrada, int puerto_salida, File archivo, String user) {
        this.ip_nodo_siguiente = ip_nodo_siguiente;
        this.puerto_salida = puerto_salida;
        this.puerto_entrada = puerto_entrada;
        this.archivo = archivo;
        this.usuario = user;
     
    }

    @Override
    public void run() {
        this.replicarArchivo();
    }

    public void replicarArchivo() {
        try {

            
            Socket socket = new Socket(this.ip_nodo_siguiente, this.puerto_salida);
            //DataInputStream servicio = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream servicioSocket = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            //write file name
            servicioSocket.writeUTF(archivo.getName());
            servicioSocket.writeUTF(this.usuario);
            servicioSocket.flush();
            FileInputStream archivo2 = new FileInputStream("../proCliente/" + this.usuario + "/" + archivo.getName());
            //buffer for file writing, to declare inside or outside loop?
            byte[] buffer = new byte[1024];
            //outer loop, executes one for each file
            System.out.println(archivo.getName());
            int len;
            //int total = 0;
            //write file to servicioSocket
            while ((len = archivo2.read(buffer)) != -1) {
                servicioSocket.write(buffer, 0, len);
                // total = total + len;
                servicioSocket.flush();
                //System.out.println("Enviando " + String.valueOf(len) + " total " + total);               
            }
            //should i close the dataoutputstream here and make a new one each time?

            //or is this good?
            servicioSocket.close();
            //final nuevo codigo
          
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("Error");
        }
    }
}
