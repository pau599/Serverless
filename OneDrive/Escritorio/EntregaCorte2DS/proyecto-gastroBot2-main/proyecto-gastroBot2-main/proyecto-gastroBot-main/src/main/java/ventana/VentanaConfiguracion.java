/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventana;

import Service.UserService;
import static Service.UserService.correoActual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Carolina
 */
public class VentanaConfiguracion extends javax.swing.JFrame {
    
    

    /**
     * Creates new form VentanaPreferencia
     */
    public VentanaConfiguracion() {
          initComponents();
    }
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCambiarContra = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("GastroBot");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("GastroBot");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("CONFIGURACIONES");

        btnCambiarContra.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnCambiarContra.setText("Cambiar Contraseña");
        btnCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraActionPerformed(evt);
            }
        });

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnCerrarSesion.setText("Cerrar sesion");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnEliminarCuenta.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnEliminarCuenta.setText("Eliminar cuenta");
        btnEliminarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCuentaActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCambiarContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnVolver)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(btnCambiarContra)
                .addGap(31, 31, 31)
                .addComponent(btnCerrarSesion)
                .addGap(32, 32, 32)
                .addComponent(btnEliminarCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraActionPerformed
        // TODO add your handling code here:
    VentanaCambiarContraseña cambiar = new VentanaCambiarContraseña();
    cambiar.setVisible(true);
    this.dispose(); 
    }//GEN-LAST:event_btnCambiarContraActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // TODO add your handling code here:
        VentanaInicioSesion configuraciones = new VentanaInicioSesion();
    configuraciones.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnEliminarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCuentaActionPerformed
        // TODO add your handling code here:
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de eliminar tu cuenta?", "Confirmar", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        try {
            UserService service = new UserService();
            service.eliminarCuenta(correoActual); 
            JOptionPane.showMessageDialog(this, "Cuenta eliminada correctamente.");
            
            VentanaInicioSesion inicio = new VentanaInicioSesion();
            inicio.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar cuenta: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_btnEliminarCuentaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    VentanaGeneral ventana = new VentanaGeneral();
    ventana.setVisible(true);
    this.dispose(); 
    }//GEN-LAST:event_btnVolverActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarContra;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
