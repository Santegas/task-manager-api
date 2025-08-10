API de Gerenciamento de Tarefas (Task Manager API)
Descrição do Projeto
Este projeto é uma API RESTful completa e funcional para gerenciar tarefas de forma eficiente. Desenvolvida em Java com Spring Boot, a API foi criada para demonstrar a aplicação de tecnologias modernas e boas práticas de desenvolvimento de software em uma solução de ponta a ponta.

A arquitetura da aplicação é organizada em camadas (Controller, Service, Repository), seguindo os princípios de design REST. Esta versão do projeto foca exclusivamente no gerenciamento de tarefas, oferecendo um conjunto completo de endpoints para as operações de CRUD.

Funcionalidades Implementadas
Gerenciamento Completo de Tarefas (CRUD): Endpoints para criar, ler, atualizar e excluir tarefas.

Busca por Tarefas: Funcionalidades de busca detalhada, permitindo a consulta por ID e por título.

Organização em Camadas: Separação clara entre a lógica de negócio, a persistência de dados e a exposição dos endpoints.

Validação de Dados: Garantia da integridade dos dados de entrada através de validações no nível da API.

Tecnologias Utilizadas
Java 21+: Utilização das features mais recentes da linguagem.

Spring Boot: Estrutura principal da aplicação, facilitando a configuração e o desenvolvimento da API REST.

Spring Data JPA: Abstração da camada de persistência para interagir com o banco de dados.

PostgreSQL: Banco de dados relacional robusto e escalável para armazenamento de dados.

Jakarta Validation: Validação de dados de entrada usando anotações como @NotBlank e @NotNull.

Spring Security: Configuração inicial para permitir o acesso público aos endpoints de tarefas para fins de demonstração.

Maven: Ferramenta de gerenciamento de dependências.

Lombok: Redução de código boilerplate (getters, setters, construtores).

Como Rodar o Projeto
Pré-requisitos:

Java Development Kit (JDK) 21+

Maven

PostgreSQL

Git

Configuração do Banco de Dados:

Crie um banco de dados PostgreSQL chamado taskmanager_db.

Defina as suas credenciais como variáveis de ambiente ou no arquivo application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5433/taskmanager_db
spring.datasource.username=${DATABASE_USERNAME:postgres}
spring.datasource.password=${DATABASE_PASSWORD:sua_senha}


Executar a Aplicação:

Clone o repositório: git clone https://github.com/seu-usuario/seu-repositorio.git

Navegue até a pasta do projeto: cd seu-repositorio

Execute a aplicação com Maven: mvn spring-boot:run

Endpoints da API
A API expõe os seguintes endpoints para o gerenciamento de tarefas:

| POST | /tasks | Cria uma nova tarefa. | POST /tasks |

| GET | /tasks/{id} | Busca uma tarefa específica por ID. | GET /tasks/1 |

| GET | /tasks?title={titulo} | Busca uma tarefa específica por título. | GET /tasks?title=Primeira%20Tarefa |

| PUT | /tasks/{id} | Atualiza uma tarefa existente por ID. | PUT /tasks/1 |

| DELETE | /tasks/{id} | Exclui uma tarefa por ID. | DELETE /tasks/1 |
