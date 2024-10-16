package Lista2_Arquivos.ex10;

import java.io.*;

public class ex10 {
    public static void main(String[] args) {
        // Arquivos de entrada e saída
        String inputFile = "./Lista2_Arquivos/ex10/ex10Input.txt";
        String outputFile = "./Lista2_Arquivos/ex10/ex10Output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)))  {
            
            String line;
            // Ler cada linha do arquivo de entrada
            while ((line = br.readLine()) != null) {
                // Limitar a linha a 30 caracteres (caso a linha seja maior que isso)
                if (line.length() > 30) {
                    line = line.substring(0, 30);
                }
                // Inverter a linha
                String linhaInvertida = new StringBuilder(line).reverse().toString();
                
                // Escrever a linha invertida no arquivo de saída
                bw.write(linhaInvertida);
                bw.newLine();
            }

            System.out.println("Arquivo processado com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}