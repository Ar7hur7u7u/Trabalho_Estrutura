# Relatorio - Pilha com minimo e maximo

## Objetivo

O objetivo do trabalho e implementar uma pilha que permita consultar o menor e o maior elemento armazenado sem remover nenhum item da estrutura. As operacoes `min()` e `max()` devem ter custo O(1), mesmo quando existem valores repetidos na pilha.

## Solucao desenvolvida

A solucao foi implementada em Java usando tres pilhas internas:

- `elementos`: armazena todos os valores inseridos, seguindo o comportamento normal de uma pilha.
- `minimos`: armazena os menores valores encontrados ate cada ponto da execucao.
- `maximos`: armazena os maiores valores encontrados ate cada ponto da execucao.

Quando um novo valor e inserido com `push(valor)`, ele sempre entra na pilha principal. Alem disso, o valor tambem entra na pilha de minimos se for menor ou igual ao minimo atual. Da mesma forma, entra na pilha de maximos se for maior ou igual ao maximo atual.

O uso de menor ou igual e maior ou igual e importante para tratar numeros repetidos. Assim, se o menor valor aparecer mais de uma vez, cada ocorrencia relevante fica registrada na pilha auxiliar. Quando um elemento e removido, a implementacao remove tambem o topo da pilha auxiliar correspondente somente se o valor removido for igual ao minimo ou maximo atual.

## Exemplo de funcionamento

Considere as insercoes `5`, `2`, `8`, `2`, `10` e `1`.

Depois de inserir esses valores, o menor valor e `1` e o maior valor e `10`. Ao remover `1`, o menor volta a ser `2`. Ao remover `10`, o maior volta a ser `8`. Como o valor `2` foi inserido duas vezes, a estrutura continua retornando `2` como minimo enquanto ainda existir uma ocorrencia dele na pilha.

## Complexidade de tempo

A operacao `min()` tem custo O(1), pois apenas consulta o topo da pilha auxiliar `minimos`. Essa consulta nao percorre os elementos da pilha principal.

A operacao `max()` tambem tem custo O(1), pois apenas consulta o topo da pilha auxiliar `maximos`. Assim como em `min()`, nao existe busca linear.

As operacoes `push()` e `pop()` tambem executam em O(1), porque realizam apenas comparacoes e insercoes ou remocoes no topo das pilhas.

## Complexidade de espaco

A estrutura usa espaco O(n), onde `n` e a quantidade de elementos inseridos na pilha. No pior caso, as pilhas auxiliares podem armazenar varios elementos, principalmente quando os valores sao inseridos em ordem crescente, decrescente ou quando existem muitos valores repetidos.

## Conclusao

A implementacao atende aos requisitos do trabalho porque permite consultar o menor e o maior elemento da pilha em tempo constante, nao remove elementos durante as consultas e trata corretamente valores repetidos.
