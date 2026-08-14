package sistema_financeiro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import sistema_financeiro.dao.ClienteDAO;
import sistema_financeiro.dao.ContaReceberDAO;
import sistema_financeiro.model.Cliente;
import sistema_financeiro.model.ContaReceber;

public class App {
    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();
        ContaReceberDAO contaDAO = new ContaReceberDAO();

        // Cliente que já foi salvo no banco anteriormente
        Cliente cliente = new Cliente(1, "Empresa ABC Ltda", "12.345.678/0001-90");
        // clienteDAO.cadastrar(cliente); // Comentado pois o cliente ID 1 já está no
        // PostgreSQL

        // Criando a conta com ID e todos os parâmetros
        ContaReceber conta = new ContaReceber();
        conta.setId(1);
        conta.setCliente(cliente);
        conta.setDescricao("Consultoria de TI - Mês 08");
        conta.setValor(new BigDecimal("2500.00"));
        conta.setDataVencimento(LocalDate.now().plusDays(15));
        conta.setStatus("PENDENTE");

        // Cadastrando no banco
        contaDAO.cadastrar(conta);

        // Listando os registros cadastrados
        System.out.println("\n--- LISTA DE CONTAS A RECEBER ---");
        List<ContaReceber> contas = contaDAO.listarTodas();
        for (ContaReceber c : contas) {
            System.out.println(c);
        }
    }
}