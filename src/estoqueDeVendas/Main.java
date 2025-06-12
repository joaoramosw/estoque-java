
package application;

import java.util.ArrayList;
import java.util.List;

import estoqueDeVendas.CurvaABCCalculadora;
import estoqueDeVendas.CurvaABCPorValor;
import estoqueDeVendas.Estoque;
import estoqueDeVendas.ItemVenda;
import estoqueDeVendas.Produto;
import estoqueDeVendas.ReabastecimentoPadrao;
import estoqueDeVendas.ReabastecimentoPorLeadTime;
import estoqueDeVendas.ReabastecimentoStrategy;
import estoqueDeVendas.Venda;

public class Main {
    public static void main(String[] args) {

        // -----------------------------
        // 1. Instanciação de produtos
        // -----------------------------
        Produto p1 = new Produto("Caneta", 2.50, 40, 30);
        Produto p2 = new Produto("Caderno", 15.00, 50, 20);
        Produto p3 = new Produto("Lápis", 1.00, 200, 50);

        // -----------------------------
        // 2. Estoque
        // -----------------------------
        Estoque estoque = new Estoque();
        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        estoque.adicionarProduto(p3);

        // -----------------------------
        // 3. Criação de vendas
        // -----------------------------
        List<Venda> vendas = new ArrayList<>();

        Venda venda1 = new Venda();
        venda1.adicionarItem(new ItemVenda(p1, 40));
        venda1.adicionarItem(new ItemVenda(p2, 10));
        vendas.add(venda1);

        Venda venda2 = new Venda();
        venda2.adicionarItem(new ItemVenda(p3, 100));
        vendas.add(venda2);

        // -----------------------------
        // 4. Check‑out das vendas
        // -----------------------------
        int contador = 1;
        for (Venda venda : vendas) {
            double total = venda.getTotal();
            System.out.println("Check‑out da Venda " + contador + ": R$ " + total);

            // Atualiza o estoque
            for (ItemVenda item : venda.getItens()) {
                item.getProduto().removerEstoque(item.getQuantidade());
            }
            contador++;
        }

        // -----------------------------
        // 5. Produtos para reabastecer
        // -----------------------------
        System.out.println("\nProdutos que precisam ser reabastecidos (estratégia padrão):");
        for (Produto produto : estoque.getProdutosParaReabastecer()) {
            System.out.println(produto.getNome() + " – Quantidade atual: " + produto.getQuantidade());
        }

        // Exemplo usando a nova estratégia baseada em lead‑time
        ReabastecimentoStrategy estrategiaLT = new ReabastecimentoPorLeadTime(30, 5, 20);
        System.out.println("\nProdutos que precisam ser reabastecidos (estratégia lead‑time):");
        for (Produto produto : estoque.getProdutosParaReabastecer(estrategiaLT)) {
            System.out.println(produto.getNome() + " – Quantidade atual: " + produto.getQuantidade());
        }

        // -----------------------------
        // 6. Curva ABC
        // -----------------------------
        CurvaABCCalculadora calculadora = new CurvaABCPorValor();
        estoque.calcularCurvaABC(vendas, calculadora);

        System.out.println("\nCurva ABC dos produtos:");
        for (Produto produto : estoque.getProdutos()) {
            System.out.println(produto.getNome() + " – Classe " + produto.getClassificacaoABC());
        }
    }
}
