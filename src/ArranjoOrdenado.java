/**
 * Estrutura baseada em arranjo de inteiros que mantém os elementos ordenados.
 * A ordem pode ser crescente ou decrescente, definida no construtor.
 */
public class ArranjoOrdenado {
    private final int[] elementos;
    private int tamanho;
    private final boolean crescente;
    private final int capacidade;

    /**
     * @param capacidade quantidade máxima de elementos
     * @param crescente true para ordem crescente, false para decrescente
     */
    public ArranjoOrdenado(int capacidade, boolean crescente) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        this.elementos = new int[capacidade];
        this.tamanho = 0;
        this.crescente = crescente;
        this.capacidade = capacidade;
    }

    /**
     * Insere um valor mantendo a ordenação do arranjo.
     *
     * @param valor valor a ser inserido
     * @return true se inseriu com sucesso, false se o arranjo está cheio
     */
    public boolean insert(int valor) {
        if (isFull()) {
            return false;
        }

        int posicao = encontrarPosicaoInsercao(valor);

        // Desloca elementos à direita para abrir espaço.
        for (int i = tamanho; i > posicao; i--) {
            elementos[i] = elementos[i - 1];
        }

        elementos[posicao] = valor;
        tamanho++;
        return true;
    }

    /**
     * Remove a primeira ocorrência de um valor.
     *
     * @param valor valor a ser removido
     * @return true se removeu, false se não encontrou
     */
    public boolean remove(int valor) {
        int indice = buscar(valor);
        if (indice < 0) {
            return false;
        }

        // Desloca elementos à esquerda para fechar o espaço removido.
        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        tamanho--;
        return true;
    }

    /**
     * Busca binária por um valor.
     *
     * @param valor valor procurado
     * @return índice do valor, ou -1 caso não exista
     */
    public int buscar(int valor) {
        int inicio = 0;
        int fim = tamanho - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            int atual = elementos[meio];

            if (atual == valor) {
                return meio;
            }

            if (crescente) {
                if (valor < atual) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            } else {
                if (valor > atual) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public int size() {
        return tamanho;
    }

    private int encontrarPosicaoInsercao(int valor) {
        int inicio = 0;
        int fim = tamanho;

        // Busca binária para encontrar o ponto de inserção correto.
        while (inicio < fim) {
            int meio = inicio + (fim - inicio) / 2;
            int atual = elementos[meio];

            if (crescente) {
                if (valor <= atual) {
                    fim = meio;
                } else {
                    inicio = meio + 1;
                }
            } else {
                if (valor >= atual) {
                    fim = meio;
                } else {
                    inicio = meio + 1;
                }
            }
        }
        return inicio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(elementos[i]);
            if (i < tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
