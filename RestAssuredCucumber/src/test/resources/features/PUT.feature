#language:pt
Funcionalidade: Teste utilizando PUT

  Contexto:
  Dado que minha URL base é "https://jsonplaceholder.typicode.com/"
  Cenario: 1 - Deve alterar Usuario
    Dado que o body Json contem "{ \"name\": \"Jose\", \"age\":50}"
    Quando realizar um "PUT" na URL "users/1"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio
    E no caminho "id" do body da resposta deve ser o inteiro 1
    E no caminho "name" do body da resposta deve ser a string "Jose"
    E no caminho "age" do body da resposta deve ser o inteiro 50
