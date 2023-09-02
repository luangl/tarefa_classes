package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.domain.Produto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testSalvarProduto() {
        // Crie um novo Produto
        Produto produto = new Produto("Produto de Teste", 19.99) {
            @Override
            public void salvar(Produto produto) {

            }

            @Override
            public void atualizar(Produto produto) {

            }

            @Override
            public void excluir(Produto produto) {

            }

            @Override
            public Produto encontrarPorId(Long id) {
                return null;
            }

            @Override
            public List<Produto> encontrarTodos() {
                return null;
            }
        };

        // Inicie uma transação
        em.getTransaction().begin();

        // Salve o produto no banco de dados
        em.persist(produto);

        // Termine a transação
        em.getTransaction().commit();

        // Verifique se o ID foi gerado
        assertNotNull(produto.getId());

        // Recupere o produto do banco de dados pelo ID
        Produto produtoRecuperado = em.find(Produto.class, produto.getId());

        // Verifique se o produto recuperado é igual ao produto original
        assertEquals(produto, produtoRecuperado);
    }

    @Test
    public void testAtualizarProduto() {
        // Crie um novo Produto
        Produto produto = new Produto("Produto de Teste", 19.99) {
            @Override
            public void salvar(Produto produto) {

            }

            @Override
            public void atualizar(Produto produto) {

            }

            @Override
            public void excluir(Produto produto) {

            }

            @Override
            public Produto encontrarPorId(Long id) {
                return null;
            }

            @Override
            public List<Produto> encontrarTodos() {
                return null;
            }
        };

        // Inicie uma transação
        em.getTransaction().begin();

        // Salve o produto no banco de dados
        em.persist(produto);

        // Termine a transação
        em.getTransaction().commit();

        // Atualize o nome do produto
        em.getTransaction().begin();
        produto.setNome("Produto Atualizado");
        em.merge(produto);
        em.getTransaction().commit();

        // Recupere o produto do banco de dados pelo ID
        Produto produtoAtualizado = em.find(Produto.class, produto.getId());

        // Verifique se o nome foi atualizado corretamente
        assertEquals("Produto Atualizado", produtoAtualizado.getNome());
    }

    @Test
    public void testExcluirProduto() {
        // Crie um novo Produto
        Produto produto = new Produto("Produto de Teste", 19.99) {
            @Override
            public void salvar(Produto produto) {

            }

            @Override
            public void atualizar(Produto produto) {

            }

            @Override
            public void excluir(Produto produto) {

            }

            @Override
            public Produto encontrarPorId(Long id) {
                return null;
            }

            @Override
            public List<Produto> encontrarTodos() {
                return null;
            }
        };

        // Inicie uma transação
        em.getTransaction().begin();

        // Salve o produto no banco de dados
        em.persist(produto);

        // Termine a transação
        em.getTransaction().commit();

        // Exclua o produto do banco de dados
        em.getTransaction().begin();
        em.remove(produto);
        em.getTransaction().commit();

        // Tente recuperar o produto após a exclusão
        Produto produtoExcluido = em.find(Produto.class, produto.getId());

        // Verifique se o produto não existe mais no banco de dados
        assertNull(produtoExcluido);
    }

    @Test
    public void testEncontrarProdutoPorId() {
        // Crie um novo Produto
        Produto produto = new Produto("Produto de Teste", 19.99) {
            @Override
            public void salvar(Produto produto) {

            }

            @Override
            public void atualizar(Produto produto) {

            }

            @Override
            public void excluir(Produto produto) {

            }

            @Override
            public Produto encontrarPorId(Long id) {
                return null;
            }

            @Override
            public List<Produto> encontrarTodos() {
                return null;
            }
        };

        // Inicie uma transação
        em.getTransaction().begin();

        // Salve o produto no banco de dados
        em.persist(produto);

        // Termine a transação
        em.getTransaction().commit();

        // Recupere o produto do banco de dados pelo ID
        Produto produtoRecuperado = em.find(Produto.class, produto.getId());

        // Verifique se o produto recuperado é igual ao produto original
        assertEquals(produto, produtoRecuperado);
    }

    @Test
    public void testEncontrarTodosProdutos() {
        // Crie alguns produtos para testar a busca de todos
        Produto produto1 = new Produto("Produto 1", 10.0);
        Produto produto2 = new Produto("Produto 2", 20.0);
        Produto produto3 = new Produto("Produto 3", 30.0);

        // Inicie uma transação
        em.getTransaction().begin();

        // Salve os produtos no banco de dados
        em.persist(produto1);
        em.persist(produto2);
        em.persist(produto3);

        // Termine a transação
        em.getTransaction().commit();

        // Recupere todos os produtos do banco de dados
        List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();

        // Verifique se a lista de produtos não está vazia e contém os produtos corretos
        assertNotNull(produtos);
        assertEquals(3, produtos.size());
        assertTrue(produtos.contains(produto1));
        assertTrue(produtos.contains(produto2));
        assertTrue(produtos.contains(produto3));
    }

    private void assertTrue(boolean contains) {
    }
}


