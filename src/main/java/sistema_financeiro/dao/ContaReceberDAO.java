package sistema_financeiro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema_financeiro.model.Cliente;
import sistema_financeiro.model.ContaReceber;

public class ContaReceberDAO {

    public void cadastrar(ContaReceber conta) {
        String sql = "INSERT INTO tb_conta_receber (id, id_cliente, descricao, valor, data_vencimento, data_pagamento, status) "
                +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, conta.getId());
            stmt.setInt(2, conta.getCliente().getId());
            stmt.setString(3, conta.getDescricao());
            stmt.setBigDecimal(4, conta.getValor());
            stmt.setDate(5, Date.valueOf(conta.getDataVencimento()));

            if (conta.getDataPagamento() != null) {
                stmt.setDate(6, Date.valueOf(conta.getDataPagamento()));
            } else {
                stmt.setNull(6, java.sql.Types.DATE);
            }

            stmt.setString(7, conta.getStatus());

            stmt.executeUpdate();
            System.out.println("Conta a receber cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar conta: " + e.getMessage());
        }
    }

    public List<ContaReceber> listarTodas() {
        String sql = "SELECT cr.id, cr.descricao, cr.valor, cr.data_vencimento, cr.data_pagamento, cr.status, " +
                "c.id AS cliente_id, c.nome AS cliente_nome, c.cpf_cnpj " +
                "FROM tb_conta_receber cr " +
                "INNER JOIN tb_cliente c ON cr.id_cliente = c.id";

        List<ContaReceber> contas = new ArrayList<>();

        try (Connection conn = ConexaoBanco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("cliente_nome"),
                        rs.getString("cpf_cnpj"));

                ContaReceber conta = new ContaReceber();
                conta.setId(rs.getInt("id"));
                conta.setCliente(cliente);
                conta.setDescricao(rs.getString("descricao"));
                conta.setValor(rs.getBigDecimal("valor"));
                conta.setDataVencimento(rs.getDate("data_vencimento").toLocalDate());

                Date dataPagto = rs.getDate("data_pagamento");
                if (dataPagto != null) {
                    conta.setDataPagamento(dataPagto.toLocalDate());
                }

                conta.setStatus(rs.getString("status"));

                contas.add(conta);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar contas: " + e.getMessage());
        }

        return contas;
    }
}