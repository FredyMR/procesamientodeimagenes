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
public class negativoGrises extends javax.swing.JInternalFrame {
    ProcesamientoImagen ObjProcesamiento=new ProcesamientoImagen();
    Histograma nuevohistograma=new Histograma();
    BufferedImage ImageActual1,ImageActual2;
    /**
     * Creates new form negativoGrises
     */
    public negativoGrises() {
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

        comboNG = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 153, 0));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Modulo Negativo y Grises");

        comboNG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Negativo", "Grises" }));
        comboNG.setToolTipText("");
        comboNG.setPreferredSize(new java.awt.Dimension(95, 20));
        comboNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNGActionPerformed(evt);
            }
        });

        jButton1.setText("Abrir Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setMaximumSize(new java.awt.Dimension(710, 421));
        jScrollPane1.setViewportView(jLabel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(comboNG, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboNG, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel1.setIcon(new ImageIcon(ImageActual1 = (ObjProcesamiento.abrirImagen())));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNGActionPerformed
        // COMBO BOX DE NEGATIVO Y GRISES
            //seleccion de los filtros del combobox
//            if ((int)comboNG.getSelectedIndex() == 1 ){
//                jLabel1.setIcon(new ImageIcon(ImageActual1=ObjProcesamiento.negativo(ImageActual1)));
//            }
//            if((int)comboNG.getSelectedIndex() == 2 ){
//                jLabel1.setIcon(new ImageIcon(ImageActual1=ObjProcesamiento.escalaGrises(ImageActual1)));
//            }
            int numero = (int)comboNG.getSelectedIndex();
            switch(numero){
                    case 1:
                        jLabel1.setIcon(new ImageIcon(ImageActual1=ObjProcesamiento.negativo(ImageActual1)));
                        System.out.println(numero);
                    break;
                    case 2:
                        jLabel1.setIcon(new ImageIcon(ImageActual1=ObjProcesamiento.escalaGrises(ImageActual1)));
                        System.out.println(numero);
                    break;
            }
            
            
        
    }//GEN-LAST:event_comboNGActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboNG;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}