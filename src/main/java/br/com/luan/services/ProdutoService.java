/**
 *
 */
package main.java.br.com.luan.services;

import main.java.br.com.luan.dao.IProdutoDAO;
import main.java.br.com.luan.domain.Produto;
import main.java.br.com.luan.services.generic.GenericService;

/**
 * @author Luan Glaab
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}