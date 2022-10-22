/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Conexion.sql;
import Conexion.PdfDAO;
import JTable.Tabla_PdfVO;
import JTable.PdfVO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julian
 */
public class SubirPDF extends javax.swing.JFrame {

    /**
     * Creates new form MostrarPDF
     */
    Tabla_PdfVO tpdf = new Tabla_PdfVO();
    String ruta_archivo = "";
    int id = -1;

    public SubirPDF() {
        initComponents();
                this.setResizable(false);
        this.setLocationRelativeTo(null);
        tpdf.visualizar_PdfVO(tabla);
        activa_boton(false, false, false, false, false, false);
        txtNombre.setEnabled(false);
    }

    public void guardar_pdf(int codigo, int cedula ,String nombre, File ruta, Date fecha) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        po.setCedula(cedula);
        po.setFecha(fecha);
        po.setNombrepdf(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        pa.Agregar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, int cedula ,String nombre, File ruta, Date fecha) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        po.setCedula(cedula);
        po.setFecha(fecha);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        pa.Modificar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, String nombre) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        pa.Modificar_PdfVO2(po);
    }

    public void eliminar_pdf(int codigo) {
        PdfDAO pa = new PdfDAO();
        PdfVO po = new PdfVO();
        po.setCodigopdf(codigo);
        pa.Eliminar_PdfVO(po);
    }

    public void seleccionar_pdf() {
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.btnseleccionar.setText("" + j.getSelectedFile().getName());
            ruta_archivo = j.getSelectedFile().getAbsolutePath();
        } else {
        }
    }

    public void activa_boton(boolean a, boolean b, boolean c, boolean d, boolean cedula, boolean dateC) {
        btnguardar.setEnabled(a);
        btnmodificar.setEnabled(b);
        btneliminar.setEnabled(c);
        txtCedula.setEnabled(cedula);
        dateChooser.setEnabled(dateC);
        txtNombre.setText("");
        btnseleccionar.setEnabled(d);
        btnseleccionar.setText("Seleccionar...");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnseleccionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guardar y Leer PDF");

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setBackground(new java.awt.Color(204, 204, 204));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Archivo"
            }
        ));
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        tabla.getTableHeader().setResizingAllowed(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 176, 590, 325));

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel7.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 176, 424, -1));

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jPanel7.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 423, 424, -1));

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });
        jPanel7.add(btnmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 451, 424, -1));

        jLabel2.setText("Seleccionar archivo:");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 398, 100, -1));

        btnseleccionar.setText("Seleccionar...");
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });
        jPanel7.add(btnseleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 395, 318, -1));

        jLabel1.setText("Nombre del archivo:");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 247, -1, -1));
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 244, 304, -1));

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel7.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 479, 424, -1));

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Subir Archivos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(35, 35, 35))
        );

        jPanel7.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, -1));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel7.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 272, 304, -1));

        jLabel4.setText("Cedula Radicante");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 275, -1, -1));

        jLabel5.setText("Fecha de expedicion");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 303, -1, -1));

        dateChooser.setDateFormatString("dd/MM/yyyy");
        jPanel7.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed
        seleccionar_pdf();
    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        String nombre = txtNombre.getText();
        int cedula = Integer.parseInt(txtCedula.getText());
        Date fecha = new java.sql.Date(dateChooser.getCalendar().getTimeInMillis());
        sql s = new sql();
        int codigo = s.auto_increment("SELECT MAX(Codigo) FROM pdf;");
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            guardar_pdf(codigo, cedula, nombre, ruta, fecha);
            tpdf.visualizar_PdfVO(tabla);
            ruta_archivo = "";
            activa_boton(false, false, false, false, false, false);
            txtNombre.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Rellenar todo los campos");
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        String nombre = txtNombre.getText();
        File ruta = new File(ruta_archivo);
        int cedula = Integer.parseInt(txtCedula.getText());
        Date fecha = new java.sql.Date(dateChooser.getCalendar().getTimeInMillis());
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            modificar_pdf(id, cedula, nombre, ruta, fecha);
            tpdf.visualizar_PdfVO(tabla);
        } else if (ruta_archivo.trim().length() == 0) {
            modificar_pdf(id, nombre);
            tpdf.visualizar_PdfVO(tabla);
        }
        ruta_archivo = "";
        activa_boton(false, false, false, false, false, false);
        txtNombre.setEnabled(false);

    }//GEN-LAST:event_btnmodificarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int column = tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tabla.getRowHeight();
        activa_boton(false, true, true, true, false, false);
        txtNombre.setEnabled(true);
        if (row < tabla.getRowCount() && row >= 0 && column < tabla.getColumnCount() && column >= 0) {
            id = (int) tabla.getValueAt(row, 0);
            Object value = tabla.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    PdfDAO pd = new PdfDAO();
                    pd.ejecutar_archivoPDF(id);
                    try {
                        Desktop.getDesktop().open(new File("new.pdf"));
                    } catch (Exception ex) {
                    }
                }

            } else {
                String name = "" + tabla.getValueAt(row, 1);
                txtNombre.setText(name);
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar_pdf(id);
        tpdf.visualizar_PdfVO(tabla);
        activa_boton(false, false, false, false, false, false);
        txtNombre.setEnabled(false);
        ruta_archivo = "";
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        activa_boton(true, false, false, true, true, true);
        txtNombre.setEnabled(true);
        ruta_archivo = "";
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SubirPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubirPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubirPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubirPDF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnseleccionar;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
