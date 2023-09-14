package net.controladores;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import net.modelo.Cliente;
import net.vista.VistaCliente;
import net.vista.VistaPrincipal;

public class VistaController {

    private VistaCliente vistaCliente;
    private VistaPrincipal vistaPrincipal;
    private ClienteJpaController clienteJpaController;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Taller_MecanicaPU");

    public VistaController() {

    }
    
    public void principalView(){
        vistaPrincipal = new VistaPrincipal();
        clienteJpaController = new ClienteJpaController(emf);
        
        List<Cliente> clientes = clienteJpaController.findClienteEntities();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.jTableCliente.getModel();
        
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
        
        vistaPrincipal.setVistaController(this);
        vistaPrincipal.setVisible(true);
    }
    
    public void CreateClienteView(){
        if (vistaCliente == null) {
            vistaCliente = new VistaCliente();
        }
        
        vistaCliente.setController(clienteJpaController);
        vistaCliente.setVistaPrincipal(vistaPrincipal);
        vistaCliente.setVisible(true);
    }
    
    public void UpdateClienteView(){
        if (vistaCliente == null) {
            vistaCliente = new VistaCliente();
        }
        
        vistaCliente.setController(clienteJpaController);
        vistaCliente.setVistaPrincipal(vistaPrincipal);
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
    
}
