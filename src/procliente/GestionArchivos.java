/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.print.attribute.standard.MediaSize.Other;

import java.io.*;
import java.net.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karenandreabarretorasquin
 */
public final class GestionArchivos extends javax.swing.JFrame {

  // Vector<HiloDescarga> VectorHilos;
    int selected = -1;
    //private String ip0 = null;
    private String ip1 = null;
    private String ip2 = null;
    private String ip= "localhost";
    private String carpetausuario;
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Creates new form GestionArchivos
     */
    
    
    public GestionArchivos() {
        
        initComponents();
        
        XMLCliente xml = new XMLCliente();
        xml.cargaArchivos(this,this.carpetausuario);
      //conexion();
        
    }

    public GestionArchivos(String carpetausuario) {
        this.carpetausuario = carpetausuario;
        initComponents();
        XMLCliente xml = new XMLCliente();
        System.out.println(this.carpetausuario);
        xml.cargaArchivos(this,this.carpetausuario);
    }
    
    
    
    public void conexion(){
    
     try {
            // TODO code application logic here
            ServerSocket servicio = new ServerSocket(6000);//puerto donde escucha
            Socket socketServicio = null;
            
            //System.out.println("Soy nodo dos (2)" + args[0]);
            //esperamos conexion
            boolean prueba = true;
            while(prueba) {
            
                socketServicio = servicio.accept();
                PrintWriter salida = new PrintWriter(socketServicio.getOutputStream(), true);
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));

                //Object
                String llego = entrada.readLine();
                
                if(llego.equals("archivo"))
                {                    
                    System.out.println("Recibi Archivo");
                    Conexion envio = new Conexion("localhost",7000);
                    envio.start();
                    break;
                }      

                salida.close();
                entrada.close();
                socketServicio.close();

            }

            
            servicio.close();
        } catch (IOException ex) {
            System.out.println("Algo se daño:");
            ex.printStackTrace();
        }
    
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionArchivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionArchivos().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gestor = new javax.swing.JTable();
        crear = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        Usuario1 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setText("Biblioteca de Archivos");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        gestor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Archivo", "Tamaño", "Día Creado", "Día Modificado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gestor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(gestor);

        crear.setText("Crear Archivo");
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar Archivo");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar Lista");
        actualizar.setActionCommand("");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel2.setText("Dropbox Ucab");

        username.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N

        Usuario1.setFont(new java.awt.Font("Lucida Grande", 2, 14)); // NOI18N
        Usuario1.setText("Usuario:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(216, 216, 216)
                .add(jLabel2)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(Usuario1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(username, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 139, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 454, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(layout.createSequentialGroup()
                            .add(crear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(actualizar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 147, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(eliminar))))
                .add(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, Usuario1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, username, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(jLabel2)
                .add(27, 27, 27)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(29, 29, 29)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(eliminar)
                    .add(crear)
                    .add(actualizar))
                .add(18, 18, 18))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-612)/2, (screenSize.height-324)/2, 612, 324);
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed
        // TODO add your handling code here:
        
        CrearArchivo crear= new CrearArchivo();
        crear.setVisible(true);
        crear.setPadre(this);
        crear.getUsername().setText(this.getUsername().getText());
        this.setUsuario(this.getUsername().getText());
        crear.setCarpetausuario(this.carpetausuario);
        this.setVisible(false);
    }//GEN-LAST:event_crearActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarActionPerformed

    
    public int getRowCount() {
        return gestor.getRowCount();
    }
    
    public Archivo getArchivo(int i) {
        Archivo archi = new Archivo();
        archi.setNombre((String) gestor.getValueAt(i, 0));
        archi.setTamano((String) gestor.getValueAt(i, 1));
        archi.setDiacreado((String) gestor.getValueAt(i, 2));
       archi.setDiamodificado((String) gestor.getValueAt(i, 3));
       archi.setUsuario(this.carpetausuario);
        
        return archi;
    }
    public void agregarfila(String nombre, String tamano, String diacreado, String diamodificado) {
        ((DefaultTableModel) this.gestor.getModel()).addRow(new Object[]{nombre, tamano, diacreado, diamodificado});
    
    }

    public JLabel getUsername() {
        return username;
    }

    public void setUsername(JLabel username) {
        this.username = username;
    }

    public String getCarpetausuario() {
        return carpetausuario;
    }

    public void setCarpetausuario(String carpetausuario) {
        this.carpetausuario = carpetausuario;
    }
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Usuario1;
    private javax.swing.JButton actualizar;
    private javax.swing.JButton crear;
    private javax.swing.JButton eliminar;
    private javax.swing.JTable gestor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
