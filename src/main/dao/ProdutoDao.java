package main.dao;

import main.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProdutoDao extends Produto {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void salvar(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    public void atualizar(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    public void excluir(Produto produto) {
        entityManager.remove(produto);
    }

    @Override
    public Produto encontrarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    public List<Produto> encontrarTodos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }
}

