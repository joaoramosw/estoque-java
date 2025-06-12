package estoqueDeVendas;

public class ReabastecimentoPadrao implements ReabastecimentoStrategy {
    public boolean precisaReabastecer(Produto produto) {
        return produto.getQuantidade() <= produto.getPontoDeReabastecimento();
    }
}
