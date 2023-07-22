/**
 *
 */
package main.java.br.com.luan.dao;

import main.java.br.com.luan.dao.generic.IGenericDAO;
import main.java.br.com.luan.domain.Venda;
import main.java.br.com.luan.exceptions.DAOException;
import main.java.br.com.luan.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Luan Glaab
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}