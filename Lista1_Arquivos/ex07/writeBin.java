package ex07;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class writeBin {

    public static void main(String[] args) {
        String fileName = "./Lista1_Arquivos/ex07/binario.txt";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeUTF("João Silva");
            dos.writeDouble(8.5);
            
            dos.writeUTF("Maria Oliveira");
            dos.writeDouble(9.2);
            
            dos.writeUTF("Pedro Santos");
            dos.writeDouble(7.8);
            
            dos.writeUTF("Ana Souza");
            dos.writeDouble(9.5);

            System.out.println("Arquivo binário criado com sucesso.");

        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo binário: " + e.getMessage());
        }
    }
}
