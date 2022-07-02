# CHALLENGE - Sistema de críticas de filmes

## Sobre o projeto

<img height="550px"  align="center" src="https://i.imgur.com/YGkpEtv.png">

## Diagrama de classes

## Execução do Projeto

* Configuração de ambiente:
  * IDE de sua preferência (IntelliJ, Eclipse, STS...)
  * Instalação do Java 11
  * Maven configurado no ambiente

* Após ambiente configurado, para executar o projeto, faça o clone do repositório e, na pasta principal, proceda com as instruções:
  * Configure o IntelliJ com o Java 11 e o Maven que instalou.
  * Encontre a classe SystemReviewApplication na arquitetura do projeto, com o botão direito, clique em "Run SystemApplication"
  * Caso ocorra algum problema de execução, execute o comando "mvn clean install" no projeto Maven.

 * Observações:
    * As informações de Usuários, Filmes, Comentários e Avaliações serão salvas no H2.
    * É possivel cadastrar usuários, lista-los e deletar via metódos configurados no projeto.

## Autor

Tomas de Andrade Alric 


## Tecnologias utilizadas:

* Java 11
* Maven 3.8.6
* Spring Data JPA
* H2 Database
* MapStruct
* Spring Security
* Spring Web
* Lombok

<img height="550px"  align="center" src="https://i.imgur.com/ofZQwZ2.png">

Collections do Postman

https://www.getpostman.com/collections/f6128c7725d483530133

FILMS

[GET] Buscar filmes da API Omdb, por titulo

--------------------------------------------------

USERS

[GET] Busca usuários de forma páginada

[PUT] Avaliar um filme

[POST] Criar um usuário

[DELETE] Deletar um usuário


--------------------------------------------------

AUTH

[POST] Login


---------------------------------------------------

Para rodar aplicação é necessário autenticar com username: itau password: itau123

Será gerado um token, e um refresh token... no postman tem um script que armazena seu token numa variável de ambiente



no arquivo import.sql, tem usuários criados com cada role



O banco de dados está no H2: http://localhost:8070/h2-console/


Ao criar um usuário, as senhas são salvas no banco de dados encriptadas.





