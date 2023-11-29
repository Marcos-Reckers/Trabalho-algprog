public class Principal {
    // Método principal
    public static void main(String[] args) {
        int quantidadePessoas = 20; // Quantidade de pessoas que vão concorrer na Tele Sena

        // Cria um objeto da classe ControleTeleSena passando o array de Pessoa
        ControleTeleSena controle = new ControleTeleSena(quantidadePessoas);

        // Chama o método que realiza o sorteio da Tele Sena
        controle.realizarSorteio();
        // Chama o método que mostra as informações sobre o sorteio da Tele Sena
        controle.mostrarInformacoes();
    }
}