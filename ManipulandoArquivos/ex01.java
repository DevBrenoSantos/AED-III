package ManipulandoArquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ex01 {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            // Cria um FileInputStream para o arquivo especificado
            file = new FileInputStream("./ManipulandoArquivos/teste.txt");

            int byteData, byteCont = 0;

            // Lê o arquivo byte a byte até o final do arquivo (-1)
            while ((byteData = file.read()) != -1) {
                byteCont++;
                System.out.print((char) byteData);
            }

            System.out.println("\n\nTotal de bytes lidos: " + byteCont);

        } catch (IOException e) {
            // Lida com exceções relacionadas a IO
            e.printStackTrace();
        } finally {
            try {
                // Fecha o FileInputStream para liberar recursos
                if (file != null) {
                    file.close();
                }
            } catch (IOException err) {
                err.printStackTrace();
            }
        }
    }
}