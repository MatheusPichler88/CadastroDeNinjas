# 🥷 Sistema de Cadastro de Ninjas

Bem-vindo ao **Cadastro de Ninjas**, uma aplicação robusta de gerenciamento desenvolvida com foco em arquitetura em camadas e boas práticas de desenvolvimento backend. Este sistema foi criado como parte da minha jornada no curso **Java10x**, onde aprofundei meus conhecimentos em Spring Boot, persistência de dados e automação.



## 🚀 Sobre o Projeto
Este sistema gerencia o registro de ninjas da Vila da Folha e suas respectivas missões. Ele permite operações completas (CRUD) com foco em consistência de dados e relacionamentos eficientes entre entidades.

### Principais Funcionalidades
* **Gestão de Ninjas:** Cadastro detalhado (nome, idade, email, rank).
* **Atribuição de Missões:** Relacionamento inteligente entre ninjas e missões.
* **Persistência de Dados:** Uso de JPA/Hibernate com suporte a banco de dados H2 (testes) e MySQL (produção).
* **Migração Automatizada:** Controle de versão do banco via Flyway.
* **Documentação:** API totalmente documentada via OpenAPI (Swagger).

## 🛠 Tecnologias Utilizadas

| Categoria | Tecnologia |
| :--- | :--- |
| **Back-end** | Java 17+, Spring Boot, Spring Data JPA |
| **Banco de Dados** | MySQL, H2 (Memory), SQL |
| **Gerenciamento** | Maven, Flyway, Docker |
| **Controle de Versão** | Git & GitHub |

## 📊 Design do Banco de Dados
O sistema utiliza um modelo de relacionamento eficiente para garantir a integridade:

* **Ninja:** Identificador único, nome, idade, email e rank.
* **Missão:** Título, descrição e dificuldade.
* **Relacionamento:** Implementação de chave estrangeira (`missoes_id`), permitindo que um ninja seja vinculado a uma missão específica.



## 🚀 Como Rodar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/MatheusPichler88/CadastroDeNinjas.git](https://github.com/MatheusPichler88/CadastroDeNinjas.git)