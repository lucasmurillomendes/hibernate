/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.model.dao;

import br.com.lucas.connection.ConnectionFactory;
import br.com.lucas.model.bean.Categoria;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author lucas
 */
public class CategoriaDAO {

    protected EntityManager entityCon;

    public CategoriaDAO() {
        this.entityCon = new ConnectionFactory().getConnection();
    }

    public Categoria create(Categoria categoria) {
        try {
            entityCon.getTransaction().begin();
            if (categoria.getId() == null) {
                entityCon.persist(categoria);
            } else {
                entityCon.merge(categoria);
            }
            entityCon.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entityCon.getTransaction().rollback();
        } finally {
            entityCon.close();
        }
        return categoria;
    }
    
    public Categoria delete(Integer pk) {
        Categoria categoria = null;
        try {
            categoria = entityCon.find(Categoria.class, pk);
            entityCon.getTransaction().begin();
            entityCon.remove(categoria);
            entityCon.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            entityCon.getTransaction().rollback();
        } finally {
            entityCon.close();
        }
        return categoria;
    }

    public Categoria findById(Integer pk) {
        Categoria categoria = null;
        try {
            categoria = entityCon.find(Categoria.class, pk);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            entityCon.close();
        }
        return categoria;
    }

    public List<Categoria> findAll() {
        List<Categoria> categorias = null;
        try {
            //uso JPQL (select na Classe e não na tabela)
            categorias = entityCon.createQuery("FROM Categoria c").getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            entityCon.close();
        }
        return categorias;
    }

    
}
