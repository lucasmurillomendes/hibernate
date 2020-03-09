/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lucas
 */
public class ConnectionFactory {
    
    
     private static EntityManagerFactory efm = Persistence.createEntityManagerFactory("meuPU");
     
     public EntityManager getConnection(){
         return efm.createEntityManager();
     }
     
}
