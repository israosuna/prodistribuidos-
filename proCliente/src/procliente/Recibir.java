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
 * @author israelosuna
 */
public class Recibir implements Runnable {

    int puerto;
    boolean cerrar;

    public Recibir(int puerto) {
        this.puerto = puerto;
    }

    public void run() {

        while (1 == 1) {

            try {

                ServerSocket servicio = new ServerSocket(puerto);

                Socket socket = servicio.accept();

                DataInputStream entrada = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                File archivo = new File(entrada.readUTF());

               // if (!(new File("../proCliente/" + entrada.readUTF() + "/" + archivo.getName())).exists()) {

                int n = 0;
                byte[] buf = new byte[4092];

                //outer loop, executes one for each file

                File folder = new File("../proCliente/" + entrada.readUTF() + "/");

                System.out.println("Receiving file: " + archivo.getName());
                //create a new fileoutputstream for each new file
                folder.mkdir();
                FileOutputStream fos = new FileOutputStream(folder.getName() + "/" + archivo.getName());

                XMLCliente xml = new XMLCliente();
                xml.escribirArchivos(archivo.getName(), "10KB", "16-11-2012", "16-11-2012", folder.getName());

                //read file
                while ((n = entrada.read(buf)) != -1) {
                    fos.write(buf, 0, n);
                    fos.flush();
                    //System.out.println("1");
                }
                fos.close();

              

                // OJO EL 1200 ES EL PUERTO DE ENVIAR, EL DE ESCUCHA SE ESTA USANDO POR ARGUMENTO
          
//
                //}

                //final nuevo codigo

                servicio.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }

    }
}
