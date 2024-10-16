package ex07;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ex07 {
    public static void main(String[] args) {
        String fileName = "./Lista1_Arquivos/ex07/binario.txt";

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            String topStudent = "";
            double topGrade = Double.MIN_VALUE;

            while (dis.available() > 0) {
                String name = dis.readUTF();
                double grade = dis.readDouble();

                if (grade > topGrade) {
                    topGrade = grade;
                    topStudent = name;
                }
            }

            System.out.println("Aluno com a maior nota:");
            System.out.println(topStudent + " - Nota: " + topGrade);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo binário: " + e.getMessage());
        }
    }
}
