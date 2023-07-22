/**
 *
 */
package main.java.br.com.luan.services.generic;

import java.io.Serializable;
import java.util.Collection;

import main.java.br.com.luan.dao.IClienteDAO;
import main.java.br.com.luan.dao.IProdutoDAO;
import main.java.br.com.luan.dao.Persistente;
import main.java.br.com.luan.dao.generic.IGenericDAO;
import main.java.br.com.luan.exceptions.DAOException;
import main.java.br.com.luan.exceptions.MaisDeUmRegistroException;
import main.java.br.com.luan.exceptions.TableException;
import main.java.br.com.luan.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Luan Glaab
 *
 */
public abstract class GenericService<T extends Persistente, E extends Serializable>
        implements IGenericService<T, E> {

    protected IGenericDAO<T,E> dao;

    public GenericService(IClienteDAO dao) {
        this.dao = (IGenericDAO<T, E>) dao;
    }

    public GenericService(IProdutoDAO dao) {
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(E valor) throws DAOException {
        this.dao.excluir(valor);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws DAOException {
        try {
            return this.dao.consultar(valor);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            //TODO levantar um erro genérico
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<T> buscarTodos() throws DAOException {
        return this.dao.buscarTodos();
    }

}