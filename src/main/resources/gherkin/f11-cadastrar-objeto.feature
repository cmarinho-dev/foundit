# language: pt
Funcionalidade: Castrar objeto

  Cenário: Cadastrar fone perdido
    Dado que inicio o cadastro de um objeto
      E insiro o campo nome com "Fone"
      E insiro o campo descricao com "Fone JBL 2"
      E insiro o campo local com "Bloco 5, Sala 101"
    Quando consulto o nome do objeto
      E o status do objeto
    Então o nome dele deve ser igual a "Fone"
      E o status deve ser igual a "DISPONIVEL"
