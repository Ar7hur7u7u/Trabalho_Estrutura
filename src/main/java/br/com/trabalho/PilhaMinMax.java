package br.com.trabalho;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class PilhaMinMax {
    private final Deque<Integer> elementos = new ArrayDeque<Integer>();
    private final Deque<Integer> minimos = new ArrayDeque<Integer>();
    private final Deque<Integer> maximos = new ArrayDeque<Integer>();

    public void push(int valor) {
        elementos.push(valor);

        if (minimos.isEmpty() || valor <= minimos.peek()) {
            minimos.push(valor);
        }

        if (maximos.isEmpty() || valor >= maximos.peek()) {
            maximos.push(valor);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha esta vazia.");
        }

        int removido = elementos.pop();

        if (removido == minimos.peek()) {
            minimos.pop();
        }

        if (removido == maximos.peek()) {
            maximos.pop();
        }

        return removido;
    }

    public int top() {
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha esta vazia.");
        }

        return elementos.peek();
    }

    public int min() {
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha esta vazia.");
        }

        return minimos.peek();
    }

    public int max() {
        if (isEmpty()) {
            throw new NoSuchElementException("A pilha esta vazia.");
        }

        return maximos.peek();
    }

    public boolean isEmpty() {
        return elementos.isEmpty();
    }

    public int size() {
        return elementos.size();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}
