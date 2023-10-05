package net.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.controlador.ControladorServicioPagado;

public class VistaPagarServicio extends javax.swing.JFrame {
    private ControladorServicioPagado controladorServicioPagado;

    public VistaPagarServicio(ControladorServicioPagado controladorServicioPagado) {
        this.controladorServicioPagado = controladorServicioPagado;
        initComponents();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controladorServicioPagado.CerrarVista();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Personal = new javax.swing.JLabel();
        lbl_MetodoPago = new javax.swing.JLabel();
        lbl_ComprobantePago = new javax.swing.JLabel();
        cmb_ComprobantePago = new javax.swing.JComboBox<>();
        lbl_servicioPago = new javax.swing.JLabel();
        txt_servicioPago = new javax.swing.JTextField();
        btn_GuardarAsignarC = new javax.swing.JButton();
        cmb_MetodoPago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));

        lbl_Personal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_Personal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Personal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Personal.setText("ASIGNAR");
        lbl_Personal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_MetodoPago.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_MetodoPago.setForeground(new java.awt.Color(255, 255, 255));
        lbl_MetodoPago.setText("Metodo de Pago:");

        lbl_ComprobantePago.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_ComprobantePago.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ComprobantePago.setText("Comprobante de Pago:");

        cmb_ComprobantePago.setBackground(new java.awt.Color(58, 80, 107));
        cmb_ComprobantePago.setForeground(new java.awt.Color(255, 255, 255));

        lbl_servicioPago.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_servicioPago.setForeground(new java.awt.Color(255, 255, 255));
        lbl_servicioPago.setText("Servicio:");

        txt_servicioPago.setBackground(new java.awt.Color(58, 80, 107));
        txt_servicioPago.setForeground(new java.awt.Color(255, 255, 255));
        txt_servicioPago.setBorder(null);

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

        cmb_MetodoPago.setBackground(new java.awt.Color(58, 80, 107));
        cmb_MetodoPago.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_servicioPago, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmb_ComprobantePago, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_ComprobantePago, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_MetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_MetodoPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_GuardarAsignarC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(txt_servicioPago, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbl_Personal)
                .addGap(6, 6, 6)
                .addComponent(lbl_MetodoPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_MetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lbl_ComprobantePago, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(cmb_ComprobantePago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_servicioPago, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(txt_servicioPago, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_GuardarAsignarC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lbl_MetodoPago.getAccessibleContext().setAccessibleName("lbl_MetodoPago");
        lbl_MetodoPago.getAccessibleContext().setAccessibleParent(lbl_MetodoPago);
        lbl_ComprobantePago.getAccessibleContext().setAccessibleName("lbl_ComprobantePago");
        lbl_ComprobantePago.getAccessibleContext().setAccessibleDescription("");
        lbl_ComprobantePago.getAccessibleContext().setAccessibleParent(lbl_ComprobantePago);
        cmb_ComprobantePago.getAccessibleContext().setAccessibleName("cmb_ComprobantePago");
        cmb_ComprobantePago.getAccessibleContext().setAccessibleParent(cmb_ComprobantePago);
        lbl_servicioPago.getAccessibleContext().setAccessibleName("lbl_servicioPago");
        lbl_servicioPago.getAccessibleContext().setAccessibleDescription("");
        lbl_servicioPago.getAccessibleContext().setAccessibleParent(lbl_servicioPago);
        txt_servicioPago.getAccessibleContext().setAccessibleName("txt_servicioPago");
        txt_servicioPago.getAccessibleContext().setAccessibleDescription("");
        txt_servicioPago.getAccessibleContext().setAccessibleParent(txt_servicioPago);
        cmb_MetodoPago.getAccessibleContext().setAccessibleName("cmb_MetodoPago");
        cmb_MetodoPago.getAccessibleContext().setAccessibleParent(cmb_MetodoPago);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GuardarAsignarCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuardarAsignarCMouseClicked
        controladorServicioPagado.PagarServicio();
    }//GEN-LAST:event_btn_GuardarAsignarCMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_GuardarAsignarC;
    public javax.swing.JComboBox<String> cmb_ComprobantePago;
    public javax.swing.JComboBox<String> cmb_MetodoPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_ComprobantePago;
    private javax.swing.JLabel lbl_MetodoPago;
    private javax.swing.JLabel lbl_Personal;
    private javax.swing.JLabel lbl_servicioPago;
    public javax.swing.JTextField txt_servicioPago;
    // End of variables declaration//GEN-END:variables
}
