package net.controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import net.modelo.Personal;
import net.singleton.Conectar;
import net.vista.VistaPersonal;
import net.vista.VistaPrincipal;

public class ControladorPersonal {

    private VistaPersonal vistaPersonal;
    private VistaPrincipal vistaPrincipal;
    private Personal personalEditar;
    
    private boolean editar = false;
    
//  Contructores

    public ControladorPersonal() {
    }

    public ControladorPersonal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    
// Vista
    
    public void AbrirVistaCrear() {
    
        if (vistaPersonal == null) {
            vistaPersonal = new VistaPersonal(this);
            vistaPersonal.setLocationRelativeTo(vistaPrincipal);
        }
        vistaPersonal.setVisible(true);
    
    }
    
    public void AbrirVistaEditar() {
        
        if (vistaPersonal == null) {
            vistaPersonal = new VistaPersonal(this);
            vistaPersonal.setLocationRelativeTo(vistaPrincipal);
        }
        
        int filaSeleccionada = vistaPrincipal.jTablePersonal.getSelectedRow();
        
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTablePersonal.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            personalEditar = em.find(Personal.class, idSeleccionado);
            em.close();
            
            if (personalEditar != null) { // Verifica si se encontró el cliente
                // Carga los datos del cliente en la vista
                String nombrePersonal = personalEditar.getNombrePersonal();
                String apellidoPersonal = personalEditar.getApellidoPersonal();
                String ocupacion = personalEditar.getOcupacion();
                Float salario = personalEditar.getSalario();
                String telefonoPersonal = personalEditar.getTelefonoPersonal();
                String correoPersonal = personalEditar.getCorreoPersonal();
                String contraPersonal = personalEditar.getContraPersonal();

                vistaPersonal.txt_Nombre.setText(nombrePersonal);
                vistaPersonal.txt_Apellido.setText(apellidoPersonal);
                vistaPersonal.txt_Ocupacion.setText(ocupacion);
                vistaPersonal.txt_Salario.setText(String.valueOf(salario));
                vistaPersonal.txt_Telefono.setText(telefonoPersonal);
                vistaPersonal.txt_Correo.setText(correoPersonal);
                vistaPersonal.txt_Contra.setText(contraPersonal);
                
                editar = true;
                
                vistaPersonal.setVisible(true);
            } else {
                vistaPrincipal.lbl_alert.setText("Personal no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
        
    }
    
    public void CerrarVista(){
        if (vistaPersonal != null) {
            vistaPersonal.dispose();  // Cierra la vista
            vistaPersonal = null;     // Elimina la referencia
            editar = false;
        }
    }
    
    public void CargarPersonals() {
        // Obtener el EntityManager
        EntityManager em = entityManager();

        // Crear una consulta para obtener todos los clientes
        Query query = em.createQuery("SELECT p FROM Personal p");

        // Obtener la lista de clientes
        List<Personal> personals = query.getResultList();

        // Obtener el modelo de la tabla de la vista
        DefaultTableModel modeloTabla = (DefaultTableModel) vistaPrincipal.jTablePersonal.getModel();

        // Limpiar el modelo de la tabla
        modeloTabla.setRowCount(0);

        // Llenar el modelo de la tabla con los datos de los clientes
        for (Personal personal : personals) {
            modeloTabla.addRow(new Object[] {
                personal.getIdPersonal(),
                personal.getNombrePersonal(),
                personal.getApellidoPersonal(),
                personal.getOcupacion(),
                personal.getSalario(),
                personal.getTelefonoPersonal(),
                personal.getCorreoPersonal(),
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
        String nombrePersonal = vistaPersonal.txt_Nombre.getText();
        String apellidoPersonal = vistaPersonal.txt_Apellido.getText();
        String ocupacionPersonal = vistaPersonal.txt_Ocupacion.getText();
        float salarioPersonal = Float.parseFloat(vistaPersonal.txt_Salario.getText());
        String telefonoPersonal = vistaPersonal.txt_Telefono.getText();
        String correoPersonal = vistaPersonal.txt_Correo.getText();
        String contraPersonal = vistaPersonal.txt_Contra.getText();
                
//      Creamos un Objeto Cliente
        Personal personal = new Personal(nombrePersonal, apellidoPersonal, ocupacionPersonal, salarioPersonal, telefonoPersonal, correoPersonal, contraPersonal);
        
//      Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(personal);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Personal Creado");
            this.CargarPersonals();
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al Personal Usuario");
            em.getTransaction().rollback();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVista();
    }    
    
    public void Editar(){
        
        String nombrePersonal = vistaPersonal.txt_Nombre.getText();
        String apellidoPersonal = vistaPersonal.txt_Apellido.getText();
        String ocupacionPersonal = vistaPersonal.txt_Ocupacion.getText();
        float salarioPersonal = Float.parseFloat(vistaPersonal.txt_Salario.getText());
        String telefonoPersonal = vistaPersonal.txt_Telefono.getText();
        String correoPersonal = vistaPersonal.txt_Correo.getText();
        String contraPersonal = vistaPersonal.txt_Contra.getText();
        
        personalEditar.setNombrePersonal(nombrePersonal);
        personalEditar.setApellidoPersonal(apellidoPersonal);
        personalEditar.setOcupacion(ocupacionPersonal);
        personalEditar.setSalario(salarioPersonal);
        personalEditar.setTelefonoPersonal(telefonoPersonal);
        personalEditar.setCorreoPersonal(correoPersonal);
        personalEditar.setContraPersonal(contraPersonal);
        
//      Obtenemos el EntityManager
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.merge(personalEditar);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Personal Editado");
            this.CargarPersonals();
        } catch (Exception e) {
            em.getTransaction().rollback();
            vistaPrincipal.lbl_alert.setText("Error al Editar Personal");
        } finally {
            em.close();
        }
        
//      Cerrar vistaCliente cuando se aprete el boton 'Guardar'
        this.CerrarVista();
    }

    public void EliminarCliente() {
        int filaSeleccionada = vistaPrincipal.jTablePersonal.getSelectedRow();
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTablePersonal.getValueAt(filaSeleccionada, 0);
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            Personal personal = em.find(Personal.class, idSeleccionado);
            
            if (personal != null) { // Verifica si se encontró el cliente
                
                em.getTransaction().begin();
                em.remove(personal);
                em.getTransaction().commit();
                
                em.close();
                
                vistaPrincipal.lbl_alert.setText("Personal eliminado.");
                this.CargarPersonals();
                
            } else {
                vistaPrincipal.lbl_alert.setText("Personal no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
    }
    
    
    
    public  EntityManager entityManager() {
        return Conectar.getConectar().getFactory().createEntityManager();
    }
    
}
