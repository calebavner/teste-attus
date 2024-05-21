package app.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USUARIOS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String nome;

    @Column(nullable = false)
    @NotEmpty
    private String dataNascimento;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    private Set<Endereco> enderecos = new HashSet<>();

    public Pessoa(String nome, String dataNascimento, Set<Endereco> enderecos) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }
}
