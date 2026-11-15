# language: pt
Funcionalidade: Listagem de objetos

  Contexto: 
    Dado que cadastro um objeto com o campo nome como "Fone"
      E o campo descricao como "Fone JBL 2"
      E o campo local como "Bloco 5, Sala 101"
    E que cadastro outro com o campo nome como "Carregador"
      E o campo descricao como "Usb C - Preto"
      E o campo local como "Bloco 3"

  Cenário: Listar cadastros de dois objetos
    Quando realizo a listagem dos objetos
    Então é imprimido "1 - Fone"
      E é imprimido "2 - Carregador"
