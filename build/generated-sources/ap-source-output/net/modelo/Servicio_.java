package net.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-10-04T22:28:02")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, String> descripcionServicio;
    public static volatile SingularAttribute<Servicio, Integer> idVehiculo;
    public static volatile SingularAttribute<Servicio, Integer> idPersonal;
    public static volatile SingularAttribute<Servicio, Boolean> servicioPagado;
    public static volatile SingularAttribute<Servicio, Integer> idServicio;
    public static volatile SingularAttribute<Servicio, Date> fechaServicio;
    public static volatile SingularAttribute<Servicio, Float> precioServicio;

}