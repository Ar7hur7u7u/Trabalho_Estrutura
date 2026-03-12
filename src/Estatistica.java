/**
 * Funções utilitárias para cálculo de estatísticas básicas.
 */
public final class Estatistica {

    private Estatistica() {
        // Classe utilitária.
    }

    public static double calcularMedia(long[] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("Vetor de valores não pode ser vazio.");
        }

        double soma = 0.0;
        for (long valor : valores) {
            soma += valor;
        }
        return soma / valores.length;
    }

    public static double calcularDesvioPadrao(long[] valores) {
        if (valores == null || valores.length == 0) {
            throw new IllegalArgumentException("Vetor de valores não pode ser vazio.");
        }

        double media = calcularMedia(valores);
        double somaQuadrados = 0.0;

        for (long valor : valores) {
            double diferenca = valor - media;
            somaQuadrados += diferenca * diferenca;
        }

        return Math.sqrt(somaQuadrados / valores.length);
    }
}
