package app.servicos;

import app.entidades.Endereco;
import app.repositorios.RepositorioEndereco;
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
}
