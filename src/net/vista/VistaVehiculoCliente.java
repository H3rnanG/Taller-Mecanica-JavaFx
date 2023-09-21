package net.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.controlador.ControladorClienteVehiculo;

public class VistaVehiculoCliente extends javax.swing.JFrame {
    private ControladorClienteVehiculo controladorClienteVehiculo;
    
    public VistaVehiculoCliente(ControladorClienteVehiculo controladorClienteVehiculo) {
        this.controladorClienteVehiculo = controladorClienteVehiculo;
        
        initComponents();
        
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controladorClienteVehiculo.CerrarVista();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Personal = new javax.swing.JLabel();
        lbl_PlacaAsignar = new javax.swing.JLabel();
        lbl_ClienteAsignar = new javax.swing.JLabel();
        cmb_ClienteAsignar = new javax.swing.JComboBox<>();
        txt_PlacaAsignar = new javax.swing.JTextField();
        btn_GuardarAsignarC = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));

        lbl_Personal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_Personal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Personal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Personal.setText("ASIGNAR");
        lbl_Personal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_PlacaAsignar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_PlacaAsignar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_PlacaAsignar.setText("Placa:");

        lbl_ClienteAsignar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_ClienteAsignar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ClienteAsignar.setText("Cliente:");

        cmb_ClienteAsignar.setBackground(new java.awt.Color(58, 80, 107));
        cmb_ClienteAsignar.setForeground(new java.awt.Color(255, 255, 255));

        txt_PlacaAsignar.setBackground(new java.awt.Color(58, 80, 107));
        txt_PlacaAsignar.setForeground(new java.awt.Color(255, 255, 255));
        txt_PlacaAsignar.setBorder(null);

        btn_GuardarAsignarC.setBackground(new java.awt.Color(255, 255, 255));
        btn_GuardarAsignarC.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn_GuardarAsignarC.setForeground(new java.awt.Color(58, 80, 107));
        btn_GuardarAsignarC.setText("Guardar");
        btn_GuardarAsignarC.setBorder(null);
        btn_GuardarAsignarC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GuardarAsignarCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_PlacaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_ClienteAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_PlacaAsignar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_GuardarAsignarC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                        .addComponent(cmb_ClienteAsignar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_Personal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_PlacaAsignar)
                .addGap(0, 0, 0)
                .addComponent(txt_PlacaAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_ClienteAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmb_ClienteAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_GuardarAsignarC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lbl_PlacaAsignar.getAccessibleContext().setAccessibleName("lbl_PlacaAsignar");
        lbl_PlacaAsignar.getAccessibleContext().setAccessibleParent(lbl_PlacaAsignar);
        lbl_ClienteAsignar.getAccessibleContext().setAccessibleName("lbl_ClienteAsignar");
        lbl_ClienteAsignar.getAccessibleContext().setAccessibleParent(lbl_ClienteAsignar);
        cmb_ClienteAsignar.getAccessibleContext().setAccessibleName("cmb_ClienteAsignar");
        cmb_ClienteAsignar.getAccessibleContext().setAccessibleParent(cmb_ClienteAsignar);
        txt_PlacaAsignar.getAccessibleContext().setAccessibleName("txt_PlacaAsignar");
        txt_PlacaAsignar.getAccessibleContext().setAccessibleParent(txt_PlacaAsignar);
        btn_GuardarAsignarC.getAccessibleContext().setAccessibleName("btn_GuardarAsignarC");
        btn_GuardarAsignarC.getAccessibleContext().setAccessibleParent(btn_GuardarAsignarC);

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

    private void btn_GuardarAsignarCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuardarAsignarCMouseClicked
        controladorClienteVehiculo.CrearAsignarCliente();
    }//GEN-LAST:event_btn_GuardarAsignarCMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_GuardarAsignarC;
    public javax.swing.JComboBox<String> cmb_ClienteAsignar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_ClienteAsignar;
    private javax.swing.JLabel lbl_Personal;
    private javax.swing.JLabel lbl_PlacaAsignar;
    public javax.swing.JTextField txt_PlacaAsignar;
    // End of variables declaration//GEN-END:variables
}
