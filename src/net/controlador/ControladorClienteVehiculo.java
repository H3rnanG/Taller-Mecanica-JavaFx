package net.controlador;

import java.util.List;
import javax.persistence.EntityManager;
import net.modelo.Cliente;
import net.modelo.ClienteVehiculo;
import net.modelo.Vehiculo;
import net.singleton.Conectar;
import net.vista.VistaPrincipal;
import net.vista.VistaVehiculoCliente;

public class ControladorClienteVehiculo {
    private VistaPrincipal vistaPrincipal;
    private VistaVehiculoCliente vistaVehiculoCliente;
    private Object IdVehiculo;

    
//  Constructores
    public ControladorClienteVehiculo() {
    }

    public ControladorClienteVehiculo(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    
//  Vistas
    public void AbrirVista(){
        
        if (vistaVehiculoCliente == null) {
            vistaVehiculoCliente = new VistaVehiculoCliente(this);
            vistaVehiculoCliente.setLocationRelativeTo(vistaPrincipal);
        }
        
        int filaSeleccionada = vistaPrincipal.jTableVehiculo.getSelectedRow();
        
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableVehiculo.getValueAt(filaSeleccionada, 0);
            IdVehiculo = idSeleccionado;
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            Vehiculo vehiculo = em.find(Vehiculo.class, idSeleccionado);
            List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            vistaVehiculoCliente.cmb_ClienteAsignar.removeAllItems();
            em.close();
            
            if (vehiculo != null) { // Verifica si se encontró el cliente
                // Carga los datos del cliente en la vista
                String placa = vehiculo.getPlaca();
                vistaVehiculoCliente.txt_PlacaAsignar.setText(placa);
                
                for (Cliente cliente : clientes) {
                    vistaVehiculoCliente.cmb_ClienteAsignar.addItem(cliente.getNombreRazonSocial()); // Asumiendo que el nombre del cliente se obtiene con el método getNombre()
                }
                
                vistaVehiculoCliente.setVisible(true);
            } else {
                vistaPrincipal.lbl_alert.setText("Vehiculo no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
        
    }
    
    public void CerrarVista() {
        if (vistaVehiculoCliente != null) {
            vistaVehiculoCliente.dispose();  // Cierra la vista
            vistaVehiculoCliente = null;     // Elimina la referencia
        }
    }
    
//  Controlador
    
    public void CrearAsignarCliente() {
        int id_cliente = vistaVehiculoCliente.cmb_ClienteAsignar.getSelectedIndex();
        
        ClienteVehiculo clienteVehiculo = new ClienteVehiculo(id_cliente, (Integer) IdVehiculo);
        
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(clienteVehiculo);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Usuario Creado");
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al Crear Usuario");
            em.getTransaction().rollback();
        }
        
        this.CerrarVista();
    }
    
    public  EntityManager entityManager() {
        return Conectar.getConectar().getFactory().createEntityManager();
    }
}
