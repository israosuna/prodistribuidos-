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
public class XMLCliente {

    //private String ruta = "Archivos/";
    //public Vector<Archivo> Varchivo = new Vector<Archivo>();

    /**
     * Metodo que carga la lista de archivos leyendo del archivo XML
     * @param ventanita
     */
    public void cargaArchivos(GestionArchivos ventanita,String usuario) {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            //System.out.println(usuario);
            Document doc = builder.build("ListaArchivos.xml");
            Element raiz = doc.getRootElement();
            List listaarchivos = raiz.getChildren("archivo");
            Iterator k = listaarchivos.iterator();
            while (k.hasNext()) {
                int i = 0, j = 0;
                Element e = (Element) k.next();
                Element nombre = e.getChild("nombre");
                Element tamano = e.getChild("tamano");
               
                Element diacreado = e.getChild("diacreado");
                Element diamodificado = e.getChild("diamodificado");
                Element user = e.getChild("user");
                if (usuario.equals(user.getText())){
                ventanita.agregarfila(nombre.getText(), tamano.getText(), diacreado.getText(), diamodificado.getText());
                }
                
                }
        } catch (FileNotFoundException F) {
            System.out.println("Archivo XML no encontrado");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return Varchivo;
    }


    /**
     * Metodo que genera un nodo de elemento archivo en el archivo xml
     */
    public class agregarArchivo extends Element {

        public agregarArchivo(Archivo archivo) {
            super("archivo");
            addContent(new Element("nombre").setText(archivo.getNombre()));
            addContent(new Element("tamano").setText(archivo.getTamano()));
            //addContent(new Element("cantidad").setText(archivo.getCantidad().toString()));
            addContent(new Element("diacreado").setText(archivo.getDiacreado()));
            addContent(new Element("diamodificado").setText(archivo.getDiamodificado()));
            addContent(new Element("user").setText(archivo.getUsuario()));
        }
    }

    /**
     * metodo que escribe la lista de archivos en el XML
     * @param ventanita
     */
    
    
    public static void archivoNuevo(String nombre){
    
          try {
 
		Element company = new Element("archivos");
		Document doc = new Document(company);
		doc.setRootElement(company);
		// new XMLOutputter().output(doc, System.out);
		XMLOutputter xmlOutput = new XMLOutputter();
		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("../proCliente/"+nombre));
		System.out.println("Usuario Creado Satisfactoriamente");
	  } catch (IOException io) {
		System.out.println(io.getMessage());
	  }
    }
    
    
    public static  boolean  escribirArchivos(String nombrearchivo,String tamanoarchivo,String fechacreado, String fechamodificado, String usuario) {        
    {
        Document    doc;
        Element     root, archivo, nombre, tamano,diacreado,diamodificado,user;
        SAXBuilder  builder = new SAXBuilder();
        
      
        
        try
        {
            doc = builder.build("ListaArchivos.xml");
            root = doc.getRootElement();
            // Creamos una nueva etiqueta
            archivo = new Element("archivo");
            nombre = new Element("nombre");
            tamano = new Element("tamano");
            diacreado = new Element("diacreado");
            diamodificado = new Element("diamodificado");
            user = new Element("user");
            
            root.addContent(archivo);
            archivo.addContent(nombre);
            nombre.addContent(nombrearchivo);
            
            archivo.addContent(tamano);
            tamano.addContent(tamanoarchivo);
            
            archivo.addContent(diacreado);
            diacreado.addContent(fechacreado);
            
            archivo.addContent(diamodificado);
            diamodificado.addContent(fechamodificado);
            
             archivo.addContent(user);
             user.addContent(usuario);
            
            
            
            
            
            
            
            
          
           
            try
            {
                Format format = Format.getPrettyFormat();
                /* Se genera un flujo de salida de datos XML */
                XMLOutputter out = new XMLOutputter(format);
                /* Se asocia el flujo de salida con el archivo donde se guardaran los datos */
                FileOutputStream file = new FileOutputStream("ListaArchivos.xml");
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
}
