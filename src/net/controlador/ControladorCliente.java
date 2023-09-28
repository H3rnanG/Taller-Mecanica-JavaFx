package net.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import net.modelo.Cliente;
import net.modelo.HistorialCliente;
import net.singleton.Conectar;
import net.vista.VistaCliente;
import net.vista.VistaHistorialCliente;
import net.vista.VistaPrincipal;
import net.vista.VistaVisitaCliente;

public class ControladorCliente {
    
    private VistaCliente vistaCliente;
    private VistaPrincipal vistaPrincipal;
    private VistaHistorialCliente vistaHistorialCliente;
    private VistaVisitaCliente vistaVisitaCliente;
    private Cliente clienteEditar;
    
    private boolean editar = false;

//  Contructores
    
    public ControladorCliente() {
    }
    
    public ControladorCliente(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    
//  Vista
    public void AbrirVistaCrear() {
    
        if (vistaCliente == null) {
            vistaCliente = new VistaCliente(this);
            vistaCliente.setLocationRelativeTo(vistaPrincipal);
        }
        vistaCliente.setVisible(true);
    
    }
    
    public void AbrirVistaEditar() {
        
        if (vistaCliente == null) {
            vistaCliente = new VistaCliente(this);
            vistaCliente.setLocationRelativeTo(vistaPrincipal);
        }
        
        int filaSeleccionada = vistaPrincipal.jTableCliente.getSelectedRow();
        
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableCliente.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            clienteEditar = em.find(Cliente.class, idSeleccionado);
            em.close();
            
            if (clienteEditar != null) { // Verifica si se encontró el cliente
                // Carga los datos del cliente en la vista
                String nombreRazonSocial = clienteEditar.getNombreRazonSocial();
                String tipoDocumento = clienteEditar.getTipoDocumento();
                String numeroDocumento = clienteEditar.getNumeroDocumento();
                String telefonoCliente = clienteEditar.getTelefonoCliente();
                String correoCliente = clienteEditar.getCorreoCliente();
                String direccionCliente = clienteEditar.getDireccionCliente();

                vistaCliente.txt_Nombre.setText(nombreRazonSocial);
                vistaCliente.cmb_TipoDocumento.setSelectedItem(tipoDocumento);
                vistaCliente.txt_NumeroDocumento.setText(numeroDocumento);
                vistaCliente.txt_Telefono.setText(telefonoCliente);
                vistaCliente.txt_Correo.setText(correoCliente);
                vistaCliente.txt_Direccion.setText(direccionCliente);
                
                editar = true;
                
                vistaCliente.setVisible(true);
            } else {
                vistaPrincipal.lbl_alert.setText("Cliente no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
        
    }
    
    public void AbrirVistaVisita() {
        
        if (vistaVisitaCliente == null) {
            vistaVisitaCliente = new VistaVisitaCliente(this);
            vistaVisitaCliente.setLocationRelativeTo(vistaPrincipal);
        }
        
        int filaSeleccionada = vistaPrincipal.jTableCliente.getSelectedRow();
        
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableCliente.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            clienteEditar = em.find(Cliente.class, idSeleccionado);
            em.close();
            
            if (clienteEditar != null) { // Verifica si se encontró el cliente
                // Carga los datos del cliente en la vista
                String nombreCliente = clienteEditar.getNombreRazonSocial();
                vistaVisitaCliente.txt_ClienteVisita.setText(nombreCliente);
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaActual = sdf.format(new Date());
                vistaVisitaCliente.txt_FechaVisita.setText(fechaActual);
                
                vistaVisitaCliente.setVisible(true);
            } else {
                vistaPrincipal.lbl_alert.setText("Cliente no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
        
    }
    
    public void CerrarVistaVisita(){
        if (vistaVisitaCliente != null) {
            vistaVisitaCliente.dispose();  // Cierra la vista
            vistaVisitaCliente = null;     // Elimina la referencia
        }
    }
    
    public void CerrarVista(){
        if (vistaCliente != null) {
            vistaCliente.dispose();  // Cierra la vista
            vistaCliente = null;     // Elimina la referencia
            editar = false;
        }
    }
    
    public void CargarClientes() {
        // Obtener el EntityManager
        EntityManager em = entityManager();

        // Crear una consulta para obtener todos los clientes
        Query query = em.createQuery("SELECT c FROM Cliente c");

        // Obtener la lista de clientes
        List<Cliente> clientes = query.getResultList();

        // Obtener el modelo de la tabla de la vista
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.jTableCliente.getModel();

        // Limpiar el modelo de la tabla
        modeloTabla.setRowCount(0);

        // Llenar el modelo de la tabla con los datos de los clientes
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

        // Cierra el EntityManager
        em.close();
    }
    
//  Persistencia
    
    public void ComprobarEdicion() {
        if (editar) {
            this.Editar();
        } else {
            this.Crear();
        }
    }
    
    public void Crear() {
//      Almacenamos todos los campos en variables
        String nombreRazonSocial = vistaCliente.txt_Nombre.getText();
        String tipoDocumento = (String) vistaCliente.cmb_TipoDocumento.getSelectedItem();
        String numeroDocumento = vistaCliente.txt_NumeroDocumento.getText();
        String telefonoCliente = vistaCliente.txt_Telefono.getText();
        String correoCliente = vistaCliente.txt_Correo.getText();
        String direccionCliente = vistaCliente.txt_Direccion.getText();
                
//      Creamos un Objeto Cliente
        Cliente cliente = new Cliente(nombreRazonSocial, tipoDocumento, numeroDocumento, telefonoCliente, correoCliente, direccionCliente);
        
//      Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Usuario Creado");
            this.CargarClientes();
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al Crear Usuario");
            em.getTransaction().rollback();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVista();
    }    
    
    public void Editar(){
        
        String nombreRazonSocial = vistaCliente.txt_Nombre.getText();
        String tipoDocumento = (String) vistaCliente.cmb_TipoDocumento.getSelectedItem();
        String numeroDocumento = vistaCliente.txt_NumeroDocumento.getText();
        String telefonoCliente = vistaCliente.txt_Telefono.getText();
        String correoCliente = vistaCliente.txt_Correo.getText();
        String direccionCliente = vistaCliente.txt_Direccion.getText();
        
        clienteEditar.setNombreRazonSocial(nombreRazonSocial);
        clienteEditar.setTipoDocumento(tipoDocumento);
        clienteEditar.setNumeroDocumento(numeroDocumento);
        clienteEditar.setTelefonoCliente(telefonoCliente);
        clienteEditar.setCorreoCliente(correoCliente);
        clienteEditar.setDireccionCliente(direccionCliente);
        
//      Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.merge(clienteEditar);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Usuario Editado");
            this.CargarClientes();
        } catch (Exception e) {
            em.getTransaction().rollback();
            vistaPrincipal.lbl_alert.setText("Error al Editar Usuario");
        } finally {
            em.close();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVista();
    }

    public void EliminarCliente() {
        int filaSeleccionada = vistaPrincipal.jTableCliente.getSelectedRow();
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableCliente.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            Cliente cliente = em.find(Cliente.class, idSeleccionado);
            
            if (cliente != null) { // Verifica si se encontró el cliente
                
                em.getTransaction().begin();
                em.remove(cliente);
                em.getTransaction().commit();
                
                em.close();
                
                vistaPrincipal.lbl_alert.setText("Cliente eliminado.");
                this.CargarClientes();
                
            } else {
                vistaPrincipal.lbl_alert.setText("Cliente no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
    }
    
    public void VistaHistorialCliente() {
        if (vistaHistorialCliente == null) {
        vistaHistorialCliente = new VistaHistorialCliente();
        vistaHistorialCliente.setLocationRelativeTo(null);
        }

        int filaSeleccionada = vistaPrincipal.jTableCliente.getSelectedRow();

        if (filaSeleccionada != -1) {
            Object idSeleccionado = vistaPrincipal.jTableCliente.getValueAt(filaSeleccionada, 0);

            if (idSeleccionado != null) {
                // Obtener el EntityManager
                EntityManager em = entityManager();

                try {
                    // Crear una consulta para obtener el historial del cliente seleccionado
                    Query query = em.createQuery("SELECT hc FROM HistorialCliente hc WHERE hc.idCliente = :clienteId");
                    query.setParameter("clienteId", idSeleccionado);

                    // Obtener una lista de resultados
                    List<HistorialCliente> historialClienteList = query.getResultList();

                    // Obtener el modelo de la tabla de la vista
                    DefaultTableModel modeloTabla = (DefaultTableModel) vistaHistorialCliente.JtableHistoriaCliente.getModel();

                    // Limpiar el modelo de la tabla
                    modeloTabla.setRowCount(0);

                    // Llenar el modelo de la tabla con los datos del historial
                    for (HistorialCliente historialCliente : historialClienteList) {
                        modeloTabla.addRow(new Object[] {
                            historialCliente.getIdCliente(),
                            historialCliente.getFechaHistorialCliente(),
                            historialCliente.getDescripcion(),
                        });
                    }

                    // Mostrar la vista
                    vistaHistorialCliente.setVisible(true);
                } catch (Exception e) {
                    vistaPrincipal.lbl_alert.setText("Error al obtener historial del cliente.");
                } finally {
                    // Cerrar el EntityManager
                    em.close();
                }
            } else {
                vistaPrincipal.lbl_alert.setText("ID del cliente seleccionado es nulo.");
            }
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna fila seleccionada.");
        }
    }   
    
    public void nuevaVisita() {
    
        // Almacenamos todos los campos en variables
        int id_cliente = clienteEditar.getIdCliente();
        Date fecha = new Date();
        String descripcion = vistaVisitaCliente.txt_DescripcionVisita.getText();
                
        // Creamos un Objeto Cliente
        HistorialCliente historialCliente = new HistorialCliente(id_cliente, fecha, descripcion);
        
        // Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(historialCliente);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Visita Creado");
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al Crear Usuario");
            em.getTransaction().rollback();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVistaVisita();
        
    }
    
    public  EntityManager entityManager() {
        return Conectar.getConectar().getFactory().createEntityManager();
    }
    
}
