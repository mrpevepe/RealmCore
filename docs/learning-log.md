Learning Log

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
