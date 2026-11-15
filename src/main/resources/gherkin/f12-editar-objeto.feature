# language: pt
Funcionalidade: Devolução de objetos

  Contexto: 
    Dado que inicio o cadastro de um objeto
      E insiro o campo nome com "Fone"
      E insiro o campo descricao com "Fone JBL 2"
      E insiro o campo local com "Bloco 5, Sala 101"

          
  Cenário: Editar o cadastro de objeto perdido
    Quando altero o nome para "Novo Nome"
    Então o nome dele deve ser igual a "Novo Nome"
