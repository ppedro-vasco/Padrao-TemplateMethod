public abstract class Usuario {
    protected String documento;
    protected String nome;
    protected String email;
    protected boolean situacaoCadastro;

    public abstract String tipoUsuario();

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public boolean situacaoCadastro() {
        return situacaoCadastro;
    }

    public void cadastrar() {
        situacaoCadastro = true;
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void cancelarCadastro() {
        situacaoCadastro = false;
        System.out.println("Cadastro do usuário cancelado.");
    }

    public String getInfo() {
        String tipoUsuario = tipoUsuario();
        return "Usuário{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipo de usuário='" + tipoUsuario +
                '}';
    }
}
