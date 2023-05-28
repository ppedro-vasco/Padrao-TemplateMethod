public abstract class Usuario {
    protected String documento;
    protected String nome;
    protected String email;

    public abstract String tipoUsuario();;

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

    public String getInfo() {
        String tipoUsuario = tipoUsuario();
        return "Usuario{" +
                "documento='" + documento + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipo de usuário='" + tipoUsuario +
                '}';
    }
}
