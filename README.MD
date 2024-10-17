## Visão Geral
    Este projeto é uma API REST construída com Spring Boot que gerencia entidades de usuários e departamentos. A API permite operações CRUD (Create, Read, Update, Delete) para as entidades e utiliza um banco de dados em memória (H2) para armazenamento temporário dos dados. Além disso, o projeto está preparado para ser executado em um ambiente Docker.

## Funcionalidades
    CRUD de Usuários: Endpoints para criação, leitura, atualização e exclusão de usuários.
    Associação de Usuários a Departamentos: Cada usuário pode ser associado a um departamento específico.

## Banco de Dados H2 em Memória e seu uso: 
    Utilização do banco H2 para armazenamento de dados em tempo de execução, ideal para testes e desenvolvimento.

## Execução em Docker: 
    Configuração de Dockerfile para containerização e execução simplificada da aplicação.

## Endpoints
    GET /users: Retorna todos os usuários.
    GET /users/{id}: Retorna um usuário específico pelo ID.
    POST /users: Insere um novo usuário.
    PUT /users/{id}: Atualiza as informações de um usuário existente.
    DELETE /users/{id}: Deleta um usuário pelo ID.

## Estrutura do Projeto
    UserController: Controlador principal que gerencia os endpoints da API.
    Users: Entidade que representa um usuário.
    Department: Entidade que representa um departamento.
    UserRepository: Interface de repositório JPA para operações de banco de dados.

## Banco de Dados H2 em Memória
    O projeto utiliza o banco de dados H2 em memória, que é ideal para testes e desenvolvimento. As configurações estão no arquivo application.properties e são específicas para o H2:

```md
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:test
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=create
```

## Containerização com Docker
    O projeto está configurado para ser executado em um contêiner Docker. O Dockerfile inclui todas as etapas necessárias para configurar o ambiente e iniciar a aplicação:

```md
FROM openjdk:17-jdk-alpine
RUN mkdir /application
WORKDIR /application
COPY target/*.jar /application/application.jar
CMD ["java", "-jar", "/application/application.jar"]
```

## Para construir e executar o contêiner:
```md
docker build -t api-rest-example .
docker run -p 8080:8080 
```

## Aviso
    As credenciais de conexão com o banco de dados estão incluídas no projeto para facilitar o desenvolvimento e testes, pois utilizamos um banco de dados em memória (H2). Essas credenciais não devem ser usadas em ambientes de produção.
