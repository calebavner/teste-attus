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

### Usando Docker

- Clonar repositório git
- Construir o projeto:
```
./mvnw clean package
```
- Construir a imagem:
```
./mvnw spring-boot:build-image
```
- Executar o container:
```
docker run --name place-service -p 8080:8080  -d place-service:0.0.1-SNAPSHOT
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/):

- Cadastrar novo usuario POST /usuarios/cadastrar
```
![image](https://github.com/calebavner/teste-attus/assets/153721016/580c7502-935c-4a71-bd89-cd25685583d4)

```

- Buscar Usuario cadastrado pelo ID GET /usuarios/{id}
```
![image](https://github.com/calebavner/teste-attus/assets/153721016/fcf12bbe-00cb-4210-9887-9eea2e8dadb9)

```

- Listar todos Usuarios cadastrados GET /usuarios
```
![image](https://github.com/calebavner/teste-attus/assets/153721016/3d062c2c-0f87-45a5-a4de-796444017ac4)

```

- PATCH /places/{id}
```
http PATCH :8080/places/1 name='New Name' state='New State'
HTTP/1.1 200 OK
Content-Length: 142
Content-Type: application/json

{
    "createdAt": "2023-06-07T14:45:39.693689",
    "name": "New Name",
    "slug": "new-name",
    "state": "New State",
    "updatedAt": "2023-06-07T14:53:21.671129345"
}
```
