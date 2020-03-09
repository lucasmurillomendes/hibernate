/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.model.dao;

import br.com.lucas.connection.ConnectionFactory;
import br.com.lucas.model.bean.Produto;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author lucas
 */
public class ProdutoDAO {
      protected EntityManager entityCon;

    public ProdutoDAO() {
        this.entityCon = new ConnectionFactory().getConnection();
    }
    public Produto create (Produto produto){
        
        try {
            entityCon.getTransaction().begin();
            if (produto.getId() == null) {
                 entityCon.persist(produto);
            }else{
                entityCon.merge(produto);
            }          
            entityCon.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entityCon.getTransaction().rollback();
        }finally{
            entityCon.close();
        }
        return produto;
    }
    public Produto findById(Integer pk){
        Produto produto = null;
        try {
            produto = entityCon.find(Produto.class, pk);
            
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            entityCon.close();
        }
        return produto;
    }
    
    public List<Produto> findAll(){
        List<Produto> produtos = null;
        
        try {
            produtos = entityCon.createQuery("FROM Produto p").getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            entityCon.close();
        }
        return produtos;
    }
}
