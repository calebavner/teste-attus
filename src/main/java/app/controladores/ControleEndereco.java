package app.controladores;

import app.entidades.Endereco;
import app.servicos.ServicoEndereco;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class ControleEndereco {

    private final ServicoEndereco servicoEndereco;

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> alterarEndereco(@PathVariable Long id, @RequestBody @Valid Endereco endereco) {
        return ResponseEntity.ok(servicoEndereco.alterarEndereco(id, endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        return ResponseEntity.ok(servicoEndereco.listarEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(servicoEndereco.buscarEnderecoPorId(id));
    }
}
