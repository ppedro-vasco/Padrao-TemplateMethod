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

    @Override
    public void cadastrar() {
        situacaoCadastro = true;
        System.out.println("Usuário cadastrado com sucesso!");
    }

    @Override
    public void cancelarCadastro() {
        situacaoCadastro = false;
        System.out.println("Cadastro do usuário cancelado.");
    }
}