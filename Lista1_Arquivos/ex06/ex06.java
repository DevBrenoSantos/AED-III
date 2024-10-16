package ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ex06 {
    public static void main(String[] args) {
        String arquivoEntrada = "./Lista1_Arquivos/ex06/entrada.txt";
        String arquivoSaida = "./Lista1_Arquivos/ex06/saida.txt";

        try (BufferedReader breader = new BufferedReader(new FileReader(arquivoEntrada));
             BufferedWriter bwriter = new BufferedWriter(new FileWriter(arquivoSaida))) {

            String linha;
            while ((linha = breader.readLine()) != null) {
                String[] partes = linha.split(",");
                String nomeAluno = partes[0];
                double[] notas = new double[3];

                for (int i = 0; i < 3; i++) {
                    notas[i] = Double.parseDouble(partes[i + 1]);
                }

                Arrays.sort(notas);

                bwriter.write(nomeAluno + ": ");
                for (int i = 0; i < 3; i++) {
                    bwriter.write(notas[i] + (i < 2 ? ", " : ""));
                }
                bwriter.newLine();
            }

            System.out.println("Arquivo de saída gerado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}
