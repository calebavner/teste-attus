package app.servicos;

import app.entidades.Endereco;
import app.repositorios.RepositorioEndereco;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoEndereco {

    private final RepositorioEndereco repositorioEndereco;

    public Endereco cadastrarEndereco(Endereco endereco) {
        return repositorioEndereco.save(endereco);
    }

    public List<Endereco> listarEnderecos() {
        return repositorioEndereco.findAll();
    }

    public Endereco alterarEndereco(Long id, Endereco endereco) {
        return attEndereco(id, endereco);
    }

    public Endereco buscarEnderecoPorId(Long id) {
        return repositorioEndereco.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi possível encontrar um endereço para id: " + id));
    }

    private Endereco attEndereco(Long id, Endereco endereco) {
        Endereco novoEndereco = repositorioEndereco.findById(id).get();
        novoEndereco.setCep(endereco.getCep());
        novoEndereco.setLogradouro(endereco.getLogradouro());
        novoEndereco.setNumero(endereco.getNumero());
        novoEndereco.setEstado(endereco.getEstado());
        novoEndereco.setCidade(endereco.getCidade());

        return repositorioEndereco.save(novoEndereco);
    }
}
