# language: pt
Funcionalidade: Pesquisar objetos por nome

  Contexto:
    Dado que os objetos "Fone Bluetooth", "Porta-fone" e "Carteira" estão cadastrados

  Cenário: Encontrar nomes que contêm o termo pesquisado
    Quando pesquiso pelo termo "FONE"
    Então o resultado contém somente "Fone Bluetooth" e "Porta-fone"

  Cenário: Pesquisar um nome sem correspondência
    Quando pesquiso pelo termo "Guarda-chuva"
    Então o resultado está vazio
