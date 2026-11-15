# language: pt
Funcionalidade: Excluir objeto

  Cenário: Excluir um objeto cadastrado
    Dado que os objetos "Fone" e "Carteira" estão cadastrados
    Quando excluo o objeto "Fone" pelo seu identificador
    Então a exclusão é confirmada
    E apenas o objeto "Carteira" permanece cadastrado

  Cenário: Tentar excluir um objeto inexistente
    Dado que o objeto "Carteira" está cadastrado
    Quando tento excluir um identificador inexistente
    Então a exclusão não é confirmada
    E o objeto "Carteira" permanece cadastrado
