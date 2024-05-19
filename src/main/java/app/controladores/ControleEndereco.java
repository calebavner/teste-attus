package app.controladores;

import app.entidades.Endereco;
import app.servicos.ServicoEndereco;
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
    public ResponseEntity<Endereco> alterarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        return ResponseEntity.ok(servicoEndereco.alterarEndereco(id, endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos() {
        return ResponseEntity.ok(servicoEndereco.listarEnderecos());
    }
}
