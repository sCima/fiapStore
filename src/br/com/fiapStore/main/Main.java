package br.com.fiapStore.main;
import java.sql.SQLException;
import java.util.List;
import br.com.fiapStore.controller.CategoriaController;
import br.com.fiapStore.controller.ProdutoController;
import br.com.fiapStore.model.Categoria;
import br.com.fiapStore.model.Produto;
/**
 @Author Emerson Abraham
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        CategoriaController categoriaController = new CategoriaController();
        ProdutoController produtoController = new ProdutoController();

        List<Categoria> listaCategoria = categoriaController.listarTodas();
        for (Categoria categoria : listaCategoria) {
            System.out.println(categoria.getNome());
        }

        Produto produto1 = new Produto();
        produto1.setNome("God Of War");
        produto1.setDescricao("Jogo de aventura. Recomendação 18+");
        produto1.setIdCategoria(2);
        produtoController.salvarComCategoria(produto1);

        Produto produto2 = new Produto();
        produto2.setNome("Galaxy S24 Ultra");
        produto2.setDescricao("Samsung Galaxy S24 Ultra");
        produto2.setIdCategoria(1);
        produtoController.salvarComCategoria(produto2);

        Produto produto3 = new Produto();
        produto3.setNome("iPhone 15");
        produto3.setDescricao("Apple iPhone 15 Pro");
        produto3.setIdCategoria(1);
        produtoController.salvarComCategoria(produto3);

        listaCategoria = categoriaController.listarComProduto();
        List<Produto> listaProdutos = null;
        for (Categoria categoria : listaCategoria) {
            listaProdutos = categoria.getProdutos();
            for (Produto produtoDaCategoria : listaProdutos) {
                System.out.print("Categoria: " + categoria.getNome() + " -- ");
                System.out.println("Nome do produto: " + produtoDaCategoria.getNome());
            }
        }


        List<Produto> listaProduto = produtoController.listarPorCategoria(2);
        for(Produto produto: listaProduto) {
            System.out.println(produto.getNome() +" -- "+ produto.getIdCategoria());
        }

        produtoController.alterar(produto1);
        produtoController.excluir(3);


    }

}
