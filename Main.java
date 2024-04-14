import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int TAMANHO_TABULEIRO = 5;
    private static List<List<Character> > tabuleiro = new ArrayList<>();
    private static int linhaNavio, colunaNavio;
  
    private static void inicializarTabuleiro() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            List<Character> linha = new ArrayList<>();
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                linha.add('O');
            }
            tabuleiro.add(linha);
        }
    }
    private static void exibirTabuleiro() {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    private static void posicionarNavio() {
        Random rand = new Random();
        linhaNavio = rand.nextInt(TAMANHO_TABULEIRO);
        colunaNavio = rand.nextInt(TAMANHO_TABULEIRO);
        tabuleiro.get(linhaNavio).set(colunaNavio, 'N');
    }
    public static void main(String[] args) {
        inicializarTabuleiro();
        posicionarNavio();
        int palpiteLinha, palpiteColuna;
        int turno;

        System.out.println("Bem-vindo ao Jogo de Batalha Naval!");
        System.out.println("Escolha uma linha e uma coluna de 0 a 4 para atacar:");
      
        for (turno = 0; turno < 4; turno++) {
            System.out.println("Turno " + (turno + 1));
            Scanner scanner = new Scanner(System.in);
            System.out.print("Adivinhe a linha: ");
            palpiteLinha = scanner.nextInt();
            System.out.print("Adivinhe a coluna: ");
            palpiteColuna = scanner.nextInt();

            if (palpiteLinha < 0 || palpiteLinha >= TAMANHO_TABULEIRO || palpiteColuna < 0 || palpiteColuna >= TAMANHO_TABULEIRO) {
                System.out.println("Palpite fora do tabuleiro! Tente novamente.");
            } else if (tabuleiro.get(palpiteLinha).get(palpiteColuna) == 'X') {
                System.out.println("Você já tentou esta posição. Tente novamente.");
            } else if (tabuleiro.get(palpiteLinha).get(palpiteColuna) == 'N') {
                System.out.println("Parabéns! Você afundou o navio!");
                tabuleiro.get(palpiteLinha).set(palpiteColuna, 'X');
                exibirTabuleiro();
                break;
            } else {
                System.out.println("Você errou!");
                tabuleiro.get(palpiteLinha).set(palpiteColuna, 'X');
            }
        }

        if (turno == 4) {
            System.out.printf("Fim do jogo! O navio estava na linha %d e coluna %d.\n", linhaNavio, colunaNavio);
            tabuleiro.get(linhaNavio).set(colunaNavio, 'N');
            exibirTabuleiro();
        }
    }
}


