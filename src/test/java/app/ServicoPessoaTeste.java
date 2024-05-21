package app;

import app.entidades.Pessoa;
import app.repositorios.RepositorioPessoa;
import app.servicos.ServicoPessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static app.modelos_de_teste.ConstantesDeUsuario.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicoPessoaTeste {

    @InjectMocks
    private ServicoPessoa servicoPessoa;

    @Mock
    private RepositorioPessoa repositorioPessoa;

    @Test
    public void cadastrarUsuario_ComDadosValidos_RetornaUsuario() {

        when(repositorioPessoa.save(PESSOA_VALIDA)).thenReturn(PESSOA_VALIDA);
        Pessoa sut = servicoPessoa.cadastrarUsuario(PESSOA_VALIDA);

        assertThat(sut).isEqualTo(PESSOA_VALIDA);
        assertThat(sut.getEnderecos()).isEqualTo(CONJUNTO_ENDERECO);
    }

    @Test
    public void cadastrarUsuario_ComDadosInvalidos_LancaExcecao() {

        when(repositorioPessoa.save(PESSOA_INVALIDA)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> servicoPessoa.cadastrarUsuario(PESSOA_INVALIDA)).isInstanceOf(RuntimeException.class);
    }
}
