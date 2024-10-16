package Lista2_Arquivos.ex11;

import java.io.*;
import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Recebe o nome do arquivo e a palavra do usuário
        System.out.print("Digite o nome do arquivo: ");
        String inputFile = input.nextLine();

        inputFile = "./Lista2_Arquivos/ex11/" + inputFile;
        
        System.out.print("Digite a palavra a ser contada: ");
        String word = input.nextLine();

        // Variável para contar a quantidade de vezes que a palavra aparece no arquivo
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            // Ler cada linha do arquivo
            while ((line = br.readLine()) != null) {
                // Divide a linha em palavras (por espaços, pontuação, etc.)
                String[] palavras = line.split("\\W+");  // Regex para dividir por caracteres não alfabéticos

                // Conta as ocorrências da palavra
                for (String p : palavras) {
                    if (p.equalsIgnoreCase(word)) {  // Ignora maiúsculas/minúsculas
                        count++;
                    }
                }
            }

            System.out.println("A palavra '" + word + "' aparece " + count + " vezes no arquivo.");

        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
        input.close();
    }
}
