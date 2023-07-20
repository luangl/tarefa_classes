package br.com.luan;

import br.com.luan.dao.ClienteDao;
import br.com.luan.dao.ClienteDaoMock;
import br.com.luan.dao.IClienteDao;
import br.com.luan.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Luan Glaab
 */
public class ClienteServiceTest {

    @Test
    public void salvarTest() {
        IClienteDao mockDao = new ClienteDaoMock();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IClienteDao mockDao = new ClienteDao();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }
}
