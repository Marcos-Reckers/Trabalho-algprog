// Classe que representa uma pessoa que compra Tele Senas
public class Pessoa {
    // Nome da pessoa
    private String nome;
    // Array de Tele Senas que a pessoa possui
    private TeleSena[] teleSenas;
    // Valor do prêmio recebido pela pessoa
    private double premio;

    // Construtor que cria uma pessoa com um nome e uma quantidade de Tele Senas
    public Pessoa(String nome, int quantidade) {
        this.nome = nome;
        teleSenas = new TeleSena[quantidade];
        // Cria as Tele Senas da pessoa
        for (int i = 0; i < quantidade; i++) {
            teleSenas[i] = new TeleSena();
        }
        premio = 0.0; // Inicializa o prêmio com zero
    }

    // Método que retorna o nome da pessoa
    public String getNome() {
        return nome;
    }

    // Método que retorna o array de Tele Senas da pessoa
    public TeleSena[] getTeleSenas() {
        return teleSenas;
    }

    // Método que retorna o valor do prêmio da pessoa
    public double getPremio() {
        return premio;
    }

    // Método que adiciona um valor ao prêmio da pessoa
    public void adicionarPremio(double valor) {
        premio += valor;
    }

    // Método que verifica se a pessoa foi premiada com um conjunto de números sorteados
    public boolean foiPremiada(int[] numerosSorteados) {
        // Verifica se alguma das Tele Senas da pessoa foi premiada
        for (TeleSena t : teleSenas) {
            if (t.foiPremiada(numerosSorteados)) {
                return true;
            }
        }
        return false;
    }

    // Método que retorna uma representação textual de uma pessoa
    public String toString() {
        String s = "Nome: " + nome + "\n";
        s += "Tele Senas:\n";
        // Adiciona as Tele Senas da pessoa
        for (TeleSena t : teleSenas) {
            s += t + "\n";
        }
        s += "Prêmio: R$" + premio + "\n";
        return s;
    }
}