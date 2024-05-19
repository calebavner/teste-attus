package app.servicos;

import app.entidades.Pessoa;
import app.repositorios.RepositorioPessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicoPessoa {

    private final RepositorioPessoa repo;

    public Pessoa cadastrarUsuario(Pessoa pessoa) {
        return repo.save(pessoa);
    }

    public List<Pessoa> listarUsuarios() {
        return repo.findAll();
    }
}
