package estoqueDeVendas;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<Produto>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> listarProdutos() {
        List<Produto> copia = new ArrayList<Produto>();
        for (int i = 0; i < produtos.size(); i++) {
            copia.add(produtos.get(i));
        }
        return copia;
    }





/**
 * Retorna uma cópia da lista interna de produtos para fins de leitura.
 */
public List<Produto> getProdutos() {
    return new ArrayList<Produto>(this.produtos);
}

/**
 * Retorna os produtos que precisam ser reabastecidos utilizando a estratégia informada.
 */
public List<Produto> getProdutosParaReabastecer(ReabastecimentoStrategy strategy) {
    List<Produto> reabastecer = new ArrayList<Produto>();
    for (Produto p : produtos) {
        if (strategy.precisaReabastecer(p)) {
            reabastecer.add(p);
        }
    }
    return reabastecer;
}

/**
 * Mantido para compatibilidade: usa a estratégia padrão.
 */
public List<Produto> getProdutosParaReabastecer() {
    return getProdutosParaReabastecer(new ReabastecimentoPadrao());
}

/**
 * Calcula a Curva ABC utilizando a estratégia informada e
 * atualiza a classificação no próprio objeto Produto.
 */
public void calcularCurvaABC(List<Venda> vendas, CurvaABCCalculadora calculadora) {
    calculadora.calcular(vendas, this.produtos);
}

/**
 * Mantido para compatibilidade: usa CurvaABCPorValor como default.
 */
public void calcularCurvaABC(List<Venda> vendas) {
    calcularCurvaABC(vendas, new CurvaABCPorValor());
}

}