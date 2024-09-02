# RemediosAPI

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

**RemediosAPI** é uma API RESTful desenvolvida em Java utilizando o framework Spring Boot. O objetivo desta API é gerenciar medicamentos, permitindo operações de CRUD (Create, Read, Update, Delete) sobre registros de remédios.

## Features

- Adicionar, visualizar, atualizar e remover registros de remédios.
- Consultar remédios por diferentes critérios (nome, fabricante, etc.).
- Autenticação e autorização utilizando Spring Security.
- Documentação da API com Swagger.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** - para persistência de dados.
- **H2 Database** - banco de dados em memória para desenvolvimento e testes.
- **Spring Security** - para autenticação e autorização.
- **Swagger** - para documentação da API.
- **JUnit 5** - para testes unitários e de integração.

## Estrutura do Projeto

```
remediosAPI
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.remediosapi
│   │   │       ├── controller
│   │   │       ├── model
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── security
│   │   └── resources
│   │       ├── application.properties
│   │       └── data.sql
│   └── test
│       └── java
│           └── com.example.remediosapi
├── pom.xml
└── README.md
```

## Como Executar

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/viniciuslevi/remediosAPI.git
   cd remediosAPI
   ```

2. **Compile o projeto utilizando Maven:**

   ```bash
   mvn clean install
   ```

3. **Execute a aplicação:**

   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API:**

   A aplicação estará disponível em `http://localhost:8080`.

5. **Documentação da API:**

   Acesse `http://localhost:8080/swagger-ui.html` para visualizar a documentação interativa da API.

## Endpoints Principais

- **GET /api/remedios** - Lista todos os remédios.
- **GET /api/remedios/{id}** - Consulta um remédio específico por ID.
- **POST /api/remedios** - Adiciona um novo remédio.
- **PUT /api/remedios/{id}** - Atualiza um remédio existente.
- **DELETE /api/remedios/{id}** - Remove um remédio.

## Contribuindo

Se você deseja contribuir com este projeto, siga os passos abaixo:

1. Faça um fork do projeto.
2. Crie uma nova branch: `git checkout -b feature/nova-feature`.
3. Faça as suas modificações e commit: `git commit -m 'Adiciona nova feature'`.
4. Envie para o seu fork: `git push origin feature/nova-feature`.
5. Abra um Pull Request no repositório original.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

- **Autor:** Vinícius Levi
- **Email:** viniciuslevi152@gmail.com


Esse README fornece uma visão geral clara e organizada do projeto, o que facilita para outros desenvolvedores entenderem e contribuírem com o repositório. Você pode adaptá-lo conforme necessário para incluir informações adicionais ou alterar detalhes específicos.
