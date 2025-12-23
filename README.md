## 📚 LiterAlura

Projeto desenvolvido como parte do programa ONE – Oracle Next Education, com o objetivo de praticar Java, Spring Boot, Spring Data JPA, consumo de API REST e persistência de dados com PostgreSQL.

O sistema consome dados da API pública Gutendex, armazena livros e autores em um banco de dados relacional e permite consultas e estatísticas via terminal.

## 🚀 Funcionalidades

🔎 Buscar livros por título através da API Gutendex

💾 Salvar livros e autores no banco de dados

📖 Listar todos os livros cadastrados

🌍 Exibir a quantidade de livros por idioma

✍ Listar autores cadastrados

📅 Listar autores que estavam vivos em um determinado ano

## 🛠️ Tecnologias Utilizadas

Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Hibernate

Jackson

API Gutendex

Maven

Git e GitHub

## 🧱 Estrutura do Projeto
src/main/java/com/literalura <br>
│<br>
├── model<br>
│   ├── Livro.java<br>
│   ├── Autor.java<br>
│   ├── GutendexResponse.java<br>
│   └── LivroGutendex.java<br>
│<br>
├── repository<br>
│   ├── LivroRepository.java<br>
│   └── AutorRepository.java<br>
│<br>
├── service<br>
│   └── ConsumoApi.java<br>
│<br>
└── LiterAluraApplication.java<br>

## 🗄️ Banco de Dados

O projeto utiliza PostgreSQL para persistência de dados.

Entidades principais:

Livro

Autor

Relacionamento:

Um Livro possui um Autor

Um Autor pode possuir vários Livros

⚙️ Configuração do Banco

No arquivo application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

## ▶️ Como Executar o Projeto

Clone o repositório:

git clone https://github.com/seu-usuario/literalura.git


Crie o banco no PostgreSQL:

CREATE DATABASE literalura;


Configure o application.properties

Execute a aplicação:

mvn spring-boot:run

## 📊 Exemplo de Uso

Menu exibido no terminal:

===== LiterAlura =====
1 - Buscar livro por título
2 - Listar livros
3 - Listar autores
4 - Listar livros por idioma
5 - Listar autores vivos em determinado ano
0 - Sair

## 🧠 Conceitos Aplicados

Consumo de API REST

Mapeamento de JSON para objetos Java

Relacionamento entre entidades JPA

Derived Queries com Spring Data

Streams do Java

Persistência de dados

Boas práticas de organização de projeto

## 📌 Status do Projeto

✅ Concluído
📚 Projeto final do programa ONE – Oracle Next Education

## ✨ Autor

Samira Santos da Fonseca
Projeto desenvolvido para fins educacionais e profissionais.
