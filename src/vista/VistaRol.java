/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author hgust
 */
public class VistaRol extends javax.swing.JFrame {

    /**
     * Creates new form Rol
     */
    public VistaRol() {
        initComponents();
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnperfil = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btncerrar = new javax.swing.JButton();
        btnclientes = new javax.swing.JButton();
        btnestados = new javax.swing.JButton();
        btnusuarios = new javax.swing.JButton();
        btncategorias = new javax.swing.JButton();
        btninicio = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ltitulo2 = new javax.swing.JLabel();
        lid = new javax.swing.JLabel();
        lnombre = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        tnombre = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        enviar = new javax.swing.JButton();
        miScroll = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        mitablita = new javax.swing.JTable();

        btnperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario (1). (1).png"))); // NOI18N
        btnperfil.setBorder(null);
        btnperfil.setBorderPainted(false);
        btnperfil.setContentAreaFilled(false);
        btnperfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnperfil.setFocusPainted(false);
        btnperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperfilActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        btncerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion (1).png"))); // NOI18N
        btncerrar.setBorder(null);
        btncerrar.setBorderPainted(false);
        btncerrar.setContentAreaFilled(false);
        btncerrar.setFocusPainted(false);

        btnclientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclientes.setForeground(new java.awt.Color(255, 255, 255));
        btnclientes.setText("Clientes");
        btnclientes.setBorder(null);
        btnclientes.setBorderPainted(false);
        btnclientes.setContentAreaFilled(false);
        btnclientes.setFocusPainted(false);
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });

        btnestados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnestados.setForeground(new java.awt.Color(255, 255, 255));
        btnestados.setText("Estados");
        btnestados.setBorder(null);
        btnestados.setBorderPainted(false);
        btnestados.setContentAreaFilled(false);
        btnestados.setFocusPainted(false);
        btnestados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnestadosActionPerformed(evt);
            }
        });

        btnusuarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnusuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnusuarios.setText("Usuarios");
        btnusuarios.setBorder(null);
        btnusuarios.setBorderPainted(false);
        btnusuarios.setContentAreaFilled(false);
        btnusuarios.setFocusPainted(false);

        btncategorias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncategorias.setForeground(new java.awt.Color(255, 255, 255));
        btncategorias.setText("Categorias");
        btncategorias.setBorder(null);
        btncategorias.setBorderPainted(false);
        btncategorias.setContentAreaFilled(false);
        btncategorias.setFocusPainted(false);

        btninicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btninicio.setForeground(new java.awt.Color(255, 255, 255));
        btninicio.setText("Inicio");
        btninicio.setBorder(null);
        btninicio.setBorderPainted(false);
        btninicio.setContentAreaFilled(false);
        btninicio.setFocusPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(btninicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnestados, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(btncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnestados, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnusuarios)
                            .addComponent(btncategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btninicio))
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 70));

        jPanel2.setBackground(new java.awt.Color(234, 223, 191));

        ltitulo2.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        ltitulo2.setText("Roles");

        lid.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lid.setText("Id");

        lnombre.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        lnombre.setText("Nombre");

        tid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnombreActionPerformed(evt);
            }
        });

        buscar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        buscar.setText("Buscar");
        buscar.setBorder(null);
        buscar.setBorderPainted(false);
        buscar.setContentAreaFilled(false);
        buscar.setFocusPainted(false);

        insertar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        insertar.setText("Insertar");
        insertar.setBorder(null);
        insertar.setBorderPainted(false);
        insertar.setContentAreaFilled(false);
        insertar.setFocusPainted(false);

        actualizar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        actualizar.setText("Actualizar");
        actualizar.setBorder(null);
        actualizar.setBorderPainted(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setFocusPainted(false);

        eliminar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.setBorder(null);
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setFocusPainted(false);

        enviar.setFont(new java.awt.Font("Century", 0, 14)); // NOI18N
        enviar.setText("Enviar");
        enviar.setBorder(null);
        enviar.setBorderPainted(false);
        enviar.setContentAreaFilled(false);
        enviar.setFocusPainted(false);

        mitablita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE"
            }
        ));
        jScrollPane2.setViewportView(mitablita);

        miScroll.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(miScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(ltitulo2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(insertar))))
                        .addGap(52, 52, 52)
                        .addComponent(actualizar)
                        .addGap(52, 52, 52)
                        .addComponent(eliminar)
                        .addGap(32, 32, 32)
                        .addComponent(enviar)))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ltitulo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tnombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lid)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(lnombre)))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enviar)
                    .addComponent(eliminar)
                    .addComponent(actualizar)
                    .addComponent(insertar)
                    .addComponent(buscar))
                .addGap(41, 41, 41)
                .addComponent(miScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 870, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnombreActionPerformed

    private void btnperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnperfilActionPerformed

    private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnclientesActionPerformed

    private void btnestadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnestadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnestadosActionPerformed

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
            java.util.logging.Logger.getLogger(VistaRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRol.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRol().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton actualizar;
    public javax.swing.JButton btncategorias;
    public javax.swing.JButton btncerrar;
    public javax.swing.JButton btnclientes;
    public javax.swing.JButton btnestados;
    public javax.swing.JButton btninicio;
    public javax.swing.JButton btnperfil;
    public javax.swing.JButton btnusuarios;
    public javax.swing.JButton buscar;
    public javax.swing.JButton eliminar;
    public javax.swing.JButton enviar;
    public javax.swing.JButton insertar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lid;
    private javax.swing.JLabel lnombre;
    private javax.swing.JLabel ltitulo2;
    private javax.swing.JScrollPane miScroll;
    public javax.swing.JTable mitablita;
    public javax.swing.JTextField tid;
    public javax.swing.JTextField tnombre;
    // End of variables declaration//GEN-END:variables
}