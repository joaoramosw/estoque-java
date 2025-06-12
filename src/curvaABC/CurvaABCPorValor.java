package estoqueDeVendas;

import java.util.*;

public class CurvaABCPorValor implements CurvaABCCalculadora {
    public void calcular(List<Venda> vendas, List<Produto> produtos) {
        Map<Produto, Double> faturamento = new HashMap<Produto, Double>();

        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            List<ItemVenda> itens = venda.getItens();
            for (int j = 0; j < itens.size(); j++) {
                ItemVenda item = itens.get(j);
                Produto produto = item.getProduto();
                double valor = item.getQuantidade() * produto.getPreco();
                Double atual = faturamento.get(produto);
                if (atual == null) {
                    faturamento.put(produto, valor);
                } else {
                    faturamento.put(produto, atual + valor);
                }
            }
        }

        List<Map.Entry<Produto, Double>> listaOrdenada = new ArrayList<Map.Entry<Produto, Double>>(faturamento.entrySet());

        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
            for (int j = i + 1; j < listaOrdenada.size(); j++) {
                if (listaOrdenada.get(i).getValue() < listaOrdenada.get(j).getValue()) {
                    Map.Entry<Produto, Double> temp = listaOrdenada.get(i);
                    listaOrdenada.set(i, listaOrdenada.get(j));
                    listaOrdenada.set(j, temp);
                }
            }
        }

        double total = 0.0;
        for (int i = 0; i < listaOrdenada.size(); i++) {
            total += listaOrdenada.get(i).getValue();
        }

        double acumulado = 0.0;
        for (int i = 0; i < listaOrdenada.size(); i++) {
            Produto produto = listaOrdenada.get(i).getKey();
            double valor = listaOrdenada.get(i).getValue();
            double percentual = (valor / total) * 100;
            acumulado += percentual;

            if (acumulado <= 80) {
                produto.setClassificacaoABC('A');
            } else if (acumulado <= 95) {
                produto.setClassificacaoABC('B');
            } else {
                produto.setClassificacaoABC('C');
            }
        }
    }
}