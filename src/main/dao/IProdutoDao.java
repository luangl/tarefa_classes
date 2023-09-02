package main.dao;

import main.domain.Produto;

import java.util.List;

public interface IProdutoDao {

    void salvar(Produto produto);

    void atualizar(Produto produto);

    void excluir(Produto produto);

    Produto encontrarPorId(Long id);

    List<Produto> encontrarTodos();
}
