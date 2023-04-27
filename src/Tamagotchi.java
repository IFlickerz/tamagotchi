// Nicolas Mossmann Lemos

public class Tamagotchi {
    private final String nome; // Final pois o nome nunca será alterado
    private int idade, sono, fome, tedio;
    private double peso; // Por mais que o projeto só trabalhe com inteiros para peso,
                         // optei por colocar double por se tratar de KG.
    public Tamagotchi(String nome) { // Construtor da Classe
        this.nome = nome;
        this.idade = 0;
        this.peso = 1;
        this.sono = 0;
        this.fome = 0;
        this.tedio = 0;
    }

    // INICIO - Getters & Setters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getSono() {
        return sono;
    }

    public int getFome() {
        return fome;
    }

    public int getTedio() {
        return tedio;
    }

    // FIM - Getters & Setters

    public void status() { // Exibe o Status atual do Tamagotchi
        System.out.println("\nIdade: " + idade +
                            "\nPeso: " + peso);
    }

    public void comer(boolean isMuito) { // Método para o Tamagotchi comer
        passarTempo(1);
        passarTempo(3);
        if (isMuito) {              // Faz o Tamagotchi comer muito
            this.peso += 5;         // Depois de comer muito, engorda 5kg (regra)
            this.fome = 0;          // Fica sem fome
            dormir();               // Depois de comer muito, automaticamente dorme (regra)
        } else {                // Faz o Tamagotchi comer pouco
            this.peso += 1;     // Depois de comer pouco, engorda 1kg (regra)
            if (fome < 3) {     // Diminui a fome
                this.fome = 0;
            } else {
                this.fome -= 3;
            }
        }
        checaMorte();
    }

    public void dormir() { // Método para o Tamagotchi dormir
        this.sono = 0;
        this.idade += 1; // Depois de dormir, fica mais velho em 1 dia (regra)
        passarTempo(2);
        passarTempo(3);
    }

    public void exercitar(boolean isCorrida) { // Método para exercitar o Tamagotchi
        passarTempo(1);
        passarTempo(2);
        if (isCorrida) {           // Faz o Tamagotchi correr
            this.peso -= 4;        // Depois de correr, o Tamagotchi perde 4kg (regra)
            this.tedio = 0;        // Fica muito feliz (zera tédio)
            checaMorte();
            comer(true);   // Depois de correr, automaticamente come muito (regra)
        } else {              // Faz o Tamagotchi caminhar
            this.peso -= 1;   // Depois de caminhar, o Tamagotchi perde 1kg (regra)
            if (tedio < 3) {  // Acrescenta felicidade (diminui tédio)
                this.tedio = 0;
            } else {
                this.tedio -= 3;
            }
            checaMorte();
            if (fome < 7) this.fome = 7; // Depois de caminhar, o Tamagotchi fica com fome (regra)
        }
    }

    public void passarTempo(int ocasiao) { // Método para passar o tempo (somente acrescenta fome, sono e tédio)
        switch (ocasiao) {
            case 0 -> {
                if (fome != 10) this.fome += 1;
                if (sono != 10) this.sono += 1;
                if (tedio != 10) this.tedio += 1;
            }
            case 1 -> {
                if (sono != 10) this.sono += 1;
            }
            case 2 -> {
                if (fome != 10) this.fome += 1;
            }
            case 3 -> {
                if (tedio != 10) this.tedio += 1;
            }
        }
    }

    public void checaMorte() {        //  Verifica se o Tamagotchi está nas condições de morte, caso esteja,
        if (peso > 20 || peso <= 0) { //  exibe a mensagem de morte e interrompe a execução.
            System.out.println("\n" +
                    "Eita! Seu Tamagotchi morreu porque você é um péssimo cuidador...\n" +
                    "Veja pelo lado bom, ele sobreviveu " + idade + " dia(s)...");
            System.exit(0);
        }
    }
}
