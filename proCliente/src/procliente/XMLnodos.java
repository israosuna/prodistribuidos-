package procliente;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author israelosuna
 */
public class XMLnodos {

    public XMLnodos() {
    }
    
    

    public void cargaArchivos(int index) {
        int cant =0;
        try {
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            Document doc = builder.build("ListaNodos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("nodo");
            Iterator k = listaarchivos.iterator();
            while (k.hasNext()) {
                
           if(index== cant){
                Element e = (Element) k.next();
                Element idnodo = e.getChild("id");
                Element ip = e.getChild("ip");
                Element puerto_entrada = e.getChild("puerto_entrada");
                Element puerto_salida = e.getChild("puerto_salida");
              //  System.out.println(ip.getText());
                Datos.setArgumentos(ip.getText(), Integer.valueOf(puerto_entrada.getText()), Integer.valueOf(puerto_salida.getText()),Integer.valueOf(idnodo.getText()));

           }
           else{
           cant++;
           }
            }
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return Varchivo;
    }

    public int cantNodos() {
        int cant = 0;

        try {
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            Document doc = builder.build("ListaNodos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("nodo");
            Iterator k = listaarchivos.iterator();
            int contador=0;
            while (k.hasNext()) {
                contador++;
                cant = cant++;
                k.next();
                

            }
            return contador;

        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cant;

    }
}
