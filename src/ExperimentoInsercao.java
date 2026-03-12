import java.util.Random;

public class ExperimentoInsercao {
    private static final int CAPACIDADE = 100_000;
    private static final int EXECUCOES = 100;

    public ResultadoInsercao executar() {
        long[] temposCrescenteEstruturaCrescente = executarCenario(0, true);
        long[] temposCrescenteEstruturaDecrescente = executarCenario(0, false);
        long[] temposDecrescenteEstruturaCrescente = executarCenario(1, true);
        long[] temposDecrescenteEstruturaDecrescente = executarCenario(1, false);
        long[] temposAleatorioEstruturaCrescente = executarCenario(2, true);
        long[] temposAleatorioEstruturaDecrescente = executarCenario(2, false);

        ResultadoInsercao resultado = new ResultadoInsercao();
        resultado.medias[0][0] = Estatistica.calcularMedia(temposCrescenteEstruturaCrescente);
        resultado.desvios[0][0] = Estatistica.calcularDesvioPadrao(temposCrescenteEstruturaCrescente);
        resultado.medias[0][1] = Estatistica.calcularMedia(temposCrescenteEstruturaDecrescente);
        resultado.desvios[0][1] = Estatistica.calcularDesvioPadrao(temposCrescenteEstruturaDecrescente);

        resultado.medias[1][0] = Estatistica.calcularMedia(temposDecrescenteEstruturaCrescente);
        resultado.desvios[1][0] = Estatistica.calcularDesvioPadrao(temposDecrescenteEstruturaCrescente);
        resultado.medias[1][1] = Estatistica.calcularMedia(temposDecrescenteEstruturaDecrescente);
        resultado.desvios[1][1] = Estatistica.calcularDesvioPadrao(temposDecrescenteEstruturaDecrescente);

        resultado.medias[2][0] = Estatistica.calcularMedia(temposAleatorioEstruturaCrescente);
        resultado.desvios[2][0] = Estatistica.calcularDesvioPadrao(temposAleatorioEstruturaCrescente);
        resultado.medias[2][1] = Estatistica.calcularMedia(temposAleatorioEstruturaDecrescente);
        resultado.desvios[2][1] = Estatistica.calcularDesvioPadrao(temposAleatorioEstruturaDecrescente);

        return resultado;
    }

    private long[] executarCenario(int cenario, boolean estruturaCrescente) {
        long[] tempos = new long[EXECUCOES];

        for (int execucao = 0; execucao < EXECUCOES; execucao++) {
            ArranjoOrdenado arranjo = new ArranjoOrdenado(CAPACIDADE, estruturaCrescente);
            Random random = new Random(12345L + execucao);

            long t1 = System.nanoTime();
            for (int i = 0; i < CAPACIDADE; i++) {
                int valor;
                if (cenario == 0) {
                    valor = i;
                } else if (cenario == 1) {
                    valor = CAPACIDADE - i;
                } else {
                    valor = random.nextInt(CAPACIDADE * 10);
                }
                arranjo.insert(valor);
            }
            long t2 = System.nanoTime();
            tempos[execucao] = t2 - t1;
        }

        return tempos;
    }

    public static class ResultadoInsercao {
        private final double[][] medias = new double[3][2];
        private final double[][] desvios = new double[3][2];

        public void imprimirTabela() {
            String[] cenarios = {
                "Inserção crescente",
                "Inserção decrescente",
                "Inserção aleatória"
            };

            System.out.println("\n===== RESULTADOS DE INSERÇÃO (ns) =====");
            System.out.printf("%-28s %-24s %-24s%n", "Cenário", "Estrutura Crescente", "Estrutura Decrescente");
            for (int i = 0; i < cenarios.length; i++) {
                String colCresc = String.format("%.2f +/- %.2f", medias[i][0], desvios[i][0]);
                String colDecresc = String.format("%.2f +/- %.2f", medias[i][1], desvios[i][1]);
                System.out.printf("%-28s %-24s %-24s%n", cenarios[i], colCresc, colDecresc);
            }
        }
    }
}
