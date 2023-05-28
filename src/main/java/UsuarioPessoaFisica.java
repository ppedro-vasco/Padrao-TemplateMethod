public class UsuarioPessoaFisica extends Usuario {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String tipoUsuario() {
        return "Pessoa Física: " + cpf;
    }

}