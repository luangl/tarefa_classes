/**
 *
 */
package main.java.br.com.luan.services;

import main.java.br.com.luan.domain.Cliente;
import main.java.br.com.luan.exceptions.DAOException;
import main.java.br.com.luan.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.luan.services.generic.IGenericService;

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