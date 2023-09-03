/**
 * 
 */
package br.com.luan.dao.factory;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.luan.domain.Produto;
import br.com.luan.domain.ProdutoQuantidade;

/**
 * @author Luan Glaab
 *
 */
public class ProdutoQuantidadeFactory {

	public static ProdutoQuantidade convert(ResultSet rs) throws SQLException {
		Produto prod = ProdutoFactory.convert(rs);
		ProdutoQuantidade prodQ = new ProdutoQuantidade();
		prodQ.setProduto(prod);
		prodQ.setId(rs.getLong("ID"));
		prodQ.setQuantidade(rs.getInt("QUANTIDADE"));
		prodQ.setValorTotal(rs.getBigDecimal("VALOR_TOTAL"));
		return prodQ;
	}
}
