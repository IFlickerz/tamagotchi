// Nicolas Mossmann Lemos

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option, inOption, contSono = 0;
        boolean shouldBreak;

        System.out.println("Dê um nome a(o) Tamagotchi!");
        String nome = input.nextLine();

        Tamagotchi tamagotchi = new Tamagotchi(nome); // Cria o(a) Tamagotchi dando o nome para ele/ela

        while (tamagotchi.getIdade() < 15) { // Não utilizei "!=" para evitar loop infinito em caso de bug com a Idade
            shouldBreak = false;
            tamagotchi.status(); // Exibe o status do Tamagotchi

            if (tamagotchi.getFome() >= 7) {
                System.out.println(tamagotchi.getNome() + " está com fome!");
            }

            if (tamagotchi.getSono() >= 9) {
                System.out.println(tamagotchi.getNome() + " está com sono!");
                contSono++;
                if (contSono == 5) { // Funcionalidade Necessária: Dormir automaticamente após 5 avisos de Sono
                    System.out.println(tamagotchi.getNome() + " ficou com tanto sono que desmaiou!");
                    contSono = 0;
                    tamagotchi.dormir();
                }
            }

            if (tamagotchi.getTedio() >= 7) {
                System.out.println(tamagotchi.getNome() + " está entediado!");
            }

            while (!shouldBreak) {
                System.out.println("\n1) Dormir\n2) Comer\n3) Exercitar\n4) Passar o Tempo"); //Exibe o menu de ações
                option = Integer.parseInt(input.nextLine());

                switch (option) {
                    case 1 -> { // Opção para o Tamagotchi dormir
                        tamagotchi.dormir();
                        contSono = 0;
                        shouldBreak = true;
                    }
                    case 2 -> { // Opção para o Tamagotchi comer
                        while (!shouldBreak) {
                            System.out.println("\nVocê deseja que " + tamagotchi.getNome() + " coma:\n1) Pouco\n2) Muito");
                            inOption = Integer.parseInt(input.nextLine());
                            switch (inOption) {
                                case 1 -> {
                                    tamagotchi.comer(false); // Opção para o Tamagotchi comer muito
                                    shouldBreak = true;
                                }
                                case 2 -> {
                                    tamagotchi.comer(true); // Opção para o Tamagotchi comer pouco
                                    shouldBreak = true;
                                }
                                default -> System.out.println("\nVocê deve selecionar uma entre as opções (1) e (2)"); // Sem opção selecionada (Erro)
                            }
                        }
                    }
                    case 3 -> { // Opção para o Tamagotchi exercitar
                        while (!shouldBreak) {
                            System.out.println("\nVocê deseja que " + tamagotchi.getNome() + ":\n1) Caminhe\n2) Corra");
                            inOption = Integer.parseInt(input.nextLine());
                            switch (inOption) {
                                case 1 -> {
                                    tamagotchi.exercitar(false); // Opção para o Tamagotchi caminhar
                                    shouldBreak = true;
                                }
                                case 2 -> {
                                    tamagotchi.exercitar(true); // Opção para o Tamagotchi correr
                                    shouldBreak = true;
                                }
                                default -> System.out.println("\nVocê deve selecionar uma entre as opções (1) e (2)"); // Sem opção selecionada (Erro)
                            }
                        }
                    }
                    case 4 -> { // Opção para passar o tempo
                        tamagotchi.passarTempo(0);
                        shouldBreak = true;
                    }
                    default -> System.out.println("\nVocê deve selecionar uma entre as opções (1), (2), (3) e (4)"); // Sem opção selecionada (Erro)
                }
            }
        }
        System.out.println("\n" + tamagotchi.getNome() + " morreu de velhice...\nMas você o(a) cuidou muito bem, parabéns!");
    }
}