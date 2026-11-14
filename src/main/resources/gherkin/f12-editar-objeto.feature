# language: pt
Funcionalidade: Devolução de objetos


  	Contexto: 
	        Dado que selecionei o produto "Nike Air Vapor Ace"
                E pressionei "Finalizar compra"
                E me autentiquei com o usuário "joaosilva@email.com" senha "123456"
	        E estou na "Página de pagamento"

          
  Cenário: Editar o cadastro de objeto perdio
    Dado que tenho um objeto cadastro
    Quando altero o nome para "Novo Nome"
    Então o nome dele deve ser igual a "Novo Nome"