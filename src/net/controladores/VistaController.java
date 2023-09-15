package net.controladores;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.controlador.exceptions.NonexistentEntityException;
import net.modelo.Cliente;
import net.modelo.HistorialCliente;
import net.vista.VistaCliente;
import net.vista.VistaHistorialCliente;
import net.vista.VistaPersonal;
import net.vista.VistaPrincipal;

public class VistaController {

    private VistaPrincipal vistaPrincipal;
    
    private VistaCliente vistaCliente;
    private ClienteJpaController clienteJpaController;
    private VistaHistorialCliente vistaHistorialCliente;
    
    private VistaPersonal vistaPersonal;
    private PersonalJpaController personalJpaController;
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Taller_MecanicaPU");

    public VistaController() {

    }
    
    public void principalView(){
        vistaPrincipal = new VistaPrincipal();
        clienteJpaController = new ClienteJpaController(emf);
        personalJpaController = new PersonalJpaController(emf);
        
        CargarClientes();
        
        vistaPrincipal.setVistaController(this);
        vistaPrincipal.setVisible(true);
    }
    
    public void CargarClientes(){
        List<Cliente> clientes = clienteJpaController.findClienteEntities();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.jTableCliente.getModel();
        
        modeloTabla.setRowCount(0);
        
        for (Cliente cliente : clientes) {
            modeloTabla.addRow(new Object[] {
                cliente.getIdCliente(),
                cliente.getNombreRazonSocial(),
                cliente.getTipoDocumento(),
                cliente.getNumeroDocumento(),
                cliente.getTelefonoCliente(),
                cliente.getCorreoCliente(),
                cliente.getDireccionCliente()
            });
        }
        
        modeloTabla.fireTableDataChanged();
    }
    
    public void CreateClienteView(){
        if (vistaCliente == null) {
            vistaCliente = new VistaCliente();
        }
        
        vistaCliente.setController(clienteJpaController);
        vistaCliente.setVistaPrincipal(vistaPrincipal);
        vistaCliente.setVistaController(this);
        vistaCliente.setVisible(true);
    }
    
    public void UpdateClienteView(){
        if (vistaCliente == null) {
            vistaCliente = new VistaCliente();
        }
        
        vistaCliente.setController(clienteJpaController);
        vistaCliente.setVistaPrincipal(vistaPrincipal);
        vistaCliente.setVistaController(this);
        vistaCliente.setEditar(true);
        
        int filaSeleccionada = vistaPrincipal.jTableCliente.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            // Obtiene el valor del ID en la fila seleccionada
            Object idSeleccionado = vistaPrincipal.jTableCliente.getValueAt(filaSeleccionada, 0);

            // Ahora puedes almacenar el valor del ID en una variable
            Integer idCliente = (Integer) idSeleccionado;
            Cliente cliente = clienteJpaController.findCliente(idCliente);
            
            cliente.setIdCliente(idCliente);
            String nombreRazonSocial = cliente.getNombreRazonSocial();
            String tipoDocumento = cliente.getTipoDocumento();
            String numeroDocumento = cliente.getNumeroDocumento();
            String telefonoCliente = cliente.getTelefonoCliente();
            String correoCliente = cliente.getCorreoCliente();
            String direccionCliente = cliente.getDireccionCliente();
            
            vistaCliente.txt_Nombre.setText(nombreRazonSocial);
            vistaCliente.cmb_TipoDocumento.setSelectedItem(tipoDocumento);
            vistaCliente.txt_NumeroDocumento.setText(numeroDocumento);
            vistaCliente.txt_Telefono.setText(telefonoCliente);
            vistaCliente.txt_Correo.setText(correoCliente);
            vistaCliente.txt_Direccion.setText(direccionCliente);

            vistaCliente.setCliente(cliente);
            // Puedes usar idCliente en tu código
            vistaCliente.setVisible(true);
        } else {
            // No se ha seleccionado ninguna fila
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
    }
    
    public void eliminar() throws NonexistentEntityException{
        int filaSeleccionada = vistaPrincipal.jTableCliente.getSelectedRow();
        Object idSeleccionado = vistaPrincipal.jTableCliente.getValueAt(filaSeleccionada, 0);
        boolean rs = clienteJpaController.destroy((Integer) idSeleccionado);
        
        if (rs) {
            vistaPrincipal.lbl_alert.setText("Cliente Eliminado");
        } else {
            vistaPrincipal.lbl_alert.setText("Error al Eliminar Cliente");
        }
        this.CargarClientes();
    }
    
    public void historialCliente(){
        vistaHistorialCliente = new VistaHistorialCliente();
        int filaSeleccionada = vistaPrincipal.jTableCliente.getSelectedRow();
        
        Integer idCliente = (Integer) vistaPrincipal.jTableCliente.getValueAt(filaSeleccionada, 0);
        
        HistorialClienteJpaController historialClientes = new HistorialClienteJpaController(emf);
        List<HistorialCliente> historialClientesList = historialClientes.findHistorialClienteByIdCliente(idCliente);
        
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaHistorialCliente.JtableHistoriaCliente.getModel();
        
        modeloTabla.setRowCount(0);
        
        for (HistorialCliente historialCliente : historialClientesList) {
            modeloTabla.addRow(new Object[] {
                historialCliente.getIdHistorialCliente(),
                historialCliente.getFechaHistorialCliente(),
                historialCliente.getDescripcion()
            });
        }
        
        modeloTabla.fireTableDataChanged();
        
        vistaHistorialCliente.setVisible(true);
    }
    
//    Personal
    public void CreatePersonalView(){
        if (vistaPersonal == null) {
            vistaPersonal = new VistaPersonal();
        }
        
        vistaPersonal.setJpacontroller(personalJpaController);
        vistaPersonal.setVistaPrincipal(vistaPrincipal);
        vistaPersonal.setVistaController(this);
        vistaPersonal.setVisible(true);
    }
}
