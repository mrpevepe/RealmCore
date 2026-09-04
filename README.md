<div align="center">

# ⚔️ RealmCore

**Backend de um MMORPG desenvolvido com Java 21 e Spring Boot.**

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)
![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)

</div>

---

## 🎯 Sobre o Projeto

O **RealmCore** é um projeto pessoal desenvolvido para aprimorar minhas habilidades em desenvolvimento backend, arquitetura de software, modelagem de bancos de dados e boas práticas de desenvolvimento.

A aplicação simula a infraestrutura backend de um **MMORPG**, cobrindo desde a gestão de contas de usuários até mecânicas complexas do jogo, como inventário, combate, quests e persistência do mundo.

---

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java 21
* **Framework:** Spring Boot
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL
* **Gerenciador de Dependências:** Maven
* **Controle de Versão:** Git

---

## 🏗️ Arquitetura

O projeto adota a arquitetura de **Modular Monolith** (Monólito Modular), onde o código é organizado estritamente por **domínio/funcionalidade**.

> 📌 **Por que essa escolha?**  
> Permite alta coesão, baixo acoplamento e separação clara de responsabilidades, facilitando a evolução do sistema e uma futura migração para microsserviços, caso surja a necessidade.

---

## 🧠 Objetivos de Aprendizado

Este projeto serve como laboratório prático para estudo e aplicação de conceitos fundamentais e avançados de backend:

| Categoria | Conceitos & Tecnologias |
| :--- | :--- |
| **Fundamentos Backend** | APIs REST, Validação de Dados, Tratamento Global de Exceções |
| **Persistência & Dados** | JPA / Hibernate, PostgreSQL, Redis |
| **Testes & Qualidade** | Testes Automatizados (Unitários e de Integração) |
| **Segurança** | Autenticação e Autorização (JWT / Spring Security) |
| **Comunicação & Eventos**| WebSocket (tempo real), Mensageria (RabbitMQ/Kafka) |
| **DevOps & Infra** | Docker, CI/CD Pipelines |

*Nota: Tecnologias mais avançadas serão introduzidas gradualmente conforme as necessidades do projeto evoluírem.*

---

## 📊 Status de Desenvolvimento dos Sistemas

### ⚙️ Núcleo & Infraestrutura
- [x] Configuração inicial do projeto
- [x] Conexão com PostgreSQL

### 👤 Sistema de Contas (`Account`)
- [x] Modelo de `Account` e `AccountStatus`
- [ ] `AccountRepository`
- [ ] `AccountService`
- [ ] `AccountController`
- [ ] DTOs e Validações

### 🎮 Sistemas do Jogo (Futuro)
- [ ] Sistema de Personagens
- [ ] Sistema de Itens
- [ ] Inventário
- [ ] Combate
- [ ] Quests
- [ ] Mundo

---

## 📖 Learning Log

Todo o processo de desenvolvimento, decisões técnicas, desafios e aprendizados diários são documentados no nosso diário de bordo.

👉 **[Acompanhe a evolução no Learning Log](docs/learning-log.md)**