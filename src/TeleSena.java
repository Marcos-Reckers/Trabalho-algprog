// Classe que representa uma Tele Sena
public class TeleSena {
    // Valor constante de venda de cada Tele Sena
    public static final double VALOR_VENDA = 10.0;
    // Dois conjuntos de números que cada Tele Sena possui
    private int[] conjunto1;
    private int[] conjunto2;

    // Construtor que cria uma Tele Sena com números aleatórios entre 1 e 60
    public TeleSena() {
        conjunto1 = new int[25];
        conjunto2 = new int[25];
        // Preenche o primeiro conjunto com números distintos
        sorteiaNumeros(conjunto1);
        // Preenche o segundo conjunto com números distintos
        sorteiaNumeros(conjunto2);
    }

    //metodo que constroi uma tele sena com numeros aleatorios entre 1 e 60
    private void sorteiaNumeros(int[] conjunto) {
        for (int i = 0; i < 25; i++) {
            int numero = (int) (Math.random() * 60 + 1); // Sorteia um número entre 1 e 60
            while (contem(conjunto, numero)) { // Verifica se o número já está no conjunto
                numero = (int) (Math.random() * 60 + 1); // Sorteia outro número
                }
            conjunto1[i] = numero; // Adiciona o número ao conjunto
        }
    }

    // Método que verifica se um número está em um conjunto
    private boolean contem(int[] conjunto, int numero) {
        for (int n : conjunto) {
            if (n == numero) {
                return true;
            }
        }
        return false;
    }

    // Método que verifica se uma Tele Sena foi premiada com um conjunto de números sorteados
    public boolean foiPremiada(int[] numerosSorteados) {
        return isConjuntoPremiado(conjunto1, numerosSorteados) || isConjuntoPremiado(conjunto2, numerosSorteados);
    }

    // Método que verifica se todos os números de um conjunto estão nos números sorteados
    private boolean isConjuntoPremiado(int[] conjunto, int[] numerosSorteados) {
        for (int n : conjunto) {
            if (!contem(numerosSorteados, n)) {
                return false;
            }
        }
        return true;
    }

    // Método que retorna uma representação textual de uma Tele Sena
    public String numerosTeleSena(){
        String numeros = "";
        for (int i = 0; i < 25; i++) {
            numeros += conjunto1[i] + " ";
            if (i == 4 || i == 9 || i == 14 || i == 19) {
                numeros += "\n";
            }
        }
        numeros += "\n";
        for (int i = 0; i < 25; i++) {
            numeros += conjunto2[i] + " ";
            if (i == 4 || i == 9 || i == 14 || i == 19) {
                numeros += "\n";
            }
        }
        return numeros;
    }
}