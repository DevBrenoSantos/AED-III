package Lista2_Arquivos.ex13;

import java.io.*;

public class readPessoa {
    public static void main(String[] args) {
        // Desserializar o objeto do arquivo person.dat
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./Lista2_Arquivos/ex13/person.dat"))) {
            Pessoa pessoa = (Pessoa) ois.readObject();
            System.out.println("Dados lidos do arquivo:");
            System.out.println(pessoa);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
