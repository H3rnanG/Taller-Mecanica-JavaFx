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
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Taller_MecanicaPU");

    public VistaController(VistaCliente vistaCliente, VistaPrincipal vistaPrincipal) {
        this.vistaCliente = vistaCliente;
        this.vistaPrincipal = vistaPrincipal;
    }
    
    public void CreateClienteView(){
        vistaCliente.setController(new ClienteJpaController(emf));
        vistaCliente.setVisible(true);
    }
    
    public void UpdateClienteView(){
        vistaCliente.setController(new ClienteJpaController(emf));
        
        
        
        vistaCliente.setVisible(true);
    }
    
}
