/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cargarimagen;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Jose May
 */
public class rotacionImagen extends javax.swing.JInternalFrame {
    ProcesamientoImagen ObjProcesamiento=new ProcesamientoImagen();
    Histograma nuevohistograma=new Histograma();
    BufferedImage ImageActual1,ImageActual2;
    public int dato1;
    /**
     * Creates new form rotacionImagen
     */
    public rotacionImagen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        filtro_manual = new javax.swing.JSlider();
        dato = new javax.swing.JTextField();
        jButton42 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Rotacion de una Imagen");

        jScrollPane1.setMaximumSize(new java.awt.Dimension(301, 301));
        jScrollPane1.setViewportView(jLabel1);

        jScrollPane2.setMaximumSize(new java.awt.Dimension(301, 301));
        jScrollPane2.setViewportView(jLabel2);

        filtro_manual.setMajorTickSpacing(30);
        filtro_manual.setMaximum(360);
        filtro_manual.setPaintLabels(true);
        filtro_manual.setPaintTicks(true);
        filtro_manual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                filtro_manualStateChanged(evt);
            }
        });

        jButton42.setText("Abrir Imagen");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton2.setText("Rotar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(filtro_manual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(dato, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtro_manual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dato, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42)
                    .addComponent(jButton2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtro_manualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_filtro_manualStateChanged
        //llamada del metodo grados para girar la imagen
        dato.setText(""+filtro_manual.getValue());

    }//GEN-LAST:event_filtro_manualStateChanged

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        jLabel1.setIcon(new ImageIcon(ImageActual1 = ObjProcesamiento.escalaGrises(ObjProcesamiento.abrirImagen())));
    }//GEN-LAST:event_jButton42ActionPerformed
    public int datonuevo;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //BOTON DE ROTACION
        datonuevo = Integer.parseInt(this.dato.getText());
        jLabel2.setIcon(new ImageIcon(ImageActual1 = nuevohistograma.Rotacion(ImageActual1,datonuevo)));
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dato;
    private javax.swing.JSlider filtro_manual;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton42;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}