/**
 * 
 */
package br.com.luan.dao.jpa;

import br.com.luan.dao.generic.jpa.GenericJpaDAO;
import br.com.luan.domain.jpa.ProdutoJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoJpaDAO extends GenericJpaDAO<ProdutoJpa, Long> implements IProdutoJpaDAO {

	public ProdutoJpaDAO() {
		super(ProdutoJpa.class);
	}

}
