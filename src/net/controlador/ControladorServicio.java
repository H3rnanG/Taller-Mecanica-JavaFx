package net.controlador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import net.modelo.Cliente;
import net.modelo.Personal;
import net.modelo.Servicio;
import net.modelo.Vehiculo;
import net.singleton.Conectar;
import net.vista.VistaPrincipal;
import net.vista.VistaServicio;

public class ControladorServicio {
    private VistaPrincipal vistaPrincipal;
    private VistaServicio vistaServicio;
    private Servicio servicioEditar;
    
    private boolean editar = false;
    
//  Controlador
    public ControladorServicio() {
    }

    public ControladorServicio(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    
//  Vista
    public void AbrirVistaServicio() {
        
        if (vistaServicio == null) {
            vistaServicio = new VistaServicio(this);
            vistaServicio.setLocationRelativeTo(vistaPrincipal);
        }

        EntityManager em = entityManager();
        List<Personal> personales = em.createQuery("SELECT p FROM Personal p", Personal.class).getResultList();
        List<Vehiculo> vehiculos = em.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class).getResultList();

        // Agrega un elemento ficticio al principio del JComboBox
        vistaServicio.cmb_PersonalServicio.addItem(""); // Elemento vacío para el índice 0

        for (Personal personal : personales) {
            vistaServicio.cmb_PersonalServicio.addItem(personal.getNombrePersonal()); // Asumiendo que el nombre del cliente se obtiene con el método getNombre()
        }

        // Desplaza los índices para que comiencen en 1
        vistaServicio.cmb_PersonalServicio.setSelectedIndex(1);

        // Repite el mismo proceso para el otro JComboBox
        vistaServicio.cmb_PlacaServicio.addItem(""); // Elemento vacío para el índice 0

        for (Vehiculo vehiculo : vehiculos) {
            vistaServicio.cmb_PlacaServicio.addItem(vehiculo.getPlaca()); // Asumiendo que el nombre del cliente se obtiene con el método getNombre()
        }

        vistaServicio.cmb_PlacaServicio.setSelectedIndex(1);
        
        this.editar = false;

        vistaServicio.setVisible(true);
        
    }
    
    public void AbrirVistaEditar() {
        this.AbrirVistaServicio();

        int filaSeleccionada = vistaPrincipal.jTableServicios.getSelectedRow();
        
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableServicios.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            servicioEditar = em.find(Servicio.class, idSeleccionado);
            em.close();
            
            if (servicioEditar != null) { // Verifica si se encontró el cliente
                
                int id_personal = servicioEditar.getIdPersonal();
                int id_vehiculo = servicioEditar.getIdVehiculo();
                float precio = servicioEditar.getPrecioServicio();
                String descripcion = servicioEditar.getDescripcionServicio();
                
                // Rellenar los campos de edición con los datos del servicio a editar
                vistaServicio.cmb_PersonalServicio.setSelectedIndex(id_personal); // Supongamos que tienes un campo de texto txt_PersonalServicio en la vista de edición
                vistaServicio.cmb_PlacaServicio.setSelectedIndex(id_vehiculo); // Supongamos que tienes un campo de texto txt_PlacaServicio en la vista de edición // Supongamos que tienes un campo de texto txt_FechaServicio en la vista de edición
                vistaServicio.txt_PrecioServicio.setText(String.valueOf(precio)); // Supongamos que tienes un campo de texto txt_PrecioServicio en la vista de edición
                vistaServicio.txt_DescripcionServicio.setText(descripcion); // Supongamos que tienes un campo de texto txt_DescripcionServicio en la vista de edición
                
                this.editar = true;
                
                vistaServicio.setVisible(true);
            } else {
                vistaPrincipal.lbl_alert.setText("Servicio no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }

        vistaServicio.setVisible(true);
    }
    
    public void CerrarVista() {
        if (vistaServicio != null) {
            vistaServicio.dispose();  // Cierra la vista
            vistaServicio = null;     // Elimina la referencia
        }
    }
    
    public void CargarServicios() {
        
        // Obtener el EntityManager
        EntityManager em = entityManager();

        // Crear una consulta para obtener todos los clientes
        Query query = em.createQuery("SELECT s FROM Servicio s");

        // Obtener la lista de clientes
        List<Servicio> servicios = query.getResultList();

        // Obtener el modelo de la tabla de la vista
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.jTableServicios.getModel();

        // Limpiar el modelo de la tabla
        modeloTabla.setRowCount(0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        // Llenar el modelo de la tabla con los datos de los clientes
        for (Servicio servicio : servicios) {
            // Obtener los IDs de personal y vehículo desde el servicio
            int idPersonal = servicio.getIdPersonal();
            int idVehiculo = servicio.getIdVehiculo();

            // Obtener los objetos Personal y Vehiculo correspondientes desde la base de datos
            Personal personal = em.find(Personal.class, idPersonal); // Suponiendo que tengas la clase Personal
            Vehiculo vehiculo = em.find(Vehiculo.class, idVehiculo); // Suponiendo que tengas la clase Vehiculo

            // Formatear la fecha en el formato deseado
            String fechaFormateada = dateFormat.format(servicio.getFechaServicio());
            
            // Agregar los datos a la fila de la tabla
            modeloTabla.addRow(new Object[] {
                servicio.getIdServicio(), // Id Servicio
                personal != null ? personal.getNombrePersonal(): "", // Nombre Personal
                vehiculo != null ? vehiculo.getPlaca() : "", // Placa Vehiculo
                fechaFormateada,
                servicio.getPrecioServicio(),
                servicio.getDescripcionServicio(),
            });
        }

        // Cierra el EntityManager
        em.close();
        
    }
    
    public void ComprobarEdicion() {
        if (editar) {
            this.Editar();
        } else {
            this.Crear();
        }
    }
    
    public void Editar() {
        int id_personal = vistaServicio.cmb_PersonalServicio.getSelectedIndex();
        int id_vehiculo = vistaServicio.cmb_PlacaServicio.getSelectedIndex();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = servicioEditar.getFechaServicio();

        float precio = Float.parseFloat(vistaServicio.txt_PrecioServicio.getText());
        String descripcion = vistaServicio.txt_DescripcionServicio.getText();

        // Actualizar el objeto Servicio con los nuevos valores
        servicioEditar.setIdPersonal(id_personal);
        servicioEditar.setIdVehiculo(id_vehiculo);
        servicioEditar.setFechaServicio(fecha);
        servicioEditar.setPrecioServicio(precio);
        servicioEditar.setDescripcionServicio(descripcion);

        // Obtener el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.merge(servicioEditar);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Servicio Editado");
            this.CargarServicios();
        } catch (Exception e) {
            em.getTransaction().rollback();
            vistaPrincipal.lbl_alert.setText("Error al Editar Servicio");
        } finally {
            em.close();
        }

        // Cerrar la vista de edición cuando se presione el botón 'Guardar'
        this.CerrarVista();
    }
    
    public void Crear() {
        // Almacenamos todos los campos en variables
        int id_personal = vistaServicio.cmb_PersonalServicio.getSelectedIndex();
        int id_vehiculo = vistaServicio.cmb_PlacaServicio.getSelectedIndex();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = new Date(); // Obtenemos la fecha actual
        String fechaFormateada = dateFormat.format(fecha); // Formateamos la fecha
        float precio = Float.parseFloat(vistaServicio.txt_PrecioServicio.getText());
        String descripcion = vistaServicio.txt_DescripcionServicio.getText();
                
//      Creamos un Objeto Cliente
        Servicio servicio = new Servicio(id_personal, id_vehiculo, fecha, precio, descripcion);
        
//      Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(servicio);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Servicio Creado");
            this.CargarServicios();
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al Crear Servicio");
            em.getTransaction().rollback();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVista();
    }
    
    public void Eliminar(){
        
        int filaSeleccionada = vistaPrincipal.jTableServicios.getSelectedRow();
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableServicios.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            Servicio servicio = em.find(Servicio.class, idSeleccionado);
            
            if (servicio != null) { // Verifica si se encontró el cliente
                
                em.getTransaction().begin();
                em.remove(servicio);
                em.getTransaction().commit();
                
                em.close();
                
                vistaPrincipal.lbl_alert.setText("Servicio eliminado.");
                this.CargarServicios();
                
            } else {
                vistaPrincipal.lbl_alert.setText("Servicio no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
        
    }
    
    public  EntityManager entityManager() {
        return Conectar.getConectar().getFactory().createEntityManager();
    }
}
