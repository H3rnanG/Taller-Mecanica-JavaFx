package net.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.controlador.ControladorPersonal;

public class VistaPersonal extends javax.swing.JFrame {
    private ControladorPersonal controladorPersonal;
    
    public VistaPersonal(ControladorPersonal controladorPersonal) {
        this.controladorPersonal = controladorPersonal;
        
        initComponents();
        
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controladorPersonal.CerrarVista();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Personal = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_Nombre = new javax.swing.JLabel();
        lbl_Apellido = new javax.swing.JLabel();
        txt_Apellido = new javax.swing.JTextField();
        lbl_Ocupacion = new javax.swing.JLabel();
        txt_Ocupacion = new javax.swing.JTextField();
        lbl_Salario = new javax.swing.JLabel();
        lbl_Telefono = new javax.swing.JLabel();
        lbl_Correo = new javax.swing.JLabel();
        txt_Salario = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        guardarPersonal = new javax.swing.JButton();
        txt_Contra = new javax.swing.JTextField();
        lbl_Contra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));

        lbl_Personal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_Personal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Personal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Personal.setText("PERSONAL");
        lbl_Personal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_Nombre.setBackground(new java.awt.Color(58, 80, 107));
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setBorder(null);
        txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NombreActionPerformed(evt);
            }
        });

        lbl_Nombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Nombre.setText("Nombre:");

        lbl_Apellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Apellido.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Apellido.setText("Apellido:");

        txt_Apellido.setBackground(new java.awt.Color(58, 80, 107));
        txt_Apellido.setForeground(new java.awt.Color(255, 255, 255));
        txt_Apellido.setBorder(null);

        lbl_Ocupacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Ocupacion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Ocupacion.setText("Ocupacion:");

        txt_Ocupacion.setBackground(new java.awt.Color(58, 80, 107));
        txt_Ocupacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_Ocupacion.setBorder(null);

        lbl_Salario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Salario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Salario.setText("Salario:");

        lbl_Telefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Telefono.setText("Telefono:");

        lbl_Correo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Correo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Correo.setText("Correo:");

        txt_Salario.setBackground(new java.awt.Color(58, 80, 107));
        txt_Salario.setForeground(new java.awt.Color(255, 255, 255));
        txt_Salario.setBorder(null);
        txt_Salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SalarioActionPerformed(evt);
            }
        });

        txt_Telefono.setBackground(new java.awt.Color(58, 80, 107));
        txt_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_Telefono.setBorder(null);

        txt_Correo.setBackground(new java.awt.Color(58, 80, 107));
        txt_Correo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Correo.setBorder(null);

        guardarPersonal.setBackground(new java.awt.Color(255, 255, 255));
        guardarPersonal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        guardarPersonal.setForeground(new java.awt.Color(58, 80, 107));
        guardarPersonal.setText("Guardar");
        guardarPersonal.setBorder(null);
        guardarPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarPersonalMouseClicked(evt);
            }
        });

        txt_Contra.setBackground(new java.awt.Color(58, 80, 107));
        txt_Contra.setForeground(new java.awt.Color(255, 255, 255));
        txt_Contra.setBorder(null);

        lbl_Contra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Contra.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Contra.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Contra)
                    .addComponent(txt_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Apellido)
                            .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Nombre)
                            .addComponent(lbl_Ocupacion)
                            .addComponent(txt_Ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Salario)
                            .addComponent(txt_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Telefono)
                            .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Correo)
                            .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_Personal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Nombre)
                .addGap(0, 0, 0)
                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Apellido)
                .addGap(0, 0, 0)
                .addComponent(txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Ocupacion)
                .addGap(0, 0, 0)
                .addComponent(txt_Ocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Salario)
                .addGap(0, 0, 0)
                .addComponent(txt_Salario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Telefono)
                .addGap(0, 0, 0)
                .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Correo)
                .addGap(0, 0, 0)
                .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Contra)
                .addGap(0, 0, 0)
                .addComponent(txt_Contra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(guardarPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        lbl_Personal.getAccessibleContext().setAccessibleName("lbl_Personal");
        lbl_Personal.getAccessibleContext().setAccessibleParent(lbl_Personal);
        txt_Nombre.getAccessibleContext().setAccessibleName("txt_Nombre");
        txt_Nombre.getAccessibleContext().setAccessibleParent(txt_Nombre);
        lbl_Nombre.getAccessibleContext().setAccessibleName("lbl_Nombre");
        lbl_Nombre.getAccessibleContext().setAccessibleDescription("");
        lbl_Nombre.getAccessibleContext().setAccessibleParent(lbl_Nombre);
        lbl_Apellido.getAccessibleContext().setAccessibleName("lbl_Apellido");
        lbl_Apellido.getAccessibleContext().setAccessibleParent(lbl_Apellido);
        txt_Apellido.getAccessibleContext().setAccessibleName("txt_Apellido");
        txt_Apellido.getAccessibleContext().setAccessibleParent(txt_Apellido);
        lbl_Ocupacion.getAccessibleContext().setAccessibleName("lbl_Ocupacion");
        lbl_Ocupacion.getAccessibleContext().setAccessibleParent(lbl_Ocupacion);
        txt_Ocupacion.getAccessibleContext().setAccessibleName("txt_Ocupacion");
        txt_Ocupacion.getAccessibleContext().setAccessibleParent(txt_Ocupacion);
        lbl_Salario.getAccessibleContext().setAccessibleName("lbl_Salario");
        lbl_Salario.getAccessibleContext().setAccessibleParent(lbl_Salario);
        lbl_Telefono.getAccessibleContext().setAccessibleName("lbl_Telefono");
        lbl_Telefono.getAccessibleContext().setAccessibleParent(lbl_Telefono);
        lbl_Correo.getAccessibleContext().setAccessibleName("lbl_Correo");
        lbl_Correo.getAccessibleContext().setAccessibleParent(lbl_Correo);
        txt_Salario.getAccessibleContext().setAccessibleName("txt_Salario");
        txt_Salario.getAccessibleContext().setAccessibleParent(txt_Salario);
        txt_Telefono.getAccessibleContext().setAccessibleName("txt_Telefono");
        txt_Telefono.getAccessibleContext().setAccessibleDescription("");
        txt_Telefono.getAccessibleContext().setAccessibleParent(txt_Telefono);
        txt_Correo.getAccessibleContext().setAccessibleName("txt_Correo");
        txt_Correo.getAccessibleContext().setAccessibleParent(txt_Correo);
        guardarPersonal.getAccessibleContext().setAccessibleName("guardarPersonal");
        guardarPersonal.getAccessibleContext().setAccessibleParent(guardarPersonal);
        txt_Contra.getAccessibleContext().setAccessibleName("txt_Contra");
        txt_Contra.getAccessibleContext().setAccessibleParent(txt_Contra);
        lbl_Contra.getAccessibleContext().setAccessibleName("lbl_Contra");
        lbl_Contra.getAccessibleContext().setAccessibleParent(lbl_Contra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarPersonalMouseClicked
        controladorPersonal.ComprobarEdicion();
    }//GEN-LAST:event_guardarPersonalMouseClicked

    private void txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NombreActionPerformed

    private void txt_SalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SalarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton guardarPersonal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Apellido;
    public javax.swing.JLabel lbl_Contra;
    public javax.swing.JLabel lbl_Correo;
    private javax.swing.JLabel lbl_Nombre;
    public javax.swing.JLabel lbl_Ocupacion;
    private javax.swing.JLabel lbl_Personal;
    public javax.swing.JLabel lbl_Salario;
    public javax.swing.JLabel lbl_Telefono;
    public javax.swing.JTextField txt_Apellido;
    public javax.swing.JTextField txt_Contra;
    public javax.swing.JTextField txt_Correo;
    public javax.swing.JTextField txt_Nombre;
    public javax.swing.JTextField txt_Ocupacion;
    public javax.swing.JTextField txt_Salario;
    public javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}
