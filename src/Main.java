public class Main {
    public static void main(String[] args) {
        ExperimentoInsercao experimentoInsercao = new ExperimentoInsercao();
        ExperimentoInsercao.ResultadoInsercao resultadoInsercao = experimentoInsercao.executar();
        resultadoInsercao.imprimirTabela();

        ExperimentoExclusao experimentoExclusao = new ExperimentoExclusao();
        ExperimentoExclusao.ResultadoExclusao resultadoExclusao = experimentoExclusao.executar();
        resultadoExclusao.imprimirTabela();
    }
}
