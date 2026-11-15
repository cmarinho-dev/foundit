# language: pt
Funcionalidade: Filtrar objetos por status

  Cenário: Filtrar objetos disponíveis entre itens de status diferentes
    Dado que a "Carteira" e a "Chave" estão disponíveis
    E que o "Fone" está devolvido
    Quando filtro pelo status "DISPONIVEL"
    Então o resultado contém somente a "Carteira" e a "Chave"

  Cenário: Filtrar por um status sem objetos correspondentes
    Dado que existe somente um objeto disponível
    Quando filtro pelo status "DEVOLVIDO"
    Então o resultado está vazio
