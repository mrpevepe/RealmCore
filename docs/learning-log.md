### Learning Log


<details>
<summary><b>📅 07-09-2026 - Character, Item & Inventory</b></summary>

### Implementado

- Finalização do sistema de **Character**.
- Implementação do sistema de **Item**, separando a definição do item da posse do jogador.
- Implementação do **Inventory** baseado em slots.
- Suporte para itens **stackable** e **non-stackable**.
- Itens não empilháveis agora ocupam um slot diferente para cada unidade.
- Itens empilháveis utilizam o mesmo slot e aumentam sua quantidade.
- Adicionada capacidade máxima de slots e controle transacional na adição de itens.

### Aprendizados

- Diferença entre a definição de um **Item** e um **InventoryItem**.
- Relacionamentos entre entidades usando JPA.
- Uso de `@Transactional`.
- Uso de `UniqueConstraint` para garantir que cada slot do inventário seja único por personagem.
- Importância de pensar na escalabilidade sem implementar funcionalidades antes da hora.

</details>


<details open>
<summary><b>📅 06-09-2026 - Character & Item Systems</b></summary>

### Objetivos do Dia
- [x] Organizar o módulo de autenticação
- [x] Implementar o sistema de personagens
- [x] Criar relacionamento entre contas e personagens
- [x] Implementar o sistema básico de itens
- [x] Trabalhar com relacionamentos JPA
- [x] Aprofundar o conhecimento na arquitetura Modular Monolith

---

### O que foi Implementado

#### Auth
- Movido o módulo de autenticação para um módulo próprio em `com.realmcore.auth`
- Separados `AuthController` e `AuthService` do módulo de `Account`
- Mantido o fluxo de autenticação funcionando após a reorganização

#### Character
- Criada a entidade `Character`
- Implementada a relação **Many-to-One** entre `Character` e `Account`
- Uma conta pode possuir múltiplos personagens
- Criado fluxo de criação de personagens
- Implementada validação de nomes duplicados
- Criados endpoints para:
    - Criar personagem
    - Buscar personagens de uma conta
    - Buscar personagem por ID
- Definidos valores iniciais de personagem pelo backend, como nível 1 e experiência 0

#### Item
- Criada a entidade `Item`
- Criado `ItemType` para categorizar os itens
- Implementado cadastro de itens
- Implementada validação de nomes duplicados
- Criados endpoints para:
    - Criar item
    - Buscar item por ID
- Criados campos iniciais como nível requerido e possibilidade de empilhamento (`stackable`)

---

### Conceitos Aprendidos

- Organização de módulos por **domínio/feature**
- Diferença entre **Account** e **Authentication**
- Relacionamento `@ManyToOne` no JPA
- Uso de `@JoinColumn`
- Criação de restrições de unicidade com `@UniqueConstraint`
- Relacionamento entre entidades e chaves estrangeiras
- Separação entre definição de um `Item` e sua futura posse por um personagem
- Uso de DTOs para entrada e saída de dados
- Regras de negócio no Service
- Persistência de relacionamentos utilizando Spring Data JPA

---

### Decisões de Arquitetura

> **Account e Auth foram separados em módulos diferentes.**
>
> `Account` representa o domínio da conta, enquanto `Auth` representa as responsabilidades relacionadas à autenticação. Essa separação facilita a evolução futura do sistema, especialmente com a implementação de tokens e autenticação baseada em sessão/JWT.

> **Item representa a definição de um item do jogo.**
>
> O `Item` não representa diretamente um item dentro do inventário de um jogador. A ideia é que, futuramente, monstros possam possuir tabelas de drop e os itens obtidos sejam adicionados ao inventário dos personagens.

---

### Visão de Longo Prazo

A ideia futura do RealmCore é servir como backend para um MMORPG, onde o jogador poderá:

- Criar uma conta
- Criar personagens
- Explorar o mundo
- Encontrar e combater monstros
- Ganhar experiência
- Receber itens através de drops
- Gerenciar inventário
- Equipar itens
- Evoluir o personagem

Essa visão será implementada gradualmente, mantendo o desenvolvimento dividido em módulos e evitando antecipar sistemas que ainda não são necessários.

</details>

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
