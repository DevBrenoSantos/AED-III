package Lista2_Arquivos.ex13;

import java.io.*;
import java.util.Scanner;

public class writePessoa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Criar objetos Pessoa via console
        System.out.println("Você deseja criar uma pessoa pelo console ou diretamente no código?");
        System.out.println("1. Via console");
        System.out.println("2. Direto no código");
        System.out.print("Escolha uma opção: ");
        int opcao = input.nextInt();
        input.nextLine(); // Limpa o buffer do teclado

        Pessoa pessoa;

        if (opcao == 1) {
            // Criação via console
            System.out.print("Digite o ID: ");
            int id = input.nextInt();
            input.nextLine();  // Limpa o buffer do teclado
            System.out.print("Digite o nome: ");
            String nome = input.nextLine();
            pessoa = new Pessoa(id, nome);
        } else {
            // Criação diretamente no código
            pessoa = new Pessoa(1, "Maria");
        }

        // Serializar o objeto e salvar no arquivo person.dat
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            oos.writeObject(pessoa);
            System.out.println("Objeto Pessoa serializado e salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
        input.close();
    }
}
