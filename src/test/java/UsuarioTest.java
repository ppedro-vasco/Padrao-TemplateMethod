import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest{
    @Test
    void deveRetornarTipoUsuarioCPF() {
        UsuarioPessoaFisica usuario = new UsuarioPessoaFisica();
        usuario.setDocumento("CPF");
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setCpf("151.835.516-18");

        assertEquals("Pessoa Física: 151.835.516-18", usuario.tipoUsuario());
    }

    @Test
    void deveRetornarInfoUsuarioCPF() {
        UsuarioPessoaFisica usuario = new UsuarioPessoaFisica();
        usuario.setDocumento("CPF");
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setCpf("151.835.516-18");

        assertEquals("Usuário{documento='CPF', nome='João', email='joao@example.com', tipo de usuário='Pessoa Física: 151.835.516-18}", usuario.getInfo());
    }

    @Test
    void deveRetornarTipoUsuarioCNPJ() {
        UsuarioPessoaJuridica usuario = new UsuarioPessoaJuridica();
        usuario.setDocumento("CNPJ");
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setCnpj("27.829.856/0001-20");

        assertEquals("Pessoa Jurídica: 27.829.856/0001-20", usuario.tipoUsuario());
    }

    @Test
    void deveRetornarInfoUsuarioCNPJ() {
        UsuarioPessoaJuridica usuario = new UsuarioPessoaJuridica();
        usuario.setDocumento("CNPJ");
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setCnpj("27.829.856/0001-20");

        assertEquals("Usuário{documento='CNPJ', nome='João', email='joao@example.com', tipo de usuário='Pessoa Jurídica: 27.829.856/0001-20}", usuario.getInfo());
    }

    @Test
    void deveRetornarUsuarioCpfCadastrado(){
        Usuario usuario = new UsuarioPessoaFisica();
        usuario.cadastrar();

        assertTrue(usuario.situacaoCadastro);
    }

    @Test
    void deveRetornarUsuarioCpfNAOCadastrado(){
        Usuario usuario = new UsuarioPessoaFisica();

        assertFalse(usuario.situacaoCadastro);
    }

    @Test
    void deveRetornarUsuarioCnpjCadastrado(){
        Usuario usuario = new UsuarioPessoaJuridica();
        usuario.cadastrar();

        assertTrue(usuario.situacaoCadastro);
    }

    @Test
    void deveRetornarUsuarioCnpjNAOCadastrado(){
        Usuario usuario = new UsuarioPessoaJuridica();

        assertFalse(usuario.situacaoCadastro);
    }

    @Test
    void deveCancelarCadastroUsuarios(){
        Usuario usuarioCpf = new UsuarioPessoaFisica();
        Usuario usuarioCnpj = new UsuarioPessoaJuridica();

        usuarioCpf.cadastrar();
        usuarioCnpj.cadastrar();

        assertTrue(usuarioCpf.situacaoCadastro);
        assertTrue(usuarioCnpj.situacaoCadastro);

        usuarioCpf.cancelarCadastro();
        usuarioCnpj.cancelarCadastro();

        assertFalse(usuarioCpf.situacaoCadastro);
        assertFalse(usuarioCnpj.situacaoCadastro);
    }

}