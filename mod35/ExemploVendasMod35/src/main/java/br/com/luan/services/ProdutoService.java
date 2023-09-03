/**
 * 
 */
package br.com.luan.services;

import br.com.luan.dao.IProdutoDAO;
import br.com.luan.domain.Produto;
import br.com.luan.services.generic.GenericService;

/**
 * @author Luan Glaab
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
