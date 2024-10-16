package RevisãoProva1;

import java.io.FileInputStream;

// Implementar um stream de entrada de dados utilizando a classe FileInputStream e seu método read para contar o número de bytes de um arquivo

public class exercise01 {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("resource")
            FileInputStream file = new FileInputStream("./RevisãoProva1/teste.txt");

            int byteData, byteCont = 0;

            while ((byteData = file.read()) != -1) {
                byteCont++;
                System.out.print((char) byteData);
            }

            System.out.println("\n\nTotal de bytes lidos: " + byteCont);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
