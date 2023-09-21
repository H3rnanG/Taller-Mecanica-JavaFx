package net.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import net.controlador.ControladorVehiculo;

public class VistaVehiculo extends javax.swing.JFrame {
    private ControladorVehiculo controladorVehiculo;
    
    public VistaVehiculo(ControladorVehiculo controladorVehiculo) {
        this.controladorVehiculo = controladorVehiculo;
        
        initComponents();
        
        // Configura la operación de cierre de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controladorVehiculo.CerrarVista();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Personal = new javax.swing.JLabel();
        txt_Placa = new javax.swing.JTextField();
        lbl_Placa = new javax.swing.JLabel();
        lbl_Kilometraje = new javax.swing.JLabel();
        txt_Kilometraje = new javax.swing.JTextField();
        lbl_Modelo = new javax.swing.JLabel();
        txt_Modelo = new javax.swing.JTextField();
        lbl_Marca = new javax.swing.JLabel();
        lbl_Color = new javax.swing.JLabel();
        lbl_NumeroSerie = new javax.swing.JLabel();
        txt_Marca = new javax.swing.JTextField();
        txt_Color = new javax.swing.JTextField();
        txt_NumeroSerie = new javax.swing.JTextField();
        btn_Guardar = new javax.swing.JButton();
        lbl_NumeroServicios = new javax.swing.JLabel();
        lbl_NumeroChasis = new javax.swing.JLabel();
        txt_FechaFabricacion = new javax.swing.JFormattedTextField();
        lbl_FechaFabricacion = new javax.swing.JLabel();
        txt_NumeroServicios = new javax.swing.JTextField();
        txt_NumeroChasis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(11, 19, 43));

        lbl_Personal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lbl_Personal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Personal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Personal.setText("VEHICULO");
        lbl_Personal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_Placa.setBackground(new java.awt.Color(58, 80, 107));
        txt_Placa.setForeground(new java.awt.Color(255, 255, 255));
        txt_Placa.setBorder(null);

        lbl_Placa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Placa.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Placa.setText("Placa:");

        lbl_Kilometraje.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Kilometraje.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Kilometraje.setText("Kilometraje:");

        txt_Kilometraje.setBackground(new java.awt.Color(58, 80, 107));
        txt_Kilometraje.setForeground(new java.awt.Color(255, 255, 255));
        txt_Kilometraje.setBorder(null);

        lbl_Modelo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Modelo.setText("Modelo:");

        txt_Modelo.setBackground(new java.awt.Color(58, 80, 107));
        txt_Modelo.setForeground(new java.awt.Color(255, 255, 255));
        txt_Modelo.setBorder(null);

        lbl_Marca.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Marca.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Marca.setText("Marca:");

        lbl_Color.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_Color.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Color.setText("Color:");

        lbl_NumeroSerie.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NumeroSerie.setText("Numero de Serie:");

        txt_Marca.setBackground(new java.awt.Color(58, 80, 107));
        txt_Marca.setForeground(new java.awt.Color(255, 255, 255));
        txt_Marca.setBorder(null);

        txt_Color.setBackground(new java.awt.Color(58, 80, 107));
        txt_Color.setForeground(new java.awt.Color(255, 255, 255));
        txt_Color.setBorder(null);

        txt_NumeroSerie.setBackground(new java.awt.Color(58, 80, 107));
        txt_NumeroSerie.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroSerie.setBorder(null);

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

        lbl_NumeroServicios.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_NumeroServicios.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NumeroServicios.setText("Numero de Servicios:");

        lbl_NumeroChasis.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_NumeroChasis.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NumeroChasis.setText("Numero de Chasis:");

        txt_FechaFabricacion.setBackground(new java.awt.Color(58, 80, 107));
        txt_FechaFabricacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_FechaFabricacion.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        lbl_FechaFabricacion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lbl_FechaFabricacion.setForeground(new java.awt.Color(255, 255, 255));
        lbl_FechaFabricacion.setText("Fecha de Fabricacion:");

        txt_NumeroServicios.setBackground(new java.awt.Color(58, 80, 107));
        txt_NumeroServicios.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroServicios.setBorder(null);

        txt_NumeroChasis.setBackground(new java.awt.Color(58, 80, 107));
        txt_NumeroChasis.setForeground(new java.awt.Color(255, 255, 255));
        txt_NumeroChasis.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Personal, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_FechaFabricacion)
                            .addComponent(lbl_NumeroChasis)
                            .addComponent(lbl_NumeroServicios)
                            .addComponent(txt_Placa, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(lbl_Kilometraje)
                            .addComponent(txt_Kilometraje, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(lbl_Placa)
                            .addComponent(lbl_Modelo)
                            .addComponent(txt_Modelo, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(lbl_Marca)
                            .addComponent(txt_Marca, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txt_Color, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(lbl_NumeroSerie)
                            .addComponent(txt_NumeroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(lbl_Color)
                            .addComponent(btn_Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txt_NumeroServicios)
                            .addComponent(txt_NumeroChasis)
                            .addComponent(txt_FechaFabricacion))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbl_Personal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Placa)
                .addGap(0, 0, 0)
                .addComponent(txt_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Kilometraje)
                .addGap(0, 0, 0)
                .addComponent(txt_Kilometraje, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Modelo)
                .addGap(0, 0, 0)
                .addComponent(txt_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Marca)
                .addGap(0, 0, 0)
                .addComponent(txt_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_Color, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt_Color, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_NumeroSerie)
                .addGap(0, 0, 0)
                .addComponent(txt_NumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_NumeroServicios)
                .addGap(0, 0, 0)
                .addComponent(txt_NumeroServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_NumeroChasis)
                .addGap(0, 0, 0)
                .addComponent(txt_NumeroChasis, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbl_FechaFabricacion)
                .addGap(0, 0, 0)
                .addComponent(txt_FechaFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        lbl_Personal.getAccessibleContext().setAccessibleName("lbl_Personal");
        lbl_Personal.getAccessibleContext().setAccessibleParent(lbl_Personal);
        txt_Placa.getAccessibleContext().setAccessibleName("txt_Placa");
        txt_Placa.getAccessibleContext().setAccessibleParent(txt_Placa);
        lbl_Placa.getAccessibleContext().setAccessibleName("lbl_Placa");
        lbl_Placa.getAccessibleContext().setAccessibleDescription("");
        lbl_Placa.getAccessibleContext().setAccessibleParent(lbl_Placa);
        lbl_Kilometraje.getAccessibleContext().setAccessibleName("lbl_Kilometraje");
        lbl_Kilometraje.getAccessibleContext().setAccessibleParent(lbl_Kilometraje);
        txt_Kilometraje.getAccessibleContext().setAccessibleName("txt_Kilometraje");
        txt_Kilometraje.getAccessibleContext().setAccessibleParent(txt_Kilometraje);
        lbl_Modelo.getAccessibleContext().setAccessibleName("lbl_Modelo");
        lbl_Modelo.getAccessibleContext().setAccessibleParent(lbl_Modelo);
        txt_Modelo.getAccessibleContext().setAccessibleName("txt_Modelo");
        txt_Modelo.getAccessibleContext().setAccessibleParent(txt_Modelo);
        lbl_Marca.getAccessibleContext().setAccessibleName("lbl_Marca");
        lbl_Marca.getAccessibleContext().setAccessibleParent(lbl_Marca);
        lbl_Color.getAccessibleContext().setAccessibleName("lbl_Color");
        lbl_Color.getAccessibleContext().setAccessibleParent(lbl_Color);
        lbl_NumeroSerie.getAccessibleContext().setAccessibleName("lbl_NumeroSerie");
        lbl_NumeroSerie.getAccessibleContext().setAccessibleParent(lbl_NumeroSerie);
        txt_Marca.getAccessibleContext().setAccessibleName("txt_Marca");
        txt_Marca.getAccessibleContext().setAccessibleParent(txt_Marca);
        txt_Color.getAccessibleContext().setAccessibleName("txt_Color");
        txt_Color.getAccessibleContext().setAccessibleDescription("");
        txt_Color.getAccessibleContext().setAccessibleParent(txt_Color);
        txt_NumeroSerie.getAccessibleContext().setAccessibleName("txt_NumeroSerie");
        txt_NumeroSerie.getAccessibleContext().setAccessibleParent(txt_NumeroSerie);
        btn_Guardar.getAccessibleContext().setAccessibleName("btn_Guardar");
        btn_Guardar.getAccessibleContext().setAccessibleParent(btn_Guardar);
        lbl_NumeroServicios.getAccessibleContext().setAccessibleName("lbl_NumeroServicios");
        lbl_NumeroServicios.getAccessibleContext().setAccessibleParent(lbl_NumeroServicios);
        lbl_NumeroChasis.getAccessibleContext().setAccessibleName("lbl_NumeroChasis");
        lbl_NumeroChasis.getAccessibleContext().setAccessibleParent(lbl_NumeroChasis);
        txt_FechaFabricacion.getAccessibleContext().setAccessibleName("txt_FechaFabricacion");
        txt_FechaFabricacion.getAccessibleContext().setAccessibleParent(txt_FechaFabricacion);
        lbl_FechaFabricacion.getAccessibleContext().setAccessibleName("lbl_FechaFabricacion");
        lbl_FechaFabricacion.getAccessibleContext().setAccessibleParent(lbl_FechaFabricacion);
        txt_NumeroServicios.getAccessibleContext().setAccessibleName("txt_NumeroServicios");
        txt_NumeroServicios.getAccessibleContext().setAccessibleParent(txt_NumeroServicios);
        txt_NumeroChasis.getAccessibleContext().setAccessibleName("txt_NumeroChasis");
        txt_NumeroChasis.getAccessibleContext().setAccessibleParent(txt_NumeroChasis);

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
        controladorVehiculo.ComprobarEdicion();
    }//GEN-LAST:event_btn_GuardarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Guardar;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lbl_Color;
    private javax.swing.JLabel lbl_FechaFabricacion;
    private javax.swing.JLabel lbl_Kilometraje;
    public javax.swing.JLabel lbl_Marca;
    public javax.swing.JLabel lbl_Modelo;
    private javax.swing.JLabel lbl_NumeroChasis;
    public javax.swing.JLabel lbl_NumeroSerie;
    private javax.swing.JLabel lbl_NumeroServicios;
    private javax.swing.JLabel lbl_Personal;
    private javax.swing.JLabel lbl_Placa;
    public javax.swing.JTextField txt_Color;
    public javax.swing.JFormattedTextField txt_FechaFabricacion;
    public javax.swing.JTextField txt_Kilometraje;
    public javax.swing.JTextField txt_Marca;
    public javax.swing.JTextField txt_Modelo;
    public javax.swing.JTextField txt_NumeroChasis;
    public javax.swing.JTextField txt_NumeroSerie;
    public javax.swing.JTextField txt_NumeroServicios;
    public javax.swing.JTextField txt_Placa;
    // End of variables declaration//GEN-END:variables
}
