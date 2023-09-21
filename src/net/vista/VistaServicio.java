package net.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.controlador.ControladorServicio;

public class VistaServicio extends javax.swing.JFrame {
    private ControladorServicio controladorServicio;
    
    public VistaServicio(ControladorServicio controladorServicio) {
        this.controladorServicio = controladorServicio;
        
        initComponents();
        
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controladorServicio.CerrarVista();
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

        jPanel1 = new javax.swing.JPanel();
        lbl_Servicio = new javax.swing.JLabel();
        cmb_Personal = new javax.swing.JLabel();
        lbl_Apellido = new javax.swing.JLabel();
        lbl_Ocupacion = new javax.swing.JLabel();
        txt_PrecioServicio = new javax.swing.JTextField();
        lbl_Salario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmb_PersonalServicio = new javax.swing.JComboBox<>();
        cmb_PlacaServicio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_DescripcionServicio = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));

        lbl_Servicio.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_Servicio.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Servicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Servicio.setText("SERVICIO");
        lbl_Servicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cmb_Personal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cmb_Personal.setForeground(new java.awt.Color(255, 255, 255));
        cmb_Personal.setText("Personal:");

        lbl_Apellido.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Apellido.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Apellido.setText("Placa:");

        lbl_Ocupacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Ocupacion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Ocupacion.setText("Precio Servicio:");

        txt_PrecioServicio.setBackground(new java.awt.Color(58, 80, 107));
        txt_PrecioServicio.setForeground(new java.awt.Color(255, 255, 255));
        txt_PrecioServicio.setBorder(null);

        lbl_Salario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Salario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Salario.setText("Descripcion:");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(11, 19, 43));
        jButton1.setText("Guardar");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        cmb_PersonalServicio.setBackground(new java.awt.Color(58, 80, 107));
        cmb_PersonalServicio.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cmb_PersonalServicio.setForeground(new java.awt.Color(255, 255, 255));

        cmb_PlacaServicio.setBackground(new java.awt.Color(58, 80, 107));
        cmb_PlacaServicio.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cmb_PlacaServicio.setForeground(new java.awt.Color(255, 255, 255));

        txt_DescripcionServicio.setBackground(new java.awt.Color(58, 80, 107));
        txt_DescripcionServicio.setColumns(1);
        txt_DescripcionServicio.setForeground(new java.awt.Color(255, 255, 255));
        txt_DescripcionServicio.setLineWrap(true);
        txt_DescripcionServicio.setRows(8);
        txt_DescripcionServicio.setAutoscrolls(false);
        txt_DescripcionServicio.setBorder(null);
        txt_DescripcionServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(txt_DescripcionServicio);
        txt_DescripcionServicio.getAccessibleContext().setAccessibleName("txt_DescripcionServicio");
        txt_DescripcionServicio.getAccessibleContext().setAccessibleParent(txt_DescripcionServicio);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbl_Apellido)
                                .addComponent(cmb_Personal)
                                .addComponent(lbl_Ocupacion)
                                .addComponent(txt_PrecioServicio, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(lbl_Salario)
                                .addComponent(cmb_PersonalServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_PlacaServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_Servicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_Servicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Personal)
                .addGap(1, 1, 1)
                .addComponent(cmb_PersonalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Apellido)
                .addGap(0, 0, 0)
                .addComponent(cmb_PlacaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Ocupacion)
                .addGap(0, 0, 0)
                .addComponent(txt_PrecioServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Salario)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        lbl_Servicio.getAccessibleContext().setAccessibleName("lbl_Servicio");
        lbl_Servicio.getAccessibleContext().setAccessibleParent(lbl_Servicio);
        cmb_Personal.getAccessibleContext().setAccessibleName("cmb_Personal");
        cmb_Personal.getAccessibleContext().setAccessibleDescription("");
        cmb_Personal.getAccessibleContext().setAccessibleParent(cmb_Personal);
        lbl_Apellido.getAccessibleContext().setAccessibleName("lbl_Apellido");
        lbl_Apellido.getAccessibleContext().setAccessibleParent(lbl_Apellido);
        lbl_Ocupacion.getAccessibleContext().setAccessibleName("lbl_Ocupacion");
        lbl_Ocupacion.getAccessibleContext().setAccessibleParent(lbl_Ocupacion);
        txt_PrecioServicio.getAccessibleContext().setAccessibleName("txt_PrecioServicio");
        txt_PrecioServicio.getAccessibleContext().setAccessibleParent(txt_PrecioServicio);
        lbl_Salario.getAccessibleContext().setAccessibleName("lbl_Salario");
        lbl_Salario.getAccessibleContext().setAccessibleParent(lbl_Salario);
        cmb_PersonalServicio.getAccessibleContext().setAccessibleName("cmb_PersonalServicio");
        cmb_PersonalServicio.getAccessibleContext().setAccessibleDescription("");
        cmb_PersonalServicio.getAccessibleContext().setAccessibleParent(cmb_PersonalServicio);
        cmb_PlacaServicio.getAccessibleContext().setAccessibleName("cmb_PlacaServicio");
        cmb_PlacaServicio.getAccessibleContext().setAccessibleParent(cmb_PlacaServicio);

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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        controladorServicio.ComprobarEdicion();
    }//GEN-LAST:event_jButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cmb_Personal;
    public javax.swing.JComboBox<String> cmb_PersonalServicio;
    public javax.swing.JComboBox<String> cmb_PlacaServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Apellido;
    public javax.swing.JLabel lbl_Ocupacion;
    public javax.swing.JLabel lbl_Salario;
    private javax.swing.JLabel lbl_Servicio;
    public javax.swing.JTextArea txt_DescripcionServicio;
    public javax.swing.JTextField txt_PrecioServicio;
    // End of variables declaration//GEN-END:variables
}
