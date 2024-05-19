package app.repositorios;

import app.entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEndereco extends JpaRepository<Endereco, Long> {
}
