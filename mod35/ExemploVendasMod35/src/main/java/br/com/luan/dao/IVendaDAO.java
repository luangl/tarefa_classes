/**
 * 
 */
package br.com.luan.dao;

import br.com.luan.dao.generic.IGenericDAO;
import br.com.luan.domain.Venda;
import br.com.luan.exceptions.DAOException;
import br.com.luan.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Luan Glaab
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
