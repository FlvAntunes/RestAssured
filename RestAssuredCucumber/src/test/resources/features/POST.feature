#language:pt
Funcionalidade: Teste utilizando POST

  #Contexto:
  #Dado que minha URL base é "https://jsonplaceholder.typicode.com/"
  Cenario: 1 - Deve Salvar Usuario
    Dado que o body Json contem "{ \"name\": \"Jose\", \"age\":50}"
    Quando realizar um "POST" na URL "http://restapi.wcaquino.me/users"
    Entao o status code deve ser 201
    E anexo o body de resposta no relatorio
    E no caminho "id" do body da resposta nao deve ser nulo
    E no caminho "name" do body da resposta deve ser a string "Jose"
    E no caminho "age" do body da resposta deve ser o inteiro 50

  Cenario: 2 - Não deve salvar um usuario sem Nome
    Dado que o body Json contem "{ \"age\":50}"
    Quando realizar um "POST" na URL "http://restapi.wcaquino.me/users"
    Entao o status code deve ser 400
    E anexo o body de resposta no relatorio
    E no caminho "id" do body da resposta deve ser nulo
