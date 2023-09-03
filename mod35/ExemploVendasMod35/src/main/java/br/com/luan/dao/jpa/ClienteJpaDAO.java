/**
 * 
 */
package br.com.luan.dao.jpa;

import br.com.luan.dao.generic.jpa.GenericJpaDAO;
import br.com.luan.domain.jpa.ClienteJpa;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteJpaDAO extends GenericJpaDAO<ClienteJpa, Long> implements IClienteJpaDAO {

	public ClienteJpaDAO() {
		super(ClienteJpa.class);
	}

}
