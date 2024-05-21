<h1 align="center">
  Avaliação Attus
</h1>

API para gerenciamento de usuarios (CRUD) que faz parte [desse desafio](https://github.com/RocketBus/quero-ser-clickbus/tree/master/testes/backend-developer) para pessoas desenvolvedoras backend que se candidatam para a ClickBus.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)

## Práticas adotadas

- SOLID
- Testes automatizados
- Injeção de Dependências

## Como Executar

### Localmente
- Clonar repositório git

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

- Cadastrar novo usuario POST /usuarios/cadastrar
```
Requisição:
http://localhost:8080/usuarios/cadastrar
  {
    "nome" : "Nome do Usuario",
    "dataNascimento" : "18/06/1988",
    "enderecos" : [
        {
            "logradouro" : "Rua Carlos Gomes",
            "cep" : "40720600",
            "numero" : "11",
            "cidade" : "Salvador",
            "estado" : "Bahia",
            "enderecoPrincipal" : true    
        }  
    ]
}

Resposta:
  Retorna o endereço do recurso criado
    http://localhost:8080/1  

```

- Buscar Usuario cadastrado pelo ID GET /usuarios/{id}
```
Requisição:
  http://localhost:8080/usuarios/1

Resposta:
  {
    "id": 1,
    "nome": "Nome do Usuario",
    "dataNascimento": "18/06/1988",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua Carlos Gomes",
            "cep": "40720600",
            "numero": "11",
            "cidade": "Salvador",
            "estado": "Bahia",
            "enderecoPrincipal": true
        }
    ]
}  

```

- Listar todos Usuarios cadastrados GET /usuarios
```
Requisição:
  http://localhost:8080/usuarios

Resposta:
  [
    {
        "id": 1,
        "nome": "Avner Caleb",
        "dataNascimento": "18/06/1988",
        "enderecos": [
            {
                "id": 1,
                "logradouro": "Rua Carlos Gomes",
                "cep": "40720600",
                "numero": "11",
                "cidade": "Salvador",
                "estado": "Bahia",
                "enderecoPrincipal": true
            }
        ]
    },
    {
        "id": 2,
        "nome": "Nome do Usuario",
        "dataNascimento": "18/06/1988",
        "enderecos": [
            {
                "id": 2,
                "logradouro": "Rua Carlos Gomes",
                "cep": "40720600",
                "numero": "11",
                "cidade": "Salvador",
                "estado": "Bahia",
                "enderecoPrincipal": true
            }
        ]
    }
]    

```

- Atualizar usuario Put /usuarios/{id}
```

Requisição:
  http://localhost:8080/usuarios/1
  {
    "nome" : "Avner Caleb de Lima",
    "dataNascimento" : "18/06/1987"
  }

Resposta:
  {
    "id": 1,
    "nome": "Avner Caleb de Lima",
    "dataNascimento": "18/06/1987",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua Carlos Gomes",
            "cep": "40720600",
            "numero": "11",
            "cidade": "Salvador",
            "estado": "Bahia",
            "enderecoPrincipal": true
        }
    ]
}
```

- Adicionar novo endereço ao usuario Post /usuarios/{id}/adicionar-endereco
```

Requisição:
http://localhost:8080/usuarios/1/adicionar-endereco
  {
    "logradouro" : "Travessa Carlos Gomes",
    "cep" : "40725610",
    "numero" : "11",
    "cidade" : "Salvador",
    "estado" : "Bahia",
    "enderecoPrinciapal" : false
  }
  
Resposta:
 {
    "id": 1,
    "nome": "Avner Caleb de Lima",
    "dataNascimento": "18/06/1987",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua Carlos Gomes",
            "cep": "40720600",
            "numero": "11",
            "cidade": "Salvador",
            "estado": "Bahia",
            "enderecoPrincipal": true
        },
        {
            "id": 3,
            "logradouro": "Travessa Carlos Gomes",
            "cep": "40725610",
            "numero": "11",
            "cidade": "Salvador",
            "estado": "Bahia",
            "enderecoPrincipal": false
        }
    ]
}
```
