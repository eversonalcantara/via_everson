#language:pt
Funcionalidade: Carrinho
  
  Eu como um cliente da Loja
  Quero realizar a inclusão de itens no carrinho
  De modo que eu possa buscar visualizar as mensagens de que os itens foram adicionados com sucesso

  Contexto: 
    Dado que eu esteja na home da Loja
    Quando eu clicar em Comprar
    Então devo visualizar a tela de Produtos

  @OpenHome
  Cenário: Realizar inclusão de dois produtos no carrinho
    Quando eu clicar no produto 1
    E selecionar o tamanho e cor e clicar em comprar para o produto 2559
    Então devo visualizar a mensagem de intem incluido no carrinho corretamente
