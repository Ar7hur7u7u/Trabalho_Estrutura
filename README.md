# Pilha com minimo e maximo em O(1)

Trabalho de Estrutura de Dados em Java.

O projeto implementa uma pilha de inteiros com as operacoes:

- `push(valor)`: adiciona um elemento.
- `pop()`: remove o elemento do topo.
- `top()`: consulta o elemento do topo.
- `min()`: retorna o menor elemento sem remover.
- `max()`: retorna o maior elemento sem remover.

As operacoes `min()` e `max()` possuem custo O(1) e lidam corretamente com numeros repetidos.

## Como executar

### Pelo IntelliJ IDEA

1. Clone ou baixe este repositorio.
2. Abra a pasta do projeto no IntelliJ IDEA.
3. Abra o arquivo `src/main/java/br/com/trabalho/Main.java`.
4. Execute a classe `Main`.

### Pelo terminal no Windows

Com um JDK instalado:

```powershell
.\run.ps1
```

### Pelo terminal no Linux/macOS

Com um JDK instalado:

```bash
mkdir -p out
javac -encoding UTF-8 -d out src/main/java/br/com/trabalho/*.java
java -cp out br.com.trabalho.Main
```

## Arquivos principais

- `src/main/java/br/com/trabalho/PilhaMinMax.java`: implementacao da pilha.
- `src/main/java/br/com/trabalho/Main.java`: demonstracao das operacoes.
- `relatorio/relatorio.pdf`: relatorio solicitado na entrega.
- `relatorio/relatorio.md`: versao editavel do relatorio.
