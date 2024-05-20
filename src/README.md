# Entendendo os arquivos:

## Contador.java

É o arquivo principal com o desafio proposto. Segue abaixo a descrição da proposta do desafio:

O sistema deverá receber dois parâmetros via terminal que representarão dois números inteiros, com estes dois números você deverá obter a quantidade de interações (for) e realizar a impressão no console (System.out.print) dos números incrementados, exemplo:

- Se você passar os números 12 e 30, logo teremos uma interação (for) com 18 ocorrências para imprimir os números, exemplo: `"Imprimindo o número 1"`, `"Imprimindo o número 2"` e assim por diante.
- Se o primeiro parâmetro for MAIOR que o segundo parâmetro, você deverá lançar a exceção customizada chamada de `ParametrosInvalidosException` com a segunda mensagem: "O segundo parâmetro deve ser maior que o primeiro"

## ParametrosInvalidosException.java

Arquivo auxiliar do programa Contador.java. Sua única função é adicionar a exceção customizada "ParametrosInvalidosException" dentro da hierarquia de exceções, possibilitando então que o programa principal funcione corretamente.

## ProcessoSeletivoTestes.java

Este arquivo é referente aos cases que foram propostos na introdução do desafio dentro da plataforma DIO. Este programa soluciona cada case individualmente, funcionando de maneira semelhante ao que fora apresentado e sugerido dentro da própria plataforma. A descrição individual de cada de acordo com a própria plataforma pode ser lida abaixo:

**Case 1:** Vamos imaginar que em um processo seletivo, existe o valor base salarial de R$ 2.000,00 e o salário pretentido pelo candidato. Vamos elaborar um controle de fluxo onde:

- Se o valor salário base, for maior que valor salário pretentido, imprima : LIGAR PARA O CANDIDATO;
- Senão, Se o valor salário base for igual ao valor salário pretentido, imprima : LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA;
- Senão imprima: AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.

**Case 2:** Foi solicitado, que nosso sistema garanta que, diante das inúmeras candidaturas sejam selecionados apenas no máximo, 5 candidatos para entrevista, onde o salário pretendido seja menor ou igual ao salário base.

**Case 3:** Agora é hora de imprimir a lista dos candidatos selecionados, para disponibilizar para o RH entrar em contato.

**Case 4:** O RH deverá realizar uma ligação, com no máximo 03 tentativas para cada candidato selecionado e caso o candidato atenda, deve-se imprimir:

- **"CONSEGUIMOS CONTATO COM** [CANDIDATO] **APÓS**  [TENTATIVA] **TENTATIVA(S)."**
- Do contrário imprima: **"NÃO CONSEGUIMOS CONTATO COM O** [CANDIDATO].

## ProcessoSeletivo.java

Um pequeno projeto pessoal meu que fiz considerando o programa acima. Sua funcionalidade é exatamente a mesma, mas com o diferencial de que o seu sistema foi pensado para que os resultados de cada case afetem a resposta do próximo numa única ativação. Basicamente, uma integração de todos os cases num único programa.

Apesar de não ser obrigatório, imagino que tenha sido o mais desafiador dentre os 4 arquivos que estão sendo enviados, já que meu conhecimento atual de programação em Java ainda é bastante superficial, todavia foi o suficiente para criar este programa. O resultado ficou bastante satisfatório e limpo.