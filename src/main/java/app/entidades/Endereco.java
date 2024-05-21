package app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String logradouro;

    @Column(nullable = false)
    @NotEmpty
    private String cep;

    @Column(nullable = false)
    @NotEmpty
    private String numero;

    @Column(nullable = false)
    @NotEmpty
    private String cidade;

    @Column(nullable = false)
    @NotEmpty
    private String estado;

    @Column(nullable = false)
    @NotNull
    private boolean enderecoPrincipal;

    public Endereco(String logradouro, String cep, String numero, String cidade, String estado, boolean enderecoPrincipal) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.enderecoPrincipal = enderecoPrincipal;
    }
}
