### Learning Log

<details open>
<summary><b>📅 05-09-2026 - Account & Autenticação</b></summary>

### Objetivos do Dia
- [x] Implementar cadastro de contas
- [x] Criar endpoints para consulta de contas
- [x] Implementar hash de senhas
- [x] Implementar login
- [x] Aprender tratamento básico de exceções

---

### O que foi Implementado

#### Account
- Criado fluxo de cadastro de contas através de `POST /accounts`
- Validação de username duplicado
- Criados endpoints para buscar contas por **username** e **ID**
- Criado `AccountResponse` para controlar os dados retornados pela API

#### Autenticação
- Criado fluxo de login através de `POST /auth/login`
- Senhas protegidas utilizando **BCrypt**
- Implementada atualização do `lastLogin`
- Criado `LoginRequest` e `LoginResponse`

#### Tratamento de Erros
- Criado tratamento global de exceções com `@RestControllerAdvice`
- Criadas exceções específicas para credenciais inválidas e username duplicado
- Aprendidos códigos HTTP como `401 Unauthorized` e `409 Conflict`

---

### Conceitos Aprendidos

- Fluxo **Controller → Service → Repository → Database**
- Diferença entre **Entity** e **DTO**
- Injeção de dependências no Spring
- Hash de senhas e verificação com BCrypt
- Uso de `Optional` com Spring Data JPA
- Uso de `final` em objetos imutáveis
- Tratamento global de exceções
- Uso de diferentes códigos de status HTTP

</details>
<details open>
<summary><b>📅 04-09-2026 - Inicialização do Projeto</b></summary>

###  Objetivos do Dia
- [x] Criar a estrutura inicial do backend
- [x] Configurar Java e Spring Boot
- [x] Conectar o projeto ao PostgreSQL
- [x] Criar o primeiro domínio da aplicação

---

### O que foi Implementado

####  Configurações & Infraestrutura
- Projeto criado utilizando **Spring Initializr**
- **Java 21** configurado
- **Spring Boot** & **Maven** configurados
- **PostgreSQL** conectado ao projeto
- **Spring Data JPA** configurado
- **Git** inicializado, primeiro commit realizado e projeto publicado no GitHub
- Variáveis de ambiente configuradas para as credenciais do banco

####  Código
- Entidade `Account` criada
- Enum `AccountStatus` criado

---


### Decisões de Arquitetura

> **Arquitetura Escolhida:** Modular Monolith
>
> Foi escolhida uma arquitetura de **Modular Monolith** para o projeto, organizando o código por domínio/funcionalidade em vez de separar todas as classes apenas por tipo.
>
> A decisão foi tomada buscando manter o projeto organizado e permitir sua evolução gradual sem introduzir a complexidade de uma arquitetura de microserviços prematuramente.


</details>
