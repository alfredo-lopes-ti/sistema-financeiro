# Sistema Financeiro - Módulo Contas a Receber (Java + JDBC)

Aplicação enterprise em Java voltada para a gestão de contas a receber com integração a banco de dados relacional (PostgreSQL). O projeto foi desenvolvido aplicando boas práticas de Orientação a Objetos, padrão DAO (Data Access Object) e manipulação precisa de dados financeiros e temporais.

---

## Tecnologias Utilizadas

* **Linguagem:** Java 25
* **Gerenciador de Dependências:** Maven
* **Banco de Dados:** PostgreSQL
* **Driver JDBC:** PostgreSQL JDBC Driver

---

## Diferenciais Técnicos e Arquitetura

* **Precisão Financeira:** Utilização de `BigDecimal` para evitar problemas de arredondamento em valores monetários.
* **Manipulação de Datas:** Aplicação da API `java.time.LocalDate` para vencimentos e pagamentos.
* **Mapeamento Relacional (POO + SQL):** Associação direta entre objetos de domínio (`ContaReceber` possui um `Cliente`).
* **Segurança e Desempenho:** Uso de `PreparedStatement` para prevenção de *SQL Injection* e `try-with-resources` para gestão automática de conexões e recursos do banco.
* **Arquitetura em Camadas:** Divisão clara entre o modelo de domínio (`model`) e a camada de acesso aos dados (`dao`).

---

## Estrutura do Banco de Dados

```sql
CREATE TABLE tb_cliente (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf_cnpj VARCHAR(20) NOT NULL
);

CREATE TABLE tb_conta_receber (
    id INT PRIMARY KEY,
    id_cliente INT REFERENCES tb_cliente(id),
    descricao VARCHAR(150) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    status VARCHAR(20) NOT NULL
);

