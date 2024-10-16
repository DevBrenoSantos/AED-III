package ex08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ex08 {
    public static void main(String[] args) {
        String fileName = "./Lista1_Arquivos/ex08/text.txt";
        Map<Character, Integer> letterFrequency = new HashMap<>();

        // Inicializa o mapa com todas as letras do alfabeto
        for (char c = 'a'; c <= 'z'; c++) {
            letterFrequency.put(c, 0);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while((line = reader.readLine()) != null) {
                line = line.toLowerCase();

                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        letterFrequency.put(c, letterFrequency.get(c) + 1);
                    }
                }
            }

            for (char c = 'a'; c <= 'z'; c++) {
                System.out.println("Letra " + c + ": " + letterFrequency.get(c) + " ocorrência(s)");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
