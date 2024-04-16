import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java Main <caminho_do_arquivo>");
            return;
        }

        String arquivoEntrada = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada));
            Set<Integer> estados = new HashSet<>();
            int numEstados = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < numEstados; i++) {
                estados.add(i);
            }
            
            String[] alfabetoArray = reader.readLine().trim().split("\\s+");
            Set<Character> alfabeto = new HashSet<>();
            for (int i = 1; i < alfabetoArray.length; i++) {
                alfabeto.add(alfabetoArray[i].charAt(0));
            }
            
            String[] estadosAceitacaoStr = reader.readLine().trim().split("\\s+");
            int numEstadosAceitacao = Integer.parseInt(estadosAceitacaoStr[0]);
            Set<Integer> estadosAceitacao = new HashSet<>();
            for (int i = 1; i <= numEstadosAceitacao; i++) {
                estadosAceitacao.add(Integer.parseInt(estadosAceitacaoStr[i]));
            }
           
            int numTransicoes = Integer.parseInt(reader.readLine().trim());
            Map<Integer, Map<Character, Set<In1teger>>> transicoes = new HashMap<>();
            for (int i = 0; i < numTransicoes; i++) {
                String[] transicao = reader.readLine().trim().split("\\s+");
                int estadoAtual = Integer.parseInt(transicao[0]);
                char simbolo = transicao[1].charAt(0);
                int proximoEstado = Integer.parseInt(transicao[2]);
                transicoes.putIfAbsent(estadoAtual, new HashMap<>());
                transicoes.get(estadoAtual).putIfAbsent(simbolo, new HashSet<>());
                transicoes.get(estadoAtual).get(simbolo).add(proximoEstado);
            }
            
            int estadoInicial = 0;
            AutomatoFinito automato = new AutomatoFinito(estados, alfabeto, transicoes, estadoInicial, estadosAceitacao);
            int numCadeias = Integer.parseInt(reader.readLine().trim());
            for (int i = 0; i < numCadeias; i++) {
                String cadeia = reader.readLine().trim();
                boolean aceita = automato.processarCadeia(cadeia);
                System.out.println(aceita ? "aceita" : "rejeita");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
