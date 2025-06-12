package estoqueDeVendas;

import java.util.List;

public interface CurvaABCCalculadora {
    void calcular(List<Venda> vendas, List<Produto> produtos);
}