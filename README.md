#ZUP   

##Sobre a API

API para o gerenciamento de uma conta bancária.  
MVP do projeto é a funcionaliadde de cadastro de uma conta.  
Foi desenvolvida com Java, Springboot e Spring Framework para participar do processo seletivo para o bootcamp do Orange Talents da Zup

##Caracteristicas
Essa API prove as seguintes funcionanlidades:

* Criar uma conta: `POST/v1/contas`  
* Buscar uma conta pelo id: `GET/v1/contas/{id}`  

###Detalhes

`POST/v1/contas`

Esse endpoint é chamado para a criação de uma nova conta.

**Body:**

```json
{
  "nome": "Priscila",
  "email": "zupa@email.com",
  "cpf": "325.027.250-70",
  "dataDeNascimento": "10/12/20120"
}
```

**Onde:**  
`id` - id da conta e é gerado automaticamente.  
`nome` - nome do titular da conta.  
`email` - email do titular da conta.  
`cpf` -  cpf do titular da compra.  
`dataDeNascimento` - data de nascimento do titular da compra.  

Retorna o objeto salvo no banco ou os seguintes códigos.  

* 201 - Created: tudo funcionou como o experado e a conta foi salva.  
* 400 - Bad Request: a solicitação era inaceitável, geralmente devido à falta de um parâmetro obrigatório ou JSON inválido.  
* 404 - Not Found: o recurso solicitado não existe.  
* 500, 502, 503, 504 - Server Errors: algo deu errado no final da API (são raros).  


### Tecnologias usadas

O projeto foi desenvolvido com:  

* **Java 8 (Java Development Kit - JDK: 1.8.0_275)**  
* **Spring Boot 2.4.1**  
* **Maven**  
* **JUnit 5**  
* **H2 Database**  
* **Swagger 2.9.2**  

### Compilar e gerar o pacote da aplicação

A API foi desenvolvida para rodar com um `jar` e para gerá-lo execute o comando:  

```bash
mvn package
```

Isso irá limpar, compilar e gerar o `jar` na pasta target, exemplo: `zup-0.0.1-SNAPSHOT.jar`  

### Testes

* Para rodar os teste unitários:  

```bash
mvn test
```

###Inicializar a aplicação  

Para inicializar a aplicação, apenas execute o arquivo jar:  

```bash
java -jar zup-0.0.1-SNAPSHOT.jar
```

ou  

```bash
mvn spring-boot:run
```

Por padrão, a API ficará disponivel no endereço [http://localhost:8080/v1/contas](http://localhost:8080/v1/contas)  

### Documentation

* Swagger (ambiente de desenvolvimento): [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)  




