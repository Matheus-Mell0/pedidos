# Pedidos - API de Controle de Produção

API REST para controle de pedidos de produção (cliente, pedido, status e prazo), feita com Java e Spring Boot.

> 🚧 Projeto em desenvolvimento. Os dados usados são fictícios.

## Tecnologias
- Java 21
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven

## Como rodar
**Pré-requisitos:** JDK 21 e MySQL instalados.

1. Clone o repositório
   `git clone https://github.com/Matheus-Mell0/pedidos.git`
2. Crie o banco no MySQL: `CREATE DATABASE pedidos;`
3. Defina a variável de ambiente `DB_PASSWORD` com a senha do seu MySQL
4. Rode a classe `PedidosApplication` pelo IntelliJ
5. Acesse `http://localhost:8080/status`


## Roadmap
- [x] Estrutura do projeto e endpoint `/status`
- [x] Banco de dados MySQL com JPA
- [ ] CRUD de pedidos e clientes
- [ ] Validações e tratamento de erros
- [ ] Testes com JUnit e Mockito
- [ ] Autenticação com JWT
- [ ] Docker
- [ ] Deploy na AWS
