public class ArranjoOrdenado {
    private final int[] elementos;
    private int tamanho;
    private final boolean crescente;
    private final int capacidade;

    public ArranjoOrdenado(int capacidade, boolean crescente) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        this.elementos = new int[capacidade];
        this.tamanho = 0;
        this.crescente = crescente;
        this.capacidade = capacidade;
    }

    public boolean insert(int valor) {
        if (isFull()) {
            return false;
        }

        int posicao = encontrarPosicaoInsercao(valor);
        for (int i = tamanho; i > posicao; i--) {
            elementos[i] = elementos[i - 1];
        }

        elementos[posicao] = valor;
        tamanho++;
        return true;
    }

    public boolean remove(int valor) {
        int indice = buscar(valor);
        if (indice < 0) {
            return false;
        }

        for (int i = indice; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }

        tamanho--;
        return true;
    }

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
