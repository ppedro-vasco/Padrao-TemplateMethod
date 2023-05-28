public class UsuarioPessoaJuridica extends Usuario {
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String tipoUsuario() {
        return "Pessoa Jurídica: " + cnpj;
    }
}