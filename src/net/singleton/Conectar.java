/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conectar {
    private static Conectar conectar = new Conectar();
    private EntityManagerFactory Factory;
    
    private Conectar() {
        Factory = Persistence.createEntityManagerFactory("Taller_MecanicaPU");
    }

    public static Conectar getConectar() {
        return conectar;
    }

    public EntityManagerFactory getFactory() {
        return Factory;
    }
    
}
