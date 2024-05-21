package app;

import app.entidades.Pessoa;
import app.repositorios.RepositorioPessoa;
import app.servicos.ServicoPessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static app.modelos_de_teste.ConstantesDeUsuario.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
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

    @Test
    public void listarUsuarios_RetornaListaUsuarios() {

        List<Pessoa> usuarios = new ArrayList<>(){{
            add(PESSOA_VALIDA);
        }};

        when(repositorioPessoa.findAll()).thenReturn(usuarios);
        List<Pessoa> sut = servicoPessoa.listarUsuarios();

        assertThat(sut).hasSize(1);
        assertThat(sut).isNotEmpty();
        assertThat(sut.get(0)).isEqualTo(PESSOA_VALIDA);
    }

    @Test
    public void listarUsuarios_RetornaListaVazia() {
        when(repositorioPessoa.findAll()).thenReturn(Collections.emptyList());
        List<Pessoa> sut = servicoPessoa.listarUsuarios();

        assertThat(sut).isEmpty();
    }

    @Test
    public void buscarUsuario_ComIdValido_RetornaUsuario() {
        when(repositorioPessoa.findById(anyLong())).thenReturn(Optional.of(PESSOA_VALIDA));

        Pessoa sut = servicoPessoa.buscarUsuarioPorId(1L);
        assertThat(sut.getNome()).isNotEmpty();
        assertThat(sut.getNome()).isEqualTo(PESSOA_VALIDA.getNome());
    }

    @Test
    public void buscarUsuario_ComIdInvalido_LancaExcecao() {
        when(repositorioPessoa.findById(1L)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> servicoPessoa.buscarUsuarioPorId(1L)).isInstanceOf(RuntimeException.class);
    }
}
