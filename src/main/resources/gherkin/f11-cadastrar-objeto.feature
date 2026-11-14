# language: pt
Funcionalidade: Devolução de objetos

  Cenário: Cadastrar um objeto perdido
    Dado que inicio o cadastro de um objeto
      E insiro o campo nome com "Fone"
      E insiro o campo descricao com "Fone JBL 2"
      E insiro o campo local com "Bloco 5, Sala 101"
    Quando consulto o nome do objeto
    Então o nome dele deve ser "Fone"
      E o status deve ser "DISPONIVEL"