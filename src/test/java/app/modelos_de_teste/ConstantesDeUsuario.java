package app.modelos_de_teste;

import app.entidades.Endereco;
import app.entidades.Pessoa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstantesDeUsuario {

    public static  Endereco ENDERECO_VALIDO = new Endereco("logradouro", "cep", "numero", "cidade", "estado", true);
    public static final Endereco ENDERECO_INVALIDO = new Endereco("", "cep", "numero", "cidade", "estado", true);

    public static final Set<Endereco> CONJUNTO_ENDERECO_VALIDOS = new HashSet<>(List.of(ENDERECO_VALIDO));
    public static final Set<Endereco> CONJUNTO_ENDERECO_INVALIDOS = new HashSet<>(List.of(ENDERECO_INVALIDO));

    public static final Pessoa PESSOA_VALIDA = new Pessoa("nome", "dataAniversario", CONJUNTO_ENDERECO_VALIDOS);
    public static final Pessoa PESSOA_INVALIDA = new Pessoa(" ", " ", CONJUNTO_ENDERECO_INVALIDOS);
}
