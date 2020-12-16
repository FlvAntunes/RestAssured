#language:pt
Funcionalidade: Teste utilizando DELETE

  #Contexto:
  #Dado que minha URL base é "https://jsonplaceholder.typicode.com/"
  Cenario: 1 - Deve remover Usuario
    Quando realizar um "delete" na URL "http://restapi.wcaquino.me/users/1"
    Entao o status code deve ser 204
    E anexo o body de resposta no relatorio

  Cenario: 1 - Não deve remover Usuario inexistente
    Quando realizar um "delete" na URL "http://restapi.wcaquino.me/users/1000"
    Entao o status code deve ser 400
    E anexo o body de resposta no relatorio
    E no caminho "error" do body da resposta deve ser a string "Registro inexistente"
