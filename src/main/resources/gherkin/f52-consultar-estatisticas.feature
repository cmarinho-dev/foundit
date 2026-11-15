# language: pt
Funcionalidade: Consultar estatísticas

  Cenário: Contar objetos por status
    Dado que existem dois objetos disponíveis e um objeto devolvido
    Quando consulto as estatísticas
    Então a quantidade de disponíveis é 2
    E a quantidade de devolvidos é 1

  Cenário: Consultar estatísticas sem objetos cadastrados
    Dado que não existem objetos cadastrados
    Quando consulto as estatísticas
    Então a quantidade de disponíveis é 0
    E a quantidade de devolvidos é 0
