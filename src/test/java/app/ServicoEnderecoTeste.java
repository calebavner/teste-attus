package app;

import app.entidades.Endereco;
import app.entidades.Pessoa;
import app.repositorios.RepositorioEndereco;
import app.servicos.ServicoEndereco;
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
public class ServicoEnderecoTeste {

    @InjectMocks
    private ServicoEndereco servicoEndereco;

    @Mock
    private RepositorioEndereco repositorioEndereco;

    @Test
    public void listarEnderecos_RetornaListaEnderecos() {

        List<Endereco> enderecos = new ArrayList<>(){{
            add(ENDERECO_VALIDO);
        }};

        when(repositorioEndereco.findAll()).thenReturn(enderecos);
        List<Endereco> sut = servicoEndereco.listarEnderecos();

        assertThat(sut).hasSize(1);
        assertThat(sut).isNotEmpty();
        assertThat(sut.get(0)).isEqualTo(ENDERECO_VALIDO);
    }

    @Test
    public void listarEnderecos_RetornaListaVazia() {
        when(repositorioEndereco.findAll()).thenReturn(Collections.emptyList());
        List<Endereco> sut = servicoEndereco.listarEnderecos();

        assertThat(sut).isEmpty();
    }

    @Test
    public void buscarEndereco_ComIdValido_RetornaEndereco() {
        when(repositorioEndereco.findById(anyLong())).thenReturn(Optional.of(ENDERECO_VALIDO));

        Endereco sut = servicoEndereco.buscarEnderecoPorId(1L);
        assertThat(sut.getLogradouro()).isNotEmpty();
        assertThat(sut.getLogradouro()).isEqualTo(ENDERECO_VALIDO.getLogradouro());
    }

    @Test
    public void buscarEndereco_ComIdInvalido_LancaExcecao() {
        when(repositorioEndereco.findById(1L)).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> servicoEndereco.buscarEnderecoPorId(1L)).isInstanceOf(RuntimeException.class);
    }
}
