package net.controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import net.modelo.ComprobantePago;
import net.modelo.MetodoPago;
import net.modelo.PagoServicio;
import net.modelo.Servicio;
import net.singleton.Conectar;
import net.vista.VistaPagarServicio;
import net.vista.VistaPrincipal;
import net.vista.VistaServiciosPagados;

public class ControladorServicioPagado {

    VistaPrincipal vistaPrincipal;
    VistaPagarServicio vistaPagarServicio;
    VistaServiciosPagados vistaServicioPagados;
    private Object IdServicio;

    public ControladorServicioPagado() {
    }

    public ControladorServicioPagado(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }
    
//    Vistas
    public void AbrirVistaVer(){
        if (vistaServicioPagados == null) {
            vistaServicioPagados = new VistaServiciosPagados();
            vistaServicioPagados.setLocationRelativeTo(vistaPrincipal);
        }
        
        // Obtener el EntityManager
        EntityManager em = entityManager();

        try {
            // Crear una consulta para obtener el historial del cliente seleccionado
            Query query = em.createQuery("SELECT ps FROM PagoServicio ps");

            // Obtener una lista de resultados
            List<PagoServicio> historialpagoList = query.getResultList();

            // Obtener el modelo de la tabla de la vista
            DefaultTableModel modeloTabla = (DefaultTableModel) vistaServicioPagados.jTableHistorialPago.getModel();

            // Limpiar el modelo de la tabla
            modeloTabla.setRowCount(0);

            // Llenar el modelo de la tabla con los datos del historial
            for (PagoServicio pago : historialpagoList) {
                ComprobantePago comprobante = em.find(ComprobantePago.class, pago.getIdComprobante());
                MetodoPago metodo = em.find(MetodoPago.class, pago.getIdMetodo());
                modeloTabla.addRow(new Object[] {
                    
                    pago.getIdServicio(),
                    comprobante.getTipoComprobante(),
                    metodo.getTipoMetodo(),
                });
            }

            // Mostrar la vista
            vistaServicioPagados.setVisible(true);
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al obtener historial del pagos.");
        } finally {
            // Cerrar el EntityManager
            em.close();
        }

    }
    
    public void AbrirVistaPagar(){
        
        if (vistaPagarServicio == null) {
            vistaPagarServicio = new VistaPagarServicio(this);
            vistaPagarServicio.setLocationRelativeTo(vistaPrincipal);
        }
        
        int filaSeleccionada = vistaPrincipal.jTableServicios.getSelectedRow();
        
        Object idSeleccionado = null;

        if (filaSeleccionada != -1) {
            idSeleccionado = vistaPrincipal.jTableServicios.getValueAt(filaSeleccionada, 0);
            IdServicio = idSeleccionado;
        }
        
        if (idSeleccionado != null) {
            
            EntityManager em = entityManager();
            Servicio servicio = em.find(Servicio.class, idSeleccionado);
            List<ComprobantePago> comprobantes = em.createQuery("SELECT c FROM ComprobantePago c", ComprobantePago.class).getResultList();
            List<MetodoPago> metodos = em.createQuery("SELECT m FROM MetodoPago m", MetodoPago.class).getResultList();
            
            vistaPagarServicio.cmb_ComprobantePago.removeAllItems();
            vistaPagarServicio.cmb_MetodoPago.removeAllItems();
            em.close();
            
            if (servicio != null) { // Verifica si se encontró el cliente
                // Carga los datos del cliente en la vista
                String descripcion = servicio.getDescripcionServicio();
                vistaPagarServicio.txt_servicioPago.setText(descripcion);
                
                for (ComprobantePago comprobante : comprobantes) {
                    vistaPagarServicio.cmb_ComprobantePago.addItem(comprobante.getTipoComprobante());
                }
                
                for (MetodoPago metodo : metodos) {
                    vistaPagarServicio.cmb_MetodoPago.addItem(metodo.getTipoMetodo()); // Asumiendo que el nombre del cliente se obtiene con el método getNombre()
                }
                
                vistaPagarServicio.setVisible(true);
            } else {
                vistaPrincipal.lbl_alert.setText("Servicio no encontrado.");
            }
            
        } else {
            vistaPrincipal.lbl_alert.setText("Ninguna Fila Seleccionada.");
        }
        
    }
    
    public void CerrarVista() {
    
        if (vistaPagarServicio != null) {
            vistaPagarServicio.dispose();  // Cierra la vista
            vistaPagarServicio = null;     // Elimina la referencia
        }
        
    }
    
    public void PagarServicio() {
    
        int idcomprobante = vistaPagarServicio.cmb_ComprobantePago.getSelectedIndex();
        int idmetodo = vistaPagarServicio.cmb_MetodoPago.getSelectedIndex();
        
        PagoServicio pagoServicio = new PagoServicio((Integer )IdServicio, idcomprobante, idmetodo);
    
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            em.persist(pagoServicio);
            em.getTransaction().commit();
            vistaPrincipal.lbl_alert.setText("Servicio Pagado");
        } catch (Exception e) {
            vistaPrincipal.lbl_alert.setText("Error al Pagar Servicio");
            em.getTransaction().rollback();
        }

        this.CerrarVista();
        
    }
    
    public  EntityManager entityManager() {
        return Conectar.getConectar().getFactory().createEntityManager();
    }

}
