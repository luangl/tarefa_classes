/**
 * 
 */
package br.com.luan.services;

import br.com.luan.domain.Cliente;
import br.com.luan.exceptions.DAOException;
import br.com.luan.services.generic.IGenericService;

/**
 * @author Luan Glaab
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
