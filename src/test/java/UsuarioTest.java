import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest{
    @Test
    void deveRetornarTipoUsuarioCPF() {
        UsuarioPessoaFisica usuario = new UsuarioPessoaFisica();
        usuario.setDocumento("CPF");
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setCpf("15183551618");

        assertEquals("Pessoa Física: 15183551618", usuario.tipoUsuario());
    }

    @Test
    void deveRetornarInfoUsuarioCPF() {
        UsuarioPessoaFisica usuario = new UsuarioPessoaFisica();
        usuario.setDocumento("CPF");
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        usuario.setCpf("151.835.516-18");

        assertEquals("Usuario{documento='CPF', nome='João', email='joao@example.com', tipo de usuário='Pessoa Física: 151.835.516-18}", usuario.getInfo());
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

        assertEquals("Usuario{documento='CNPJ', nome='João', email='joao@example.com', tipo de usuário='Pessoa Jurídica: 27.829.856/0001-20}", usuario.getInfo());
    }
}