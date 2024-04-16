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
        Set<Integer> estadosAtuais = new HashSet<>();
        estadosAtuais.add(estadoInicial);

        for (char c : cadeia.toCharArray()) {
            Set<Integer> proximosEstados = new HashSet<>();

            for (int estadoAtual : estadosAtuais) {
                if (transicoes.containsKey(estadoAtual) && transicoes.get(estadoAtual).containsKey(c)) {
                    proximosEstados.addAll(transicoes.get(estadoAtual).get(c));
                }
            }
            estadosAtuais = proximosEstados;
        }

        for (int estadoAtual : estadosAtuais) {
            if (estadosAceitacao.contains(estadoAtual)) {
                return true;
            }
        }

        return false;
    }
}