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
O principal objetivo deste pequeno projeto foi que eu podesse consolidar meu aprendizados em jwt, swagger e rabbitMQ, então criei um projeto onde tem um User, e ele pode enviar mensagens, quando ele faz login, ele recebe um token JWT
