import java.util.Scanner;

public class JogoDaVelha {

    private static final int TAMANHO_TABULEIRO = 3;

    public static void main(String[] args) {
    
        char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        inicializarTabuleiro(tabuleiro);

        try (Scanner teclado = new Scanner(System.in)) {
            
            char jogador = 'X'; 

            
            processarVezUsuario(teclado, tabuleiro, jogador);

        
            exibirTabuleiro(tabuleiro);
        }
    }

    static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    static void processarVezUsuario(Scanner teclado, char[][] tabuleiro, char jogador) {
        int linha, coluna;

        while (true) {
            try {
                System.out.println("Jogador " + jogador + ", escolha a linha (0, 1, 2): ");
                linha = teclado.nextInt();
                System.out.println("Escolha a coluna (0, 1, 2): ");
                coluna = teclado.nextInt();

                if (isPosicaoValida(tabuleiro, linha, coluna)) {
                    tabuleiro[linha][coluna] = jogador;
                    break;
                } else {
                    System.out.println("Jogada inválida! Escolha outra posição.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Por favor, insira números inteiros.");
                teclado.nextLine();
            }
        }
    }

    static boolean isPosicaoValida(char[][] tabuleiro, int linha, int coluna) {
        return linha >= 0 && linha < TAMANHO_TABULEIRO && coluna >= 0 && coluna < TAMANHO_TABULEIRO && tabuleiro[linha][coluna] == ' ';
    }

    static void exibirTabuleiro(char[][] tabuleiro) {
        System.out.println("Tabuleiro:");
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] + (j < 2 ? " | " : ""));
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
    }
}
