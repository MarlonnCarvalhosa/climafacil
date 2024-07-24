# ClimaFácil

## Overview
O ClimaFácil é um aplicativo Android desenvolvido em Kotlin que fornece informações meteorológicas detalhadas. O aplicativo utiliza uma API para buscar e exibir dados sobre o clima atual, previsões do tempo e condições climáticas, tudo apresentado de forma clara e acessível.

## Licença
Este projeto é licenciado sob a [Licença Creative Commons Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)](https://creativecommons.org/licenses/by-nc/4.0/deed.pt-br).

## Tecnologias Utilizadas
- **Plataforma:** Android
- **Linguagem:** Kotlin
- **Interface do Usuário:** Jetpack Compose
- **Injeção de Dependência:** Koin
- **Arquitetura:** Clean Architecture
- **Padrão de Projeto:** MVVM com Flow
- **Teste:** Utilização de testes unitários e testes instrumentados para garantir a qualidade do código e a funcionalidade do aplicativo.

## Funcionalidades Principais

### Exibição de Informações Meteorológicas
O aplicativo fornece detalhes sobre o clima, incluindo:

- **Clima Atual:** Exibe a temperatura atual, condições meteorológicas e outros parâmetros climáticos.
- **Previsões do Tempo:** Apresenta previsões detalhadas para os próximos dias.
- **Ícones de Condição Climática:** Mostra ícones representativos das condições meteorológicas usando imagens da API.

### Interface Intuitiva
A interface do usuário é projetada utilizando Jetpack Compose, proporcionando uma experiência visual moderna e interativa.

## Estrutura do Projeto
O código-fonte do aplicativo está organizado seguindo os princípios da Clean Architecture, proporcionando modularidade e escalabilidade. As camadas incluem:

- **Data:** Manipulação de dados e interação com a API.
- **Domain:** Lógica de negócios e regras de negócios.
- **Presentation:** Camada responsável pela interface do usuário, implementando o padrão MVVM com Flow e Jetpack Compose.

## Configuração do Projeto
1. Clone o repositório: `git clone https://github.com/SeuUsuario/ClimaFacil`
2. Configure as credenciais da API no arquivo de configuração.
3. Abra o projeto no Android Studio ou sua IDE preferida.
4. Compile e execute o aplicativo em um emulador ou dispositivo Android.

## Prints do Aplicativo

![Tela Principal]()
*Tela principal do ClimaFácil mostrando o clima atual*

![Previsão do Tempo]()
*Previsão do tempo para os próximos dias*

## Contribuição
Contribuições são bem-vindas! Se você encontrar bugs, problemas ou deseja adicionar novos recursos, fique à vontade para abrir issues e pull requests.
