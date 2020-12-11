#language:pt
Funcionalidade: Teste utilizando GET

Cenario: Testando primeiro GET
Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users/1"
Entao o status code deve ser 200 
E anexo o body de resposta no relatorio
E no caminho do body da resposta "username" deve ser "Bret"
E no caminho do body da resposta "address.city" deve ser "Gwenborough"
E no caminho do body da resposta "address.geo.lat" deve ser "-37.3159"
E no caminho do body da resposta "company.name" deve ser "Romaguera-Crona"

Esquema do Cenario: Testando o campo <caminho> no body
Quando realizar um GET na URL "https://jsonplaceholder.typicode.com/users/2"
Entao o status code deve ser 200 
E anexo o body de resposta no relatorio
E no caminho do body da resposta <caminho> deve ser <info>

Exemplos:
|caminho|info|
|"id"|"2"|
|"name"|"Ervin Howell"|
|"username"|"Antonette"|
|"email"|"Shanna@melissa.tv"|
|"address.street"|"Victor Plains"|
|"address.suite"|"Suite 879"|
|"address.city"|"Wisokyburgh"|
|"address.zipcode"|"90566-7771"|

