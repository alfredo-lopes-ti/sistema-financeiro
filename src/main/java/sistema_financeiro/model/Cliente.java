package sistema_financeiro.model;

public class Cliente {
    private int id;
    private String nome;
    private String cpfCnpj;

    public Cliente() {
    };

    public Cliente(int id, String nome, String cpfCnpj) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String toString() {
        return "Cliente [ID: \" + id + \" | Nome: \" + nome + \" | CPF/CNPJ: \" + cpfCnpj + \"]";
    }

}
