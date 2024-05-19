package app.controladores;

import app.entidades.Endereco;
import app.entidades.Pessoa;
import app.servicos.ServicoEndereco;
import app.servicos.ServicoPessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class ControlePessoa {

    private final ServicoPessoa servicoPessoa;
    private final ServicoEndereco servicoEndereco;

    @PostMapping("/cadastrar")
    public ResponseEntity<Pessoa> cadastrarUsuario(@RequestBody Pessoa pessoa, UriComponentsBuilder uriBuilder) {

        Set<Endereco> enderecos = pessoa.getEnderecos();

        for(Endereco e : enderecos)
            servicoEndereco.cadastrarEndereco(e);

        Pessoa novoUsuario = servicoPessoa.cadastrarUsuario(pessoa);
        URI uri = uriBuilder.path("/{id}").buildAndExpand(novoUsuario.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarUsuarios() {
        return ResponseEntity.ok(servicoPessoa.listarUsuarios());
    }
}
