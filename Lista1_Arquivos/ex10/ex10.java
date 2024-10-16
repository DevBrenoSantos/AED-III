package ex10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class ex10 {
    public static void main(String[] args) {
        String inputFileName = "./Lista1_Arquivos/ex10/dates.txt";
        String outputFileName = "./Lista1_Arquivos/ex10/ages.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            LocalDate currentDate = LocalDate.now();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    LocalDate birthDate = LocalDate.parse(parts[1].trim(), formatter);
                    int age = Period.between(birthDate, currentDate).getYears();

                    writer.write(name + ": " + age + " anos");
                    writer.newLine();
                } else {
                    System.out.println("Linha inválida: " + line);
                }
            }

            System.out.println("Arquivo gerado com sucesso: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao processar os dados: " + e.getMessage());
        }
    }
}
