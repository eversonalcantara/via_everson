$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cenario.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language:pt"
    }
  ],
  "line": 2,
  "name": "Busca de CEP",
  "description": "\nEu como usuário do site dos correios\nQuero buscar um cep ou um Endereço\nDe modo que eu possa buscar CEPs através de um endereço ou Endereços a partir de um CEP\n\nParametros necessários para busca:\n- CEP ou Endereço\n\nParâmetro opcional para pesquisa de endereço\n- Opção de pesquisa por palavras semelhantes\n\t- Sim ou Não\n\nFiltros para tipo:\n- Localidades/Logradouro\n- CEP promocional\n- Caixa Postal Comunitária\n- Grande usuário\n- Unidade operacional \n- Todos",
  "id": "busca-de-cep",
  "keyword": "Funcionalidade"
});
formatter.before({
  "duration": 1040725133,
  "status": "passed"
});
formatter.background({
  "line": 23,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 24,
  "name": "que eu esteja na home dos correios",
  "keyword": "Dado "
});
formatter.step({
  "line": 25,
  "name": "eu clicar em busca CEP",
  "keyword": "Quando "
});
formatter.step({
  "line": 26,
  "name": "devo visualizar a tela de Busca de CEP",
  "keyword": "Então "
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.queEuEstejaNaHomeDosCorreios()"
});
formatter.result({
  "duration": 197166439,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.euClicarEmBuscaCEP()"
});
formatter.result({
  "duration": 1673846873,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.devoVisualizarATelaDeBuscaDeCEP()"
});
formatter.result({
  "duration": 99939920,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Realizar Pesquisa com CEP válido",
  "description": "",
  "id": "busca-de-cep;realizar-pesquisa-com-cep-válido",
  "type": "scenario",
  "keyword": "Cenário",
  "tags": [
    {
      "line": 28,
      "name": "@OpenHome"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "eu entrar com os criterios de busca \"06130060\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 31,
  "name": "clicar no botao buscar",
  "keyword": "E "
});
formatter.step({
  "line": 32,
  "name": "devo visualizar a tela de Resultados",
  "keyword": "Então "
});
formatter.match({
  "arguments": [
    {
      "val": "06130060",
      "offset": 37
    }
  ],
  "location": "BuscaCEPStepDefinitions.euEntrarComOsCriteriosDeBusca(String)"
});
formatter.result({
  "duration": 134654393,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.clicarNoBotaoBuscar()"
});
formatter.result({
  "duration": 457611901,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.devoVisualizarATelaDeResultados()"
});
formatter.result({
  "duration": 87856488,
  "status": "passed"
});
formatter.before({
  "duration": 843304575,
  "status": "passed"
});
formatter.background({
  "line": 23,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 24,
  "name": "que eu esteja na home dos correios",
  "keyword": "Dado "
});
formatter.step({
  "line": 25,
  "name": "eu clicar em busca CEP",
  "keyword": "Quando "
});
formatter.step({
  "line": 26,
  "name": "devo visualizar a tela de Busca de CEP",
  "keyword": "Então "
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.queEuEstejaNaHomeDosCorreios()"
});
formatter.result({
  "duration": 60801009,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.euClicarEmBuscaCEP()"
});
formatter.result({
  "duration": 372181606,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.devoVisualizarATelaDeBuscaDeCEP()"
});
formatter.result({
  "duration": 59315711,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Realizar Pesquisa com filtro",
  "description": "",
  "id": "busca-de-cep;realizar-pesquisa-com-filtro",
  "type": "scenario",
  "keyword": "Cenário",
  "tags": [
    {
      "line": 34,
      "name": "@OpenHome"
    }
  ]
});
formatter.step({
  "line": 36,
  "name": "eu entrar com os criterios de busca \"Avenida Paes de Barros\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 37,
  "name": "selecionar \"\"",
  "keyword": "E "
});
formatter.step({
  "line": 38,
  "name": "clicar no botao buscar",
  "keyword": "E "
});
formatter.step({
  "line": 39,
  "name": "devo visualizar a tela de Resultados",
  "keyword": "Então "
});
formatter.match({
  "arguments": [
    {
      "val": "Avenida Paes de Barros",
      "offset": 37
    }
  ],
  "location": "BuscaCEPStepDefinitions.euEntrarComOsCriteriosDeBusca(String)"
});
formatter.result({
  "duration": 204744534,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 12
    }
  ],
  "location": "BuscaCEPStepDefinitions.selecionar(String)"
});
formatter.result({
  "duration": 178234,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.clicarNoBotaoBuscar()"
});
formatter.result({
  "duration": 455995289,
  "status": "passed"
});
formatter.match({
  "location": "BuscaCEPStepDefinitions.devoVisualizarATelaDeResultados()"
});
formatter.result({
  "duration": 64068571,
  "status": "passed"
});
});