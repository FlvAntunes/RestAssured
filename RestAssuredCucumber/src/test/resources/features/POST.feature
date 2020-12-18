#language:pt
Funcionalidade: Teste utilizando POST

  Contexto: 
    Dado que minha URL base é "https://jsonplaceholder.typicode.com/"

  Cenario: 1 - Deve Salvar Usuario
    Dado que o body Json contem "{ \"title\": \"Teste Post\",\"body\": \"teste body\",\"userId\":1}"
    Quando realizar um "POST" na URL "posts"
    Entao o status code deve ser 201
    E anexo o body de resposta no relatorio
    E no caminho "id" do body da resposta nao deve ser nulo
    E no caminho "title" do body da resposta deve ser a string "Teste Post"
    E no caminho "userId" do body da resposta deve ser o inteiro 1

