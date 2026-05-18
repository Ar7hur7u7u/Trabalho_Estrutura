package br.com.trabalho;

public class Main {
    public static void main(String[] args) {
        PilhaMinMax pilha = new PilhaMinMax();

        adicionar(pilha, 5);
        adicionar(pilha, 2);
        adicionar(pilha, 8);
        adicionar(pilha, 2);
        adicionar(pilha, 10);
        adicionar(pilha, 1);
        remover(pilha);
        remover(pilha);
        remover(pilha);
        adicionar(pilha, 7);
        adicionar(pilha, 0);
        remover(pilha);
    }

    private static void adicionar(PilhaMinMax pilha, int valor) {
        pilha.push(valor);
        mostrarEstado("push(" + valor + ")", pilha);
    }

    private static void remover(PilhaMinMax pilha) {
        int removido = pilha.pop();
        mostrarEstado("pop() -> " + removido, pilha);
    }

    private static void mostrarEstado(String operacao, PilhaMinMax pilha) {
        System.out.println("Operacao: " + operacao);
        System.out.println("Pilha: " + pilha);

        if (pilha.isEmpty()) {
            System.out.println("Minimo: pilha vazia");
            System.out.println("Maximo: pilha vazia");
        } else {
            System.out.println("Minimo: " + pilha.min());
            System.out.println("Maximo: " + pilha.max());
        }

        System.out.println("--------------------------------");
    }
}
