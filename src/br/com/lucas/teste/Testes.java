/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lucas.teste;

import br.com.lucas.model.bean.Categoria;
import br.com.lucas.model.bean.Produto;
import br.com.lucas.model.dao.CategoriaDAO;
import br.com.lucas.model.dao.ProdutoDAO;

/**
 *
 * @author lucas
 */
public class Testes {

    public static void main(String[] args) {
//        Categoria c = new Categoria();
//        c.setId(5);
//        c.setDescricao("Frios");
//        

//        //  dao.create(c);
//        Categoria findById = dao.findById(5);
//        System.out.println("ID " + findById.getId());
//        System.out.println("Descrição " + findById.getDescricao());
//        for (Categoria categoria : dao.finAll()) {
//            System.out.println("ID " + categoria.getId());
//            System.out.println("Descrição " + categoria.getDescricao());
//        }
//        dao.delete(5);
        CategoriaDAO dao = new CategoriaDAO();
//        Categoria categoria = new Categoria();
//        categoria.setId(2);

        ProdutoDAO daoP = new ProdutoDAO();
//        Produto p = new Produto();
//        p.setDescricao("Refrigerante");
//        p.setQtd(10);
//        p.setValor(4.50);
//
//        p.setCategoria(categoria);

      //  daoP.create(p);
//      Produto produto = daoP.findById(1);
//        System.out.println("Descrição: " + produto.getDescricao());
//        
//       
        for (Produto produto : daoP.findAll()) {
            System.out.println("ID: " + produto.getId());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("Quantidade: " + produto.getQtd());
            System.out.println("Valor: " + produto.getValor());
            System.out.println("Categoria: " + produto.getCategoria().getDescricao());
            System.out.println("");
        }
    }
}
