package ex09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ex09 {
    public static void main(String[] args) {
        String fileName = "./Lista1_Arquivos/ex09/produtos.txt";
        double totalValue = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    @SuppressWarnings("unused")
                    String productName = parts[0].trim();
                    double productPrice = Double.parseDouble(parts[1].trim());

                    totalValue += productPrice;
                } else {
                    System.out.println("Linha inválida: " + line);
                }
            }

            System.out.printf("Valor total da compra: R$ %.2f%n", totalValue);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao formatar o número: " + e.getMessage());
        }
    }
}
