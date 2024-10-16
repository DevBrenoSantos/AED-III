package Lista2_Arquivos.ex12;

import java.io.*;
import java.util.*;

public class ex12 {
    private static List<Aluno> alunos = new ArrayList<>();
    private static final String NOME_ARQUIVO = "./Lista2_Arquivos/ex12/notas_turma.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Inserir notas dos alunos");
            System.out.println("2. Exibir alunos aprovados");
            System.out.println("3. Exibir alunos reprovados");
            System.out.println("4. Salvar informações em arquivo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();
            input.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    inserirNotas(input);
                    break;
                case 2:
                    exibirAlunos(true);
                    break;
                case 3:
                    exibirAlunos(false);
                    break;
                case 4:
                    salvarEmArquivo();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static void inserirNotas(Scanner input) {
        System.out.print("Digite o nome do aluno: ");
        String nome = input.nextLine();
        System.out.print("Digite a nota do aluno: ");
        double nota = input.nextDouble();
        input.nextLine();  // Limpar o buffer

        Aluno aluno = new Aluno(nome, nota);
        alunos.add(aluno);
        System.out.println("Nota inserida com sucesso.");
    }

    private static void exibirAlunos(boolean exibirAprovados) {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno registrado.");
            return;
        }

        System.out.println(exibirAprovados ? "\nAlunos Aprovados:" : "\nAlunos Reprovados:");
        for (Aluno aluno : alunos) {
            if (aluno.isAprovado() == exibirAprovados) {
                System.out.println(aluno);
            }
        }
    }

    private static void salvarEmArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Aluno aluno : alunos) {
                bw.write(aluno.toString());
                bw.newLine();
            }
            System.out.println("Informações salvas no arquivo '" + NOME_ARQUIVO + "'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
