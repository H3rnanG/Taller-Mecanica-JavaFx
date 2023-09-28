package net.controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import net.modelo.ComprobantePago;
import net.modelo.MetodoPago;
import net.modelo.PagoServicio;
import net.singleton.Conectar;
import net.vista.VistaPagarServicio;
import net.vista.VistaPrincipal;
import net.vista.VistaServiciosPagados;

public class ControladorServicioPagado {

    VistaPrincipal vistaPrincipal;
    VistaPagarServicio vistaPagarServicio;
    VistaServiciosPagados vistaServicioPagados;

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
    
    public  EntityManager entityManager() {
        return Conectar.getConectar().getFactory().createEntityManager();
    }

}
