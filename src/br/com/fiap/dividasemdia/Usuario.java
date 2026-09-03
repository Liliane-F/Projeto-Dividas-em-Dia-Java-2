package br.com.fiap.dividasemdia;

public class Usuario {
    private Long idUsuario;
    private String nome;
    private String email;
    private String cpf;
    private String statusConta;

    //Construtor com Parâmetros
    public Usuario(Long idUsuario, String nmUsuario, String emailUsuario, String cpfUsuario, String telefoneUsuario, String stConta) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.statusConta = statusConta;
    }

    //Getters e Setters
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(String statusConta) {
        this.statusConta = statusConta;
    }
}
