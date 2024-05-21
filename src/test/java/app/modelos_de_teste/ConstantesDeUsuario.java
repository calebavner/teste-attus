package app.modelos_de_teste;

import app.entidades.Endereco;
import app.entidades.Pessoa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstantesDeUsuario {

    public static final Endereco ENDERECO = new Endereco("logradouro", "cep", "numero", "cidade", "estado", true);
    public static final Set<Endereco> CONJUNTO_ENDERECO = new HashSet<>(List.of(ENDERECO));

    public static final Pessoa PESSOA_VALIDA = new Pessoa("nome", "dataAniversario", CONJUNTO_ENDERECO);
    public static final Pessoa PESSOA_INVALIDA = new Pessoa(" ", " ", null);
}
