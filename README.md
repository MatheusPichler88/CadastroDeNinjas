# 🥷 Cadastro de Ninjas (Vila da Folha)

Bem-vindo ao **Cadastro de Ninjas**, uma aplicação de arquitetura em camadas desenvolvida com **Spring Boot**. Este projeto foi criado para o gerenciamento de ninjas e suas respectivas missões, focando em boas práticas de desenvolvimento de software e controle de versão.

---

## 🚀 Sobre o Projeto
Este sistema permite o registro de ninjas da Vila da Folha e a atribuição de missões a eles. O projeto demonstra a integração entre **Spring Data JPA**, **Flyway** para migrações de banco de dados e uma API REST documentada.

### Principais Funcionalidades
* **Cadastro de Ninjas:** Gerenciamento completo de nome, idade, email e rank.
* **Atribuição de Missões:** Vínculo automático entre ninjas e missões através de relacionamento de banco de dados.
* **Persistência de Dados:** Uso de JPA/Hibernate com suporte a banco de dados H2 (testes) e MySQL (produção).
* **Migração Automatizada:** Banco de dados versionado via **Flyway**.
* **Documentação:** API documentada e interativa via **Swagger (OpenAPI)**.

---

## 🛠 Tecnologias Utilizadas

| Categoria | Tecnologia |
| :--- | :--- |
| **Back-end** | Java 17+, Spring Boot, Spring Data JPA |
| **Banco de Dados** | MySQL, H2 (Memory), SQL |
| **Gerenciamento** | Maven, Flyway, Docker |
| **Documentação** | Swagger (OpenAPI) |
| **Controle de Versão** | Git & GitHub |

---

## 📊 Design do Banco de Dados
O sistema utiliza um modelo relacional eficiente:
* **Ninja:** Identificador único, nome, idade, email e rank.
* **Missão:** Título, dificuldade e descrição.
* **Relacionamento:** Implementação de chave estrangeira (`missoes_id`), vinculando ninjas a missões específicas.

### 🌐 Acesse a aplicação:

* **Interface Web:** [http://localhost:8080](http://localhost:8080)
* **Documentação da API (Swagger):** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)