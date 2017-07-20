#language:pt
Funcionalidade: Busca de CEP
  
  Eu como usuário do site dos correios
  Quero buscar um cep ou um Endereço
  De modo que eu possa buscar CEPs através de um endereço ou Endereços a partir de um CEP
  
  Parametros necessários para busca:
  - CEP ou Endereço
  
  Parâmetro opcional para pesquisa de endereço
  - Opção de pesquisa por palavras semelhantes
  	- Sim ou Não
  
  Filtros para tipo:
  - Localidades/Logradouro
  - CEP promocional
  - Caixa Postal Comunitária
  - Grande usuário
  - Unidade operacional 
  - Todos

  Contexto: 
    Dado que eu esteja na home dos correios
    Quando eu clicar em busca CEP
    Então devo visualizar a tela de Busca de CEP

  @OpenHome
  Cenário: Realizar Pesquisa com CEP válido
    Quando eu entrar com os criterios de busca "06130060"
    E clicar no botao buscar
    Então devo visualizar a tela de Resultados

  @OpenHome
  Cenário: Realizar Pesquisa com filtro
    Quando eu entrar com os criterios de busca "Avenida Paes de Barros"
    E selecionar ""
    E clicar no botao buscar
    Então devo visualizar a tela de Resultados

  #Cenário: Realizar Pesquisa com palavas semelhantes
    #Quando eu entrar os criterios de busca ""
    #E selecionar pesquisa com palavras semelhantes
    #E clicar no botao buscar
    #Então devo visualizar a tela de Resultados
#
  #Cenário: Realizar Pesquisa com CEP inválido
    #Quando eu entrar os criterios de busca ""
    #E clicar no botao buscar
    #Então devo visualizar a mensagem de dados não encontrados
#
  #Cenário: Realizar Pesquisa sem parametros
    #Quando eu entrar os criterios de busca ""
    #E clicar no botao buscar
    #Então devo visualizar a mensagem de dados não encontrados
