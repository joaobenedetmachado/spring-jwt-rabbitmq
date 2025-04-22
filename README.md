![image](https://github.com/user-attachments/assets/2967c02f-76b9-4311-b325-cf429cf845fb)
http://localhost:8080/swagger-ui/index.html

--- 

## Exemplo de requisicoes:
Post de usuario:
`curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"password123"}' `
  //Output: Usuario registrado com sucesso!

Login de usuario retornando o token JWT
  `curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"password123"}'`
  //Output: TOKEN JWT

# Objetivo do projeto
O principal objetivo deste pequeno projeto foi que eu podesse consolidar meu aprendizados em jwt, swagger e rabbitMQ, então criei um projeto onde tem um User, e ele pode enviar mensagens, quando ele faz login, ele recebe um token JWT, e precisa da mesma para que ele possa enviar uma mensagem e tal


## Link do start.spring (sei que não é necessario mas está ai para projetos futuros)
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.4.4&packaging=jar&jvmVersion=21&groupId=com.jowdev&artifactId=simpleapi&name=simpleapi&description=Demo%20project%20for%20Spring%20Boot&packageName=com.jowdev.simpleapi&dependencies=data-jpa,h2,amqp,security,web
