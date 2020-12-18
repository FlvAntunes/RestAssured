#language:pt
Funcionalidade: Teste utilizando DELETE

  Contexto:
  Dado que minha URL base é "https://jsonplaceholder.typicode.com/"
  Cenario: 1 - Deve remover Usuario
    Quando realizar um "delete" na URL "posts/1"
    Entao o status code deve ser 200
    E anexo o body de resposta no relatorio


