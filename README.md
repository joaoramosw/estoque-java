# 📦 Sistema de Estoque com Estratégias de Reabastecimento

Este projeto é uma **Prova de Conceito (PoC)** desenvolvida com o objetivo de aplicar os princípios do **SOLID** e os padrões de projeto **Strategy** e futuramente **Factory**, simulando um sistema de controle de estoque com diferentes estratégias de reabastecimento.

## 🧠 Objetivo do Projeto

✔ Escolha de um tema de pesquisa: *Estoque de Vendas com Curva ABC e Estratégias de Reabastecimento*
✔ Criação de uma Prova de Conceito (PoC) com uso de Padrões de Projeto
✔ Aplicação dos princípios SOLID
✔ Elaboração de um artigo científico
✔ Apresentação final demonstrando a solução implementada

---

## 🧱 Estrutura do Projeto

```
projetoPooa/
├── src/
│   ├── curvaABC/
│   │   └──│CurvaABCCalculadora.java
│   │   └──│CurvaABCPorValor.java
│   ├── reabastecimento/
│   │   └──│ReabastecimentoStrategy.java
│   │   └──│ReabastecimentoPadrao.java
│   │   └──│ReabastecimentoPorLeadTime.java
│   └── estoqueDeVendas/
│       ├── Main.java
│       ├── Produto.java
│       ├── Venda.java
│       ├── ItemVenda.java
│       ├── Estoque.java
```

---

## 🧩 Padrão de Projeto: Strategy

O projeto implementa o padrão **Strategy** para definir diferentes formas de **reabastecimento de estoque**:

* `ReabastecimentoStrategy`: Interface comum para todas as estratégias.
* `ReabastecimentoPadrao`: Estratégia simples baseada no nível mínimo de estoque.
* `ReabastecimentoPorLeadTime`: Estratégia baseada no tempo de entrega do fornecedor.

A aplicação seleciona dinamicamente a estratégia adequada, permitindo **extensibilidade e baixo acoplamento**.

### 💡 Futuro: Padrão Factory

O próximo passo será a implementação do padrão **Factory**, permitindo que a escolha da estratégia de reabastecimento seja feita de forma automática a partir de uma **fábrica de estratégias**.

---

## ⚙️ Como Usar

1. Clone o repositório:

   ```bash
   git clone https://github.com/joaoramosw/estoqueDeVendas_pooa.git
   ```
2. Acesse o diretório:

   ```bash
   cd estoqueDeVendas_pooa/projetoPooa
   ```
3. Compile e execute:

   ```bash
   javac -d bin src/estoqueDeVendas/*.java src/application/Main.java
   java -cp bin application.Main
   ```

---

## 📌 Funcionalidades

* Cálculo da **Curva ABC** por valor total de vendas
* Controle de produtos e vendas
* Estratégias de reabastecimento com base em critérios de negócio
* Simulação de vendas e necessidades de reposição

---

## 🧪 Tecnologias

* Java 11+
* Paradigma Orientado a Objetos Avançado
* Eclipse IDE (estrutura de projeto compatível)

---

## 🧑‍💻 Autor

* [@joaoramosty](https://github.com/joaoramosw)
* [@luisGustavoSilv](https://github.com/luisGustavoSilv)

---

## 📄 Licença

Este projeto está sob a licença [MIT](https://choosealicense.com/licenses/mit/).

---

## 🔖 Etiquetas

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![Padrão Strategy](https://img.shields.io/badge/Pattern-Strategy-blue.svg)](https://refactoring.guru/design-patterns/strategy)
[![SOLID](https://img.shields.io/badge/SOLID-Principles-orange.svg)](https://en.wikipedia.org/wiki/SOLID)

