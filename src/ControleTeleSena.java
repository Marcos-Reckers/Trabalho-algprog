// Classe que controla a lógica do programa
public class ControleTeleSena {
    // Array de Pessoa que representa os concorrentes da Tele Sena
    private Pessoa[] pessoas;
    // Array de inteiros que representa os números sorteados na Tele Sena
    private int[] numerosSorteados;
    // Quantidade de Tele Senas vendidas
    private int quantidadeTeleSenas;
    // Quantidade de ganhadores da Tele Sena
    private int quantidadeGanhadores;
    // Valor do prêmio da Tele Sena
    private double valorPremio;
    // Lucro obtido pelo Silvio Santos com a Tele Sena
    private double lucro;
    
    // Construtor que recebe a quantidade de pessoas que vão concorrer na Tele Sena
    public ControleTeleSena(int quantidadePessoas) {
        pessoas = new Pessoa[quantidadePessoas]; // Cria o array de Pessoa com o tamanho da quantidade
        numerosSorteados = new int[25]; // Cria o array de números sorteados com o tamanho inicial de 25
        quantidadeTeleSenas = 0; // Inicializa a quantidade de Tele Senas vendidas com zero
        quantidadeGanhadores = 0; // Inicializa a quantidade de ganhadores com zero
        valorPremio = 0; // Inicializa o valor do prêmio com zero
        lucro = 0; // Inicializa o lucro com zero
    }
    
    // Método que gera os nomes das pessoas que vão concorrer na Tele Sena
    public void gerarNomes() {
        // Array de String que contém alguns nomes possíveis
        String[] nomes = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fabiana", "Gabriel", "Helena", "Igor", "Julia", "Leonardo", "Mariana", "Nelson", "Olivia", "Pedro", "Renata", "Samuel", "Tatiana", "Victor", "Zara"};
        // Array de boolean que indica se o nome já foi sorteado
        boolean[] sorteados = new boolean[nomes.length];
        // Inicializa o array de sorteados com falso
        for (int i = 0; i < sorteados.length; i++) {
            sorteados[i] = false;
        }
        // Percorre o array de Pessoa
        for (int i = 0; i < pessoas.length; i++) {
            int indice = (int)(Math.random() * nomes.length); // Gera um índice aleatório entre 0 e o tamanho do array de nomes
            boolean repetido = sorteados[indice]; // Verifica se o nome já foi sorteado
            if (repetido) { // Se o nome é repetido
                i--; // Decrementa o contador do laço para sortear outro nome
            } else { // Se o nome é inédito
                pessoas[i] = new Pessoa(nomes[indice], (int)(Math.random() * 15 + 1)); // Cria uma nova Pessoa com o nome sorteado e uma quantidade aleatória de Tele Senas entre 1 e 15
                sorteados[indice] = true; // Marca o nome como sorteado
            }
        }
    }
    
    // Método que calcula a quantidade de Tele Senas vendidas
    public void calcularQuantidadeTeleSenas() {
        // Percorre o array de Pessoa
        for (int i = 0; i < pessoas.length; i++) {
            // Adiciona a quantidade de Tele Senas da Pessoa à quantidade total
            quantidadeTeleSenas += pessoas[i].getTeleSenas().length;
        }
    }
    
    // Método que realiza o sorteio da Tele Sena
    public void realizarSorteio() {
        // Variável que indica se houve algum ganhador
        boolean houveGanhador = false;
        // Contador que indica quantos números foram sorteados
        int numerosSorteados = 0;
        // Enquanto não houver ganhador
        while (!houveGanhador) {
            int numero = (int)(Math.random() * 60 + 1); // Gera um número aleatório entre 1 e 60
            boolean repetido = false; // Flag para verificar se o número já foi sorteado
            // Percorre o array de números sorteados até a posição atual
            for (int i = 0; i < numerosSorteados; i++) {
                if (this.numerosSorteados[i] == numero) { // Se o número já foi sorteado
                    repetido = true; // Marca a flag como verdadeira
                    break; // Sai do laço interno
                }
            }
            if (repetido) { // Se o número é repetido
                continue; // Volta ao início do laço externo
            } else { // Se o número é inédito
                this.numerosSorteados[numerosSorteados] = numero; // Adiciona o número ao array de números sorteados
                numerosSorteados++; // Incrementa o contador de números sorteados
                // Mostra o número sorteado na tela
                System.out.println("Número sorteado: " + numero);
                // Pausa o programa por 1 segundo
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }
        }
    }
    
    // Método que calcula o valor do prêmio da Tele Sena
    public void calcularValorPremio() {
        // O valor do prêmio é 80% do valor total de vendas das Tele Senas
        valorPremio = quantidadeTeleSenas * TeleSena.VALOR_VENDA * 0.8;
    }
    
    // Método que distribui o prêmio entre os ganhadores
    public void distribuirPremio() {
        // O valor do prêmio para cada ganhador é o valor total do prêmio dividido pela quantidade de ganhadores
        double valorIndividual = valorPremio / quantidadeGanhadores;
        // Percorre o array de Pessoa
        for (int i = 0; i < pessoas.length; i++) {
            // Se a Pessoa possui alguma Tele Sena premiada
            if (pessoas[i].foiPremiada(numerosSorteados)) {
                // Adiciona o valor individual à premiação da Pessoa
                pessoas[i].adicionarPremio(valorIndividual);
            }
        }
    }
    
    // Método que calcula o lucro obtido pelo Silvio Santos com a Tele Sena
    public void calcularLucro() {
        // O lucro é o valor total de vendas das Tele Senas menos o valor do prêmio
        lucro = quantidadeTeleSenas * TeleSena.VALOR_VENDA - valorPremio;
    }
    
    // Método que mostra as informações finais na tela
    public void mostrarInformacoes() {
        // Mostra a quantidade de Tele Senas vendidas
        System.out.println("Quantidade de Tele Senas vendidas: " + quantidadeTeleSenas);
        // Mostra a quantidade de ganhadores
        System.out.println("Quantidade de ganhadores: " + quantidadeGanhadores);
        // Mostra o valor do prêmio para cada ganhador
        System.out.println("Valor do prêmio para cada ganhador: R$" + valorPremio / quantidadeGanhadores);
        // Mostra o valor total das Tele Senas vendidas
        System.out.println("Valor total das Tele Senas vendidas: R$" + quantidadeTeleSenas * TeleSena.VALOR_VENDA);
        // Mostra o lucro obtido pelo Silvio Santos
        System.out.println("Lucro obtido pelo Silvio Santos: R$" + lucro);
    }
}