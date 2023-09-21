package net.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.controlador.ControladorCliente;

public class VistaCliente extends javax.swing.JFrame {
    private ControladorCliente controladorCliente;
    
    public VistaCliente(ControladorCliente controladorCliente) {
        this.controladorCliente = controladorCliente;

        initComponents();
        
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controladorCliente.CerrarVista();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Personal = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        lbl_NombreRazon = new javax.swing.JLabel();
        lbl_TipoDocumento = new javax.swing.JLabel();
        lbl_NumeroDocumento = new javax.swing.JLabel();
        txt_NumeroDocumento = new javax.swing.JTextField();
        lbl_Direccion = new javax.swing.JLabel();
        lbl_Telefono = new javax.swing.JLabel();
        lbl_Correo = new javax.swing.JLabel();
        txt_Direccion = new javax.swing.JTextField();
        txt_Telefono = new javax.swing.JTextField();
        txt_Correo = new javax.swing.JTextField();
        btn_Guardar = new javax.swing.JButton();
        cmb_TipoDocumento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));

        lbl_Personal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_Personal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Personal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Personal.setText("CLIENTE");
        lbl_Personal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_Nombre.setBackground(new java.awt.Color(58, 80, 107));
        txt_Nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_Nombre.setBorder(null);

        lbl_NombreRazon.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_NombreRazon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NombreRazon.setText("Nombre / Razon Social:");

        lbl_TipoDocumento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_TipoDocumento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_TipoDocumento.setText("Tipo de Documento:");

        lbl_NumeroDocumento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_NumeroDocumento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NumeroDocumento.setText("Numero de Documento:");

        txt_NumeroDocumento.setBackground(new java.awt.Color(58, 80, 107));
        txt_NumeroDocumento.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroDocumento.setBorder(null);

        lbl_Direccion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Direccion.setText("Direccion:");

        lbl_Telefono.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Telefono.setText("Telefono:");

        lbl_Correo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Correo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Correo.setText("Correo:");

        txt_Direccion.setBackground(new java.awt.Color(58, 80, 107));
        txt_Direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_Direccion.setBorder(null);

        txt_Telefono.setBackground(new java.awt.Color(58, 80, 107));
        txt_Telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_Telefono.setBorder(null);

        txt_Correo.setBackground(new java.awt.Color(58, 80, 107));
        txt_Correo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Correo.setBorder(null);

        btn_Guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_Guardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_Guardar.setForeground(new java.awt.Color(58, 80, 107));
        btn_Guardar.setText("Guardar");
        btn_Guardar.setBorder(null);
        btn_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GuardarMouseClicked(evt);
            }
        });

        cmb_TipoDocumento.setBackground(new java.awt.Color(58, 80, 107));
        cmb_TipoDocumento.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cmb_TipoDocumento.setForeground(new java.awt.Color(255, 255, 255));
        cmb_TipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_Personal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_TipoDocumento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Nombre)
                    .addComponent(txt_NumeroDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(txt_Direccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(txt_Telefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(txt_Correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_TipoDocumento)
                            .addComponent(lbl_NombreRazon)
                            .addComponent(lbl_NumeroDocumento)
                            .addComponent(lbl_Direccion)
                            .addComponent(lbl_Telefono)
                            .addComponent(lbl_Correo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_Personal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_NombreRazon)
                .addGap(0, 0, 0)
                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_TipoDocumento)
                .addGap(0, 0, 0)
                .addComponent(cmb_TipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_NumeroDocumento)
                .addGap(0, 0, 0)
                .addComponent(txt_NumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Direccion)
                .addGap(0, 0, 0)
                .addComponent(txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Telefono)
                .addGap(0, 0, 0)
                .addComponent(txt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Correo)
                .addGap(0, 0, 0)
                .addComponent(txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lbl_Personal.getAccessibleContext().setAccessibleName("lbl_Personal");
        lbl_Personal.getAccessibleContext().setAccessibleParent(lbl_Personal);
        txt_Nombre.getAccessibleContext().setAccessibleName("txt_Nombre");
        txt_Nombre.getAccessibleContext().setAccessibleParent(txt_Nombre);
        lbl_NombreRazon.getAccessibleContext().setAccessibleName("lbl_NombreRazon");
        lbl_NombreRazon.getAccessibleContext().setAccessibleDescription("");
        lbl_NombreRazon.getAccessibleContext().setAccessibleParent(lbl_NombreRazon);
        lbl_TipoDocumento.getAccessibleContext().setAccessibleName("lbl_TipoDocumento");
        lbl_TipoDocumento.getAccessibleContext().setAccessibleParent(lbl_TipoDocumento);
        lbl_NumeroDocumento.getAccessibleContext().setAccessibleName("lbl_NumeroDocumento");
        lbl_NumeroDocumento.getAccessibleContext().setAccessibleParent(lbl_NumeroDocumento);
        txt_NumeroDocumento.getAccessibleContext().setAccessibleName("txt_NumeroDocumento");
        txt_NumeroDocumento.getAccessibleContext().setAccessibleParent(txt_NumeroDocumento);
        lbl_Direccion.getAccessibleContext().setAccessibleName("lbl_Direccion");
        lbl_Direccion.getAccessibleContext().setAccessibleParent(lbl_Direccion);
        lbl_Telefono.getAccessibleContext().setAccessibleName("lbl_Telefono");
        lbl_Telefono.getAccessibleContext().setAccessibleParent(lbl_Telefono);
        lbl_Correo.getAccessibleContext().setAccessibleName("lbl_Correo");
        lbl_Correo.getAccessibleContext().setAccessibleParent(lbl_Correo);
        txt_Direccion.getAccessibleContext().setAccessibleName("txt_Direccion");
        txt_Direccion.getAccessibleContext().setAccessibleParent(txt_Direccion);
        txt_Telefono.getAccessibleContext().setAccessibleName("txt_Telefono");
        txt_Telefono.getAccessibleContext().setAccessibleDescription("");
        txt_Telefono.getAccessibleContext().setAccessibleParent(txt_Telefono);
        txt_Correo.getAccessibleContext().setAccessibleName("txt_Correo");
        txt_Correo.getAccessibleContext().setAccessibleParent(txt_Correo);
        btn_Guardar.getAccessibleContext().setAccessibleName("btn_Guardar");
        btn_Guardar.getAccessibleContext().setAccessibleDescription("");
        btn_Guardar.getAccessibleContext().setAccessibleParent(btn_Guardar);
        cmb_TipoDocumento.getAccessibleContext().setAccessibleName("cmb_TipoDocumento");
        cmb_TipoDocumento.getAccessibleContext().setAccessibleDescription("");
        cmb_TipoDocumento.getAccessibleContext().setAccessibleParent(cmb_TipoDocumento);

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

    private void btn_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuardarMouseClicked
        controladorCliente.ComprobarEdicion();
    }//GEN-LAST:event_btn_GuardarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Guardar;
    public javax.swing.JComboBox<String> cmb_TipoDocumento;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lbl_Correo;
    public javax.swing.JLabel lbl_Direccion;
    private javax.swing.JLabel lbl_NombreRazon;
    public javax.swing.JLabel lbl_NumeroDocumento;
    private javax.swing.JLabel lbl_Personal;
    public javax.swing.JLabel lbl_Telefono;
    private javax.swing.JLabel lbl_TipoDocumento;
    public javax.swing.JTextField txt_Correo;
    public javax.swing.JTextField txt_Direccion;
    public javax.swing.JTextField txt_Nombre;
    public javax.swing.JTextField txt_NumeroDocumento;
    public javax.swing.JTextField txt_Telefono;
    // End of variables declaration//GEN-END:variables
}
