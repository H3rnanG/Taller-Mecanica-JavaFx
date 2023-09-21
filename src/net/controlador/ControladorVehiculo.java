package net.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import net.modelo.Vehiculo;
import net.singleton.Conectar;
import net.vista.VistaPrincipal;
import net.vista.VistaVehiculo;

public class ControladorVehiculo {

    private VistaVehiculo vistaVehiculo;
    private VistaPrincipal vistaPrincipal;
    private Vehiculo vehiculoEditar;
    
    private boolean editar = false;
    
//  Contructores

    public ControladorVehiculo() {
    }

    public ControladorVehiculo(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    
// Vista
    
    public void AbrirVistaCrear() {
    
        if (vistaVehiculo == null) {
            vistaVehiculo = new VistaVehiculo(this);
            vistaVehiculo.setLocationRelativeTo(vistaPrincipal);
        }
        vistaVehiculo.setVisible(true);
    
    }
    
    public void AbrirVistaEditar() {
        
        if (vistaVehiculo == null) {
            vistaVehiculo = new VistaVehiculo(this);
            vistaVehiculo.setLocationRelativeTo(vistaPrincipal);
        }
        
        int filaSeleccionada = vistaPrincipal.jTableVehiculo.getSelectedRow();
        
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableVehiculo.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            vehiculoEditar = em.find(Vehiculo.class, idSeleccionado);
            em.close();
            
            if (vehiculoEditar != null) { // Verifica si se encontró el cliente
                // Carga los datos del cliente en la vista
                String placa = vehiculoEditar.getPlaca();
                String kilometraje = String.valueOf(vehiculoEditar.getKilometraje());
                String modelo = vehiculoEditar.getModelo();
                String marca = vehiculoEditar.getMarca();
                String n_servicios = String.valueOf(vehiculoEditar.getNServicios());
                String color = vehiculoEditar.getColor();
                String n_serie = String.valueOf(vehiculoEditar.getNSerie());
                
                // Formatear la fecha en "yyyy-MM-dd"
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fecha_fabricacion = sdf.format(vehiculoEditar.getFechaFabricacion());
                
                String n_chasis = vehiculoEditar.getNChasis();


                vistaVehiculo.txt_Placa.setText(placa);
                vistaVehiculo.txt_Kilometraje.setText(kilometraje);
                vistaVehiculo.txt_Modelo.setText(modelo);
                vistaVehiculo.txt_Marca.setText(marca);
                vistaVehiculo.txt_NumeroServicios.setText(n_servicios);
                vistaVehiculo.txt_Color.setText(color);
                vistaVehiculo.txt_NumeroSerie.setText(n_serie);
                vistaVehiculo.txt_FechaFabricacion.setText(fecha_fabricacion);
                vistaVehiculo.txt_NumeroChasis.setText(n_chasis);
                
                editar = true;
                
                vistaVehiculo.setVisible(true);
            } else {
                vistaPrincipal.lbl_alert.setText("Vehiculo no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
        
    }
    
    public void CerrarVista(){
        if (vistaVehiculo != null) {
            vistaVehiculo.dispose();  // Cierra la vista
            vistaVehiculo = null;     // Elimina la referencia
            editar = false;
        }
    }
    
    public void CargarVehiculos() {
        // Obtener el EntityManager
        EntityManager em = entityManager();

        // Crear una consulta para obtener todos los clientes
        Query query = em.createQuery("SELECT v FROM Vehiculo v");

        // Obtener la lista de clientes
        List<Vehiculo> vehiculos = query.getResultList();

        // Obtener el modelo de la tabla de la vista
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.jTableVehiculo.getModel();

        // Limpiar el modelo de la tabla
        modeloTabla.setRowCount(0);
        
        // Crear un SimpleDateFormat para formatear la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Llenar el modelo de la tabla con los datos de los clientes
        for (Vehiculo vehiculo : vehiculos) {
            String fechaFormateada = sdf.format(vehiculo.getFechaFabricacion()); // Formatear la fecha
            modeloTabla.addRow(new Object[] {
                vehiculo.getIdVehiculo(),
                vehiculo.getPlaca(),
                vehiculo.getKilometraje(),
                vehiculo.getModelo(),
                vehiculo.getMarca(),
                vehiculo.getColor(),
                vehiculo.getNSerie(),
                vehiculo.getNServicios(),
                fechaFormateada,
                vehiculo.getNChasis(),
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
        String placa = vistaVehiculo.txt_Placa.getText();
        int kilometraje = Integer.parseInt(vistaVehiculo.txt_Kilometraje.getText());
        String modelo = vistaVehiculo.txt_Modelo.getText();
        String marca = vistaVehiculo.txt_Marca.getText();
        int n_servicios = Integer.parseInt(vistaVehiculo.txt_NumeroServicios.getText());
        String color = vistaVehiculo.txt_Color.getText();
        int n_serie = Integer.parseInt(vistaVehiculo.txt_NumeroSerie.getText());
        Date fecha_fabricacion = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha_fabricacion = sdf.parse(vistaVehiculo.txt_FechaFabricacion.getText());

            // Resto del código
        } catch (ParseException e) {
            // Manejar el error si la cadena no tiene el formato correcto
            vistaPrincipal.lbl_alert.setText("Formato de fecha incorrecto");
        }
        String n_chasis = vistaVehiculo.txt_NumeroChasis.getText();
                
//      Creamos un Objeto Cliente
        Vehiculo vehiculo = new Vehiculo(placa, kilometraje, modelo, marca, color, n_serie, n_servicios, fecha_fabricacion, n_chasis);
        
//      Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(vehiculo);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Vehiculo Creado");
            this.CargarVehiculos();
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al crear Vehiculo");
            em.getTransaction().rollback();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVista();
    }    
    
    public void Editar(){
        
        // Almacenamos todos los campos en variables
        String placa = vistaVehiculo.txt_Placa.getText();
        int kilometraje = Integer.parseInt(vistaVehiculo.txt_Kilometraje.getText());
        String modelo = vistaVehiculo.txt_Modelo.getText();
        String marca = vistaVehiculo.txt_Marca.getText();
        int n_servicios = Integer.parseInt(vistaVehiculo.txt_NumeroServicios.getText());
        String color = vistaVehiculo.txt_Color.getText();
        int n_serie = Integer.parseInt(vistaVehiculo.txt_NumeroSerie.getText());
        Date fecha_fabricacion = new Date(vistaVehiculo.txt_FechaFabricacion.getText());
        String n_chasis = vistaVehiculo.txt_NumeroChasis.getText();
        
        
        
        vehiculoEditar.setPlaca(placa);
        vehiculoEditar.setKilometraje(kilometraje);
        vehiculoEditar.setModelo(modelo);
        vehiculoEditar.setMarca(marca);
        vehiculoEditar.setNServicios(n_servicios);
        vehiculoEditar.setColor(color);
        vehiculoEditar.setNSerie(n_serie);
        vehiculoEditar.setFechaFabricacion(fecha_fabricacion);
        vehiculoEditar.setNChasis(n_chasis);
        
//      Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.merge(vehiculoEditar);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Vehiculo Editado");
            this.CargarVehiculos();
        } catch (Exception e) {
            em.getTransaction().rollback();
            vistaPrincipal.lbl_alert.setText("Error al Editar Vehiculo");
        } finally {
            em.close();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVista();
    }

    public void EliminarCliente() {
        int filaSeleccionada = vistaPrincipal.jTableVehiculo.getSelectedRow();
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableVehiculo.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            Vehiculo vehiculo = em.find(Vehiculo.class, idSeleccionado);
            
            if (vehiculo != null) { // Verifica si se encontró el cliente
                
                em.getTransaction().begin();
                em.remove(vehiculo);
                em.getTransaction().commit();
                
                em.close();
                
                vistaPrincipal.lbl_alert.setText("Vehiculo eliminado.");
                this.CargarVehiculos();
                
            } else {
                vistaPrincipal.lbl_alert.setText("Vehiculo no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
    }
    
    public  EntityManager entityManager() {
        return Conectar.getConectar().getFactory().createEntityManager();
    }

}
