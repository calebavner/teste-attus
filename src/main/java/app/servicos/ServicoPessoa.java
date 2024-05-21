package app.servicos;

import app.entidades.Endereco;
import app.entidades.Pessoa;
import app.repositorios.RepositorioPessoa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.collection.spi.PersistentSortedMap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public Pessoa buscarUsuarioPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrado nenhum usuário com o id: " + id));
    }

    public Pessoa atualizarDadosDeUsuario(Long id, Pessoa pessoa) {
        return attUsuario(id, pessoa);
    }

    private Pessoa attUsuario(Long id, Pessoa pessoa) {
        Pessoa usuario = repo.findById(id).get();

        usuario.setNome(pessoa.getNome());
        usuario.setDataNascimento(pessoa.getDataNascimento());

        return repo.save(usuario);
    }
}
