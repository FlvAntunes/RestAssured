#language:pt
Funcionalidade: Teste utilizando GET

  Cenario: 1 - Testando primeiro Nivel
    Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users/1"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio
    E no caminho "id" do body da resposta deve ser o inteiro 1
    E no caminho "username" do body da resposta deve ser a string "Bret"

  Cenario: 2 - Testando primeiro Nivel com Path
    Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users/1"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio
    E utilizando o Path, no caminho "id" do body da resposta deve ser o inteiro 1

  Cenario: 3 - Testando primeiro Nivel com Jsonpath
    Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users/1"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio
    E usando o Jsonpath, no caminho "id" do body da resposta deve ser o inteiro 1

  Cenario: 4 - Testando primeiro Nivel com From
    Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users/1"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio
    E usando o Fron, no caminho "id" do body da resposta deve ser o inteiro 1

  Cenario: 5 - Testando segundo Nivel
    Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users/1"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio
    E no caminho "address.street" do body da resposta deve ser a string "Kulas Light"

  Cenario: 6 - Testando lista
    #dica: utilizar https://jsonpathfinder.com/ para auxiliar a montar o caminho
    Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio
    E no caminho da lista "name" possui o tamanho 10 
    E no caminho da lista "[2].name" do body da resposta deve ser a string "Clementine Bauch"
    E no caminho da lista "address.street" possui o item "Dayna Park" 
    E no caminho da lista "address.street" possui os itens "Dayna Park" e "Victor Plains"
