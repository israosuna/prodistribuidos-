/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procliente;

import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;

/**
 * Clase que permite la carga y descarga de la lista de archivos del cliente
 * @author ignaciocardenas
 */
public class XMLUsuario {

    //private String ruta = "Archivos/";
    //public Vector<Archivo> Varchivo = new Vector<Archivo>();

    /**
     * Metodo que carga la lista de archivos leyendo del archivo XML
     * @param ventanita
     */
    
    
   // public String comprobarUsuario(Login )
    public String comprobarUsuarios(String username,String contrasena) {
        try {
            //System.out.println(username + " " + contrasena);
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = builder.build("ListaUsuarios.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("usuario");
            Iterator k = listaarchivos.iterator();
            while (k.hasNext()) {
                int i = 0, j = 0;
                Element e = (Element) k.next();
                Element nombre = e.getChild("login");
                Element clave = e.getChild("clave");
                Element carpeta = e.getChild("carpeta");
                
                if (username.equals(nombre.getText())) {
                    if (clave.getText().equals(contrasena)){
                       
                       String directorio= carpeta.getText();
                        return directorio;}
                }
            }
            return null;
            
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        //return Varchivo;
    }

public static boolean agregarUsuario(String nombre,String clave, String carpeta)
    {
        Document    doc;
        Element     root, elusuario, ellogin, laclave,lacarpeta;
        SAXBuilder  builder = new SAXBuilder();
        try
        {
            doc = builder.build("ListaUsuarios.xml");
            root = doc.getRootElement();
            // Creamos una nueva etiqueta
            elusuario = new Element("usuario");
            ellogin = new Element("login");
            laclave = new Element("clave");
            lacarpeta = new Element("carpeta");
            
            root.addContent(elusuario);
            elusuario.addContent(ellogin);
            ellogin.addContent(nombre);
            elusuario.addContent(laclave);
            laclave.addContent(clave);
            elusuario.addContent(lacarpeta);
            lacarpeta.addContent(nombre);
           
            try
            {
                Format format = Format.getPrettyFormat();
                /* Se genera un flujo de salida de datos XML */
                XMLOutputter out = new XMLOutputter(format);
                /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
                FileOutputStream file = new FileOutputStream("ListaUsuarios.xml");
                /* Se manda el documento generado hacia el archivo XML */
                out.output(doc,file);
                /* Se limpia el buffer ocupado por el objeto file y se manda a cerrar el archivo */
                file.flush();
                file.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        catch(JDOMParseException e)
        {
            System.out.println("Error loading XML file - The file is empty");
            e.printStackTrace();
        }
        catch(JDOMException e)
        {
            System.out.println("Error loading XML file - The file is empty");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            System.out.println("Error loading XML file - The file is empty");
            e.printStackTrace();
        }

        return true;
    }
}


