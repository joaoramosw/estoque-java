
package estoqueDeVendas;

/**
 * Estratégia de reabastecimento que leva em conta consumo médio diário,
 * tempo de reposição (lead time) e estoque de segurança.
 *
 * Ponto de Reabastecimento = consumoMedioDiario × tempoReposicaoDias + estoqueSeguranca
 */
public class ReabastecimentoPorLeadTime implements ReabastecimentoStrategy {

    private int consumoMedioDiario;
    private int tempoReposicaoDias;
    private int estoqueSeguranca;

    public ReabastecimentoPorLeadTime(int consumoMedioDiario, int tempoReposicaoDias, int estoqueSeguranca) {
        this.consumoMedioDiario = consumoMedioDiario;
        this.tempoReposicaoDias = tempoReposicaoDias;
        this.estoqueSeguranca = estoqueSeguranca;
    }

    @Override
    public boolean precisaReabastecer(Produto produto) {
        int pontoDePedidoCalculado = consumoMedioDiario * tempoReposicaoDias + estoqueSeguranca;
        return produto.getQuantidade() <= pontoDePedidoCalculado;
    }
}
