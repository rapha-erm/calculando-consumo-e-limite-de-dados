import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Função para calcular o consumo total de dados móveis
    public static int calcularConsumoTotal(List<Integer> lista) {
        int total = 0;
        total = lista.stream().reduce(0, (x,y) -> x + y);

        // TODO: Calcule o consumo total de dados móveis

        return total;
    }

    // Função para calcular a média semanal de consumo de dados móveis
    public static int calcularMediaSemanal(int totalConsumo, List<Integer> lista) {
        int numeroDeSemanas = lista.size();
        return calcularConsumoTotal(Collections.singletonList(totalConsumo)) / numeroDeSemanas;                   // Calcule a média semanal de consumo de dados móveis
    }

    // Função para identificar a semana de maior consumo
    public static int identificarSemanaDeMaiorConsumo(String[] consumoSemanal) {
        int semanaDeMaiorConsumo = 0;
        int maiorConsumo = 0;

        // Função para identificar a semana de maior consumo
        for (int i = 0; i < consumoSemanal.length; i++) {
            int consumo = Integer.parseInt(consumoSemanal[i].trim());
            if(Integer.parseInt(consumoSemanal[i]) > maiorConsumo){
                maiorConsumo = Integer.parseInt(consumoSemanal[i]);
                semanaDeMaiorConsumo = i+1;
            }else{
                maiorConsumo = maiorConsumo;
            }

            // TODO: Estabeleça Faça o cálculo para identificar a semana de maior consumo
        }
        return semanaDeMaiorConsumo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitando ao usuário a lista de consumos semanais em MB
        String input = scanner.nextLine();

        // Convertendo a entrada em uma lista de strings
        List<Integer> lista = new ArrayList<>();
        String[] consumoSemanal = input.split(",");

        for (int i = 0; i < consumoSemanal.length; i++) {
            lista.add(Integer.valueOf(consumoSemanal[i]));
        }

        // Calculando o consumo total de dados móveis no mês
        int totalConsumo = calcularConsumoTotal(lista);

        // Calculando a média semanal de consumo de dados móveis
        int mediaSemanal = calcularMediaSemanal(totalConsumo, lista);

        // Identificando a semana de maior consumo
        int semanaDeMaiorConsumo = identificarSemanaDeMaiorConsumo(consumoSemanal);

        // Exibindo o consumo total de dados móveis no mês
        System.out.println("Total mensal: " + totalConsumo + " MB");

        // Exibindo a média semanal de consumo
        System.out.println("Media semanal: " + mediaSemanal + " MB");

        // Exibindo a semana de maior consumo
        System.out.println("Maior consumo: Semana " + semanaDeMaiorConsumo);

        scanner.close();
    }
}