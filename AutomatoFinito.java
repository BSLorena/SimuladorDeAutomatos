import java.util.*;

public class AutomatoFinito {
    private Set<Integer> estados;
    private Set<Character> alfabeto;
    private Map<Integer, Map<Character, Set<Integer>>> transicoes;
    private int estadoInicial;
    private Set<Integer> estadosAceitacao;

    public AutomatoFinito(Set<Integer> estados, Set<Character> alfabeto, Map<Integer, Map<Character, Set<Integer>>> transicoes, int estadoInicial, Set<Integer> estadosAceitacao) {
        this.estados = estados;
        this.alfabeto = alfabeto;
        this.transicoes = transicoes;
        this.estadoInicial = estadoInicial;
        this.estadosAceitacao = estadosAceitacao;
    }

    public boolean processarCadeia(String cadeia) {
        int estadoAtual = estadoInicial;
        for (char c : cadeia.toCharArray()) {
            if (!transicoes.containsKey(estadoAtual) || !transicoes.get(estadoAtual).containsKey(c))
                return false;
            estadoAtual = transicoes.get(estadoAtual).get(c).iterator().next();
        }
        return estadosAceitacao.contains(estadoAtual);
    }
}