# Simulador de Autômatos Finitos

Este é um projeto Java para implementar um simulador de autômatos finitos. O programa lê um arquivo de entrada que contém a especificação de um autômato finito e, em seguida, processa uma lista de cadeias de entrada, determinando se cada cadeia é aceita ou rejeitada pelo autômato.

## Arquivos do Projeto

- `Main.java`: Contém o código-fonte da classe principal que lê o arquivo de entrada, cria o autômato finito e processa as cadeias de entrada.
- `AutomatoFinito.java`: Contém o código-fonte da classe que representa o autômato finito e define o método para processar uma cadeia de entrada.

## Como Compilar e Executar

Para compilar e executar o programa, siga estas etapas:

1. Certifique-se de ter o JDK (Java Development Kit) instalado em seu sistema.
2. Abra um terminal ou prompt de comando e navegue até o diretório do projeto.
3. Compile os arquivos Java usando o seguinte comando:
    ```
    javac Main.java AutomatoFinito.java
    ```
4. Após a compilação bem-sucedida, execute o programa fornecendo o caminho do arquivo de entrada como argumento:
    ```
    java Main <caminho_do_arquivo>
    ```
   Substitua `<caminho_do_arquivo>` pelo caminho do seu arquivo de entrada real.

O programa processará as cadeias de entrada conforme especificado no arquivo de entrada e exibirá os resultados no console.