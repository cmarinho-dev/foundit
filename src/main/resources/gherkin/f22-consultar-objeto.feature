# language: pt
Funcionalidade: Consultar objeto

  Cenário: Consultar objeto existente
    Dado que existe um objeto cadastrado com os seguintes dados:
      | nome      | Fone              |
      | descricao | Fone JBL 2        |
      | local     | Bloco 5, Sala 101 |
    Quando consulto o objeto pelo seu identificador
    Então é impresso um objeto com o mesmo identificador e os seguintes dados:
      | nome      | Fone              |
      | descricao | Fone JBL 2        |
      | local     | Bloco 5, Sala 101 |

  Cenário: Consultar objeto inexistente
    Dado que não existe um objeto com o identificador 999
    Quando consulto o objeto pelo identificador 999
    Então não é impresso nada
