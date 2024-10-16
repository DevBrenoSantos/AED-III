package ManipulandoArquivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ex02 {
    public static void main(String[] args) {
        // Números a serem escritos no arquivo
        double[] numbers = {3.1415, 2.7182, 3.3, 0.5772, 4.6692, 1.6180};

        // Nome do arquivo
        String file = "./ManipulandoArquivos/numbers.bin";

        // Escrevendo os números no arquivo
        writeNumbers(file, numbers);

        // Lendo os números do arquivo
        double[] numbersRead = readNumbers(file, numbers.length);

        System.out.println("Números lidos do arquivo:");
        for (double number : numbersRead) {
            System.out.println(number);
        }
    }

    public static void writeNumbers(String file, double[] numbers){
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (double number : numbers) {
                dos.writeDouble(number);
            }
            System.out.println("Números escritos no arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
    }

    public static double[] readNumbers(String file, int numOfDoubles){
        double[] numbers = new double[numOfDoubles];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = dis.readDouble();
            }
            System.out.println("Números lidos do arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro.");
            e.printStackTrace();
        }
        return numbers;
    }
}