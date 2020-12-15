#language:pt
Funcionalidade: Teste utilizando POST

#Contexto:
#Dado que minha URL base é "https://jsonplaceholder.typicode.com/"

  Cenario: 1 - Deve Salvar Usuario
   Dado que o body Json contem "{}"
    Quando realizar um "POST" na URL "http://restapi.wcaquino.me/users"
    Entao o status code deve ser 201
    E anexo o body de resposta no relatorio


  