import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("-----Jogos no Terminal Java-----");
            System.out.println("Qual das operações você deseja utilizar?");
            System.out.println("1 => Adivinhação");
            System.out.println("2 => Pedra, Papel e Tesoura");
            System.out.println("0 => Sair");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 2) {

                switch (opcao) {
                    case 1:
                        System.out.println("Quantas tentativas o jogador terá?");
                        int numTentativas = scanner.nextInt();
                        System.out.println("Até que número o jogador deve tentar adivinhar?");
                        int numMaximo = scanner.nextInt();

                        int numSecreto = random.nextInt(numMaximo) + 1;

                        boolean acertou = false;
                        int tentativaFinal = 0;

                        for (int i = 0; i < numTentativas; i++) {
                            System.out.println("Tentativa " + (i + 1) + " de " + numTentativas + ". Qual o palpite?");
                            int palpite = scanner.nextInt();

                            if (palpite == numSecreto) {
                                acertou = true;
                                tentativaFinal = i + 1;
                                break;

                            } else if (palpite < numSecreto) {
                                System.out.println("O número informado é menor do que o número alvo.");
                            } else {
                                System.out.println("O número informado é maior do que o número alvo.");
                            }

                        }

                        if (acertou) {
                            System.out.println("Parabéns, você acertou na tentativa " + tentativaFinal);
                        } else {
                            System.out.println("Que pena, o número sorteado foi " + numSecreto);
                        }
                        break;

                    case 2:
                        System.out.println("Escolha 1 para pedra, 2 para papel e 3 para tesoura.");
                        int numOpcao = scanner.nextInt();

                        int numOpcaoSecreto = random.nextInt(3) + 1;

                        String objetoJogador;
                        String objetoMaquina;

                        switch (numOpcaoSecreto) {
                            case 1:
                                objetoMaquina = "pedra";
                                break;
                            case 2:
                                objetoMaquina = "papel";
                                break;
                            case 3:
                                objetoMaquina = "tesoura";
                                break;
                            default:
                                objetoMaquina = "Objeto inválido";
                                break;
                        }

                        switch (numOpcao) {
                            case 1:
                                objetoJogador = "pedra";
                                break;
                            case 2:
                                objetoJogador = "papel";
                                break;
                            case 3:
                                objetoJogador = "tesoura";
                                break;
                            default:
                                objetoJogador = "Objeto inválido";
                                break;
                        }
                        if (numOpcao >= 1 && numOpcao <= 3) {
                            if (numOpcao == numOpcaoSecreto) {
                                System.out.println("Você escolheu " + objetoJogador + " o computador escolheu " + objetoMaquina + ", foi um empate!");
                            } else if ((numOpcao == 1 && numOpcaoSecreto == 3)
                                    || (numOpcao == 2 && numOpcaoSecreto == 1)
                                    || (numOpcao == 3 && numOpcaoSecreto == 2)) {
                                System.out.println("Você escolheu " + objetoJogador + " o computador escolheu " + objetoMaquina + ", você venceu!");
                            } else {
                                System.out.println("Você escolheu " + objetoJogador + " o computador escolheu " + objetoMaquina + ", você perdeu!");
                            }
                        } else {
                            System.out.println("Jogada Inválida.");
                        }
                        break;
                }
            } else if (opcao == 0) {
                System.out.println("Até mais!");
            } else {
                System.out.println("Operação Inválida.");
            }
        }
        scanner.close();
    }

}


