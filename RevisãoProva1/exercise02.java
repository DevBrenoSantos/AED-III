package RevisãoProva1;
// Implemente um programa que use DataByteStreams para ler e escrever um vetor de números reais em um arquivo

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class exercise02 {
    public static void main(String[] args) {
        double[] numerosReais = {1.1, 2.2, 3.3, 4.4, 5.5}; // Vetor de números reais

        try (FileOutputStream fos = new FileOutputStream("numerosReais.dat");
             DataOutputStream dos = new DataOutputStream(fos)) {

            for (double numero : numerosReais) {
                dos.writeDouble(numero);
            }
            System.out.println("Vetor de números reais gravados com sucesso!");    
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("numeros_reais.dat");
        DataInputStream dis = new DataInputStream(fis)) {
            
            System.out.println("Lendo o vetor de números reais do arquivo");
            while (dis.available() > 0) {
                System.out.println(dis.readDouble());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
